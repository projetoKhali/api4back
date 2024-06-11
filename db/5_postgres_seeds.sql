-- TRACK
INSERT INTO Track (tk_name, tk_insert_date) VALUES
('Cloud Build', CURRENT_DATE),
('Cloud Sell', CURRENT_DATE),
('Cloud Service', CURRENT_DATE),
('Cloud Industry Healthcare', CURRENT_DATE)


-- EXPERTISE
INSERT INTO Expertise (ex_name, tk_id) VALUES
('Application Development', 1),
('DevOps', 1),
('Cloud Native', 1),
('On-premises Solutions', 1),

('Cloud Sales', 2),
('Customer Acquisition', 2),
('Solution Selling', 2),
('Software Licensing', 2),

('Cloud Implementation', 3),
('Cloud Migration', 3),
('Managed Services', 3),

('License Management', 4),
('Hardware Integration', 4),
('Cloud Licensing', 4),
('Hardware Sales', 4),

-- QUALIFIER
INSERT INTO Qualifier (ql_name) VALUES

-- Application Development Qualifiers (Cloud Build)
('App Dev Fundamentals'),           -- ql_id = 1
('Advanced App Dev Techniques'),    -- ql_id = 2
('App Dev Certification Exam'),     -- ql_id = 3
('Cloud Native App Dev'),           -- ql_id = 4
('Microservices Architecture'),     -- ql_id = 5
('Application Security'),           -- ql_id = 6

-- DevOps Qualifiers (Cloud Build)
('DevOps Fundamentals'),            -- ql_id = 7
('Continuous Integration & Delivery'), -- ql_id = 8
('Infrastructure as Code'),         -- ql_id = 9
('DevOps Certification Exam'),      -- ql_id = 10
('Monitoring & Logging'),           -- ql_id = 11
('DevOps Security Practices'),      -- ql_id = 12
('Automated Testing'),              -- ql_id = 13
('Container Orchestration'),        -- ql_id = 14

-- Cloud Native Qualifiers (Cloud Build)
('Cloud Native Fundamentals'),      -- ql_id = 15
('Kubernetes Certification'),       -- ql_id = 16
('Serverless Architecture'),        -- ql_id = 17
('Cloud Native Security'),          -- ql_id = 18
('Containerization'),               -- ql_id = 19
('Advanced Cloud Native Practices'), -- ql_id = 20
('Microservices Deployment'),       -- ql_id = 21

-- Cloud Sales Qualifiers (Cloud Sell)
('Cloud Sales Basics'),             -- ql_id = 22
('Advanced Cloud Selling Techniques'), -- ql_id = 23
('Customer Relationship Management'), -- ql_id = 24
('Salesforce Integration'),         -- ql_id = 25
('Cloud Pricing Strategies'),       -- ql_id = 26
('Cloud Contract Negotiation'),     -- ql_id = 27
('Solution Selling for Cloud'),     -- ql_id = 28
('Value-Based Selling'),            -- ql_id = 29

-- Customer Acquisition Qualifiers (Cloud Sell)
('Lead Generation Strategies'),     -- ql_id = 30
('Customer Acquisition Certification'), -- ql_id = 31
('Digital Marketing for Cloud'),    -- ql_id = 32
('Sales Funnel Optimization'),      -- ql_id = 33
('Customer Onboarding Techniques'), -- ql_id = 34
('Retention and Loyalty Programs'), -- ql_id = 35
('Market Analysis'),                -- ql_id = 36

-- Solution Selling Qualifiers (Cloud Sell)
('Solution Selling Fundamentals'),  -- ql_id = 37
('Building Customer Solutions'),    -- ql_id = 38
('Sales Solution Certification'),   -- ql_id = 39
('Customer Needs Assessment'),      -- ql_id = 40
('Value Proposition Development'),  -- ql_id = 41
('Advanced Solution Selling'),      -- ql_id = 42
('Solution Presentation Skills'),   -- ql_id = 43

-- Cloud Implementation Qualifiers (Cloud Service)
('Implementation Fundamentals'),    -- ql_id = 44
('Cloud Service Deployment'),       -- ql_id = 45
('Cloud Implementation Certification'), -- ql_id = 46
('Data Migration Strategies'),      -- ql_id = 47
('Integration Techniques'),         -- ql_id = 48
('Implementation Project Management'), -- ql_id = 49
('Risk Management in Cloud'),       -- ql_id = 50

