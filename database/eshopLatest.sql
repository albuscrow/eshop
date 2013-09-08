-- MySQL dump 10.13  Distrib 5.5.28, for Win64 (x86)
--
-- Host: localhost    Database: eshop
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `buyer`
--

DROP TABLE IF EXISTS `buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyer` (
  `Buyer_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) NOT NULL,
  `Sex` varchar(32) DEFAULT NULL,
  `User` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Email` varchar(128) DEFAULT NULL,
  `Register_Date` datetime NOT NULL,
  PRIMARY KEY (`Buyer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=201309030002 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer`
--

LOCK TABLES `buyer` WRITE;
/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
INSERT INTO `buyer` VALUES (201309010001,'lc','男','20105296','20105296','12349923@qq.com','2012-09-02 17:12:33'),(201309020001,'lwx','女','20105235','20105235','5187616587@qq.com','2012-09-03 17:12:35'),(201309030001,'lzq','男','20105200','20105200','02489075@qq.com','2012-09-04 17:12:40');
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carriage`
--

DROP TABLE IF EXISTS `carriage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carriage` (
  `Carriage_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Start` varchar(16) NOT NULL,
  `Destination` varchar(16) NOT NULL,
  `Company` varchar(64) NOT NULL,
  `Cost` smallint(6) NOT NULL,
  PRIMARY KEY (`Carriage_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20130903003 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carriage`
--

LOCK TABLES `carriage` WRITE;
/*!40000 ALTER TABLE `carriage` DISABLE KEYS */;
INSERT INTO `carriage` VALUES (20130901001,'广州','重庆','56',7),(20130902001,'重庆','广州','78',8),(20130902005,'广州','重庆','56',75),(20130903001,'重庆','广州','78',45),(20130903002,'广州','重庆','56',79);
/*!40000 ALTER TABLE `carriage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `Category_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Cat_Category_ID` bigint(20) DEFAULT NULL,
  `Name` varchar(32) NOT NULL,
  PRIMARY KEY (`Category_ID`),
  KEY `FK_Relationship_9` (`Cat_Category_ID`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`Cat_Category_ID`) REFERENCES `category` (`Category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10407 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,1,'食品酒水  '),(104,1,'休闲食品'),(10401,104,'巧克力'),(10402,104,'枣干'),(10403,104,'糕点饼干'),(10404,104,'干果'),(10405,104,'牛肉干'),(10406,104,'蜜饯');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (10401001,10401,'M&M\'s花生牛奶巧克力豆135g',12,36.4,36.4,1,95,NULL,85,'好吃又便宜','越南',45,'2012-09-02 17:22:26',1,'MM'),(10401002,10401,'Rocher费列罗T30榛果威化巧克力375g',12,89,88,1,82,NULL,89,'香浓可口','英国',119,'2012-09-03 17:23:06',1,'mc'),(10401003,10401,'德芙精心之选巧克力礼盒金色装',12,118,115,1,52,NULL,86,'好吃到cry','重庆',46,'2012-09-02 17:24:13',1,'po'),(10402001,10402,'一品玉和田枣四星',12,69.9,68,1,42,NULL,90,'掌柜极力推荐','广州',51,'2012-09-03 17:32:25',1,'nc'),(10402002,10402,'疆域本色和田好枣四星',12,29.9,28,1,46,NULL,89,'不好吃包全退','福建',46,'2012-09-04 17:32:28',1,'wa'),(10402003,10402,'昆仑山和田玉枣四星',12,115,113,1,53,NULL,93,'低脂低热量健康食品','南京',65,'2012-09-02 17:32:32',1,'grs'),(10403001,10403,'雀巢巧克力夹心威化',12,19.9,15,1,16,NULL,88,'减肥瘦身最佳食品','上海',46,'2012-09-06 17:32:35',1,'hrsj'),(10403002,10403,'卡夫奥利奥夹心饼干',12,11.9,10,1,76,NULL,92,'亲朋好友都夸好吃','上海',53,'2012-09-03 17:32:38',1,'jtsa'),(10403003,10403,'旺旺仙贝经济包',12,22,21,1,12,NULL,91,'全民疯抢特惠价','台湾',35,'2012-08-28 17:32:42',1,'tscv'),(10404001,10404,'甘源 零食分享包',12,15.9,13,1,72,NULL,95,'低脂低热量','越南',42,'2012-09-25 17:32:45',1,'cctv'),(10404002,10404,'拉友 桂西北甜栗',12,14.7,14,1,43,NULL,96,'迅速补充能量','重庆',45,'2012-09-18 17:32:50',1,'aga'),(10404003,10404,'黄飞红麻辣花生',12,44,40,1,16,NULL,94,'亲朋好友馈赠佳品','重庆',52,'2012-09-18 17:32:53',1,'hrs'),(10405001,10405,'棒棒娃手撕牛肉',12,16.8,16,1,12,NULL,93,'回头客99%','上海',60,'2012-09-24 17:32:56',1,'tdbh'),(10405002,10405,'金角五香牛肉干',12,29.4,29,1,43,NULL,89,'美食杂志极力推荐小零食','北京',47,'2012-09-24 17:32:59',1,'ntd'),(10405003,10405,'棒棒娃灯影牛肉',12,19,18,1,19,NULL,88,'好评率98%','四川',49,'2012-09-11 17:33:02',1,'xhr'),(10406001,10406,'果园老农加州西梅',12,39,35,1,26,NULL,91,'限时低价','广州',58,'2012-09-25 17:33:06',1,'sdh'),(10406002,10406,'沙漠玉珠新疆葡萄干',12,43.8,43,1,86,NULL,93,'掌柜自留，极力推荐','福建',52,'2012-09-27 17:33:10',1,'rsse'),(10406003,10406,'安琪百钻无铝双效泡打粉',12,3,3,1,49,NULL,95,'限时低价','浙江',53,'2012-09-30 17:33:13',1,'shr');
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (20130901000101,201309010001,400000,'重庆市沙坪坝区','13996524324'),(20130901000102,201309020001,400000,'重庆市江北区','13996524325'),(20130903000103,201309030001,400000,'重庆市渝中区','13996524326');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_list`
--

DROP TABLE IF EXISTS `import_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `import_list` (
  `Import_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Commodity_ID` bigint(20) DEFAULT NULL,
  `Quantity` smallint(6) NOT NULL,
  `Price` double NOT NULL,
  `Import_Date` datetime NOT NULL,
  PRIMARY KEY (`Import_ID`),
  KEY `FK_Relationship_15` (`Commodity_ID`),
  CONSTRAINT `FK_Relationship_15` FOREIGN KEY (`Commodity_ID`) REFERENCES `commodity` (`Commodity_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=543555 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_list`
--

LOCK TABLES `import_list` WRITE;
/*!40000 ALTER TABLE `import_list` DISABLE KEYS */;
INSERT INTO `import_list` VALUES (123456,10402003,24,75,'2012-09-16 16:21:54'),(156541,10401002,28,178,'2012-09-03 16:19:56'),(156813,10401003,45,123,'2012-09-10 16:20:31'),(168354,10402001,15,41,'2012-09-11 16:21:00'),(489851,10402002,12,78,'2012-09-04 16:21:26'),(543548,10401001,32,156,'2012-09-02 16:18:49'),(543549,10401001,242,235,'2013-09-07 16:37:04'),(543552,10401002,242,75,'2013-09-08 12:59:39'),(543553,10402003,242,75,'2013-09-08 23:25:36'),(543554,10401002,25,33,'2013-09-08 23:25:56');
/*!40000 ALTER TABLE `import_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_list`
--

DROP TABLE IF EXISTS `order_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_list` (
  `Order_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Buyer_ID` bigint(20) DEFAULT NULL,
  `Commodity_ID` bigint(20) DEFAULT NULL,
  `Quantity` smallint(6) NOT NULL,
  `Pay_Type` smallint(6) NOT NULL,
  `State` smallint(6) NOT NULL,
  `Logistics_State` varchar(1024) DEFAULT NULL,
  `Register_Date` datetime NOT NULL,
  `Post_Type` int(11) NOT NULL,
  `Postcode` int(11) NOT NULL,
  `Address` varchar(256) NOT NULL,
  `Phone` varchar(32) NOT NULL,
  `Carriage_Fee` smallint(6) NOT NULL,
  `Comment` varchar(1024) DEFAULT NULL,
  `Is_Matched` smallint(6) NOT NULL,
  `Logistics_Speed` smallint(6) NOT NULL,
  `Attitude` smallint(6) NOT NULL,
  `Comment_Date` datetime NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`Order_ID`),
  KEY `FK_Relationship_5` (`Commodity_ID`),
  KEY `FK_Relationship_6` (`Buyer_ID`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`Commodity_ID`) REFERENCES `commodity` (`Commodity_ID`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`Buyer_ID`) REFERENCES `buyer` (`Buyer_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20130903000104 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_list`
--

LOCK TABLES `order_list` WRITE;
/*!40000 ALTER TABLE `order_list` DISABLE KEYS */;
INSERT INTO `order_list` VALUES (20100902000102,201309010001,10402001,2,1,1,'正在派送中','2012-09-02 17:02:53',2,1,'重庆市渝中区','13996524326',15,'性价比高，下次推荐朋友来买',98,93,95,'2012-09-05 17:03:28',99),(20130901000101,201309020001,10401001,23,2,2,'到达重庆','2012-09-02 16:51:38',1,2,'重庆市沙坪坝区','13996524324',12,'非常好，下次还会购买',100,85,91,'2012-09-11 16:57:59',95),(20130903000103,201309030001,10401003,5,2,2,'已签收','2012-09-02 17:01:15',1,1,'重庆市江北区','13996524325',10,'朋友都夸好看',95,90,93,'2012-09-03 17:00:32',98);
/*!40000 ALTER TABLE `order_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_pay`
--

DROP TABLE IF EXISTS `other_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `other_pay` (
  `OPay_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `User_ID` bigint(20) DEFAULT NULL,
  `Note` varchar(1024) DEFAULT NULL,
  `OPay_Date` datetime NOT NULL,
  `Amount` double NOT NULL,
  PRIMARY KEY (`OPay_ID`),
  KEY `FK_Relationship_12` (`User_ID`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=168357 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_pay`
--

LOCK TABLES `other_pay` WRITE;
/*!40000 ALTER TABLE `other_pay` DISABLE KEYS */;
INSERT INTO `other_pay` VALUES (25485,20105345,'差价补贴','2012-09-05 17:05:54',240),(153246,20105296,'邮费','2012-09-03 17:05:09',650),(168354,20105228,'包装费','2012-09-02 17:05:02',530);
/*!40000 ALTER TABLE `other_pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_way`
--

DROP TABLE IF EXISTS `pay_way`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pay_way` (
  `Pay_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) NOT NULL,
  `Company` varchar(64) NOT NULL,
  `URL` varchar(1024) NOT NULL,
  PRIMARY KEY (`Pay_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=459453 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_way`
--

LOCK TABLES `pay_way` WRITE;
/*!40000 ALTER TABLE `pay_way` DISABLE KEYS */;
INSERT INTO `pay_way` VALUES (23159,'zhuhaiz','chongdaA','www.cqu.edu,net'),(215972,'luzeqi','chongqingdaxue','www.cqu.edu.cn'),(459452,'liangweix','chongda','www.cqu.net');
/*!40000 ALTER TABLE `pay_way` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_list`
--

DROP TABLE IF EXISTS `role_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_list` (
  `Role_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Role` int(11) NOT NULL,
  `Authority` varchar(256) NOT NULL,
  PRIMARY KEY (`Role_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_list`
--

LOCK TABLES `role_list` WRITE;
/*!40000 ALTER TABLE `role_list` DISABLE KEYS */;
INSERT INTO `role_list` VALUES (1,2,'1'),(2,2,'2'),(3,3,'3'),(4,4,'4'),(5,5,'5'),(6,6,'6'),(7,7,'7'),(8,8,'8');
/*!40000 ALTER TABLE `role_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_record`
--

DROP TABLE IF EXISTS `sales_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_record` (
  `Record_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Commodity_ID` bigint(20) DEFAULT NULL,
  `Quantity` smallint(6) NOT NULL,
  `Amount` double NOT NULL,
  `Record_Date` datetime NOT NULL,
  PRIMARY KEY (`Record_ID`),
  KEY `FK_Relationship_14` (`Commodity_ID`),
  CONSTRAINT `FK_Relationship_14` FOREIGN KEY (`Commodity_ID`) REFERENCES `commodity` (`Commodity_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=452137 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_record`
--

LOCK TABLES `sales_record` WRITE;
/*!40000 ALTER TABLE `sales_record` DISABLE KEYS */;
INSERT INTO `sales_record` VALUES (156324,10401003,20,2036,'2012-09-03 17:11:25'),(156421,10401002,12,1562,'2012-09-02 17:11:11'),(452136,10402003,18,1865,'2012-09-04 17:11:54');
/*!40000 ALTER TABLE `sales_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Role_ID` bigint(20) DEFAULT NULL,
  `User` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `FK_Relationship_13` (`Role_ID`),
  CONSTRAINT `FK_Relationship_13` FOREIGN KEY (`Role_ID`) REFERENCES `role_list` (`Role_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20105346 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (20105200,2,'20105200','20105200','LZQ'),(20105228,5,'20105228','20105228','GY'),(20105296,1,'20105296','20105296','LC'),(20105325,3,'20105325','20105325','LWX'),(20105345,4,'20105345','20105345','ZHZ');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-08 23:53:49
