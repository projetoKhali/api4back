DROP VIEW IF EXISTS track_metrics;

CREATE OR REPLACE VIEW track_metrics AS 
SELECT
    tk.tk_id,
    tk.tk_name,
    
    -- Contagem de expertises associadas à track
    (SELECT COUNT(ex.ex_id)
     FROM Expertise ex
     WHERE ex.tk_id = tk.tk_id) AS expertise_count,

    -- Contagem de qualifiers associados às expertises da track
    (SELECT COUNT(ql.ql_id)
     FROM Qualifier ql
     JOIN Expertise_Qualifier ex_ql ON ql.ql_id = ex_ql.ql_id
     JOIN Expertise ex ON ex_ql.ex_id = ex.ex_id
     WHERE ex.tk_id = tk.tk_id) AS qualifier_count,

    -- Contagem de parceiros associados à track
    (SELECT COUNT(pt.pt_id)
     FROM Partner_Track pt
     WHERE pt.tk_id = tk.tk_id) AS partner_count,

    -- Tempo médio para completar uma expertise (em dias)
    (SELECT ROUND(AVG((pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date)::numeric), 2)
     FROM Partner_Expertise pt_ex
     JOIN Expertise ex ON pt_ex.ex_id = ex.ex_id
     WHERE ex.tk_id = tk.tk_id
       AND pt_ex.pt_ex_complete_date IS NOT NULL) AS avg_expertise_completion_time,

    -- Tempo médio para completar um qualifier (em dias)
    (SELECT ROUND(AVG((pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date)::numeric), 2)
     FROM Partner_Qualifier pt_ql
     JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
     JOIN Expertise ex ON ex_ql.ex_id = ex.ex_id
     WHERE ex.tk_id = tk.tk_id
       AND pt_ql.pt_ql_complete_date IS NOT NULL) AS avg_qualifier_completion_time,

    -- Porcentagem de expertises completadas na track
    (SELECT ROUND((COUNT(pt_ex.pt_ex_complete_date) * 100.0 / NULLIF(COUNT(pt_ex.pt_ex_id), 0))::numeric, 2)
     FROM Partner_Expertise pt_ex
     JOIN Expertise ex ON pt_ex.ex_id = ex.ex_id
     WHERE ex.tk_id = tk.tk_id) AS avg_expertise_completion_percentage,

    -- Porcentagem de qualifiers completados na track
    (SELECT ROUND((COUNT(pt_ql.pt_ql_complete_date) * 100.0 / NULLIF(COUNT(pt_ql.pt_ql_id), 0))::numeric, 2)
     FROM Partner_Qualifier pt_ql
     JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
     JOIN Expertise ex ON ex_ql.ex_id = ex.ex_id
     WHERE ex.tk_id = tk.tk_id) AS avg_qualifier_completion_percentage,

    -- Tempo médio de conclusão da track
    (SELECT 
        ROUND(
            COALESCE(
                (
                    SELECT AVG(pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date)
                    FROM Partner_Expertise pt_ex
                    JOIN Expertise ex ON pt_ex.ex_id = ex.ex_id
                    WHERE ex.tk_id = tk.tk_id
                      AND pt_ex.pt_ex_complete_date IS NOT NULL
                )::numeric, 
                0
            ) / NULLIF((SELECT COUNT(pt_ex.pt_ex_complete_date)
                        FROM Partner_Expertise pt_ex
                        JOIN Expertise ex ON pt_ex.ex_id = ex.ex_id
                        WHERE ex.tk_id = tk.tk_id
                          AND pt_ex.pt_ex_complete_date IS NOT NULL), 0) + 
            COALESCE(
                (
                    SELECT AVG(pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date)
                    FROM Partner_Qualifier pt_ql
                    JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
                    JOIN Expertise ex ON ex_ql.ex_id = ex.ex_id
                    WHERE ex.tk_id = tk.tk_id
                      AND pt_ql.pt_ql_complete_date IS NOT NULL
                )::numeric, 
                0
            ) / NULLIF((SELECT COUNT(pt_ql.pt_ql_complete_date)
                        FROM Partner_Qualifier pt_ql
                        JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
                        JOIN Expertise ex ON ex_ql.ex_id = ex.ex_id
                        WHERE ex.tk_id = tk.tk_id
                          AND pt_ql.pt_ql_complete_date IS NOT NULL), 0),
            2
        )
    ) AS avg_track_completion_time,

    -- Porcentagem de abandono (validade de um ano)
    (SELECT ROUND(
        (
            COUNT(pt_ql.pt_ql_id)
            FILTER (
                WHERE pt_ql.pt_ql_complete_date IS NOT NULL 
                AND pt_ql.pt_ql_complete_date + INTERVAL '1 year' < NOW()
            ) * 100.0 / NULLIF(COUNT(pt_ql.pt_ql_id), 0)
        )::numeric, 2
    ) 
    FROM Partner_Qualifier pt_ql
    JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
    JOIN Expertise ex ON ex_ql.ex_id = ex.ex_id
    WHERE ex.tk_id = tk.tk_id) AS avg_expired_qualifiers,

    -- Porcentagem da conclusão da track
    (SELECT ROUND(
        (
            (qualifier_completed_count(tk.tk_id) * 100.0 / NULLIF(qualifier_count(tk.tk_id), 0)) +
            (expertise_completed_count(tk.tk_id) * 100.0 / NULLIF(expertise_count(tk.tk_id), 0))
        ) / 2.0, 2
    )) AS track_completion_percentage

