-- Criar a função
CREATE OR REPLACE FUNCTION trigger_partner_expertise() 
RETURNS TRIGGER AS $$
DECLARE
    v_tk_id INTEGER;
    v_ql_id INTEGER;
BEGIN
    SELECT tk_id INTO v_tk_id 
    FROM Expertise 
    WHERE ex_id = NEW.ex_id;

    INSERT INTO Partner_Track (pt_id, tk_id, pt_tk_insert_date)
    VALUES (NEW.pt_id, v_tk_id, NOW())
    ON CONFLICT DO NOTHING;

    FOR v_ql_id IN 
        SELECT ql_id 
        FROM Expertise_Qualifier 
        WHERE ex_id = NEW.ex_id
    LOOP
        INSERT INTO Partner_Qualifier (pt_id, ql_id, pt_ql_insert_date)
        VALUES (NEW.pt_id, v_ql_id, NOW())
        ON CONFLICT DO NOTHING;
    END LOOP;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_partner_expertise_insert
AFTER INSERT ON Partner_Expertise
FOR EACH ROW
EXECUTE FUNCTION trigger_partner_expertise();

CREATE OR REPLACE FUNCTION trigger_partner_qualifier_complete() 
RETURNS TRIGGER AS $$
DECLARE
    v_ex_id INTEGER;
    v_complete BOOLEAN;
BEGIN
    SELECT ex_id INTO v_ex_id
    FROM Expertise_Qualifier
    WHERE ql_id = NEW.ql_id;

    SELECT COUNT(*) = 0 INTO v_complete
    FROM Expertise_Qualifier eq
    LEFT JOIN Partner_Qualifier pq ON eq.ql_id = pq.ql_id AND pq.pt_id = NEW.pt_id
    WHERE eq.ex_id = v_ex_id AND pq.pt_ql_complete_date IS NULL;

    IF v_complete THEN
        UPDATE Partner_Expertise
        SET pt_ex_complete_date = NEW.pt_ql_complete_date
        WHERE pt_id = NEW.pt_id AND ex_id = v_ex_id;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER after_partner_qualifier_update
AFTER UPDATE OF pt_ql_complete_date ON Partner_Qualifier
FOR EACH ROW
WHEN (NEW.pt_ql_complete_date IS NOT NULL)
EXECUTE FUNCTION trigger_partner_qualifier_complete();
