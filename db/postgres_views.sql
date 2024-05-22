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
        (SELECT (count(pt_ql.pt_ql_complete_date) * 100) / (SELECT COUNT(ql.ql_id) 
        FROM Qualifier AS ql 
        JOIN Expertise_Qualifier AS ex_ql ON ql.ql_id = ex_ql.ql_id 
        WHERE ex_ql.ex_id IN 
            (SELECT ex_id
            FROM Expertise 
            WHERE tk_id = tk.tk_id))
        FROM Partner_Qualifier AS pt_ql
        JOIN Expertise_Qualifier ex_ql on pt_ql.ql_id = ex_ql.ql_id
        WHERE ex_ql.ex_id IN (
            SELECT ex_id 
            FROM Expertise ex 
            WHERE ex.tk_id = tk.tk_id)
        )AS avg_qualifier_completion_percentage,

    -- porcentagem de expertise completadas na track
    (SELECT ((count(pt_ex.pt_ex_complete_date) * 100) / count(ex.ex_id))
        FROM Partner_Expertise AS pt_ex, Expertise ex
        WHERE ex.ex_id = pt_ex.ex_id
        AND ex.tk_id = tk.tk_id
        AND pt_ex.pt_ex_complete_date IS NOT NULL) AS avg_expertise_completion_percentage

FROM 
    Track AS tk;