INSERT INTO cw_users
       (name
            , cw_id
            , password
            , email
            , role
            , designation
            , department
            , sessionId
       )
       VALUES
       ('Luv Gupta'
            , 101
            , '$2a$10$RAcfBB1fd7CJd5srLJ7ZdegECOdhuhAkzC.saDentBVjx8otRPvs.'
            , 'test1@gmail.com'
            , 'Case Analyst'
            , 'Assistant Secretary for Health'
            , 'US Health & Human Services'
            , 'luv_gupta'
       )
;

INSERT INTO cw_users
       (name
            , cw_id
            , password
            , email
            , role
            , designation
            , department
			, sessionId
       )
       VALUES
       ('Amit Kumar'
            , 102
            , '$2a$10$.suLp/nK2wFDmw/0IcpyTe.naDmstgzf5jO6OXlYV5nc.QFJJXnsO'
            , 'test2@gmail.com'
            , 'Case Analyst'
            , 'Assistant Secretary for Human Services'
            , 'US Health & Human Services'
			, 'amit_kumar'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (101
            , 'Kevin Mitnick'
            , 'Daily Sprint Status Call'
            , 'T1F Meeting Room Delhi'
            , '05/31/2018'
            , '10:30'
            , '30 Minutes'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (101
            , 'Joe Gatto'
            , 'Firm Initiative'
            , 'Skype'
            , '05/31/2018'
            , '11:00'
            , '1 Hour'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (101
            , 'James Murray'
            , 'Daily Client Call'
            , 'Skype'
            , '05/30/2018'
            , '11:00'
            , '30 Minutes'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (101
            , 'Satoshi Nakamoto'
            , 'All Hands Meet'
            , 'Break-out Area'
            , '05/30/2018'
            , '12:00'
            , '30 Minutes'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (101
            , 'Amit Kumar'
            , 'Well-being Session'
            , 'Cafetaria'
            , '05/31/2018'
            , '14:30'
            , '30 Minutes'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (102
            , 'Kevin Mitnick'
            , 'Daily Sprint Status Call'
            , 'T1F Meeting Room Delhi'
            , '05/31/2018'
            , '15:00'
            , '30 Minutes'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (102
            , 'Joe Gatto'
            , 'Firm Initiative'
            , 'Skype'
            , '05/26/2018'
            , '18:00'
            , '1 Hour'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (102
            , 'James Murray'
            , 'Daily Client Call'
            , 'Skype'
            , '05/24/2018'
            , '18:00'
            , '30 Minutes'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (102
            , 'Satoshi Nakamoto'
            , 'All Hands Meet'
            , 'Break-out Area'
            , '05/24/2018'
            , '17:00'
            , '30 Minutes'
       )
;

INSERT INTO cw_appointments
       (cw_id
            , organizer
            , subject
            , location
            , start_date
            , start_time
            , duration
       )
       VALUES
       (102
            , 'Luv Gupta'
            , 'Well-being Session'
            , 'Cafetaria'
            , '05/24/2018'
            , '11:30'
            , '30 Minutes'
       )
;

INSERT INTO cw_cases
       (cw_id
            , start_date
            , description
            , status
            , cw_assigned_name
       )
       VALUES
       (101
            , '04/13/2018'
            , '{"pt":"TANF","hoh":"John Doe","adultCnt":"2","childrenCnt":"2","monthlyIncome":"$150","assistanceElig":"$100"}'
            , 'Pending Review'
            , 'Luv Gupta'
       )
;

INSERT INTO cw_cases
       (cw_id
            , start_date
            , description
            , status
            , cw_assigned_name
       )
       VALUES
       (101
            , '04/16/2018'
            , '{"pt":"TANF","hoh":"Jane Doe","adultCnt":"1","childrenCnt":"3","monthlyIncome":"$100","assistanceElig":"$175"}'
            , 'Approved'
            , 'Luv Gupta'
       )
;

INSERT INTO cw_cases
       (cw_id
            , start_date
            , description
            , status
            , cw_assigned_name
       )
       VALUES
       (101
            , '04/17/2018'
            , '{"pt":"TANF","hoh":"Jhonny Depp","adultCnt":"1","childrenCnt":"1","monthlyIncome":"$500","assistanceElig":"$0"}'
            , 'Denied'
            , 'Luv Gupta'
       )
;

INSERT INTO cw_cases
       (cw_id
            , start_date
            , description
            , status
            , cw_assigned_name
       )
       VALUES
       (102
            , '04/13/2018'
            , '{"pt":"TANF","hoh":"Robert Brown","adultCnt":"3","childrenCnt":"6","monthlyIncome":"$500","assistanceElig":"$100"}'
            , 'Pending Review'
            , 'Amit Kumar'
       )
;

INSERT INTO cw_cases
       (cw_id
            , start_date
            , description
            , status
            , cw_assigned_name
       )
       VALUES
       (102
            , '04/16/2018'
            , '{"pt":"TANF","hoh":"Jennifer Jones","adultCnt":"3","childrenCnt":"4","monthlyIncome":"$75","assistanceElig":"$375"}'
            , 'Approved'
            , 'Amit Kumar'
       )
;

INSERT INTO cw_cases
       (cw_id
            , start_date
            , description
            , status
            , cw_assigned_name
       )
       VALUES
       (102
            , '04/17/2018'
            , '{"pt":"TANF","hoh":"James Moriarty","adultCnt":"2","childrenCnt":"0","monthlyIncome":"$450","assistanceElig":"$0"}'
            , 'Denied'
            , 'Amit Kumar'
       )
;
