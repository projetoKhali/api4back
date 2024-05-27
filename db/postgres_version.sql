-- Postgres ddl version

-- tables

-- Table: Partner
CREATE TABLE Partner (
    pt_id SERIAL UNIQUE,
    pt_company_id varchar NOT NULL UNIQUE,
    pt_name varchar NOT NULL,
    pt_admin_name varchar NOT NULL,
    pt_admin_email varchar NOT NULL,
    pt_slogan varchar NOT NULL,
    pt_country varchar NOT NULL,
    pt_city varchar NOT NULL,
    pt_address varchar NOT NULL,
    pt_compliance boolean NOT NULL,
    pt_credit boolean NOT NULL,
    pt_status boolean NOT NULL,
    pt_member_type boolean NOT NULL,
    pt_insert_date date DEFAULT NOW() NOT NULL,
    CONSTRAINT Partner_pk PRIMARY KEY (pt_id)
) ;

-- Table: Expertise
CREATE TABLE Expertise (
    ex_id SERIAL UNIQUE,
    ex_name varchar UNIQUE NOT NULL,
    tk_id integer NOT NULL,
    CONSTRAINT Expertise_pk PRIMARY KEY (ex_id)
) ;

-- Table: Qualifier
CREATE TABLE Qualifier (
    ql_id SERIAL UNIQUE,
    ql_name varchar UNIQUE NOT NULL,
    CONSTRAINT Qualifier_pk PRIMARY KEY (ql_id)
) ;

-- Table: Expertise_Qualifier
CREATE TABLE Expertise_Qualifier (
    ex_ql_id SERIAL UNIQUE,
    ex_id integer NOT NULL,
    ql_id integer NOT NULL,
    CONSTRAINT ex_ql_unique UNIQUE (ex_id, ql_id),
    CONSTRAINT Expertise_Qualifier_pk PRIMARY KEY (ex_ql_id)
) ;

-- Table: Partner_Expertise
CREATE TABLE Partner_Expertise (
    pt_ex_id SERIAL UNIQUE,
    pt_id integer NOT NULL,
    ex_id integer NOT NULL,
    pt_ex_insert_date date DEFAULT CURRENT_DATE NOT NULL,
    pt_ex_complete_date date NULL,
    CONSTRAINT pt_ex_unique UNIQUE (pt_id, ex_id),
    CONSTRAINT Partner_Expertise_pk PRIMARY KEY (pt_ex_id)
) ;

-- Table: Partner_Qualifier
CREATE TABLE Partner_Qualifier (
    pt_ql_id SERIAL UNIQUE,
    pt_id integer NOT NULL,
    ql_id integer NOT NULL,
    pt_ql_insert_date date DEFAULT CURRENT_DATE NOT NULL,
    pt_ql_complete_date date NULL,
    CONSTRAINT pt_ql_unique UNIQUE (pt_id, ql_id),
    CONSTRAINT Partner_Qualifier_pk PRIMARY KEY (pt_ql_id)
) ;

-- Table: Partner_Track
CREATE TABLE Partner_Track (
    pt_tk_id SERIAL UNIQUE,
    pt_id integer NOT NULL,
    tk_id integer NOT NULL,
    pt_tk_insert_date date DEFAULT now() NOT NULL,
    pt_tk_complete_date date NULL,
    CONSTRAINT pt_tk_unique UNIQUE (pt_id, tk_id),
    CONSTRAINT Partner_Track_pk PRIMARY KEY (pt_tk_id)
) ;

-- Table: Track
CREATE TABLE Track (
    tk_id SERIAL UNIQUE,
    tk_name varchar NOT NULL UNIQUE,
    tk_insert_date date NOT NULL,
    CONSTRAINT Track_pk PRIMARY KEY (tk_id)
) ;

-- Table: User
CREATE TABLE Users (
    usr_id SERIAL UNIQUE,
    usr_login varchar NOT NULL UNIQUE,
    usr_name varchar NOT NULL,
    usr_profile_type boolean NOT NULL,
    usr_password varchar NOT NULL,
    CONSTRAINT User_pk PRIMARY KEY (usr_id)
) ;

-- foreign keys
-- Reference: Expertise_Track (table: Expertise)
ALTER TABLE Expertise ADD CONSTRAINT Expertise_Track
    FOREIGN KEY (tk_id)
    REFERENCES Track (tk_id);

-- Reference: Expertise_Qualifiers_Expertise (table: Expertise_Qualifier)
ALTER TABLE Expertise_Qualifier ADD CONSTRAINT Expertise_Qualifiers_Expertise
    FOREIGN KEY (ex_id)
    REFERENCES Expertise (ex_id);

-- Reference: Expertise_Qualifiers_Qualifiers (table: Expertise_Qualifier)
ALTER TABLE Expertise_Qualifier ADD CONSTRAINT Expertise_Qualifiers_Qualifiers
    FOREIGN KEY (ql_id)
    REFERENCES Qualifier (ql_id);

-- Reference: Partner_Expertise_Expertise (table: Partner_Expertise)
ALTER TABLE Partner_Expertise ADD CONSTRAINT Partner_Expertise_Expertise
    FOREIGN KEY (ex_id)
    REFERENCES Expertise (ex_id);

-- Reference: Partner_Expertise_Partner (table: Partner_Expertise)
ALTER TABLE Partner_Expertise ADD CONSTRAINT Partner_Expertise_Partner
    FOREIGN KEY (pt_id)
    REFERENCES Partner (pt_id);

-- Reference: Partner_Qualifiers_Partner (table: Partner_Qualifier)
ALTER TABLE Partner_Qualifier ADD CONSTRAINT Partner_Qualifiers_Partner
    FOREIGN KEY (pt_id)
    REFERENCES Partner (pt_id);

-- Reference: Partner_Qualifiers_Qualifiers (table: Partner_Qualifier)
ALTER TABLE Partner_Qualifier ADD CONSTRAINT Partner_Qualifiers_Qualifiers
    FOREIGN KEY (ql_id)
    REFERENCES Qualifier (ql_id);

-- Reference: Partner_Track_Partner (table: Partner_Track)
ALTER TABLE Partner_Track ADD CONSTRAINT Partner_Track_Partner
    FOREIGN KEY (pt_id)
    REFERENCES Partner (pt_id);

-- Reference: Partner_Track_Track (table: Partner_Track)
ALTER TABLE Partner_Track ADD CONSTRAINT Partner_Track_Track
    FOREIGN KEY (tk_id)
    REFERENCES Track (tk_id);
