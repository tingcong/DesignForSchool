/*
Navicat MySQL Data Transfer

Source Server         : MySQL57
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : electivesystem

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-12-29 15:51:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for choose_course_record
-- ----------------------------
DROP TABLE IF EXISTS `choose_course_record`;
CREATE TABLE `choose_course_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) NOT NULL,
  `stu_no` bigint(255) NOT NULL,
  `choose_date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_id` (`course_id`,`stu_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choose_course_record
-- ----------------------------
INSERT INTO `choose_course_record` VALUES ('1', '12', '1310400114', '2016-12-26 13:50:33');
INSERT INTO `choose_course_record` VALUES ('2', '12', '1310400115', '2016-12-26 13:54:26');
INSERT INTO `choose_course_record` VALUES ('3', '14', '1310400114', '2016-12-26 13:54:26');

-- ----------------------------
-- Table structure for class_room
-- ----------------------------
DROP TABLE IF EXISTS `class_room`;
CREATE TABLE `class_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_no` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `course_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_no` (`room_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_room
-- ----------------------------
INSERT INTO `class_room` VALUES ('1', 'B101', '空闲', '');
INSERT INTO `class_room` VALUES ('2', 'B201', '空闲', '');
INSERT INTO `class_room` VALUES ('3', 'B301', '不可用', '13');
INSERT INTO `class_room` VALUES ('4', 'C303', '使用中', '14');
INSERT INTO `class_room` VALUES ('5', 'C304', '使用中', '14');
INSERT INTO `class_room` VALUES ('10', 'C102', '使用中', '13');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) NOT NULL,
  `course_name` varchar(255) NOT NULL,
  `stu_num` bigint(20) NOT NULL,
  `course_time` varchar(255) DEFAULT NULL,
  `multimedia` varchar(20) NOT NULL,
  `teach_no` bigint(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_id` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '12', '高等数学', '88', '2016-12-26 七八节', '0', '119');
INSERT INTO `course` VALUES ('2', '13', '高等数学', '88', '2016-12-26 七八节', '1', '119');
INSERT INTO `course` VALUES ('3', '14', '商务英语', '90', '2016-12-26 三四节', '0', '119');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `stu_no` bigint(20) NOT NULL,
  `stu_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1310400114', '胡廷聪');
INSERT INTO `student` VALUES ('2', '1310400115', '成');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teach_no` bigint(20) NOT NULL,
  `teach_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '110', '刘');
INSERT INTO `teacher` VALUES ('2', '119', '胡廷聪');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_no` bigint(20) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `is_Admin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_no` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1310400114', 'c4ca4238a0b923820dcc509a6f75849b', 'true');
INSERT INTO `users` VALUES ('2', '1310400115', 'c4ca4238a0b923820dcc509a6f75849b', 'false');
INSERT INTO `users` VALUES ('3', '119', 'c4ca4238a0b923820dcc509a6f75849b', 'true');
