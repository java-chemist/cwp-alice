--DROP TABLE cw_users IF EXISTS;

CREATE TABLE cw_users (
  cw_users_id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY,
  name VARCHAR(50),
  cw_id BIGINT,
  password VARCHAR(100),
  email  VARCHAR(50),
  role VARCHAR(100),
  designation VARCHAR(100),
  department VARCHAR(100),
  sessionId VARCHAR(100)
);