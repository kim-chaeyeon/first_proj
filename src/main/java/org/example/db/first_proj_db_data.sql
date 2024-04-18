/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - first_proj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`first_proj` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `first_proj`;

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `memberId` char(100) NOT NULL,
  `name` char(100) NOT NULL,
  `sex` char(2) NOT NULL,
  `age` int(11) NOT NULL,
  `major` char(100) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `mbti` char(4) NOT NULL,
  `snsId` char(100) NOT NULL,
  `appeal` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `memberId` (`memberId`),
  UNIQUE KEY `phoneNumber` (`phoneNumber`),
  UNIQUE KEY `snsId` (`snsId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `information` */

insert  into `information`(`id`,`regDate`,`memberId`,`name`,`sex`,`age`,`major`,`phoneNumber`,`mbti`,`snsId`,`appeal`) values 
(1,'2024-04-18 16:22:03','che3776','김채연','여',23,'빅데이터응용','1057113776','INTP','chae._.yeon__','안녕하세요!!');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
