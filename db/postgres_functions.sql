-- retorna quantidade de qualificadores na track
CREATE OR REPLACE FUNCTION qualifier_count(tk INTEGER)
RETURNS INTEGER AS $$
DECLARE
    COUNT INTEGER;
BEGIN
    SELECT COUNT(QL.QL_ID)
    INTO COUNT
    FROM Qualifier AS ql 
    JOIN Expertise_Qualifier AS ex_ql ON ql.ql_id = ex_ql.ql_id 
    WHERE ex_ql.ex_id IN 
        (SELECT ex_id 
        FROM Expertise AS ex
        WHERE ex.tk_id = tk);
RETURN COUNT;
END;
$$ LANGUAGE plpgsql;

-- TODO
-- deveria retornar quantidade de qualificadores conclídos ou não (retornando número errado)
CREATE OR REPLACE FUNCTION qualifier_completed_count(tk INTEGER, is_completed BOOLEAN)
RETURNS INTEGER AS $$
DECLARE
    COUNT INTEGER;
BEGIN
    SELECT COUNT (pt_ql.pt_ql_complete_date)
    INTO COUNT
    FROM Partner_Qualifier AS pt_ql
    JOIN Expertise_Qualifier AS ex_ql ON pt_ql.ql_id = ex_ql.ql_id
    WHERE ex_ql.ex_id IN 
        (is_completed AND pt_ql.pt_ql_complete_date IS NOT NULL) OR
        (NOT is_completed AND pt_ql.pt_ql_complete_date IS NULL) AND
        ex_ql.ex_id IN
            (SELECT ex_id 
            FROM Expertise AS ex
            WHERE ex.tk_id = tk);
    RETURN count;
END;
$$ LANGUAGE plpgsql;
