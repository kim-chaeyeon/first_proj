DROP DATABASE IF EXISTS first_proj;
CREATE DATABASE first_proj;
USE first_proj;

CREATE TABLE information (
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    memberId CHAR(100) NOT NULL,
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
memberId = '',
`name` = '김채연',
sex = '여자',
age = 23,
major = '빅데이터응용',
phoneNumber = 01057113776,
mbti = 'INTP',
snsId = 'chae._.yeon__',
appeal = '안녕하세요!!';

INSERT INTO information
SET regDate = NOW(),
memberId = '',
`name` = '변우석',
sex = '남자',
age = 24,
major = '빅데이터응용',
phoneNumber = 01078945612,
mbti = 'INTJ',
snsId = 'woo_seok',
appeal = '안녕';

INSERT INTO information
SET regDate = NOW(),
memberId = '',
`name` = '손흥민',
sex = '남자',
age = 26,
major = '스포츠학과',
phoneNumber = 01015973571,
mbti = 'ESTJ',
snsId = 'sonny_7',
appeal = '나는 축구를 좋아해';

INSERT INTO information
SET regDate = NOW(),
memberId = '',
`name` = '이유리',
sex = '여자',
age = 20,
major = '국어국문학과',
phoneNumber = 01012304560,
mbti = 'ENTJ',
snsId = 'y__r',
appeal = '^^';

SELECT * FROM information;