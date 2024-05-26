--TRACK
INSERT INTO Track (tk_name, tk_insert_date) VALUES
('Cloud Build', CURRENT_DATE),
('Cloud Sell', CURRENT_DATE),
('Cloud Service', CURRENT_DATE),
('Cloud License & Hardware', CURRENT_DATE),
('License and Hardware', CURRENT_DATE),
('Implementation', CURRENT_DATE),
('Services', CURRENT_DATE),
('Training and Education', CURRENT_DATE);


--EXPERTISE
INSERT INTO Expertise (ex_name, tk_id) VALUES 
('Data Analysis', 1),
('Software Development', 2),
('Project Management', 3),
('Cyber Security', 4),
('Machine Learning', 5),
('Cloud Computing', 6),
('Digital Marketing', 7),
('UI/UX Design', 8),
('Financial Analysis', 9),
('Blockchain Technology', 10);

--PARTNER
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

--USER
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

--QUALIFIER
INSERT INTO Qualifier (ql_name) VALUES 
('Beginner'),
('Intermediate'),
('Advanced'),
('Expert'),
('Novice'),
('Professional'),
('Amateur'),
('Skilled'),
('Certified'),
('Experienced'),
('Qualified'),
('Talented'),
('Capable'),
('Competent'),
('Proficient'),
('Master'),
('Rookie'),
('Journeyman'),
('Veteran'),
('Specialist');


--PARTNER TRACK
INSERT INTO Partner_Track (pt_id, tk_id, pt_tk_complete_date) VALUES 
(1, 1, '2024-06-01'), (1, 2, NULL), (1, 3, '2024-06-15'), (1, 4, '2024-07-20'), (1, 5, NULL),
(2, 1, NULL), (2, 2, '2024-06-10'), (2, 3, NULL), (2, 4, '2024-08-30'), (2, 5, '2024-09-15'),
(3, 1, '2024-06-05'), (3, 2, '2024-06-20'), (3, 3, '2024-06-30'), (3, 4, NULL), (3, 5, '2024-08-01'),
(7, 3, '2024-06-01'), (7, 4, NULL), (7, 2, '2024-06-15'), (7, 8, '2024-07-20'), (7, 6, NULL),
(4, 3, NULL), (4, 2, '2024-06-10'), (4, 8, NULL), (5, 4, '2024-08-30'), (5, 5, '2024-09-15'),
(8, 1, '2024-06-05'), (6, 2, '2024-06-20'), (6, 3, '2024-06-30'), (6, 4, NULL), (6, 5, '2024-08-01');

--PARTNER QUALIFIER
INSERT INTO Partner_Qualifier (pt_id, ql_id, pt_ql_complete_date) VALUES 
(1, 1, '2024-06-01'), (1, 2, NULL), (1, 3, '2024-06-15'), (1, 4, '2024-07-20'), (1, 5, NULL),
(2, 1, NULL), (2, 2, '2024-06-10'), (2, 3, NULL), (2, 4, '2024-08-30'), (2, 5, '2024-09-15'),
(3, 1, '2024-06-05'), (3, 2, '2024-06-20'), (3, 3, '2024-06-30'), (3, 4, NULL), (3, 5, '2024-08-01'),
(7, 3, '2024-06-01'), (7, 4, NULL), (7, 2, '2024-06-15'), (7, 8, '2024-07-20'), (7, 6, NULL),
(4, 3, NULL), (4, 2, '2024-06-10'), (4, 8, NULL), (5, 4, '2024-08-30'), (5, 5, '2024-09-15'),
(8, 1, '2024-06-05'), (6, 2, '2024-06-20'), (6, 3, '2024-06-30'), (6, 4, NULL), (6, 5, '2024-08-01');

 --PARTNER EXPERTISE
 INSERT INTO Partner_Expertise (pt_id, ex_id, pt_ex_complete_date) VALUES 
(1, 1, '2024-06-01'), (1, 2, NULL), (1, 3, '2024-06-15'), (1, 4, '2024-07-20'), (1, 5, NULL),
(2, 1, NULL), (2, 2, '2024-06-10'), (2, 3, NULL), (2, 4, '2024-08-30'), (2, 5, '2024-09-15'),
(3, 1, '2024-06-05'), (3, 2, '2024-06-20'), (3, 3, '2024-06-30'), (3, 4, NULL), (3, 5, '2024-08-01'),
(7, 3, '2024-06-01'), (7, 4, NULL), (7, 2, '2024-06-15'), (7, 8, '2024-07-20'), (7, 6, NULL),
(4, 3, NULL), (4, 2, '2024-06-10'), (4, 8, NULL), (5, 4, '2024-08-30'), (5, 5, '2024-09-15'),
(8, 1, '2024-06-05'), (6, 2, '2024-06-20'), (6, 3, '2024-06-30'), (6, 4, NULL), (6, 5, '2024-08-01');

--EXPERTISE QUALIFIER
INSERT INTO Expertise_Qualifier (ex_id, ql_id) VALUES 
(1, 1), (1, 3), (1, 4), (1, 5),(1, 8), (1, 9), (1, 10),
(2, 1), (2, 2), (2, 3),  (2, 7), (2, 8), (2, 10),
(3, 1), (3, 2), (3, 6), (3, 7), (3, 9), (3, 10);
 
