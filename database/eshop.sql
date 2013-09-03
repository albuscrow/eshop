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
   Buyer_ID             bigint not null,
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
   Carriage_ID          bigint not null,
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
   Category_ID          bigint not null,
   Cat_Category_ID      bigint,
   Name                 varchar(32) not null,
   primary key (Category_ID)
);

/*==============================================================*/
/* Table: Commodity                                             */
/*==============================================================*/
create table Commodity
(
   Commodity_ID         bigint not null,
   Category_ID          bigint,
   Name                 varchar(32) not null,
   Sales                int,
   Price                real not null,
   Discount_Price       real,
   Is_Recommend         bool not null,
   Rest                 bigint,
   Picture              varchar(256) not null,
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
   Delivery_ID          bigint not null,
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
   Import_ID            bigint not null,
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
   Order_ID             bigint not null,
   Buyer_ID             bigint,
   Commodity_ID         bigint,
   Quantity             smallint not null,
   Pay_Type             smallint not null,
   State                smallint not null,
   Logistics_State      varchar(1024),
   Register_Date        datetime not null,
   Post_Type            int not null,
   Postcode             int not null,
   Address              varchar(256) not null,
   Phone                varchar(32) not null,
   Carriage_Fee         smallint not null,
   Comment              varchar(1024),
   Is_Matched           smallint not null,
   Logistics_Speed      smallint not null,
   Attitude             smallint not null,
   Comment_Date         datetime not null,
   Total                real not null,
   primary key (Order_ID)
);

/*==============================================================*/
/* Table: Other_Pay                                             */
/*==============================================================*/
create table Other_Pay
(
   OPay_ID              bigint not null,
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
   Pay_ID               bigint not null,
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
   Role_ID              bigint not null,
   Role                 int not null,
   Authority            varchar(256) not null,
   primary key (Role_ID)
);

/*==============================================================*/
/* Table: Sales_Record                                          */
/*==============================================================*/
create table Sales_Record
(
   Record_ID            bigint not null,
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
   User_ID              bigint not null,
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

