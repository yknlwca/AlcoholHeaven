DROP DATABASE IF EXISTS alcohol_heaven;
CREATE DATABASE IF NOT EXISTS alcohol_heaven;

USE alcohol_heaven;

CREATE TABLE IF NOT EXISTS `ALCOHOL` (
    `id`    INT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `userId` VARCHAR(20) NOT NULL,
    `name`    VARCHAR(20)    NOT NULL,
    `detailRegion`    VARCHAR(20)    NOT NULL,
    `kindOf`    VARCHAR(20)    NOT NULL,
    `content`    TEXT NOT NULL,
    `region`    VARCHAR(20) NOT    NULL,
    `weight`    FLOAT NOT NULL,
	`img` TEXT NOT NULL,
    `orgImg` TEXT ,
    `heart` INT NOT NULL DEFAULT 0 
);

CREATE TABLE IF NOT EXISTS `friend` (
    `id`    INT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `userId`    VARCHAR(20)    NOT NULL,
    `title`    TEXT   NOT NULL,
    `intro`    TEXT    NOT NULL,
    `region`    VARCHAR(20) NOT NULL,
    `kindOf`    VARCHAR(20)    NOT NULL,
          `img` TEXT NOT NULL,
      `orgImg`  TEXT NOT NULL,
    `heart` INT NOT NULL DEFAULT 0 
);

CREATE TABLE IF NOT EXISTS  `FOOD` (
    `id`    INT    NOT NULL AUTO_INCREMENT,
    `userId`    VARCHAR(20)    NOT NULL,
    `menu`    VARCHAR(20)    NOT NULL,
    `content`    TEXT    NOT NULL,
    `title`    TEXT    NOT NULL,
    `region`    VARCHAR(20)    NOT NULL,
    `kindOf`	VARCHAR(20)	 NOT NULL,
    `heart` INT NOT NULL DEFAULT 0 ,
      `img` text NOT NULL,
      `orgImg`  text NOT NULL, 
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS  `notice` (
    `id`    INT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `userId`    VARCHAR(20)    NOT NULL,
    `content`    TEXT    NOT NULL,
    `title`    TEXT    NOT NULL,
    `password`    INT(4)    NOT NULL
);



CREATE TABLE IF NOT EXISTS `REVIEW` (
    `reviewId`    INT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id`    INT    NOT NULL,
    `writer`    VARCHAR(20)    NOT NULL,
    `content`    TEXT NOT NULL,
    `type` INT NOT NULL
);


SELECT * FROM friend;
SELECT * FROM ALCOHOL;


CREATE TABLE IF NOT EXISTS  `USER` (
    `userKey`    INT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`id` VARCHAR(20) NOT NULL UNIQUE,
    `password`    VARCHAR(20)    NOT NULL,
    `name`    VARCHAR(20)    NOT NULL,
    `idNumber`    VARCHAR(13)    NOT NULL,
    `email`    VARCHAR(50)    NOT NULL,
    `phoneNumber`    VARCHAR(11)    NOT NULL
);
select * from user;


CREATE TABLE `boardLike` (
	`id`	 INT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`userId`	VARCHAR(20)	NOT NULL,
	`type`	INT	NOT NULL,
	`boardId`	INT	NOT NULL
);


SELECT * FROM review;

DESC alcohol;



    
    