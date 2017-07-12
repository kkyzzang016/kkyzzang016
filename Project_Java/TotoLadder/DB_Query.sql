/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.5.52-0ubuntu0.14.04.1 : Database - stdt057
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stdt057` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `stdt057`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(30) NOT NULL,
  `PASSWORD` varchar(20) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `hp` varchar(20) DEFAULT NULL,
  `joindate` time NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `point` int(14) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`num`,`id`,`PASSWORD`,`NAME`,`birthday`,`hp`,`joindate`,`email`,`point`) values 
(6,'강광용','kky1201','강광용','931201','010-1234-1234','18:20:38','abcd1234@naver.com',94700),(7,'admin','1','관리자',NULL,NULL,'17:20:30',NULL,0),(8,'김동희','1234','김동희','930505','010-9691-9787','17:30:30','asd@naver.com',100),(9,'김남혁','3456','김남혁','930921','010-7227-4564','17:30:31','asd1@naver.com',100),(10,'김유찬','1','김유찬','940507','010-2453-1345','17:30:32','asd2@naver.com',100),(11,'김남자','35678','김남자','940912','010-7267-1342','17:30:33','asd3@naver.com',100);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `java` int(20) DEFAULT NULL,
  `jsp` int(20) DEFAULT NULL,
  `spring` int(20) DEFAULT NULL,
  `total` int(20) DEFAULT NULL,
  `average` int(11) DEFAULT NULL,
  `ban` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`num`,`name`,`java`,`jsp`,`spring`,`total`,`average`,`ban`) values (1,'김동희',90,95,84,269,90,'a반'),(3,'김유찬',85,90,64,239,80,'c반'),(14,'김남혁',12,12,12,36,12,'c반');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