-- Cloud Migration Qualifiers (Cloud Service)
('Cloud Migration Basics'),         -- ql_id = 51
('Migration Certification'),        -- ql_id = 52
('Legacy System Modernization'),    -- ql_id = 53
('Data Transfer Methods'),          -- ql_id = 54
('Cloud Migration Security'),       -- ql_id = 55
('Advanced Migration Techniques'),  -- ql_id = 56

-- Managed Services Qualifiers (Cloud Service)
('Managed Services Fundamentals'),  -- ql_id = 57
('Managed Services Certification'), -- ql_id = 58
('Service Level Agreements'),       -- ql_id = 59
('IT Service Management'),          -- ql_id = 60
('Monitoring and Maintenance'),     -- ql_id = 61
('Managed Security Services'),      -- ql_id = 62
('Disaster Recovery Planning'),     -- ql_id = 63
('Cloud Cost Management'),          -- ql_id = 64

-- License Management Qualifiers (Cloud License & Hardware)
('License Management Fundamentals'), -- ql_id = 65
('License Compliance Certification'), -- ql_id = 66
('Software Asset Management'),      -- ql_id = 67
('License Auditing Techniques'),    -- ql_id = 68
('Contract Negotiation Skills'),    -- ql_id = 69
('Advanced License Management'),    -- ql_id = 70

-- Hardware Integration Qualifiers (Cloud License & Hardware)
('Hardware Integration Basics'),    -- ql_id = 71
('System Integration Certification'), -- ql_id = 72
('Hardware Performance Tuning'),    -- ql_id = 73
('Network Integration Techniques'), -- ql_id = 74
('Hardware Troubleshooting'),       -- ql_id = 75
('Advanced Hardware Integration'),  -- ql_id = 76
('IoT Integration'),                -- ql_id = 77
('Edge Computing Solutions'),       -- ql_id = 78

-- Cloud Licensing Qualifiers (Cloud License & Hardware)
('Cloud Licensing Basics'),         -- ql_id = 79
('Cloud Licensing Certification'),  -- ql_id = 80
('Subscription Management'),        -- ql_id = 81
('Usage Monitoring and Reporting'), -- ql_id = 82
('Advanced Cloud Licensing'),       -- ql_id = 83

-- On-premises Solutions Qualifiers (License and Hardware)
('On-prem Solutions Fundamentals'), -- ql_id = 84
('On-prem Solutions Certification'), -- ql_id = 85
('Infrastructure Management'),      -- ql_id = 86
('Data Center Operations'),         -- ql_id = 87
('Security and Compliance'),        -- ql_id = 88
('Advanced On-prem Solutions'),     -- ql_id = 89

-- Software Licensing Qualifiers (License and Hardware)
('Software Licensing Basics'),      -- ql_id = 90
('Software Licensing Certification'), -- ql_id = 91
('License Compliance'),             -- ql_id = 92
('Contract Negotiation'),           -- ql_id = 93
('Advanced Software Licensing'),    -- ql_id = 94

-- Hardware Sales Qualifiers (License and Hardware)
('Hardware Sales Fundamentals'),    -- ql_id = 95
('Sales Techniques Certification'), -- ql_id = 96
('Product Knowledge'),              -- ql_id = 97
('Sales Performance Metrics'),      -- ql_id = 98
('Advanced Hardware Sales'),        -- ql_id = 99

-- EXPERTISE_QUALIFIER
INSERT INTO Expertise_Qualifier (ex_id, ql_id) VALUES

-- Application Development Qualifiers (Cloud Build)
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6),

-- DevOps Qualifiers (Cloud Build)
(2, 7), (2, 8), (2, 9), (2, 10), (2, 11), (2, 12), (2, 13), (2, 14),

-- Cloud Native Qualifiers (Cloud Build)
(3, 15), (3, 16), (3, 17), (3, 18), (3, 19), (3, 20), (3, 21),

-- Cloud Sales Qualifiers (Cloud Sell)
(4, 22), (4, 23), (4, 24), (4, 25), (4, 26), (4, 27), (4, 28), (4, 29),

-- Customer Acquisition Qualifiers (Cloud Sell)
(5, 30), (5, 31), (5, 32), (5, 33), (5, 34), (5, 35), (5, 36),

-- Solution Selling Qualifiers (Cloud Sell)
(6, 37), (6, 38), (6, 39), (6, 40), (6, 41), (6, 42), (6, 43),

-- Cloud Implementation Qualifiers (Cloud Service)
(7, 44), (7, 45), (7, 46), (7, 47), (7, 48), (7, 49), (7, 50),