FROM 
    Track tk;

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

--PARTNER METRICS============================================================================
CREATE OR REPLACE VIEW partner_metrics AS
SELECT pt_id,pt_name,pt_city,count(DISTINCT tracks) tracks,sum(completed_tracks) completed_tracks,
		COUNT(DISTINCT qualifiers) qualifiers, SUM(completed_qualifiers) completed_qualifiers FROM
(
	SELECT prt.pt_id,prt.pt_name,pac.tk_id as tracks,
			CASE WHEN pac.pt_tk_complete_date IS NOT NULL THEN 1
			 ELSE 0 END completed_tracks,
		pqu.ql_id qualifiers,
		CASE WHEN pqu.pt_ql_complete_date IS NOT NULL THEN 1
		 ELSE 0 END completed_qualifiers,prt.pt_city

	FROM partner prt
	LEFT JOIN partner_track pac
		ON pac.pt_id = prt.pt_id
	LEFT JOIN partner_qualifier pqu
		ON pqu.pt_id = prt.pt_id
	ORDER BY prt.pt_id
)
GROUP BY pt_id,pt_name,pt_city
ORDER BY pt_id;

--PARTNER REPORT

SELECT * FROM partner_reports AS
SELECT pt.pt_id,pt.pt_name,tr.tk_name,
		pt_tr.pt_tk_insert_date as tk_start_date,
		pt_tr.pt_tk_complete_date as tk_end_date,
		ex.ex_name,
		pt_ex.pt_ex_insert_date as ex_start_date,
		pt_ex.pt_ex_complete_date as ex_end_date,
		ql.ql_name,
		pt_ql.pt_ql_insert_date as ql_start_date,
		pt_ql.pt_ql_complete_date as ql_end_date,
		pt_ql.pt_ql_insert_date + INTERVAL '2 years' as ql_due_date 
FROM partner pt
	LEFT JOIN partner_track pt_tr
		ON pt_tr.pt_id = pt.pt_id
	LEFT JOIN track tr
		ON tr.tk_id = pt_tr.tk_id
	LEFT JOIN partner_expertise pt_ex
		ON pt_ex.pt_id = pt_tr.pt_id
	LEFT JOIN expertise ex
		ON ex.ex_id = pt_ex.ex_id
	LEFT JOIN partner_qualifier pt_ql
		ON pt_ql.pt_id = pt_tr.pt_id
	LEFT JOIN qualifier ql
		ON ql.ql_id = pt_ql.ql_id
ORDER BY pt.pt_name;