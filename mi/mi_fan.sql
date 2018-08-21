/*
Navicat MySQL Data Transfer

Source Server         : szy
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mi_fan

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-08-21 13:09:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) DEFAULT NULL,
  `cat_desc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '手机', '手机222');
INSERT INTO `category` VALUES ('2', '电脑', '电脑');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(100) DEFAULT NULL,
  `goods_price` double(8,2) DEFAULT NULL,
  `goods_img` varchar(50) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  KEY `cat_id` (`cat_id`),
  CONSTRAINT `cat_id` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('31', '33', '2400.00', 'icon_s_04.png', '2');
INSERT INTO `goods` VALUES ('32', '小米1', '344.00', 'T1Xvx_BKxT1RXrhCrK.jpg', '1');
INSERT INTO `goods` VALUES ('33', '小米3', '333.00', 'T1Xvx_BKxT1RXrhCrK.jpg', '2');
INSERT INTO `goods` VALUES ('34', '小米5', '666.00', 'T1U.jpg', '1');
INSERT INTO `goods` VALUES ('35', '小米电脑', '444.00', 'T1Xvx_BKxT1RXrhCrK.jpg', '2');
INSERT INTO `goods` VALUES ('36', '小米Is', '677.00', 'T1DLZvBmVT1RXrhCrK.jpg', '1');
INSERT INTO `goods` VALUES ('37', '小米3s', '555.00', 'note180.jpg', '1');
INSERT INTO `goods` VALUES ('38', '小米4', '556.00', 'T1U.jpg', '1');
INSERT INTO `goods` VALUES ('39', '小米6', '7775.00', 'note180.jpg', '1');
INSERT INTO `goods` VALUES ('40', '小米5x', '900.00', 'T1DLZvBmVT1RXrhCrK.jpg', '2');
INSERT INTO `goods` VALUES ('41', '红米2', '664.00', 'T1Xvx_BKxT1RXrhCrK.jpg', '1');
INSERT INTO `goods` VALUES ('42', '红米5', '556.00', 'note180.jpg', '1');
INSERT INTO `goods` VALUES ('43', '小米4', '777.00', 'T1U.jpg', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ord_id` varchar(60) NOT NULL DEFAULT '',
  `ord_totalPrice` double(10,2) DEFAULT NULL,
  `ord_score` int(8) DEFAULT NULL,
  `ord_time` timestamp NULL DEFAULT NULL,
  `ord_status` tinyint(8) DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  `ord_payTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ord_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('07e23d64-4420-4070-9166-f2a956e32a80', '200.00', '0', '2018-04-10 13:51:38', '0', '23', null);
INSERT INTO `orders` VALUES ('0e279e66-c950-416a-ab00-53b12a80ce8e', '300.00', '0', '2018-04-09 11:26:50', '0', '22', null);
INSERT INTO `orders` VALUES ('17f6af31-033b-4959-aa2b-36d5889ddaa4', '3164.00', '0', '2018-04-10 18:50:38', '1', '24', '2018-04-11 15:03:52');
INSERT INTO `orders` VALUES ('182741f5-3c82-4afb-bb2e-510af569dfe7', '554.00', '0', '2018-04-12 11:02:02', '1', '24', '2018-04-12 12:02:12');
INSERT INTO `orders` VALUES ('185fdf38-57d2-453e-8d47-9d29e4112859', '300.00', '0', '2018-04-09 09:49:59', '0', '21', null);
INSERT INTO `orders` VALUES ('187e43a6-0452-4a46-82ab-420d7137891e', '300.00', '0', '2018-04-11 09:31:42', '1', '20', '2018-07-03 09:34:57');
INSERT INTO `orders` VALUES ('200378b1-d974-408b-aa50-5257dba6d38a', '1343.00', '0', '2018-04-12 15:12:23', '1', '24', '2018-04-12 15:12:27');
INSERT INTO `orders` VALUES ('316e9272-ddee-47e8-a7eb-3b1a631feb68', '544.00', '0', '2018-04-11 09:20:00', '1', '24', '2018-04-11 15:03:52');
INSERT INTO `orders` VALUES ('386c1db5-4318-4197-8e1a-1f54e429f712', '500.00', '0', '2018-04-10 15:29:09', '1', '24', '2018-04-12 12:38:59');
INSERT INTO `orders` VALUES ('3dc499d8-33d2-4c17-863f-9f3192c5a3af', '333.00', '0', '2018-04-12 13:25:42', '1', '24', '2018-04-12 13:26:21');
INSERT INTO `orders` VALUES ('49cce7a1-e3ba-436a-a077-9a1078c91997', '33.00', '0', '2018-04-12 14:21:18', '0', '24', null);
INSERT INTO `orders` VALUES ('4b2c3d4f-d0c0-4705-bdcb-3703ff75cc32', '400.00', '0', '2018-04-10 20:02:19', '0', '24', null);
INSERT INTO `orders` VALUES ('5073aed1-ae1f-45cc-ace2-51ccb410a0dc', '888.00', '0', '2018-04-12 11:45:57', '1', '24', '2018-04-12 11:48:33');
INSERT INTO `orders` VALUES ('5c05d2fc-883e-46ee-ba7b-a906967a47d7', '400.00', '0', '2018-04-11 17:25:30', '1', '25', '2018-04-11 17:28:05');
INSERT INTO `orders` VALUES ('7552d0ec-d54a-4825-b28f-ec7125c954ac', '400.00', '0', '2018-04-10 09:26:47', '0', '23', null);
INSERT INTO `orders` VALUES ('7ce9a65a-4ee8-4f21-9395-846f8e636ae2', '677.00', '0', '2018-04-12 15:12:35', '1', '24', '2018-04-12 15:12:48');
INSERT INTO `orders` VALUES ('80db15b6-af5a-4d04-8c03-a7d3f2f965d5', '999.00', '0', '2018-04-12 11:52:25', '0', '24', null);
INSERT INTO `orders` VALUES ('8152c28d-d9c8-496e-8ccf-d09604b629d5', '4742.00', '0', '2018-04-09 15:44:06', '1', '23', '2018-04-11 15:03:52');
INSERT INTO `orders` VALUES ('85df468e-c2ea-49e4-92cf-a9d3dd402e6c', '1288.00', '0', '2018-04-09 11:03:10', '0', '21', null);
INSERT INTO `orders` VALUES ('8b2e3d7e-2f2b-48c9-8aac-66b74fd100a9', '100.00', '0', '2018-04-10 19:34:58', '1', '24', '2018-04-12 15:08:32');
INSERT INTO `orders` VALUES ('8d3a4d89-2184-49e6-808b-954c20a1e79d', '2565.00', '0', '2018-04-12 15:30:09', '1', '24', '2018-04-12 15:30:39');
INSERT INTO `orders` VALUES ('94b427a9-99f5-4621-9e52-696df77b3a15', '832.00', '0', '2018-04-09 13:24:16', '0', '23', '2018-04-11 14:53:29');
INSERT INTO `orders` VALUES ('a1968ffa-0159-413b-a5fa-6e11c4e2d1d0', '232.00', '0', '2018-04-11 09:22:26', '0', '24', null);
INSERT INTO `orders` VALUES ('a8f4840c-f6d9-4ddc-ab4f-ef652bcba33d', '444.00', '0', '2018-04-12 14:20:12', '1', '24', '2018-04-12 14:20:16');
INSERT INTO `orders` VALUES ('b1104c11-9d5f-4af3-ab76-4810a2f82264', '700.00', '0', '2018-04-11 08:53:58', '1', '24', '2018-04-12 15:09:55');
INSERT INTO `orders` VALUES ('b7d7c86d-efac-489d-93ec-46112488ab3f', '300.00', '0', '2018-04-11 09:18:29', '0', '24', null);
INSERT INTO `orders` VALUES ('be592c8a-d9e9-4869-a9fc-33f22dde4e7d', '800.00', '0', '2018-04-10 18:48:59', '1', '24', '2018-04-12 15:11:40');
INSERT INTO `orders` VALUES ('bf9ee51c-55df-4322-a234-696ac017499d', '4800.00', '0', '2018-04-12 15:08:02', '1', '24', '2018-04-12 15:08:05');
INSERT INTO `orders` VALUES ('d18660df-d9c4-48a8-9576-61c309b17107', '6054.00', '0', '2018-04-10 14:04:29', '1', '24', '2018-04-11 15:03:52');
INSERT INTO `orders` VALUES ('d43f83d1-a317-4768-999e-d3fe8bbb8222', '2133.00', '0', '2018-07-09 08:57:30', '1', '20', '2018-07-09 09:00:08');
INSERT INTO `orders` VALUES ('d719baeb-37f4-4b19-b95a-4171088b2c7a', '2922.00', '0', '2018-04-10 15:14:07', '1', '24', '2018-04-11 15:03:52');
INSERT INTO `orders` VALUES ('d7cfd878-62c2-477a-95c0-ec9343419cdc', '1354.00', '0', '2018-04-12 15:31:49', '1', '24', '2018-04-12 15:31:56');
INSERT INTO `orders` VALUES ('dbe9f0d8-bdd2-4f63-8400-73c022c487dc', '4440.00', '0', '2018-04-10 18:51:00', '0', '24', null);
INSERT INTO `orders` VALUES ('e3908757-0558-4d0e-9106-7e73596a34bb', '200.00', '0', '2018-04-11 18:52:37', '0', '24', null);
INSERT INTO `orders` VALUES ('e51cf98a-a5c9-404b-85a9-b77fb8ada60f', '600.00', '0', '2018-04-10 19:48:22', '1', '24', '2018-04-11 15:03:52');
INSERT INTO `orders` VALUES ('ebfe292a-904c-4817-bd4e-73333abe542e', '200.00', '0', '2018-04-10 13:55:42', '0', '23', null);
INSERT INTO `orders` VALUES ('ef8a204f-de78-41ae-8d64-f1a3a6383ea6', '7200.00', '0', '2018-08-21 12:40:37', '0', '20', null);
INSERT INTO `orders` VALUES ('ef9a3511-e119-4207-8bc7-07c19d85981c', '8658.00', '0', '2018-04-12 13:30:43', '1', '20', '2018-04-12 13:30:48');

-- ----------------------------
-- Table structure for ordersitem
-- ----------------------------
DROP TABLE IF EXISTS `ordersitem`;
CREATE TABLE `ordersitem` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `item_quantity` int(11) DEFAULT NULL,
  `item_singlePrice` double(10,2) DEFAULT NULL,
  `ord_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `ord_id` (`ord_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ord_id` FOREIGN KEY (`ord_id`) REFERENCES `orders` (`ord_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordersitem
-- ----------------------------
INSERT INTO `ordersitem` VALUES ('63', '31', '2', '4800.00', 'bf9ee51c-55df-4322-a234-696ac017499d');
INSERT INTO `ordersitem` VALUES ('64', '34', '1', '666.00', '200378b1-d974-408b-aa50-5257dba6d38a');
INSERT INTO `ordersitem` VALUES ('65', '36', '1', '677.00', '200378b1-d974-408b-aa50-5257dba6d38a');
INSERT INTO `ordersitem` VALUES ('66', '36', '1', '677.00', '7ce9a65a-4ee8-4f21-9395-846f8e636ae2');
INSERT INTO `ordersitem` VALUES ('67', '37', '3', '1665.00', '8d3a4d89-2184-49e6-808b-954c20a1e79d');
INSERT INTO `ordersitem` VALUES ('68', '40', '1', '900.00', '8d3a4d89-2184-49e6-808b-954c20a1e79d');
INSERT INTO `ordersitem` VALUES ('69', '36', '2', '1354.00', 'd7cfd878-62c2-477a-95c0-ec9343419cdc');
INSERT INTO `ordersitem` VALUES ('70', '33', '1', '333.00', 'd43f83d1-a317-4768-999e-d3fe8bbb8222');
INSERT INTO `ordersitem` VALUES ('71', '40', '2', '1800.00', 'd43f83d1-a317-4768-999e-d3fe8bbb8222');
INSERT INTO `ordersitem` VALUES ('72', '31', '3', '7200.00', 'ef8a204f-de78-41ae-8d64-f1a3a6383ea6');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(10) NOT NULL AUTO_INCREMENT,
  `score_num` double(20,0) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `user_sex` int(4) DEFAULT NULL,
  `user_pwd` varchar(200) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_score` double(20,2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20', null, null, 'BCBE3365E6AC95EA2C0343A2395834DD', '222', '2130.87');
INSERT INTO `user` VALUES ('21', null, null, '698D51A19D8A121CE581499D7B701668', '111', null);
INSERT INTO `user` VALUES ('22', null, null, 'C6F057B86584942E415435FFB1FA93D4', '000', null);
INSERT INTO `user` VALUES ('23', null, null, 'FAE0B27C451C728867A567E8C1BB4E53', '666', '832.00');
INSERT INTO `user` VALUES ('24', null, null, '310DCBBF4CCE62F762A2AAA148D556BD', '333', '1328.00');
INSERT INTO `user` VALUES ('25', null, null, '50BD8C21BFAFA6E4E962F6A948B1EF92', 'fan', '400.00');
