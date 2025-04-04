DROP database IF exists STUDENT2;
CREATE DATABASE IF NOT exists STUDENT2;
USE STUDENT2;
DROP TABLE IF EXISTS `STUDENT`;

CREATE TABLE `STUDENT` (
	`ST_KEY`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`ST_GRADE`	INT	NULL,
	`ST_CLASS`	INT	NULL,
	`ST_NUM`	INT	NULL,
	`ST_NAME`	VARCHAR(20)	NULL
);

DROP TABLE IF EXISTS `SUBJECT`;

CREATE TABLE `SUBJECT` (
	`SJ_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SJ_GRADE`	INT	NULL,
	`SJ_SEMESTER`	ENUM("1","2")	NULL,
	`SJ_NAME`	VARCHAR(10)	NULL
);

DROP TABLE IF EXISTS `SCORE`;

CREATE TABLE `SCORE` (
	`SC_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`SC_SCORE`	INT	NULL,
	`SC_ST_KEY`	INT	NOT NULL,
	`SC_SJ_NUM`	INT	NOT NULL
);


ALTER TABLE `SCORE` ADD CONSTRAINT `FK_STUDENT_TO_SCORE_1` FOREIGN KEY (
	`SC_ST_KEY`
)
REFERENCES `STUDENT` (
	`ST_KEY`
);

ALTER TABLE `SCORE` ADD CONSTRAINT `FK_SUBJECT_TO_SCORE_1` FOREIGN KEY (
	`SC_SJ_NUM`
)
REFERENCES `SUBJECT` (
	`SJ_NUM`
);

