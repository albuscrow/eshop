/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/9/3 18:38:32                            */
/*==============================================================*/


drop table if exists Buyer;

drop table if exists Carriage;

drop table if exists Category;

drop table if exists Commodity;

drop table if exists Delivery;

drop table if exists Import_List;

drop table if exists Order_List;

drop table if exists Other_Pay;

drop table if exists Pay_Way;

drop table if exists Role_List;

drop table if exists Sales_Record;

drop table if exists User;

/*==============================================================*/
/* Table: Buyer                                                 */
/*==============================================================*/
create table Buyer
(
   Buyer_ID             bigint auto_increment not null,
   Name                 varchar(32) not null,
   Sex                  varchar(1),
   User                 varchar(32) not null,
   Password             varchar(32) not null,
   Email                varchar(128),
   Register_Date        datetime not null,
   primary key (Buyer_ID)
);

/*==============================================================*/
/* Table: Carriage                                              */
/*==============================================================*/
create table Carriage
(
   Carriage_ID          bigint auto_increment not null,
   Start                varchar(16) not null,
   Destination          varchar(16) not null,
   Company              varchar(64) not null,
   Cost                 smallint not null,
   primary key (Carriage_ID)
);

/*==============================================================*/
/* Table: Category                                              */
/*==============================================================*/
create table Category
(
   Category_ID          bigint auto_increment not null,
   Cat_Category_ID      bigint,
   Name                 varchar(32) not null,
   primary key (Category_ID)
);

/*==============================================================*/
/* Table: Commodity                                             */
/*==============================================================*/
create table Commodity
(
   Commodity_ID         bigint auto_increment not null,
   Category_ID          bigint,
   Name                 varchar(32) not null,
   Sales                int,
   Price                real not null,
   Discount_Price       real,
   Is_Recommend         bool not null,
   Rest                 bigint,
   Picture              varchar(256),
   Average_Mark         real,
   Introduction         text,
   Origin               varchar(16),
   Market_Price         real,
   Register_Date        datetime not null,
   Is_SALE              bool,
   Brand                varchar(64) not null,
   primary key (Commodity_ID)
);

/*==============================================================*/
/* Table: Delivery                                              */
/*==============================================================*/
create table Delivery
(
   Delivery_ID          bigint auto_increment not null,
   Buyer_ID             bigint,
   Postcode             int not null,
   Address              varchar(256) not null,
   Phone                varchar(32) not null,
   primary key (Delivery_ID)
);

/*==============================================================*/
/* Table: Import_List                                           */
/*==============================================================*/
create table Import_List
(
   Import_ID            bigint auto_increment not null,
   Commodity_ID         bigint,
   Quantity             smallint not null,
   Price                real not null,
   Import_Date          datetime not null,
   primary key (Import_ID)
);

/*==============================================================*/
/* Table: Order_List                                            */
/*==============================================================*/
create table Order_List
(
   Order_ID             bigint auto_increment not null,
   Buyer_ID             bigint,
   Commodity_ID         bigint,
   Quantity             smallint,
   Pay_Type             smallint,
   State                smallint not null,
   Logistics_State      varchar(1024),
   Register_Date        datetime not null,
   Post_Type            int,
   Postcode             int,
   Address              varchar(256),
   Phone                varchar(32),
   Carriage_Fee         smallint,
   Comment              varchar(1024),
   Is_Matched           smallint,
   Logistics_Speed      smallint,
   Attitude             smallint,
   Comment_Date         datetime,
   Total                real,
   primary key (Order_ID)
);

/*==============================================================*/
/* Table: Other_Pay                                             */
/*==============================================================*/
create table Other_Pay
(
   OPay_ID              bigint auto_increment not null,
   User_ID              bigint,
   Note                 varchar(1024),
   OPay_Date            datetime not null,
   primary key (OPay_ID)
);

