-- =====================================================================================
-- USERS
-- =====================================================================================
CREATE TABLE USERS (
    ID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    USERNAME VARCHAR(50) NOT NULL UNIQUE,
    EMAIL VARCHAR(100) NOT NULL UNIQUE,
    PASSWORD VARCHAR(255) NOT NULL,
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(30),
    PHONE_NUMBER VARCHAR(20) UNIQUE,
    DATE_OF_BIRTH TIMESTAMP,
    GENDER VARCHAR(10),
    AVATAR_URL VARCHAR(255),
    ROLE VARCHAR(20),
    STATUS VARCHAR(20) DEFAULT 'ACTIVE',
    LAST_LOGIN_AT TIMESTAMP,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- trigger for update updated_at automatically when has some changes
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
   NEW.UPDATED_AT = CURRENT_TIMESTAMP;
   RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER UPDATE_USERS_UPDATED_AT
BEFORE UPDATE ON Users
FOR EACH ROW
EXECUTE PROCEDURE update_updated_at_column();
