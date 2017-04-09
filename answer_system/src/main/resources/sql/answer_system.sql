/*
SQLyog Ultimate v8.32 
MySQL - 5.7.11-log : Database - answer_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`answer_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `answer_system`;

/*Table structure for table `discuss` */

DROP TABLE IF EXISTS `discuss`;

CREATE TABLE `discuss` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `question_id` varchar(64) NOT NULL COMMENT '讨论的问题id',
  `speaker_id` varchar(64) NOT NULL COMMENT '该回复的发起者id',
  `listner_id` varchar(64) NOT NULL COMMENT '该回复的接受者id',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '该回复的创建时间',
  `content` varchar(256) NOT NULL COMMENT '该回复的内容',
  `agree_times` int(11) NOT NULL DEFAULT '0' COMMENT '被点赞的次数',
  `oppose_times` int(11) NOT NULL DEFAULT '0' COMMENT '被反对的次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `discuss` */

insert  into `discuss`(`id`,`question_id`,`speaker_id`,`listner_id`,`update_time`,`create_time`,`content`,`agree_times`,`oppose_times`) values ('2','3','1','1','2017-02-21 10:46:31','2017-02-21 10:29:32','试试',0,0),('3','3','3','2','2017-02-21 10:31:03','2017-02-21 10:31:03','试试',0,0);

/*Table structure for table `question` */

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `description` varchar(256) NOT NULL COMMENT '问题的描述，不得多于256字',
  `title` varchar(64) NOT NULL COMMENT '问题的标题，不得多于64字',
  `type_id` varchar(64) NOT NULL COMMENT '问题的类型',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '问题的创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '问题的更新时间',
  `create_user_id` varchar(64) NOT NULL COMMENT '问题创建者的主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `question` */

insert  into `question`(`id`,`description`,`title`,`type_id`,`create_time`,`update_time`,`create_user_id`) values ('1','试试','贱贱','1','2017-02-18 00:20:17','2017-02-18 00:20:17','1'),('2','update','suixueya','3,5,7','2017-02-18 18:07:09','2017-02-18 18:07:09','2'),('5','test34','suixueefa','4','2017-02-21 10:23:26','2017-02-21 10:23:26','3'),('6','test34','suixueefa','4','2017-04-08 18:42:48','2017-04-08 18:42:48','3'),('7','test34','suixueefa','4','2017-04-08 18:43:14','2017-04-08 18:43:14','3');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `description` varchar(64) NOT NULL COMMENT '角色描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`description`,`create_time`,`update_time`) values ('1','teacher','2017-02-13 09:43:09','2017-02-13 09:43:09'),('2','student','2017-02-13 09:43:09','2017-02-13 09:43:09'),('3','visitor','2017-02-13 09:43:09','2017-02-13 09:43:09');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `description` varchar(64) NOT NULL COMMENT '类型的描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`description`) values ('1','数学'),('10','计算机'),('2','语文'),('3','英语'),('4','物理'),('5','化学'),('6','生物'),('7','政治'),('8','历史'),('9','其他');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '登录名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`create_time`,`update_time`) values ('1','zhangsan','123456',NULL,NULL),('2','suixue','123456',NULL,NULL),('2147483647','suixuer','202cb962ac59075b964b07152d234b70',NULL,NULL),('3','lisi','123456',NULL,NULL),('4','sx','123456',NULL,NULL),('7','zhangsan','123489','2017-02-18 17:51:48','2017-02-18 17:51:48');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `user_id` varchar(64) NOT NULL COMMENT '用户id',
  `role_id` varchar(64) NOT NULL COMMENT '角色id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `FK_user_role` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`,`create_time`,`update_time`) values ('1','1','1',NULL,NULL),('2','2','2',NULL,NULL),('3','3','3',NULL,NULL),('4','4','2',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
