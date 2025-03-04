SJ_SEMESTERSJ_SEMESTERDROP DATABASE IF EXISTS SHOPPINGMALL;
CREATE DATABASE SHOPPINGMALL;
USE SHOPPINGMALL;
DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER` (
	`ME_ID`	VARCHAR(13) PRIMARY KEY	NOT NULL,
	`ME_PW`	VARCHAR(20) NOT	NULL,
	`ME_EMAIL`	VARCHAR(50) UNIQUE NOT	NULL,
	`ME_NUMBER`	VARCHAR(13) UNIQUE NOT	NULL,
	`ME_FAIL`	INT DEFAULT 0 NOT	NULL,
	`ME_AUTHORITY`	ENUM("ADMIN","USER") DEFAULT "USER" NOT	NULL,
	`ME_DEL`	ENUM("Y","N") DEFAULT "N" NOT	NULL
);

DROP TABLE IF EXISTS `BUY_LIST`;

CREATE TABLE `BUY_LIST` (
	`BL_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`BI_AMOUNT`	INT NOT	NULL,
	`BI_PRICE`	INT NOT	NULL,
	`BU_NUM`	INT	NOT NULL,
	`PR_cODE`	CHAR(6)	NOT NULL
);

DROP TABLE IF EXISTS `BUY`;

CREATE TABLE `BUY` (
	`BU_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`BU_DATE`	DATETIME DEFAULT CURRENT_TIMESTAMP NOT	NULL,
	`BU_STATE`	VARCHAR(4) DEFAULT "구매" NOT	NULL,
	`BU_TOTAL_PRICE`	INT NOT	NULL,
	`BU_FINAL_DATE`	DATETIME	NULL,
	`BU_ME_ID`	VARCHAR(13)	NOT NULL
);

DROP TABLE IF EXISTS `CATEGORY`;

CREATE TABLE `CATEGORY` (
	`CA_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`CA_NAME`	VARCHAR(10) UNIQUE NOT	NULL,
	`CA_CODE`	CHAR(3) UNIQUE NOT	NULL
);

DROP TABLE IF EXISTS `PRODUCT`;

CREATE TABLE `PRODUCT` (
	`PR_CODE`	CHAR(6) PRIMARY KEY	NOT NULL,
	`PR_TITLE`	VARCHAR(100) NOT	NULL,
	`PR_CONTENT`	LONGTEXT NOT	NULL,
	`PR_PRICE`	INT NOT	NULL,
	`PR_THUMB`	VARCHAR(200)	NULL,
	`PR_DEL`	ENUM("Y","N") DEFAULT "N" NOT	NULL,
	`PR_AMOUNT`	INT DEFAULT 0 NOT	NULL,
	`PR_CA_NUM`	INT	NOT NULL
);

DROP TABLE IF EXISTS `CART`;

CREATE TABLE `CART` (
	`CT_NUM`	INT PRIMARY KEY	NOT NULL,
	`CT_AMOUNT`	INT DEFAULT 0 NOT	NULL,
	`CT_ME_ID`	VARCHAR(13)	NOT NULL,
	`CT_PR_cODE`	CHAR(6)	NOT NULL
);

ALTER TABLE `BUY_LIST` ADD CONSTRAINT `FK_BUY_TO_BUY_LIST_1` FOREIGN KEY (
	`BU_NUM`
)
REFERENCES `BUY` (
	`BU_NUM`
);

ALTER TABLE `BUY_LIST` ADD CONSTRAINT `FK_PRODUCT_TO_BUY_LIST_1` FOREIGN KEY (
	`PR_cODE`
)
REFERENCES `PRODUCT` (
	`PR_CODE`
);

ALTER TABLE `BUY` ADD CONSTRAINT `FK_MEMBER_TO_BUY_1` FOREIGN KEY (
	`BU_ME_ID`
)
REFERENCES `MEMBER` (
	`ME_ID`
);

ALTER TABLE `PRODUCT` ADD CONSTRAINT `FK_CATEGORY_TO_PRODUCT_1` FOREIGN KEY (
	`PR_CA_NUM`
)
REFERENCES `CATEGORY` (
	`CA_NUM`
);

ALTER TABLE `CART` ADD CONSTRAINT `FK_MEMBER_TO_CART_1` FOREIGN KEY (
	`CT_ME_ID`
)
REFERENCES `MEMBER` (
	`ME_ID`
);

ALTER TABLE `CART` ADD CONSTRAINT `FK_PRODUCT_TO_CART_1` FOREIGN KEY (
	`CT_PR_cODE`
)
REFERENCES `PRODUCT` (
	`PR_CODE`
);

