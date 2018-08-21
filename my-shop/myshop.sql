/*
Navicat MySQL Data Transfer

Source Server         : szy
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : myshop

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-08-21 17:38:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` int(11) NOT NULL,
  `cat_name` varchar(50) DEFAULT NULL,
  `cat_iden` varchar(200) DEFAULT NULL,
  `parent_id` int(20) DEFAULT NULL,
  `parent_iden` varchar(200) DEFAULT NULL,
  `cat_url` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `mem_id` int(20) NOT NULL AUTO_INCREMENT,
  `mem_name` varchar(50) DEFAULT NULL,
  `mem_grade_name` varchar(20) DEFAULT NULL COMMENT '会员等级',
  `mem_pwd` varchar(100) DEFAULT NULL,
  `mem_card_num` varchar(50) DEFAULT NULL COMMENT '卡号',
  `mem_bir_type` varchar(6) DEFAULT NULL COMMENT '阴历生日还是阳历生日',
  `mem_birthday` varchar(20) DEFAULT NULL COMMENT '生日',
  `recommend_name` varchar(20) DEFAULT NULL,
  `mem_note` varchar(255) DEFAULT '' COMMENT '会员备注',
  `mem_sex` varchar(10) DEFAULT NULL COMMENT '会员性别',
  `mem_tel` int(20) DEFAULT NULL COMMENT '会员电话',
  `sell_card_money` decimal(20,2) DEFAULT NULL COMMENT '开卡的钱(售卡的钱)',
  `mem_card_balance` decimal(20,2) DEFAULT NULL COMMENT '会员卡余额',
  `mem_card_state` varchar(10) DEFAULT NULL COMMENT '卡片状态:挂失,注销等',
  `mem_card_expires` date DEFAULT NULL,
  `mem_card_score` int(30) DEFAULT NULL COMMENT '会员当前积分',
  `mem_reg_time` datetime DEFAULT NULL,
  `grade_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`mem_id`),
  KEY `grade_id` (`grade_id`),
  CONSTRAINT `grade_id` FOREIGN KEY (`grade_id`) REFERENCES `mem_grade` (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '66', null, '55', null, null, null, null, '', null, null, null, null, null, null, null, null, '1');
INSERT INTO `member` VALUES ('2', '66', '66', '55', null, null, '88', null, '', null, null, null, null, null, null, null, null, '2');
INSERT INTO `member` VALUES ('3', '66', '66', '66', '99', '公立', '88', '44', null, '男', '66', '5.00', '65.00', '正常', null, null, null, '2');
INSERT INTO `member` VALUES ('4', '9958', '默认等级', '44', '1514020', '公历', '08-10', '4', null, '男', '55', '55.22', '66.54', '正常', null, null, null, '2');
INSERT INTO `member` VALUES ('5', '9958', '默认等级', '44', '1514020', '公历', '08-10', '4', null, '男', '55', '55.22', '66.54', '正常', null, null, '2018-08-10 09:27:14', '2');
INSERT INTO `member` VALUES ('6', '22', '初始等级', '22', '2222', '公历', '08-10', '4534', null, '女', '22', '4.00', '5.55', '正常', null, '4', null, '2');
INSERT INTO `member` VALUES ('7', '', '默认等级', '', '54', '公历', '', '摇一摇', null, '未知', null, null, null, '正常', null, null, '2018-08-10 11:44:22', '3');
INSERT INTO `member` VALUES ('18', '', '默认等级', '', null, '公历', '', '', null, '未知', null, null, null, '正常', null, null, '2018-08-10 17:24:31', '2');
INSERT INTO `member` VALUES ('19', '', '默认等级', '', null, '公历', '', '', null, '未知', null, null, null, '正常', null, null, '2018-08-10 17:24:47', '2');
INSERT INTO `member` VALUES ('20', '', '默认等级', '', null, '公历', '', '', null, '未知', null, null, null, '正常', null, null, '2018-08-10 17:25:21', '2');
INSERT INTO `member` VALUES ('21', '', '默认等级', '', null, '公历', '', '', null, '未知', null, null, null, '正常', null, null, '2018-08-10 17:25:34', '2');
INSERT INTO `member` VALUES ('22', '', '默认等级', '', null, '公历', '', '', null, '未知', null, null, null, '正常', null, null, '2018-08-10 17:26:44', '2');
INSERT INTO `member` VALUES ('23', '3453', null, '53453', '534', '农历', '08-16', '55', null, '男', '4345', '55.00', '55.00', '挂失', null, '55', '2018-08-21 17:36:11', null);

-- ----------------------------
-- Table structure for mem_grade
-- ----------------------------
DROP TABLE IF EXISTS `mem_grade`;
CREATE TABLE `mem_grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(20) DEFAULT NULL,
  `grade_exchange_ratio` decimal(10,2) DEFAULT NULL COMMENT '兑换比例',
  `grade_general_dis_ratio` decimal(10,2) DEFAULT NULL COMMENT '折扣比例',
  `grade_serve_dis_ratio` decimal(10,2) DEFAULT NULL COMMENT '服务折扣比例',
  `grade_score` decimal(10,2) DEFAULT NULL,
  `grade_state` tinyint(10) DEFAULT NULL COMMENT '当前等级状态,是1的时候就可用,是0 就是用户',
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mem_grade
-- ----------------------------
INSERT INTO `mem_grade` VALUES ('1', '青铜会员', '1.00', '1.00', null, '1.00', '1');
INSERT INTO `mem_grade` VALUES ('2', '白银会员', '1.00', '1.00', null, '1.00', '0');
INSERT INTO `mem_grade` VALUES ('3', '白金会员', '1.00', '1.00', null, '1.00', '1');
INSERT INTO `mem_grade` VALUES ('4', '黄金会员', '1.00', '1.00', '0.55', '55.00', '1');
INSERT INTO `mem_grade` VALUES ('5', '黄金会员', '1.00', '1.00', '0.55', '55.00', '1');
INSERT INTO `mem_grade` VALUES ('6', '青铜1', '1.00', '0.50', '0.90', '1.00', '1');
INSERT INTO `mem_grade` VALUES ('7', '青铜1', '1.00', '0.50', '0.90', '1.00', '1');
INSERT INTO `mem_grade` VALUES ('8', '白银1', '0.50', '0.60', '0.70', '5.00', '1');
INSERT INTO `mem_grade` VALUES ('9', '白银1', '0.50', '0.60', '0.70', '5.00', '1');
INSERT INTO `mem_grade` VALUES ('10', '会员1', '1.00', '1.00', '1.00', '5.00', '1');
INSERT INTO `mem_grade` VALUES ('11', '会员2', '0.50', '0.80', '0.70', '5.00', '1');
INSERT INTO `mem_grade` VALUES ('12', '会员2', '0.50', '0.80', '0.70', '5.00', '1');
INSERT INTO `mem_grade` VALUES ('13', '会员2', '0.50', '0.80', '0.70', '5.00', '0');
INSERT INTO `mem_grade` VALUES ('14', 'sadas', '1.00', '1.00', '1.00', '2.00', '1');
