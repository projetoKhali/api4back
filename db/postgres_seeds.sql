-- Inserting data into the Track table
INSERT INTO Track (tk_name, tk_insert_date, tk_complete_date)
VALUES
( 'Track 1', '2024-02-25', '2024-03-01'),
( 'Track 2', '2024-03-14', '2024-03-15')
ON CONFLICT DO NOTHING;

-- Inserting data into the Partner table
INSERT INTO Partner (pt_company_id, pt_name, pt_admin_name, pt_admin_email, pt_slogan, pt_country, pt_city, pt_address, pt_compliance, pt_credit, pt_status, pt_member_type, pt_insert_date)
VALUES
('ABC123', 'Company A', 'Admin A', 'admin_a@example.com', 'Slogan A', 'Country A', 'City A', 'Address A', TRUE, TRUE, TRUE, TRUE, '2023-01-15'),
('DEF456', 'Company B', 'Admin B', 'admin_b@example.com', 'Slogan B', 'Country B', 'City B', 'Address B', TRUE, TRUE, TRUE, TRUE, '2023-02-20')
ON CONFLICT DO NOTHING;

-- Inserting data into the Expertise table
INSERT INTO Expertise (ex_name, tk_id)
VALUES
('Expertise 1', 1),
('Expertise 2', 2),
('Expertise 3', 2)
ON CONFLICT DO NOTHING;

-- Inserting data into the Qualifier table
INSERT INTO Qualifier (ql_name)
VALUES
('Qualifier 1'),
('Qualifier 2'),
('Qualifier 3')
ON CONFLICT DO NOTHING;

-- Inserting data into the Expertise_Qualifier table
INSERT INTO Expertise_Qualifier (ex_id, ql_id)
VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 3)
ON CONFLICT DO NOTHING;

-- Inserting data into the Partner_Expertise table
INSERT INTO Partner_Expertise (pt_id, ex_id, pt_ex_complete_date)
VALUES
(1, 1, '2024-03-01'),
(2, 2, '2024-03-15')
ON CONFLICT DO NOTHING;

-- Inserting data into the Partner_Qualifier table
INSERT INTO Partner_Qualifier (pt_id, ql_id, pt_ql_complete_date)
VALUES
(1, 1, '2024-03-05'),
(2, 2, '2024-03-20')
ON CONFLICT DO NOTHING;

-- Inserting data into the Partner_Track table
INSERT INTO Partner_Track (pt_id, tk_id, pt_tk_insert_date)
VALUES
(1, 1, '2024-03-01'),
(2, 2, '2024-03-15')
ON CONFLICT DO NOTHING;
