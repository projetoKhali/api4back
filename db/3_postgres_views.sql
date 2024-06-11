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
