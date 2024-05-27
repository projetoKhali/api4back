-- TRACK
INSERT INTO Track (tk_name, tk_insert_date) VALUES
('Cloud Build', CURRENT_DATE),
('Cloud Sell', CURRENT_DATE),
('Cloud Service', CURRENT_DATE),
('Cloud License & Hardware', CURRENT_DATE),
('License and Hardware', CURRENT_DATE),
('Implementation', CURRENT_DATE),
('Services', CURRENT_DATE),
('Training and Education', CURRENT_DATE);

-- EXPERTISE
INSERT INTO Expertise (ex_name, tk_id) VALUES
-- Expertises for Cloud Build (tk_id = 1)
('Application Development', 1),
('DevOps', 1),
('Cloud Native', 1),

-- Expertises for Cloud Sell (tk_id = 2)
('Cloud Sales', 2),
('Customer Acquisition', 2),
('Solution Selling', 2),

-- Expertises for Cloud Service (tk_id = 3)
('Cloud Implementation', 3),
('Cloud Migration', 3),
('Managed Services', 3),

-- Expertises for Cloud License & Hardware (tk_id = 4)
('License Management', 4),
('Hardware Integration', 4),
('Cloud Licensing', 4),

-- Expertises for License and Hardware (tk_id = 5)
('On-premises Solutions', 5),
('Software Licensing', 5),
('Hardware Sales', 5),

-- Expertises for Implementation (tk_id = 6)
('System Integration', 6),
('Business Process Automation', 6),
('ERP Implementation', 6),

-- Expertises for Services (tk_id = 7)
('Consulting', 7),
('Technical Support', 7),
('Managed IT Services', 7),

-- Expertises for Training and Education (tk_id = 8)
('Oracle Training', 8),
('Certification Programs', 8),
('Educational Services', 8);

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
(1, 'COMP123456', 'Tech Solutions Inc.', 'Alice Johnson', 'alice.johnson@techsolutions.com', TRUE, TRUE, TRUE, TRUE, NOW(), 'Innovating the Future', 'USA', 'San Francisco', '123 Tech Lane'),
(2, 'COMP654321', 'Green Energy Ltd.', 'Bob Smith', 'bob.smith@greenenergy.com', TRUE, FALSE, TRUE, FALSE, NOW(), 'Powering a Sustainable World', 'Canada', 'Toronto', '456 Green Blvd'),
(3, 'COMP789012', 'HealthCare Partners', 'Catherine Lee', 'catherine.lee@healthcarepartners.com', FALSE, TRUE, FALSE, TRUE, NOW(), 'Your Health, Our Priority', 'UK', 'London', '789 Care St'),
(4, 'COMP345678', 'Finance Solutions', 'David Brown', 'david.brown@financesolutions.com', TRUE, TRUE, TRUE, FALSE, NOW(), 'Financial Freedom for All', 'Australia', 'Sydney', '101 Finance Ave'),
(5, 'COMP987654', 'EduTech Innovations', 'Eva Green', 'eva.green@edutech.com', FALSE, FALSE, TRUE, TRUE, NOW(), 'Educating for Tomorrow', 'India', 'Bangalore', '202 Edu St'),
(6, 'COMP112233', 'AgriCorp', 'Frank White', 'frank.white@agricorp.com', TRUE, TRUE, TRUE, TRUE, NOW(), 'Growing Together', 'Brazil', 'São Paulo', '333 Agri Rd'),
(7, 'COMP445566', 'Urban Developers', 'Grace Brown', 'grace.brown@urbandevelopers.com', TRUE, TRUE, FALSE, TRUE, NOW(), 'Building the Future', 'Germany', 'Berlin', '444 Urban Ln'),
(8, 'COMP778899', 'Smart Home Systems', 'Henry Clark', 'henry.clark@smarthome.com', FALSE, FALSE, TRUE, FALSE, NOW(), 'Smart Living Made Easy', 'Japan', 'Tokyo', '555 Smart St'),
(9, 'COMP991122', 'FoodTech Co.', 'Irene Black', 'irene.black@foodtech.com', TRUE, FALSE, FALSE, TRUE, NOW(), 'Feeding the Future', 'France', 'Paris', '666 Food Blvd'),
(10, 'COMP334455', 'Auto Innovations', 'Jack Wilson', 'jack.wilson@autoinnovations.com', TRUE, TRUE, TRUE, TRUE, NOW(), 'Driving the Future', 'South Korea', 'Seoul', '777 Auto Ave'),
(11, 'COMP667788', 'Travel Easy Ltd.', 'Karen Walker', 'karen.walker@traveleasy.com', FALSE, TRUE, TRUE, FALSE, NOW(), 'Making Travel Simple', 'Italy', 'Rome', '888 Travel St'),
(12, 'COMP998877', 'FinTech Innovations', 'Leo King', 'leo.king@fintech.com', TRUE, FALSE, FALSE, TRUE, NOW(), 'Revolutionizing Finance', 'Spain', 'Madrid', '999 Finance Blvd'),
(13, 'COMP221133', 'HealthFirst', 'Maria Lewis', 'maria.lewis@healthfirst.com', FALSE, TRUE, TRUE, FALSE, NOW(), 'Health Comes First', 'Netherlands', 'Amsterdam', '101 Health Ln'),
(14, 'COMP554466', 'Solar Solutions', 'Nathan Young', 'nathan.young@solarsolutions.com', TRUE, TRUE, FALSE, TRUE, NOW(), 'Harnessing Solar Power', 'China', 'Beijing', '202 Solar Rd'),
(15, 'COMP887799', 'Cloud Computing Co.', 'Olivia Harris', 'olivia.harris@cloudcomputing.com', TRUE, FALSE, TRUE, FALSE, NOW(), 'Computing in the Cloud', 'Singapore', 'Singapore', '303 Cloud Ave'),
(16, 'COMP332255', 'AI Innovators', 'Paul Martinez', 'paul.martinez@aiinnovators.com', FALSE, TRUE, TRUE, TRUE, NOW(), 'Innovating with AI', 'Israel', 'Tel Aviv', '404 AI St'),
(17, 'COMP665577', 'Renewable Energy Inc.', 'Quincy Scott', 'quincy.scott@renewableenergy.com', TRUE, TRUE, FALSE, TRUE, NOW(), 'Sustainable Energy for All', 'Norway', 'Oslo', '505 Energy Blvd');

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

