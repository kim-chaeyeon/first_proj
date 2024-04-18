DROP DATABASE IF EXISTS first_proj;
CREATE DATABASE first_proj;
USE first_proj;

CREATE TABLE information (
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    memberId CHAR(100) NOT NULL UNIQUE,
    `name` CHAR(100) NOT NULL,
    sex CHAR(2) NOT NULL,
    age INT NOT NULL,
    major CHAR(100) NOT NULL,
    phoneNumber VARCHAR(11) NOT NULL UNIQUE,
    mbti CHAR(4) NOT NULL,
    snsId CHAR(100) NOT NULL UNIQUE,
    appeal TEXT NOT NULL
);


INSERT INTO information
SET regDate = NOW(),
memberId = 'che3776',
`name` = '김채연',
sex = '여',
age = 23,
major = '빅데이터응용',
phoneNumber = 01057113776,
mbti = 'INTP',
snsId = 'chae._.yeon__',
appeal = '안녕하세요!!';

SELECT * FROM information;