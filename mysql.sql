/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.16 : Database - parttime
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`parttime` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `parttime`;

/*Table structure for table `instructor` */

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `account` varchar(30) NOT NULL DEFAULT '',
  `name` varchar(30) NOT NULL DEFAULT '',
  `grade` varchar(30) NOT NULL DEFAULT '' COMMENT '年级',
  `status` varchar(30) DEFAULT NULL COMMENT '0:未审核或被删除 ，1：审核通过',
  `password` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='辅导员';

/*Data for the table `instructor` */

insert  into `instructor`(`account`,`name`,`grade`,`status`,`password`) values 
('123','王老师','网工151','1','132'),
('222','李老师','网工153','1','123');

/*Table structure for table `introducer` */

DROP TABLE IF EXISTS `introducer`;

CREATE TABLE `introducer` (
  `account` varchar(30) NOT NULL DEFAULT '' COMMENT '登录账号',
  `name` varchar(30) NOT NULL DEFAULT '',
  `score` int(11) DEFAULT NULL COMMENT '评分',
  `IDnumber` int(20) DEFAULT NULL COMMENT '身份证号',
  `status` varchar(30) DEFAULT NULL COMMENT '0：未审核通过，1：审核通过',
  `password` varchar(30) NOT NULL DEFAULT '',
  `position` varchar(30) DEFAULT '' COMMENT '职位',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `introducer` */

insert  into `introducer`(`account`,`name`,`score`,`IDnumber`,`status`,`password`,`position`) values 
('111','王总',2,320,'1','111','开发区总裁'),
('211','王总',3,2435346,'0','11','海鲜店老板'),
('222','张总',2,321,'0','222','开发区副总裁');

/*Table structure for table `parttime` */

DROP TABLE IF EXISTS `parttime`;

CREATE TABLE `parttime` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `introducer_id` varchar(30) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `nu_of_people` int(11) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL COMMENT '这个兼职的联系人电话',
  `salary` float(8,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `parttime_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `introducer_id` (`introducer_id`),
  CONSTRAINT `parttime_ibfk_1` FOREIGN KEY (`introducer_id`) REFERENCES `introducer` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `parttime` */

insert  into `parttime`(`Id`,`introducer_id`,`location`,`nu_of_people`,`phone`,`salary`,`status`,`start_time`,`end_time`,`parttime_name`) values 
(1,'111','开发区',2,'1780567896',33.00,'0','2018-12-12 18:02:50','2018-12-29 18:02:55','小米兼职员'),
(2,'111','崇川区',4,'1789567345',55.00,'3','2018-12-21 18:04:02','2018-12-28 18:04:11','华为兼职员'),
(3,'111','南京',7,'1780403145',30.00,'0','2018-12-14 12:00:00','2018-12-30 12:00:00','腾讯兼职员'),
(5,'111','南通崇川区',4,'17804051414',32.00,'1','2018-12-14 12:00:00','2018-12-02 12:00:00','华为修理工'),
(6,'111','南通',2,'1783678294',40.00,'2','2018-12-14 12:00:00','2018-12-08 12:00:00','洗衣房'),
(7,'111','南通',3,'1780588433',23.00,'2','2018-12-06 12:00:00','2018-12-08 12:00:00','南通大饭店');

/*Table structure for table `stu_parttime` */

DROP TABLE IF EXISTS `stu_parttime`;

CREATE TABLE `stu_parttime` (
  `stu_id` varchar(30) DEFAULT NULL,
  `parttime_id` int(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL COMMENT '0:未审核，1:已审核，2：已完成，3：已取消',
  KEY `stu_id` (`stu_id`),
  KEY `parttime_id` (`parttime_id`),
  CONSTRAINT `stu_parttime_ibfk_3` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_nu`),
  CONSTRAINT `stu_parttime_ibfk_2` FOREIGN KEY (`parttime_id`) REFERENCES `parttime` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生兼职情况';

/*Data for the table `stu_parttime` */

insert  into `stu_parttime`(`stu_id`,`parttime_id`,`status`) values 
('1513042054',2,'1'),
('1513042054',3,'2'),
('1513042054',5,'2');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `account` varchar(30) DEFAULT NULL,
  `stu_nu` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `instructor_id` varchar(30) DEFAULT NULL,
  `telephone_nu` int(11) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`stu_nu`),
  KEY `instructor_id` (`instructor_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`account`,`stu_nu`,`name`,`instructor_id`,`telephone_nu`,`major`,`status`,`password`) values 
(NULL,'1277493','小王','123',NULL,'物联网151','0',NULL),
(NULL,'1513042033','小李','123',NULL,'网络工程151','0',NULL),
('11111','1513042038','小明','123',NULL,'物联网151','1','111'),
('111','1513042054','小王','123',NULL,'网络工程151','1','111'),
(NULL,'151394556','小花','123',NULL,'物联网152','0',NULL),
(NULL,'2243536','小明','222',NULL,'物联网151','0',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