-- System Integration Qualifiers (Implementation)
('System Integration Basics'),      -- ql_id = 100
('Integration Certification'),      -- ql_id = 101
('Data Integration Techniques'),    -- ql_id = 102
('API Management'),                 -- ql_id = 103
('System Architecture'),            -- ql_id = 104
('Advanced Integration Practices'), -- ql_id = 105
('Integration Security'),           -- ql_id = 106

-- Business Process Automation Qualifiers (Implementation)
('Automation Fundamentals'),        -- ql_id = 107
('Process Automation Certification'), -- ql_id = 108
('Workflow Management'),            -- ql_id = 109
('Robotic Process Automation'),     -- ql_id = 110
('BPM Tools and Techniques'),       -- ql_id = 111
('Advanced Automation Strategies'), -- ql_id = 112
('Process Optimization'),           -- ql_id = 113

-- ERP Implementation Qualifiers (Implementation)
('ERP Fundamentals'),               -- ql_id = 114
('ERP Implementation Certification'), -- ql_id = 115
('Business Process Mapping'),       -- ql_id = 116
('ERP Configuration'),              -- ql_id = 117
('Data Migration for ERP'),         -- ql_id = 118
('Advanced ERP Implementation'),    -- ql_id = 119
('ERP Customization'),              -- ql_id = 120

-- Consulting Qualifiers (Services)
('Consulting Fundamentals'),        -- ql_id = 121
('Consulting Certification'),       -- ql_id = 122
('Business Analysis'),              -- ql_id = 123
('Solution Design'),                -- ql_id = 124
('Client Relationship Management'), -- ql_id = 125
('Advanced Consulting Skills'),     -- ql_id = 126
('Strategic Planning'),             -- ql_id = 127

