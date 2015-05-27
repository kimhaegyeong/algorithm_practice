 create database market_place_db character set utf8 collate utf8_general_ci;

 mysql> create user 'study'@'localhost' identified by 'study';
Query OK, 0 rows affected (0.03 sec)

mysql> create user 'study'@'%' identified by 'study';
Query OK, 0 rows affected (0.00 sec)


mysql> grant all privileges on market_place_db .* to 'study'@localhost with grant option; 

mysql> grant all privileges on market_place_db .* to 'study'@'%' with grant option; 


DROP TABLE PLACE;
-- 주요상권
CREATE TABLE PLACE (
NO    INTEGER      NOT NULL, -- 번호
NAME  VARCHAR(65535) NULL,     -- 상권명
POINT TEXT    NULL      -- point
);

-- 주요상권 기본키
CREATE UNIQUE INDEX PK_PLACE
ON PLACE ( -- 주요상권
NO ASC -- 상권번호
);

-- 주요상권
ALTER TABLE PLACE
ADD
	CONSTRAIㅌNT PK_PLACE -- 주요상권 기본키
PRIMARY KEY (
	NO -- 상권번호
);


mysql --local-infile=1 -u study -p
-- 파일 로드.
LOAD DATA LOCAL INFILE '/home/hae/20131016.csv'
INTO TABLE PLACE
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
(NO, NAME, POINT);
