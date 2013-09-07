/*
MySQL Data Transfer
Source Host: localhost
Source Database: eshop
Target Host: localhost
Target Database: eshop
Date: 2013/9/8 1:29:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for buyer
-- ----------------------------
CREATE TABLE `buyer` (
  `Buyer_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) NOT NULL,
  `Sex` varchar(1) DEFAULT NULL,
  `User` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Email` varchar(128) DEFAULT NULL,
  `Register_Date` datetime NOT NULL,
  PRIMARY KEY (`Buyer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=201309030002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for carriage
-- ----------------------------
CREATE TABLE `carriage` (
  `Carriage_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Start` varchar(16) NOT NULL,
  `Destination` varchar(16) NOT NULL,
  `Company` varchar(64) NOT NULL,
  `Cost` smallint(6) NOT NULL,
  PRIMARY KEY (`Carriage_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20130903003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
CREATE TABLE `category` (
  `Category_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Cat_Category_ID` bigint(20) DEFAULT NULL,
  `Name` varchar(32) NOT NULL,
  PRIMARY KEY (`Category_ID`),
  KEY `FK_Relationship_9` (`Cat_Category_ID`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`Cat_Category_ID`) REFERENCES `category` (`Category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10407 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
CREATE TABLE `commodity` (
  `Commodity_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Category_ID` bigint(20) DEFAULT NULL,
  `Name` varchar(32) NOT NULL,
  `Sales` int(11) DEFAULT NULL,
  `Price` double NOT NULL,
  `Discount_Price` double DEFAULT NULL,
  `Is_Recommend` tinyint(1) NOT NULL,
  `Rest` bigint(20) DEFAULT NULL,
  `Picture` varchar(256) DEFAULT NULL,
  `Average_Mark` double DEFAULT NULL,
  `Introduction` text,
  `Origin` varchar(16) DEFAULT NULL,
  `Market_Price` double DEFAULT NULL,
  `Register_Date` datetime NOT NULL,
  `Is_SALE` tinyint(1) DEFAULT NULL,
  `Brand` varchar(64) NOT NULL,
  PRIMARY KEY (`Commodity_ID`),
  KEY `FK_Relationship_2` (`Category_ID`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10406004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
CREATE TABLE `delivery` (
  `Delivery_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Buyer_ID` bigint(20) DEFAULT NULL,
  `Postcode` int(11) NOT NULL,
  `Address` varchar(256) NOT NULL,
  `Phone` varchar(32) NOT NULL,
  PRIMARY KEY (`Delivery_ID`),
  KEY `FK_Relationship_11` (`Buyer_ID`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`Buyer_ID`) REFERENCES `buyer` (`Buyer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20130903000104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for import_list
-- ----------------------------
CREATE TABLE `import_list` (
  `Import_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Commodity_ID` bigint(20) DEFAULT NULL,
  `Quantity` smallint(6) NOT NULL,
  `Price` double NOT NULL,
  `Import_Date` datetime NOT NULL,
  PRIMARY KEY (`Import_ID`),
  KEY `FK_Relationship_15` (`Commodity_ID`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`Commodity_ID`) REFERENCES `commodity` (`Commodity_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=543549 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_list
-- ----------------------------
CREATE TABLE `order_list` (
  `Order_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Buyer_ID` bigint(20) DEFAULT NULL,
  `Commodity_ID` bigint(20) DEFAULT NULL,
  `Quantity` smallint(6) DEFAULT NULL,
  `Pay_Type` smallint(6) DEFAULT NULL,
  `State` smallint(6) NOT NULL,
  `Logistics_State` varchar(1024) DEFAULT NULL,
  `Register_Date` datetime NOT NULL,
  `Post_Type` int(11) DEFAULT NULL,
  `Postcode` int(11) DEFAULT NULL,
  `Address` varchar(256) DEFAULT NULL,
  `Phone` varchar(32) DEFAULT NULL,
  `Carriage_Fee` smallint(6) DEFAULT NULL,
  `Comment` varchar(1024) DEFAULT NULL,
  `Is_Matched` smallint(6) DEFAULT NULL,
  `Logistics_Speed` smallint(6) DEFAULT NULL,
  `Attitude` smallint(6) DEFAULT NULL,
  `Comment_Date` datetime DEFAULT NULL,
  `Total` double DEFAULT NULL,
  PRIMARY KEY (`Order_ID`),
  KEY `FK_Relationship_5` (`Commodity_ID`),
  KEY `FK_Relationship_6` (`Buyer_ID`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`Commodity_ID`) REFERENCES `commodity` (`Commodity_ID`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`Buyer_ID`) REFERENCES `buyer` (`Buyer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20130903000104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for other_pay
-- ----------------------------
CREATE TABLE `other_pay` (
  `OPay_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `User_ID` bigint(20) DEFAULT NULL,
  `Note` varchar(1024) DEFAULT NULL,
  `OPay_Date` datetime NOT NULL,
  `Amount` double NOT NULL,
  PRIMARY KEY (`OPay_ID`),
  KEY `FK_Relationship_12` (`User_ID`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pay_way
-- ----------------------------
CREATE TABLE `pay_way` (
  `Pay_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) NOT NULL,
  `Company` varchar(64) NOT NULL,
  `URL` varchar(1024) NOT NULL,
  PRIMARY KEY (`Pay_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_list
-- ----------------------------
CREATE TABLE `role_list` (
  `Role_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Role` int(11) NOT NULL,
  `Authority` varchar(256) NOT NULL,
  PRIMARY KEY (`Role_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sales_record
-- ----------------------------
CREATE TABLE `sales_record` (
  `Record_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Commodity_ID` bigint(20) DEFAULT NULL,
  `Quantity` smallint(6) NOT NULL,
  `Amount` double NOT NULL,
  `Record_Date` datetime NOT NULL,
  PRIMARY KEY (`Record_ID`),
  KEY `FK_Relationship_14` (`Commodity_ID`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`Commodity_ID`) REFERENCES `commodity` (`Commodity_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `User_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Role_ID` bigint(20) DEFAULT NULL,
  `User` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `FK_Relationship_13` (`Role_ID`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`Role_ID`) REFERENCES `role_list` (`Role_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20105346 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `buyer` VALUES ('201309010001', 'lc', '男', '20105296', '20105296', '12349923@qq.com', '2012-09-02 17:12:33');
INSERT INTO `buyer` VALUES ('201309020001', 'lwx', '女', '20105235', '20105235', '5187616587@qq.com', '2012-09-03 17:12:35');
INSERT INTO `buyer` VALUES ('201309030001', 'lzq', '男', '20105200', '20105200', '02489075@qq.com', '2012-09-04 17:12:40');
INSERT INTO `carriage` VALUES ('20130901001', '广州', '重庆', '56', '7');
INSERT INTO `carriage` VALUES ('20130902001', '重庆', '广州', '78', '8');
INSERT INTO `carriage` VALUES ('20130902005', '广州', '重庆', '56', '75');
INSERT INTO `carriage` VALUES ('20130903001', '重庆', '广州', '78', '45');
INSERT INTO `carriage` VALUES ('20130903002', '广州', '重庆', '56', '79');
INSERT INTO `category` VALUES ('1', '1', '食品酒水  ');
INSERT INTO `category` VALUES ('104', '1', '休闲食品');
INSERT INTO `category` VALUES ('10401', '104', '巧克力');
INSERT INTO `category` VALUES ('10402', '104', '枣干');
INSERT INTO `category` VALUES ('10403', '104', '糕点饼干');
INSERT INTO `category` VALUES ('10404', '104', '干果');
INSERT INTO `category` VALUES ('10405', '104', '牛肉干');
INSERT INTO `category` VALUES ('10406', '104', '蜜饯');
INSERT INTO `commodity` VALUES ('10401001', '10401', 'M&M\'s花生牛奶巧克力豆135g', '12', '36.4', '36.4', '1', '95', null, '85', '好吃又便宜', '越南', '45', '2012-09-02 17:22:26', '1', 'MM');
INSERT INTO `commodity` VALUES ('10401002', '10401', 'Rocher费列罗T30榛果威化巧克力375g', '12', '89', '88', '1', '82', null, '89', '香浓可口', '英国', '119', '2012-09-03 17:23:06', '1', 'mc');
INSERT INTO `commodity` VALUES ('10401003', '10401', '德芙精心之选巧克力礼盒金色装', '12', '118', '115', '1', '52', null, '86', '好吃到cry', '重庆', '46', '2012-09-02 17:24:13', '1', 'po');
INSERT INTO `commodity` VALUES ('10402001', '10402', '一品玉和田枣四星', '12', '69.9', '68', '1', '42', null, '90', '掌柜极力推荐', '广州', '51', '2012-09-03 17:32:25', '1', 'nc');
INSERT INTO `commodity` VALUES ('10402002', '10402', '疆域本色和田好枣四星', '12', '29.9', '28', '1', '46', null, '89', '不好吃包全退', '福建', '46', '2012-09-04 17:32:28', '1', 'wa');
INSERT INTO `commodity` VALUES ('10402003', '10402', '昆仑山和田玉枣四星', '12', '115', '113', '1', '53', null, '93', '低脂低热量健康食品', '南京', '65', '2012-09-02 17:32:32', '1', 'grs');
INSERT INTO `commodity` VALUES ('10403001', '10403', '雀巢巧克力夹心威化', '12', '19.9', '15', '1', '16', null, '88', '减肥瘦身最佳食品', '上海', '46', '2012-09-06 17:32:35', '1', 'hrsj');
INSERT INTO `commodity` VALUES ('10403002', '10403', '卡夫奥利奥夹心饼干', '12', '11.9', '10', '1', '76', null, '92', '亲朋好友都夸好吃', '上海', '53', '2012-09-03 17:32:38', '1', 'jtsa');
INSERT INTO `commodity` VALUES ('10403003', '10403', '旺旺仙贝经济包', '12', '22', '21', '1', '12', null, '91', '全民疯抢特惠价', '台湾', '35', '2012-08-28 17:32:42', '1', 'tscv');
INSERT INTO `commodity` VALUES ('10404001', '10404', '甘源 零食分享包', '12', '15.9', '13', '1', '72', null, '95', '低脂低热量', '越南', '42', '2012-09-25 17:32:45', '1', 'cctv');
INSERT INTO `commodity` VALUES ('10404002', '10404', '拉友 桂西北甜栗', '12', '14.7', '14', '1', '43', null, '96', '迅速补充能量', '重庆', '45', '2012-09-18 17:32:50', '1', 'aga');
INSERT INTO `commodity` VALUES ('10404003', '10404', '黄飞红麻辣花生', '12', '44', '40', '1', '16', null, '94', '亲朋好友馈赠佳品', '重庆', '52', '2012-09-18 17:32:53', '1', 'hrs');
INSERT INTO `commodity` VALUES ('10405001', '10405', '棒棒娃手撕牛肉', '12', '16.8', '16', '1', '12', null, '93', '回头客99%', '上海', '60', '2012-09-24 17:32:56', '1', 'tdbh');
INSERT INTO `commodity` VALUES ('10405002', '10405', '金角五香牛肉干', '12', '29.4', '29', '1', '43', null, '89', '美食杂志极力推荐小零食', '北京', '47', '2012-09-24 17:32:59', '1', 'ntd');
INSERT INTO `commodity` VALUES ('10405003', '10405', '棒棒娃灯影牛肉', '12', '19', '18', '1', '19', null, '88', '好评率98%', '四川', '49', '2012-09-11 17:33:02', '1', 'xhr');
INSERT INTO `commodity` VALUES ('10406001', '10406', '果园老农加州西梅', '12', '39', '35', '1', '26', null, '91', '限时低价', '广州', '58', '2012-09-25 17:33:06', '1', 'sdh');
INSERT INTO `commodity` VALUES ('10406002', '10406', '沙漠玉珠新疆葡萄干', '12', '43.8', '43', '1', '86', null, '93', '掌柜自留，极力推荐', '福建', '52', '2012-09-27 17:33:10', '1', 'rsse');
INSERT INTO `commodity` VALUES ('10406003', '10406', '安琪百钻无铝双效泡打粉', '12', '3', '3', '1', '49', null, '95', '限时低价', '浙江', '53', '2012-09-30 17:33:13', '1', 'shr');
INSERT INTO `delivery` VALUES ('20130901000101', '201309010001', '400000', '重庆市沙坪坝区', '13996524324');
INSERT INTO `delivery` VALUES ('20130901000102', '201309020001', '400000', '重庆市江北区', '13996524325');
INSERT INTO `delivery` VALUES ('20130903000103', '201309030001', '400000', '重庆市渝中区', '13996524326');
INSERT INTO `import_list` VALUES ('123456', '10402003', '26', '75', '2012-09-16 16:21:54');
INSERT INTO `import_list` VALUES ('156541', '10401002', '28', '178', '2012-09-03 16:19:56');
INSERT INTO `import_list` VALUES ('156813', '10401003', '45', '123', '2012-09-10 16:20:31');
INSERT INTO `import_list` VALUES ('168354', '10402001', '15', '41', '2012-09-11 16:21:00');
INSERT INTO `import_list` VALUES ('489851', '10402002', '12', '78', '2012-09-04 16:21:26');
INSERT INTO `import_list` VALUES ('543548', '10401001', '32', '156', '2012-09-02 16:18:49');
INSERT INTO `order_list` VALUES ('20100902000102', '201309010001', '10402001', '2', '1', '1', '正在派送中', '2012-09-02 17:02:53', '2', '1', '重庆市渝中区', '13996524326', '15', '性价比高，下次推荐朋友来买', '98', '93', '95', '2012-09-05 17:03:28', '99');
INSERT INTO `order_list` VALUES ('20130901000101', '201309020001', '10401001', '23', '2', '2', '到达重庆', '2012-09-02 16:51:38', '1', '2', '重庆市沙坪坝区', '13996524324', '12', '非常好，下次还会购买', '100', '85', '91', '2012-09-11 16:57:59', '95');
INSERT INTO `order_list` VALUES ('20130903000103', '201309030001', '10401003', '5', '2', '2', '已签收', '2012-09-02 17:01:15', '1', '1', '重庆市江北区', '13996524325', '10', '朋友都夸好看', '95', '90', '93', '2012-09-03 17:00:32', '98');
INSERT INTO `role_list` VALUES ('1', '2', '1');
INSERT INTO `role_list` VALUES ('2', '2', '2');
INSERT INTO `role_list` VALUES ('3', '3', '3');
INSERT INTO `role_list` VALUES ('4', '4', '4');
INSERT INTO `role_list` VALUES ('5', '5', '5');
INSERT INTO `role_list` VALUES ('6', '6', '6');
INSERT INTO `role_list` VALUES ('7', '7', '7');
INSERT INTO `role_list` VALUES ('8', '8', '8');
INSERT INTO `user` VALUES ('20105200', '2', '20105200', '20105200');
INSERT INTO `user` VALUES ('20105228', '5', '20105228', '20105228');
INSERT INTO `user` VALUES ('20105235', '3', '20105235', '20105235');
INSERT INTO `user` VALUES ('20105296', '1', '20105296', '20105296');
INSERT INTO `user` VALUES ('20105345', '4', '20105345', '20105345');
