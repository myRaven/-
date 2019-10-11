/*
Navicat MySQL Data Transfer

Source Server         : hhh
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : studentmanager

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2018-06-07 17:36:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` varchar(20) NOT NULL,
  `cname` varchar(30) default NULL,
  `teacher` varchar(10) default NULL,
  `coursetype` varchar(20) default NULL,
  `credit` int(11) default NULL,
  `time` varchar(20) default NULL,
  `day` int(11) default NULL,
  `section` varchar(20) default NULL,
  `object` varchar(50) default NULL,
  `num` int(11) default NULL,
  `allowance` int(11) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1001', '数据库设计与应用', '许盛贵', '专业必修课', '4', '周二，1~3', '2', '1,2,3', '计算机科学与技术', '100', '100');
INSERT INTO `course` VALUES ('1002', '大学英语', '杨日红', '公共必修课', '4', '周二，11~12', '2', '11,12', '计算机科学与技术', '50', '50');
INSERT INTO `course` VALUES ('1003', '民族艺术鉴赏', '陈海山', '专业必修课', '4', '周一，8~9', '1', '8,9', '计算机科学与技术', '120', '118');
INSERT INTO `course` VALUES ('1005', '毛概实践', '曹艳肖', '公共必修课', '4', '周二，12~13', '2', '12,13', '计算机科学与技术', '120', '119');
INSERT INTO `course` VALUES ('1006', '网站设计', '成海秀', '专业限选课', '4', '周三，8~10', '3', '8,9,10', '计算机科学与技术', '120', '120');
INSERT INTO `course` VALUES ('1007', 'java程序设计', '温泉思', '专业必修课', '4', '周五，1~3', '5', '8,9,10', '计算机科学与技术', '120', '119');
INSERT INTO `course` VALUES ('1008', '击剑', '刘子青', '公共必修课', '1', '周四，8~9', '4', '8,9', '计算机科学与技术', '55', '54');
INSERT INTO `course` VALUES ('1009', '篮球', '刘子青', '公共必修课', '1', '周四，8~9', '4', '8,9', '计算机科学与技术', '55', '54');
INSERT INTO `course` VALUES ('1010', '艺术', '你好', '公共必修课', '1', '周四，8~9', '4', '8,9', '艺创', '55', '54');
INSERT INTO `course` VALUES ('1011', '哈哈哈哈', '回火', '公共必修', '2', '3', '1', '4,5', '艺创', '80', '80');
INSERT INTO `course` VALUES ('1012', 'java程序实训', '温泉思', '专业必修课', '3', '周一，1~3', '1', '1,2,3', '计算机科学与技术', '120', '119');
INSERT INTO `course` VALUES ('1013', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `course` VALUES ('1014', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `sid` varchar(20) NOT NULL default '',
  `cid` varchar(20) NOT NULL,
  `score` tinyint(4) default '-1',
  `status` varchar(10) default '未通过',
  PRIMARY KEY  (`sid`,`cid`),
  KEY `cid` (`cid`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('162011000', '1003', '-1', '未通过');
INSERT INTO `score` VALUES ('162011267', '1001', '-1', '未通过');
INSERT INTO `score` VALUES ('162011267', '1003', '-1', '未通过');
INSERT INTO `score` VALUES ('162011267', '1005', '-1', '未通过');
INSERT INTO `score` VALUES ('162011267', '1007', '-1', '未通过');
INSERT INTO `score` VALUES ('162011267', '1008', '-1', '未通过');
INSERT INTO `score` VALUES ('162011267', '1012', '-1', '未通过');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(20) NOT NULL default '0',
  `sname` varchar(10) default NULL,
  `sex` varchar(4) default NULL,
  `borndate` varchar(50) default NULL,
  `nation` varchar(6) default NULL,
  `face` varchar(10) default NULL,
  `college` varchar(50) default NULL,
  `major` varchar(50) default NULL,
  `sclass` varchar(50) default NULL,
  `selectcredit` int(11) default '0',
  `sumcredit` int(11) default '0',
  `password` varchar(20) default '666666',
  `img_path` text,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '测试', '1', '1', '1', '1', '电气与计算机工程学院', '计算机科学与技术', '2016级5班', '0', '1', '1', 'C://Users//Administrator//Desktop//图片//未标题-2.JPG');
INSERT INTO `student` VALUES ('162011000', '哈哈哈哈或', '男', '1997-2', '哈哈', '团员', '电气与计算机工程学院', '计算机科学与技术', '2016级7班', '4', '0', '123', 'C://Users//Administrator//Desktop//??//??2.jpg');
INSERT INTO `student` VALUES ('162011001', '哈哈哈哈哈哈或或或', '男', '123', '无', '群众', '电气与计算机工程学院', '计算机科学与技术', '2016级6班', '8', '0', '123', 'C://Users//Administrator//Desktop//图片//未标题-2.JPG');
INSERT INTO `student` VALUES ('162011002', '哈哈哈哈哈哈', '男', '111', '无', '群众', '电气与计算机工程学院', '电气及自动化', '2016级5班', '0', '0', '123', 'C://Users//Administrator//Desktop//图片//timg.jpg');
INSERT INTO `student` VALUES ('162011004', '哈哈哈', '男', '123', '无', '群众', '电气与计算机工程学院', '计算机科学与技术', '2016级1班', '0', '0', '123', 'C://Users//Administrator//Desktop//图片//timg.jpg');
INSERT INTO `student` VALUES ('162011005', 'myk', '女', '1997-2', '汉族', '群众', '电气与计算机工程学院', '计算机科学与技术', '2016级2班', '0', '0', '123', 'C://Users//Administrator//Desktop//图片//捕获2.jpg');
INSERT INTO `student` VALUES ('162011021', '123', '男', '1997', '汉', '团', '电气与计算机工程学院', '计算机科学与技术', '2016级3班', '0', '0', '123', 'C://Users//Administrator//Desktop//??//??2.jpg');
INSERT INTO `student` VALUES ('162011267', '11', '女', '1997-10', '汉族', '群众', '电气与计算机工程学院', '计算机科学与技术', '2016级5班', '0', '0', '123', 'C://Users//Administrator//Desktop//图片//未标题-2.JPG');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL,
  `tname` varchar(20) default NULL,
  `password` varchar(20) default '666666',
  `lasttime` timestamp NULL default NULL,
  PRIMARY KEY  (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '测试', '1', null);
INSERT INTO `teacher` VALUES ('123', '老师', '123', null);

-- ----------------------------
-- View structure for `a`
-- ----------------------------
DROP VIEW IF EXISTS `a`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `a` AS select sql_no_cache `student`.`sid` AS `sid`,`student`.`sname` AS `sname` from `student` ;

-- ----------------------------
-- View structure for `b`
-- ----------------------------
DROP VIEW IF EXISTS `b`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `b` AS select `student`.`sid` AS `sid`,`student`.`sname` AS `sname`,`student`.`sex` AS `sex` from `student` group by `student`.`major` ;
