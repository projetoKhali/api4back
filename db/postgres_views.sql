CREATE OR REPLACE VIEW track_metrics
    AS select
    tk.tk_id,
    tk.tk_name,
    (SELECT COUNT(ex.tk_id) 
        FROM Expertise AS ex 
        WHERE ex.tk_id = tk.tk_id) AS expertise_count,

    (SELECT COUNT(ql.ql_id) 
        FROM Qualifier AS ql 
        JOIN Expertise_Qualifier AS ex_ql ON ql.ql_id = ex_ql.ql_id 
        	WHERE ex_ql.ex_id IN 
                (SELECT ex_id 
        		FROM Expertise 
        		WHERE tk_id = tk.tk_id)) AS qualifier_count,

    (SELECT COUNT(pt.pt_id) 
        FROM Partner_Track AS pt 
        WHERE pt.tk_id = tk.tk_id) AS partner_count,

    -- os calulos retornam um número inteiro que são os dias de diferença entre as datas
    (SELECT AVG((pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date))
         FROM Partner_Expertise AS pt_ex 
         JOIN Expertise AS ex ON pt_ex.ex_id = ex.ex_id 
         WHERE ex.tk_id = tk.tk_id) AS avg_expertise_completion_time,

    (SELECT AVG((pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date))
         FROM Partner_Qualifier AS pt_ql 
         JOIN Expertise_Qualifier AS ex_ql ON pt_ql.ql_id = ex_ql.ql_id
         WHERE ex_ql.ex_id IN (
            SELECT ex_id 
            FROM Expertise ex 
            WHERE ex.tk_id = tk.tk_id)) AS avg_qualifier_completion_time,

    -- porcentagem de qualificadores completados na track
    (SELECT (count(pt_ql.pt_ql_complete_date) * 100) / (SELECT (COUNT(ql.ql_id) + 1)
        FROM Qualifier AS ql 
        JOIN Expertise_Qualifier AS ex_ql ON ql.ql_id = ex_ql.ql_id 
        WHERE ex_ql.ex_id IN 
            (SELECT ex_id
            FROM Expertise 
            WHERE tk_id = tk.tk_id))
        FROM Partner_Qualifier AS pt_ql
        JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
        WHERE ex_ql.ex_id IN (
            SELECT ex_id 
            FROM Expertise ex 
            WHERE ex.tk_id = tk.tk_id)
        )AS avg_qualifier_completion_percentage,

    -- porcentagem de expertise completadas na track
    (SELECT ((count(pt_ex.pt_ex_complete_date) * 100) / (count(ex.ex_id) + 1))
        FROM Partner_Expertise AS pt_ex, Expertise ex
        WHERE ex.ex_id = pt_ex.ex_id
        AND ex.tk_id = tk.tk_id
        AND pt_ex.pt_ex_complete_date IS NOT NULL) AS avg_expertise_completion_percentage,

    -- porcentagem de abandono (validade de um ano)
    (SELECT 
        ((select count(pt_ql.*) 
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

        (SELECT (COUNT(ql.ql_id) + 1)
        FROM Qualifier AS ql
        JOIN Expertise_Qualifier AS ex_ql ON ql.ql_id = ex_ql.ql_id
        WHERE ex_ql.ex_id IN (
            SELECT ex_id 
            FROM Expertise ex 
            WHERE ex.tk_id = tk.tk_id))
    )AS expired_qualifiers,

    -- porcentagem da conlusão da track
    -- porcentagem de conclusão das expertises + porcentagem de conclusão dos qualificadores / numero de qualificadores + numero de expertises (finalizados)
    (SELECT count(pt_ex.pt_ex_complete_date) + count(pt_ql.pt_ql_complete_date) * 100 / (count(ex.ex_id) + count(ql.ql_id) + 1)
        FROM Partner_Qualifier AS pt_ql
        JOIN Qualifier ql ON pt_ql.ql_id = ql.ql_id
        JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
        JOIN Partner_Expertise AS pt_ex ON pt_ql.ql_id = ex_ql.ql_id
        JOIN Expertise AS ex ON pt_ex.ex_id = ex.ex_id
        -- JOIN Partner_Qualifier AS pt_ql ON pt_ex.ex_id = ex.ex_id
        -- JOIN Qualifier AS ql ON pt_ql.ql_id = ql.ql_id
        WHERE ex.ex_id = pt_ex.ex_id
        AND ex.tk_id = tk.tk_id
        AND pt_ex.pt_ex_complete_date IS NOT NULL
        AND ql.ql_id = pt_ql.ql_id
        AND ql.ql_id IN (
            SELECT ql_id 
            FROM Expertise_Qualifier ex_ql
            WHERE ex_ql.ex_id IN (
                SELECT ex_id 
                FROM Expertise ex 
                WHERE ex.tk_id = tk.tk_id)
    )) AS track_completion_percentage,

    -- tempo médio de conclusão da track
    -- média de tempo de conclusão das expertises + média de tempo de conclusão dos qualificadores / numero de qualificadores e expertises finalizados
    (SELECT AVG((pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date)) + AVG((pt_ql.pt_ql_complete_date - pt_ql.pt_ql_insert_date)) / (count(ex.ex_id) + count(ql.ql_id) + 1)
        FROM Partner_Qualifier AS pt_ql
        JOIN Qualifier ql ON pt_ql.ql_id = ql.ql_id
        JOIN Expertise_Qualifier ex_ql ON pt_ql.ql_id = ex_ql.ql_id
        JOIN Partner_Expertise AS pt_ex ON pt_ql.ql_id = ex_ql.ql_id
        JOIN Expertise AS ex ON pt_ex.ex_id = ex.ex_id
        WHERE ex.ex_id = pt_ex.ex_id
        AND ex.tk_id = tk.tk_id
        AND pt_ex.pt_ex_complete_date IS NOT NULL
        AND ql.ql_id = pt_ql.ql_id
        AND ql.ql_id IN (
            SELECT ql_id 
            FROM Expertise_Qualifier ex_ql
            WHERE ex_ql.ex_id IN (
                SELECT ex_id
                FROM Expertise ex 
                WHERE ex.tk_id = tk.tk_id)
    )) AS avg_track_completion_time

FROM 
    Track AS tk;


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