-- Technical Support Qualifiers (Services)
('Technical Support Basics'),       -- ql_id = 128
('Support Certification'),          -- ql_id = 129
('Troubleshooting Techniques'),     -- ql_id = 130
('Customer Service Skills'),        -- ql_id = 131
('Incident Management'),            -- ql_id = 132
('Advanced Technical Support'),     -- ql_id = 133

-- Managed IT Services Qualifiers (Services)
('Managed IT Services Basics'),     -- ql_id = 134
('IT Services Certification'),      -- ql_id = 135
('Service Delivery Management'),    -- ql_id = 136
('Client IT Management'),           -- ql_id = 137
('IT Performance Metrics'),         -- ql_id = 138
('Advanced IT Services'),           -- ql_id = 139

-- Oracle Training Qualifiers (Training and Education)
('Oracle Training Fundamentals'),   -- ql_id = 140
('Training Certification'),         -- ql_id = 141
('Course Development'),             -- ql_id = 142
('Instructional Design'),           -- ql_id = 143
('Virtual Classroom Management'),   -- ql_id = 144
('Advanced Oracle Training'),       -- ql_id = 145

-- Certification Programs Qualifiers (Training and Education)
('Certification Program Management'), -- ql_id = 146
('Exam Development'),               -- ql_id = 147
('Certification Administration'),   -- ql_id = 148
('Training Delivery Methods'),      -- ql_id = 149
('Candidate Support'),              -- ql_id = 150
('Advanced Certification Programs'), -- ql_id = 151
('Assessment Techniques'),          -- ql_id = 152

-- Educational Services Qualifiers (Training and Education)
('Educational Services Basics'),    -- ql_id = 153
('Educational Services Certification'), -- ql_id = 154
('Curriculum Development'),         -- ql_id = 155
('Learning Management Systems'),    -- ql_id = 156
('Student Engagement Strategies'),  -- ql_id = 157
('Advanced Educational Services');  -- ql_id = 158

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

-- System Integration Qualifiers (Implementation)
(16, 100), (16, 101), (16, 102), (16, 103), (16, 104), (16, 105), (16, 106),

-- Business Process Automation Qualifiers (Implementation)
(17, 107), (17, 108), (17, 109), (17, 110), (17, 111), (17, 112), (17, 113),

-- ERP Implementation Qualifiers (Implementation)
(18, 114), (18, 115), (18, 116), (18, 117), (18, 118), (18, 119), (18, 120),

-- Consulting Qualifiers (Services)
(19, 121), (19, 122), (19, 123), (19, 124), (19, 125), (19, 126), (19, 127),

-- Technical Support Qualifiers (Services)
(20, 128), (20, 129), (20, 130), (20, 131), (20, 132), (20, 133),

-- Managed IT Services Qualifiers (Services)
(21, 134), (21, 135), (21, 136), (21, 137), (21, 138), (21, 139),

-- Oracle Training Qualifiers (Training and Education)
(22, 140), (22, 141), (22, 142), (22, 143), (22, 144), (22, 145),

-- Certification Programs Qualifiers (Training and Education)
(23, 146), (23, 147), (23, 148), (23, 149), (23, 150), (23, 151), (23, 152),

-- Educational Services Qualifiers (Training and Education)
(24, 153), (24, 154), (24, 155), (24, 156), (24, 157), (24, 158);

-- Adding shared qualifiers (around 30%)

INSERT INTO Expertise_Qualifier (ex_id, ql_id) VALUES

-- 'Advanced App Dev Techniques' shared with 'Cloud Native'
(3, 2),

-- 'App Dev Certification Exam' shared with 'DevOps'
(2, 3),

-- 'Cloud Native Fundamentals' shared with 'DevOps'
(2, 15),

-- 'Kubernetes Certification' shared with 'DevOps'
(2, 16),

-- 'Salesforce Integration' shared with 'Customer Acquisition'
(5, 25),

-- 'Sales Solution Certification' shared with 'Cloud Sales'
(4, 39),

-- 'Cloud Contract Negotiation' shared with 'Cloud Licensing'
(12, 27),

-- 'Customer Needs Assessment' shared with 'Hardware Sales'
(15, 40),

-- 'Data Migration Strategies' shared with 'Cloud Migration'
(8, 47),

-- 'Cloud Implementation Certification' shared with 'Managed Services'
(9, 46),

