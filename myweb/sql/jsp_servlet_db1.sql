CREATE TABLE MEMBER_t(
    userId          VARCHAR2(20)     PRIMARY KEY,
    userPassword    VARCHAR2(20)     NOT NULL,
    userName        VARCHAR2(20)     NOT NULL,
    userEmail       VARCHAR2(50),
    userPhone       VARCHAR2(20),
    joinDate        DATE             DEFAULT SYSDATE
);

SELECT * FROM MEMBER_t;