CREATE OR REPLACE VIEW track_metrics
    AS select
    tk.tk_id,
    tk.tk_name,
    (expertise_count(tk.tk_id)) AS expertise_count,

    (SELECT qualifier_count(tk.tk_id)) AS qualifier_count,

    (SELECT COUNT(pt.pt_id) 
        FROM Partner_Track AS pt 
        WHERE pt.tk_id = tk.tk_id
    ) AS partner_count,

    -- tempo médio para completar uma expertise
    (
        SELECT ROUND(AVG((pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date)::numeric), 2)
        FROM Partner_Expertise AS pt_ex
        JOIN Expertise AS ex ON pt_ex.ex_id = ex.ex_id
        WHERE ex.tk_id = tk.tk_id
    ) AS avg_expertise_completion_time,

    (
        SELECT ROUND(AVG((pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date)::numeric), 2)
        FROM Partner_Qualifier AS pt_ql 
        JOIN Expertise_Qualifier AS ex_ql ON pt_ql.ql_id = ex_ql.ql_id
        WHERE ex_ql.ex_id IN (
            SELECT ex_id 
            FROM Expertise ex 
            WHERE ex.tk_id = tk.tk_id
        )
    ) AS avg_qualifier_completion_time,

    -- porcentagem de qualificadores completados na track
    (
        ROUND(
            ((qualifier_completed_count(tk.tk_id) * 100) /
            -- se o divisor for 0, retorna NULL
            NULLIF (qualifier_count(tk.tk_id), 0))::numeric
        , 2)
    )AS avg_qualifier_completion_percentage,

    -- porcentagem de expertise completadas na track
    (
        ROUND(
            ((expertise_completed_count(tk.tk_id) * 100) / 
            NULLIF (expertise_count(tk.tk_id), 0))::numeric
        , 2)
    ) AS avg_expertise_completion_percentage,

    -- porcentagem de abandono (validade de um ano)
    (
        ROUND(
        (((select count(pt_ql.*)
        from Partner_Qualifier pt_ql
        JOIN Expertise_Qualifier AS ex_ql ON pt_ql.ql_id = ex_ql.ql_id
        WHERE pt_ql.pt_ql_complete_date is not NULL
        AND pt_ql.pt_ql_complete_date + interval '1 year' < now()
        AND ex_ql.ex_id IN (
            SELECT ex_id 
            FROM Expertise ex 
            WHERE ex.tk_id = tk.tk_id))
         * 100)

        /

        NULLIF (qualifier_count(tk.tk_id), 0))::numeric
        , 2)
    )AS avg_expired_qualifiers,

    -- porcentagem da conlusão da track
    (
        -- porcentagem de conclusão dos qualificadores
        (
            (qualifier_completed_count(tk.tk_id) * 100) /
            NULLIF (qualifier_count(tk.tk_id), 0)

        +
        -- porcentagem de conclusão dos qualificadores
            (expertise_completed_count(tk.tk_id) * 100) / 
            NULLIF (expertise_count(tk.tk_id), 0)
        )
        / 2
    ) AS track_completion_percentage,

    -- tempo médio de conclusão da track
    -- média de tempo de conclusão das expertises + média de tempo de conclusão dos qualificadores / numero de qualificadores e expertises finalizados
    (
        SELECT COALESCE(
            ROUND(
                (
                    (
                        SELECT AVG(pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date)
                        FROM Partner_Expertise AS pt_ex
                        JOIN Expertise AS ex ON pt_ex.ex_id = ex.ex_id
                        WHERE ex.tk_id = tk.tk_id
                    ) +
                    (
                        SELECT AVG(pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date)
                        FROM Partner_Qualifier AS pt_ql
                        JOIN Expertise_Qualifier AS ex_ql ON pt_ql.ql_id = ex_ql.ql_id
                        WHERE ex_ql.ex_id IN (
                            SELECT ex_id
                            FROM Expertise ex 
                            WHERE ex.tk_id = tk.tk_id
                        )
                    )
                ) / NULLIF ((expertise_completed_count(tk.tk_id) + qualifier_completed_count(tk.tk_id)), 0)
            ::numeric, 2),
            (
                ROUND(
                    (SELECT AVG(pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date)
                    FROM Partner_Qualifier AS pt_ql
                    JOIN Expertise_Qualifier AS ex_ql ON pt_ql.ql_id = ex_ql.ql_id
                    WHERE ex_ql.ex_id IN (
                        SELECT ex_id
                        FROM Expertise ex 
                        WHERE ex.tk_id = tk.tk_id))
                    ::numeric, 2)
            )
        ) AS avg_track_completion_time
    )

FROM 
    Track AS tk;

--CREATE PARTNER METRICS
CREATE OR REPLACE VIEW partner_metrics AS
SELECT prt.pt_id,prt.pt_name,prt.pt_city,
	COUNT(DISTINCT pac.tk_id) as tracks,
		COUNT(DISTINCT pac.pt_tk_complete_date) completed_tracks,
	COUNT(DISTINCT pqu.ql_id) qualifiers,
		COUNT(DISTINCT pqu.pt_ql_complete_date) completed_qualifiers,
	COUNT(DISTINCT xpe.ex_id) expertises,
		COUNT(DISTINCT xpe.pt_ex_complete_date) completed_expertises

FROM partner prt
INNER JOIN partner_track pac
	ON pac.pt_id = prt.pt_id
INNER JOIN partner_qualifier pqu
	ON pqu.pt_id = pac.pt_id
INNER JOIN partner_expertise xpe
	ON xpe.pt_id = prt.pt_id
GROUP BY prt.pt_id,prt.pt_name,prt.pt_city
ORDER BY prt.pt_id;