-- 'Data Migration for ERP' shared with 'System Integration'
(16, 118),

-- 'Client Relationship Management' shared with 'Technical Support'
(20, 125),

-- 'Certification Program Management' shared with 'Oracle Training'
(22, 146);

-- PARTNER TRACK
INSERT INTO Partner_Track (pt_id, tk_id) VALUES
-- Partner 1 - Tech Solutions Inc.
(1, 1), (1, 2), (1, 3),
-- Partner 2 - Green Energy Ltd.
(2, 2), (2, 3), (2, 4), (2, 5),
-- Partner 3 - HealthCare Partners
(3, 3), (3, 4), (3, 5),
-- Partner 4 - Finance Solutions
(4, 4), (4, 5), (4, 6), (4, 7),
-- Partner 5 - EduTech Innovations
(5, 5), (5, 6), (5, 7), (5, 8),
-- Partner 6 - AgriCorp
(6, 6), (6, 7), (6, 8), (6, 1),
-- Partner 7 - Urban Developers
(7, 7), (7, 8), (7, 1), (7, 2),
-- Partner 8 - Smart Home Systems
(8, 7), (8, 1), (8, 2), (8, 3),
-- Partner 9 - FoodTech Co.
(9, 6), (9, 1), (9, 2), (9, 3),
-- Partner 10 - Auto Innovations
(10, 6), (10, 3), (10, 4), (10, 5),
-- Partner 11 - Travel Easy Ltd.
(11, 8), (11, 4), (11, 5), (11, 6),
-- Partner 12 - FinTech Innovations
(12, 3), (12, 5), (12, 6), (12, 7),
-- Partner 13 - HealthFirst
(13, 2), (13, 6), (13, 7), (13, 8),
-- Partner 14 - Solar Solutions
(14, 6), (14, 7), (14, 8), (14, 1),
-- Partner 15 - Cloud Computing Co.
(15, 4), (15, 8), (15, 1), (15, 2),
-- Partner 16 - AI Innovators
(16, 7), (16, 2), (16, 3), (16, 4),
-- Partner 17 - Renewable Energy Inc.
(17, 6), (17, 3), (17, 4), (17, 5);

-- PARTNER QUALIFIER
INSERT INTO Partner_Expertise (pt_id, ex_id) VALUES
(1, 1), (1, 22), (1, 5),
(2, 1), (2, 18),
(3, 3), (3, 10), (3, 1), (3, 16), (3, 7),
(4, 1), (4, 20), (4, 14),
(5, 9), (5, 2),
(6, 1), (6, 13), (6, 2), (6, 24),
(7, 11),
(8, 14), (8, 8), (8, 17), (8, 6),
(9, 13), (9, 22), (9, 11),
(10, 7), (10, 4), (10, 19),
(11, 15), (11, 12), (11, 3), (11, 9), (11, 1),
(12, 1), (12, 2), (12, 20),
(13, 8), (13, 23), (13, 15),
(14, 1), (14, 10), (14, 5), (14, 17),
(15, 10),
(16, 17), (16, 11), (16, 8), (16, 6), (16, 21),
(17, 1);

-- PARTNER EXPERTISE
INSERT INTO Partner_Qualifier (pt_id, ql_id, pt_ql_insert_date, pt_ql_complete_date) VALUES 

-- Partner 1 - Tech Solutions Inc.
(1, 1, '2023-11-15', '2024-03-20'), 
(1, 2, '2023-10-20', NULL), 
(1, 3, '2023-09-25', '2024-04-12'),

-- Partner 2 - Green Energy Ltd.
(2, 7, '2023-10-10', '2024-02-05'), 
(2, 8, '2023-08-28', '2024-01-15'),

-- Partner 3 - HealthCare Partners
(3, 15, '2023-12-05', NULL), 
(3, 16, '2023-09-20', '2024-03-10'), 
(3, 18, '2023-10-30', NULL),

-- Partner 4 - Finance Solutions
(4, 22, '2023-11-02', NULL), 
(4, 25, '2023-10-15', '2024-02-20'), 
(4, 27, '2023-09-12', '2024-04-05'), 
(4, 28, '2023-08-18', NULL),

