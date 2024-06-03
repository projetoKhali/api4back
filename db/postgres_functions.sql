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

-- contador de qualificadores completos na track
CREATE OR REPLACE FUNCTION qualifier_completed_count(tk INTEGER)
RETURNS INTEGER AS $$
DECLARE
    COUNT INTEGER;
BEGIN
    SELECT COUNT (pt_ql.pt_ql_complete_date)
    INTO COUNT
    FROM Partner_Qualifier AS pt_ql
    JOIN Expertise_Qualifier AS ex_ql ON pt_ql.ql_id = ex_ql.ql_id
    where ex_ql.ex_id IN 
		(SELECT ex_id 
        FROM Expertise AS ex
        WHERE ex.tk_id = tk);
RETURN COUNT as ql_completed;
END;
$$ LANGUAGE plpgsql;

-- contador de expertises na track
CREATE OR REPLACE FUNCTION expertise_count(tk INTEGER)
RETURNS INTEGER AS $$
DECLARE
    COUNT INTEGER;
BEGIN
    SELECT COUNT(ex.tk_id)
    INTO COUNT
    FROM Expertise AS ex 
    WHERE ex.tk_id = tk;
RETURN COUNT;
END;
$$ LANGUAGE plpgsql;

-- contador de expertises completas na track
CREATE OR REPLACE FUNCTION expertise_completed_count(tk INTEGER)
RETURNS INTEGER AS $$
DECLARE
    COUNT INTEGER;
BEGIN
    SELECT COUNT (pt_ex.pt_ex_complete_date)
    INTO COUNT
    FROM Partner_Expertise AS pt_ex
    JOIN Expertise AS ex ON pt_ex.ex_id = ex.ex_id
    WHERE ex.tk_id = tk;
RETURN COUNT as ex_completed;
END;
$$ LANGUAGE plpgsql;

-- média de tempo de conclusão dos qualificadores
CREATE OR REPLACE FUNCTION avg_expertise_completion_time(tk INTEGER)
RETURNS INTEGER AS $$
DECLARE
    AVG_TIME INTEGER;
BEGIN
    SELECT AVG((pt_ex.pt_ex_complete_date - pt_ex.pt_ex_insert_date))
    INTO AVG_TIME
    FROM Partner_Expertise AS pt_ex 
    JOIN Expertise AS ex ON pt_ex.ex_id = ex.ex_id 
    WHERE ex.tk_id = tk;
RETURN AVG_TIME;
END;
$$ LANGUAGE plpgsql;