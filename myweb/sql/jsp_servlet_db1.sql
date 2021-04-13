CREATE TABLE temp_t(
    userId          VARCHAR2(20)     PRIMARY KEY,
    userName        VARCHAR2(20)     NOT NULL,
    userPassword    VARCHAR2(20)     NOT NULL,
    userEmail       VARCHAR2(50),
    userPhone       VARCHAR2(20),
    joinDate        DATE             DEFAULT SYSDATE
);

DROP TABLE temp_t;

INSERT INTO temp_t VALUES (1, 'test1', '1234', '1234@naver.com', '010-1234-5678', TO_DATE('2021/01/01', 'YYYY/MM/DD'));
INSERT INTO temp_t VALUES (2, 'test2', '5678', '5678@naver.com', '010-1234-8888', TO_DATE('2021/01/02', 'YYYY/MM/DD'));
INSERT INTO temp_t VALUES (3, 'test3', '9123', '9123@naver.com', '010-1234-5444', TO_DATE('2021/01/03', 'YYYY/MM/DD'));

SELECT userId, userName, userPassword, userEmail, userPhone, joindate FROM temp_t;