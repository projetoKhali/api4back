-- Table: Partner
CREATE TABLE Partner (
    pt_id BIGINT PRIMARY KEY,
    pt_name VARCHAR(255),
    pt_admin_name VARCHAR(255),
    pt_admin_email VARCHAR(255),
    pt_slogan VARCHAR(255),
    pt_country VARCHAR(255),
    pt_city VARCHAR(255),
    pt_address VARCHAR(255),
    pt_compliance BOOLEAN,
    pt_credit BOOLEAN,
    pt_status BOOLEAN,
    pt_member_type BOOLEAN,
    pt_first_date_membership DATE
);

-- Table: Track
CREATE TABLE Track (
    tk_id serial PRIMARY KEY,
    tk_name varchar NOT NULL,
    tk_insert_date date DEFAULT CURRENT_DATE NOT NULL
);