/*==============================================================*/
/* Table: Pay_Way                                               */
/*==============================================================*/
create table Pay_Way
(
   Pay_ID               bigint auto_increment not null,
   Name                 varchar(32) not null,
   Company              varchar(64) not null,
   URL                  varchar(1024) not null,
   primary key (Pay_ID)
);

/*==============================================================*/
/* Table: Role_List                                             */
/*==============================================================*/
create table Role_List
(
   Role_ID              bigint auto_increment not null,
   Role                 int not null,
   Authority            varchar(256) not null,
   primary key (Role_ID)
);

/*==============================================================*/
/* Table: Sales_Record                                          */
/*==============================================================*/
create table Sales_Record
(
   Record_ID            bigint auto_increment not null,
   Commodity_ID         bigint,
   Quantity             smallint not null,
   Amount               double not null,
   Record_Date          datetime not null,
   primary key (Record_ID)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   User_ID              bigint auto_increment not null,
   Role_ID              bigint,
   User                 varchar(32) not null,
   Password             varchar(32) not null,
   primary key (User_ID)
);

alter table Category add constraint FK_Relationship_9 foreign key (Cat_Category_ID)
      references Category (Category_ID) on delete restrict on update restrict;

alter table Commodity add constraint FK_Relationship_2 foreign key (Category_ID)
      references Category (Category_ID) on delete restrict on update restrict;

alter table Delivery add constraint FK_Relationship_11 foreign key (Buyer_ID)
      references Buyer (Buyer_ID) on delete restrict on update restrict;

alter table Import_List add constraint FK_Relationship_15 foreign key (Commodity_ID)
      references Commodity (Commodity_ID) on delete restrict on update restrict;

alter table Order_List add constraint FK_Relationship_5 foreign key (Commodity_ID)
      references Commodity (Commodity_ID) on delete restrict on update restrict;

alter table Order_List add constraint FK_Relationship_6 foreign key (Buyer_ID)
      references Buyer (Buyer_ID) on delete restrict on update restrict;

alter table Other_Pay add constraint FK_Relationship_12 foreign key (User_ID)
      references User (User_ID) on delete restrict on update restrict;

alter table Sales_Record add constraint FK_Relationship_14 foreign key (Commodity_ID)
      references Commodity (Commodity_ID) on delete restrict on update restrict;

alter table User add constraint FK_Relationship_13 foreign key (Role_ID)
      references Role_List (Role_ID) on delete restrict on update restrict;

