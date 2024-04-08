-- Table: Partner
/*CREATE TABLE Partner (
    pt_id varchar PRIMARY KEY,
    pt_company_id varchar NOT NULL UNIQUE,
    pt_name varchar NOT NULL,
    pt_admin_name varchar NOT NULL,
    pt_admin_email varchar NOT NULL,
    pt_compliance boolean NOT NULL,
    pt_credit boolean NOT NULL,
    pt_status boolean NOT NULL,
    pt_membership date DEFAULT CURRENT_DATE NOT NULL,
    pt_slogan varchar NOT NULL,
    pt_country varchar NOT NULL,
    pt_city varchar NOT NULL,
    pt_number varchar NOT NULL,
    pt_address varchar NOT NULL
)*/
-- Cria a tabela Partner
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