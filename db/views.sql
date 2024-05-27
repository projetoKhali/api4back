-- public.track_metrics source
CREATE OR REPLACE VIEW public.track_metrics AS
SELECT tk_id,
    (
        SELECT count(ex.tk_id) AS count
        FROM expertise ex
        WHERE ex.tk_id = tk.tk_id
    ) AS expertise_count,
    (
        SELECT count(ql.ql_id) AS count
        FROM qualifier ql
            JOIN expertise_qualifier ex_ql ON ql.ql_id = ex_ql.ql_id
        WHERE (
                ex_ql.ex_id IN (
                    SELECT expertise.ex_id
                    FROM expertise
                    WHERE expertise.tk_id = tk.tk_id
                )
            )
    ) AS qualifier_count,
    (
        SELECT count(pt.pt_id) AS count
        FROM partner_track pt
        WHERE pt.tk_id = tk.tk_id
    ) AS partner_count,
    (
        SELECT avg(
                pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date
            ) AS avg
        FROM partner_expertise pt_ex
            JOIN expertise ex ON pt_ex.ex_id = ex.ex_id
        WHERE ex.tk_id = tk.tk_id
    ) AS avg_expertise_completion_time,
    (
        SELECT avg(
                pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date
            ) AS avg
        FROM partner_qualifier pt_ql
            JOIN expertise_qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
        WHERE (
                ex_ql.ex_id IN (
                    SELECT ex.ex_id
                    FROM expertise ex
                    WHERE ex.tk_id = tk.tk_id
                )
            )
    ) AS avg_qualifier_completion_time,
    (
        SELECT count(pt_ql.pt_ql_complete_date) * 100 / count(ql.ql_id)
        FROM partner_qualifier pt_ql,
            qualifier ql
    ) AS avg_qualifier_completion_percentage
FROM track tk;



--CREATE PARTNER METRICS
CREATE OR REPLACE VIEW partner_metrics AS
SELECT prt.pt_id,prt.pt_name,prt.pt_city,COUNT(DISTINCT pac.tk_id) as tracks,
		COUNT(DISTINCT pac.pt_tk_complete_date) completed_tracks,
	COUNT(DISTINCT pqu.ql_id) qualifiers,
		COUNT(DISTINCT pqu.pt_ql_complete_date) completed_qualifiers

FROM partner prt
INNER JOIN partner_track pac
	ON pac.pt_id = prt.pt_id
INNER JOIN partner_qualifier pqu
	ON pqu.pt_id = pac.pt_id
GROUP BY prt.pt_id,prt.pt_name,prt.pt_city
ORDER BY prt.pt_id;