/*==============================================================*/
/* DATA                                               */
/*==============================================================*/
-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `buyer` VALUES ('201309010001', 'lc', '��', '20105296', '20105296', '12349923@qq.com', '2012-09-02 17:12:33');
INSERT INTO `buyer` VALUES ('201309020001', 'lwx', 'Ů', '20105235', '20105235', '5187616587@qq.com', '2012-09-03 17:12:35');
INSERT INTO `buyer` VALUES ('201309030001', 'lzq', '��', '20105200', '20105200', '02489075@qq.com', '2012-09-04 17:12:40');
INSERT INTO `carriage` VALUES ('20130901001', '����', '����', '56', '7');
INSERT INTO `carriage` VALUES ('20130902001', '����', '����', '78', '8');
INSERT INTO `carriage` VALUES ('20130902005', '����', '����', '56', '75');
INSERT INTO `carriage` VALUES ('20130903001', '����', '����', '78', '45');
INSERT INTO `carriage` VALUES ('20130903002', '����', '����', '56', '79');
INSERT INTO `category` VALUES ('1', '1', 'ʳƷ��ˮ  ');
INSERT INTO `category` VALUES ('104', '1', '����ʳƷ');
INSERT INTO `category` VALUES ('10401', '104', '�ɿ���');
INSERT INTO `category` VALUES ('10402', '104', '���');
INSERT INTO `category` VALUES ('10403', '104', '������');
INSERT INTO `category` VALUES ('10404', '104', '�ɹ�');
INSERT INTO `category` VALUES ('10405', '104', 'ţ���');
INSERT INTO `category` VALUES ('10406', '104', '�۽�');
INSERT INTO `commodity` VALUES ('10401001', '10401', 'M&M\'s����ţ���ɿ�����135g', '12', '36.4', '36.4', '1', '95', null, '85', '�ó��ֱ���', 'Խ��', '45', '2012-09-02 17:22:26', '1', 'MM');
INSERT INTO `commodity` VALUES ('10401002', '10401', 'Rocher������T30黹������ɿ���375g', '12', '89', '88', '1', '82', null, '89', '��Ũ�ɿ�', 'Ӣ��', '119', '2012-09-03 17:23:06', '1', 'mc');
INSERT INTO `commodity` VALUES ('10401003', '10401', '��ܽ����֮ѡ�ɿ�����н�ɫװ', '12', '118', '115', '1', '52', null, '86', '�óԵ�cry', '����', '46', '2012-09-02 17:24:13', '1', 'po');
INSERT INTO `commodity` VALUES ('10402001', '10402', 'һƷ�����������', '12', '69.9', '68', '1', '42', null, '90', '�ƹ����Ƽ�', '����', '51', '2012-09-03 17:32:25', '1', 'nc');
INSERT INTO `commodity` VALUES ('10402002', '10402', '����ɫ�����������', '12', '29.9', '28', '1', '46', null, '89', '���ó԰�ȫ��', '����', '46', '2012-09-04 17:32:28', '1', 'wa');
INSERT INTO `commodity` VALUES ('10402003', '10402', '����ɽ������������', '12', '115', '113', '1', '53', null, '93', '��֬����������ʳƷ', '�Ͼ�', '65', '2012-09-02 17:32:32', '1', 'grs');
INSERT INTO `commodity` VALUES ('10403001', '10403', 'ȸ���ɿ�����������', '12', '19.9', '15', '1', '16', null, '88', '�����������ʳƷ', '�Ϻ�', '46', '2012-09-06 17:32:35', '1', 'hrsj');
INSERT INTO `commodity` VALUES ('10403002', '10403', '��������¼��ı���', '12', '11.9', '10', '1', '76', null, '92', '������Ѷ���ó�', '�Ϻ�', '53', '2012-09-03 17:32:38', '1', 'jtsa');
INSERT INTO `commodity` VALUES ('10403003', '10403', '�����ɱ����ð�', '12', '22', '21', '1', '12', null, '91', 'ȫ������ػݼ�', '̨��', '35', '2012-08-28 17:32:42', '1', 'tscv');
INSERT INTO `commodity` VALUES ('10404001', '10404', '��Դ ��ʳ�����', '12', '15.9', '13', '1', '72', null, '95', '��֬������', 'Խ��', '42', '2012-09-25 17:32:45', '1', 'cctv');
INSERT INTO `commodity` VALUES ('10404002', '10404', '���� ����������', '12', '14.7', '14', '1', '43', null, '96', 'Ѹ�ٲ�������', '����', '45', '2012-09-18 17:32:50', '1', 'aga');
INSERT INTO `commodity` VALUES ('10404003', '10404', '�Ʒɺ���������', '12', '44', '40', '1', '16', null, '94', '�������������Ʒ', '����', '52', '2012-09-18 17:32:53', '1', 'hrs');
INSERT INTO `commodity` VALUES ('10405001', '10405', '��������˺ţ��', '12', '16.8', '16', '1', '12', null, '93', '��ͷ��99%', '�Ϻ�', '60', '2012-09-24 17:32:56', '1', 'tdbh');
INSERT INTO `commodity` VALUES ('10405002', '10405', '�������ţ���', '12', '29.4', '29', '1', '43', null, '89', '��ʳ��־�����Ƽ�С��ʳ', '����', '47', '2012-09-24 17:32:59', '1', 'ntd');
INSERT INTO `commodity` VALUES ('10405003', '10405', '�����޵�Ӱţ��', '12', '19', '18', '1', '19', null, '88', '������98%', '�Ĵ�', '49', '2012-09-11 17:33:02', '1', 'xhr');
INSERT INTO `commodity` VALUES ('10406001', '10406', '��԰��ũ������÷', '12', '39', '35', '1', '26', null, '91', '��ʱ�ͼ�', '����', '58', '2012-09-25 17:33:06', '1', 'sdh');
INSERT INTO `commodity` VALUES ('10406002', '10406', 'ɳĮ�����½����Ѹ�', '12', '43.8', '43', '1', '86', null, '93', '�ƹ������������Ƽ�', '����', '52', '2012-09-27 17:33:10', '1', 'rsse');
INSERT INTO `commodity` VALUES ('10406003', '10406', '������������˫Ч�ݴ��', '12', '3', '3', '1', '49', null, '95', '��ʱ�ͼ�', '�㽭', '53', '2012-09-30 17:33:13', '1', 'shr');
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
INSERT INTO `delivery` VALUES ('20130901000101', '201309010001', '400000', '������ɳƺ����', '13996524324');
INSERT INTO `delivery` VALUES ('20130901000102', '201309020001', '400000', '�����н�����', '13996524325');
INSERT INTO `delivery` VALUES ('20130903000103', '201309030001', '400000', '������������', '13996524326');
INSERT INTO `import_list` VALUES ('123456', '10402003', '26', '75', '2012-09-16 16:21:54');
INSERT INTO `import_list` VALUES ('156541', '10401002', '28', '178', '2012-09-03 16:19:56');
INSERT INTO `import_list` VALUES ('156813', '10401003', '45', '123', '2012-09-10 16:20:31');
INSERT INTO `import_list` VALUES ('168354', '10402001', '15', '41', '2012-09-11 16:21:00');
INSERT INTO `import_list` VALUES ('489851', '10402002', '12', '78', '2012-09-04 16:21:26');
INSERT INTO `import_list` VALUES ('543548', '10401001', '32', '156', '2012-09-02 16:18:49');
INSERT INTO `order_list` VALUES ('20100902000102', '201309010001', '10402001', '2', '1', '1', '����������', '2012-09-02 17:02:53', '2', '1', '������������', '13996524326', '15', '�Լ۱ȸߣ��´��Ƽ���������', '98', '93', '95', '2012-09-05 17:03:28', '99');
INSERT INTO `order_list` VALUES ('20130901000101', '201309020001', '10401001', '23', '2', '2', '��������', '2012-09-02 16:51:38', '1', '2', '������ɳƺ����', '13996524324', '12', '�ǳ��ã��´λ��Ṻ��', '100', '85', '91', '2012-09-11 16:57:59', '95');
INSERT INTO `order_list` VALUES ('20130903000103', '201309030001', '10401003', '5', '2', '2', '��ǩ��', '2012-09-02 17:01:15', '1', '1', '�����н�����', '13996524325', '10', '���Ѷ���ÿ�', '95', '90', '93', '2012-09-03 17:00:32', '98');
INSERT INTO `other_pay` VALUES ('25485', '20105345', '��۲���', '2012-09-05 17:05:54');
INSERT INTO `other_pay` VALUES ('153246', '20105296', '�ʷ�', '2012-09-03 17:05:09');
INSERT INTO `other_pay` VALUES ('168354', '20105228', '��װ��', '2012-09-02 17:05:02');
INSERT INTO `pay_way` VALUES ('23159', 'zhuhaiz', 'chongdaA', 'www.cqu.edu,net');
INSERT INTO `pay_way` VALUES ('215972', 'luzeqi', 'chongqingdaxue', 'www.cqu.edu.cn');
INSERT INTO `pay_way` VALUES ('459452', 'liangweix', 'chongda', 'www.cqu.net');
INSERT INTO `sales_record` VALUES ('156324', '10401003', '20', '2036', '2012-09-03 17:11:25');
INSERT INTO `sales_record` VALUES ('156421', '10401002', '12', '1562', '2012-09-02 17:11:11');
INSERT INTO `sales_record` VALUES ('452136', '10402003', '18', '1865', '2012-09-04 17:11:54');