-- Cloud Migration Qualifiers (Cloud Service)
(8, 51), (8, 52), (8, 53), (8, 54), (8, 55), (8, 56),

-- Managed Services Qualifiers (Cloud Service)
(9, 57), (9, 58), (9, 59), (9, 60), (9, 61), (9, 62), (9, 63), (9, 64),

-- License Management Qualifiers (Cloud License & Hardware)
(10, 65), (10, 66), (10, 67), (10, 68), (10, 69), (10, 70),

-- Hardware Integration Qualifiers (Cloud License & Hardware)
(11, 71), (11, 72), (11, 73), (11, 74), (11, 75), (11, 76), (11, 77), (11, 78),

-- Cloud Licensing Qualifiers (Cloud License & Hardware)
(12, 79), (12, 80), (12, 81), (12, 82), (12, 83),

-- On-premises Solutions Qualifiers (License and Hardware)
(13, 84), (13, 85), (13, 86), (13, 87), (13, 88), (13, 89),

-- Software Licensing Qualifiers (License and Hardware)
(14, 90), (14, 91), (14, 92), (14, 93), (14, 94),

-- Hardware Sales Qualifiers (License and Hardware)
(15, 95), (15, 96), (15, 97), (15, 98), (15, 99),


-- PARTNER
INSERT INTO Partner (
    pt_id, 
    pt_company_id, 
    pt_name, 
    pt_admin_name, 
    pt_admin_email, 
    pt_compliance, 
    pt_credit, 
    pt_status, 
    pt_member_type, 
    pt_insert_date,    
    pt_slogan, 
    pt_country, 
    pt_city, 
    pt_address
) VALUES 
(1, 'COMP123456', 'Tech Solutions Inc.', 'Alice Johnson', 'alice.johnson@techsolutions.com', TRUE, TRUE, TRUE, TRUE, NOW(), 'Innovating the Future', 'Brazil', 'SP', '123 Tech Lane'),
(2, 'COMP654321', 'Green Energy Ltd.', 'Bob Smith', 'bob.smith@greenenergy.com', TRUE, FALSE, TRUE, FALSE, NOW(), 'Powering a Sustainable World', 'Brazil', 'SP', '456 Green Blvd'),
(3, 'COMP789012', 'HealthCare Partners', 'Catherine Lee', 'catherine.lee@healthcarepartners.com', FALSE, TRUE, FALSE, TRUE, NOW(), 'Your Health, Our Priority', 'Brazil', 'RJ', '789 Care St'),
(4, 'COMP345678', 'Finance Solutions', 'David Brown', 'david.brown@financesolutions.com', TRUE, TRUE, TRUE, FALSE, NOW(), 'Financial Freedom for All', 'Brazil', 'SC', '101 Finance Ave'),

INSERT INTO Partner_Expertise (pt_id, ex_id) VALUES
(1, 1), (1, 2),
(2, 1), (2, 5), (2, 6),
(3, 1), (3, 5), (3, 9), (3, 10),
(4, 3), (4, 7), (3, 11), (3, 15);

-- USER
INSERT INTO Users (usr_login, usr_name, usr_profile_type, usr_password) VALUES 
('ajohnson', 'Alice Johnson', TRUE, 'password123'),
('bsmith', 'Bob Smith', FALSE, 'securepass456'),
('clee', 'Catherine Lee', TRUE, 'catlee789'),
('dbrown', 'David Brown', FALSE, 'davidb123'),
('egreen', 'Eva Green', TRUE, 'evagreen789'),
('fwhite', 'Frank White', FALSE, 'frankw456'),
('gbrown', 'Grace Brown', TRUE, 'gracebrown123'),
('hclark', 'Henry Clark', FALSE, 'henryc789'),
('iblack', 'Irene Black', TRUE, 'ireneblack456'),
('jwilson', 'Jack Wilson', FALSE, 'jackw123'),
('kwalker', 'Karen Walker', TRUE, 'karenw456'),
('lking', 'Leo King', FALSE, 'leoking789'),
('mlewis', 'Maria Lewis', TRUE, 'marialewis123'),
('nyoung', 'Nathan Young', FALSE, 'nathany456'),
('oharris', 'Olivia Harris', TRUE, 'oliviah789'),
('pmartinez', 'Paul Martinez', FALSE, 'paulm123'),
('qscott', 'Quincy Scott', TRUE, 'quincys456');