-- Partner 5 - EduTech Innovations
(5, 31, '2023-12-10', '2024-03-25'), 
(5, 32, '2023-11-25', '2024-04-02'), 
(5, 36, '2023-09-30', NULL), 
(5, 37, '2023-08-28', '2024-02-15'), 
(5, 39, '2023-10-05', '2024-03-18'),

-- Partner 6 - AgriCorp
(6, 38, '2023-11-18', NULL), 
(6, 40, '2023-09-15', '2024-01-20'), 
(6, 41, '2023-08-10', NULL),

-- Partner 7 - Urban Developers
(7, 45, '2023-12-03', '2024-03-10'), 
(7, 46, '2023-11-10', NULL), 
(7, 48, '2023-10-20', NULL), 
(7, 50, '2023-09-28', '2024-02-25'), 
(7, 53, '2023-08-15', '2024-04-05'),

-- Partner 8 - Smart Home Systems
(8, 52, '2023-11-28', '2024-03-20'), 
(8, 54, '2023-10-05', '2024-02-15'),

-- Partner 9 - FoodTech Co.
(9, 58, '2023-12-15', '2024-03-25'), 
(9, 59, '2023-10-30', NULL), 
(9, 61, '2023-09-20', '2024-02-10'), 
(9, 62, '2023-08-28', NULL), 
(9, 63, '2023-08-10', '2024-04-05'),

-- Partner 10 - Auto Innovations
(10, 66, '2023-11-20', '2024-03-18'), 
(10, 67, '2023-10-10', NULL), 
(10, 68, '2023-09-15', '2024-01-20'), 
(10, 70, '2023-08-28', '2024-02-15'), 
(10, 71, '2023-08-05', NULL), 
(10, 73, '2023-07-20', '2024-04-02'),

-- Partner 11 - Travel Easy Ltd.
(11, 71, '2023-11-10', '2024-03-05'), 
(11, 72, '2023-10-20', '2024-01-15'), 
(11, 75, '2023-09-25', NULL), 
(11, 77, '2023-08-30', NULL), 
(11, 78, '2023-08-10', '2024-02-10'), 
(11, 80, '2023-07-15', '2024-04-05'),

-- Partner 12 - FinTech Innovations
(12, 79, '2023-12-05', '2024-03-25'), 
(12, 80, '2023-10-20', NULL), 
(12, 82, '2023-09-15', '2024-01-20'), 
(12, 83, '2023-08-28', NULL),

-- Partner 13 - Health
(13, 84, '2023-11-28', '2024-03-20'),
(13, 85, '2023-10-10', '2024-01-15'),
(13, 87, '2023-09-25', NULL),
(13, 89, '2023-08-30', NULL),
(13, 91, '2023-08-10', '2024-02-10'),
(13, 92, '2023-07-15', '2024-04-05'),
(13, 93, '2023-06-30', NULL),

-- Partner 14 - Solar Solutions
(14, 95, '2023-11-20', '2024-03-18'),
(14, 96, '2023-10-10', NULL),
(14, 97, '2023-09-15', '2024-01-20'),
(14, 98, '2023-08-28', '2024-02-15'),
(14, 99, '2023-08-05', NULL),

-- Partner 15 - Cloud Computing Co.
(15, 103, '2023-12-05', '2024-03-25'),
(15, 105, '2023-10-20', NULL),
(15, 107, '2023-09-15', '2024-01-20'),
(15, 108, '2023-08-28', NULL),
(15, 110, '2023-08-10', '2024-04-05'),

-- Partner 16 - AI Innovators
(16, 111, '2023-11-28', '2024-03-20'),
(16, 112, '2023-10-10', '2024-01-15'),
(16, 113, '2023-09-25', NULL),
(16, 114, '2023-08-30', NULL),
(16, 115, '2023-08-10', '2024-02-10'),
(16, 116, '2023-07-15', '2024-04-05'),

-- Partner 17 - Renewable Energy Inc.
(17, 119, '2023-12-15', '2024-03-25'),
(17, 120, '2023-10-30', NULL),
(17, 121, '2023-09-20', '2024-02-10'),
(17, 122, '2023-08-28', NULL),
(17, 124, '2023-08-10', '2024-04-05');
