
CREATE TABLE COMMODITY (
  ID NUMBER(11) NOT NULL ,
  NAME VARCHAR(100) DEFAULT NULL,
  PRICE NUMBER(11,2) DEFAULT NULL,
  UNIT VARCHAR(50) DEFAULT NULL,
  CATEGORY VARCHAR(100) DEFAULT NULL,
  DESCRIPTION VARCHAR(1000) DEFAULT NULL,
  SELLER NUMBER(11) DEFAULT NULL,
  PRIMARY KEY (ID)
) ;

INSERT INTO COMMODITY VALUES (1,'中式童装',120,'套','童装','中式童装',1);
INSERT INTO COMMODITY VALUES (2,'女士套装',200,'套','女装','女士职业套装',1);
INSERT INTO COMMODITY VALUES (3,'男士西服',200,'套','男装','男士西服套装',1);
INSERT INTO COMMODITY VALUES (4,'笔记本电脑',4000,'台','电脑','双核笔记本电脑',2);
INSERT INTO COMMODITY VALUES (5,'移动硬盘',400,'块','电脑周边','1T移动硬盘',2);
INSERT INTO COMMODITY VALUES (6,'液晶电视',5000,'台','电视','4K高清液晶电视',3);
INSERT INTO COMMODITY VALUES (7,'滚筒洗衣机',4000,'台','洗衣机','滚筒洗衣机',3);
INSERT INTO COMMODITY VALUES (8,'《HIBERNATE编程》',30,'本','实体书','介绍HIBERNATE编程',4);
INSERT INTO COMMODITY VALUES (9,'《JAVA核心》',50,'本','实体书','介绍JAVA编程核心',4);
INSERT INTO COMMODITY VALUES (10,'《海底两万里》',40,'本','电子书','经典科幻小说',4);
INSERT INTO COMMODITY VALUES (11,'优盘',30,'个','电脑周边','16G优盘',2);
 
 
CREATE TABLE CUSTOMER (
  ID NUMBER(11) NOT NULL,
  NAME VARCHAR(100) DEFAULT NULL,
  TEL VARCHAR(50) DEFAULT NULL,
  ADDRESS VARCHAR(1000) DEFAULT NULL,
  EMAIL VARCHAR(300) DEFAULT NULL,
  SEX VARCHAR(30) DEFAULT NULL,
  DESCRIPTION VARCHAR(4000) DEFAULT NULL,
  AGE NUMBER(11) DEFAULT NULL,
  BIRTHDAY DATE DEFAULT NULL,
  PRIMARY KEY (ID)
) ;
 
INSERT INTO CUSTOMER VALUES (1,'张三','13800000000','中国上海××区××路','13800000000@138.COM','男','热爱编程的程序员',25,'1990-01-01');
INSERT INTO CUSTOMER VALUES (2,'李四','13888888888','中国北京××区××路','13888888888@138.COM','女','酷爱网购的白领',20,'1995-02-21');
INSERT INTO CUSTOMER VALUES (3,'王五','15888888888','中国深圳××区××路','15888888888@158.COM','男','这个家伙很懒，什么也没有留下',35,'1980-04-14');
INSERT INTO CUSTOMER VALUES (4,'赵六','13900000000',NULL,NULL,'男',NULL,40,'1975-01-01');
 
 
CREATE TABLE ORDERFORM (
  ID NUMBER(11) NOT NULL ,
  CUSTOMER NUMBER(11) DEFAULT NULL,
  TRADEDATE DATE DEFAULT NULL,
  STATUS VARCHAR(10) DEFAULT NULL,
  AMOUNT NUMBER(11,2) DEFAULT NULL,
  PRIMARY KEY (ID)
) ;

INSERT INTO ORDERFORM VALUES (1,1,'2015-04-30','已收货',4400);
INSERT INTO ORDERFORM VALUES (2,2,'2015-05-11','已发货',520);
INSERT INTO ORDERFORM VALUES (3,3,'2015-05-13','已付款',9120);
 
 
CREATE TABLE ORDERITEM (
  ID NUMBER(11) NOT NULL ,
  ORDERID NUMBER(11) DEFAULT NULL,
  COMMODITY NUMBER(11) DEFAULT NULL,
  DISCOUNT NUMBER(11,2) DEFAULT NULL,
  ACTPRICE NUMBER(11,2) DEFAULT NULL,
  AMOUNT NUMBER(11,2) DEFAULT NULL,
  PRIMARY KEY (ID)
)  ;
 
INSERT INTO ORDERITEM VALUES (1,1,4,1,4000,1);
INSERT INTO ORDERITEM VALUES (2,1,5,1,400,1);
INSERT INTO ORDERITEM VALUES (3,2,1,1,120,1);
INSERT INTO ORDERITEM VALUES (4,2,2,1,200,1);
INSERT INTO ORDERITEM VALUES (5,2,3,1,200,1);
INSERT INTO ORDERITEM VALUES (6,3,6,1,5000,1);
INSERT INTO ORDERITEM VALUES (7,3,7,1,4000,1);
INSERT INTO ORDERITEM VALUES (8,3,8,1,30,1);
INSERT INTO ORDERITEM VALUES (9,3,9,1,50,1);
INSERT INTO ORDERITEM VALUES (10,3,10,1,40,1);
 

CREATE TABLE SELLER (
  ID NUMBER(11) NOT NULL ,
  NAME VARCHAR(100) DEFAULT NULL,
  TEL VARCHAR(1000) DEFAULT NULL,
  ADDRESS VARCHAR(2000) DEFAULT NULL,
  WEBSITE VARCHAR(500) DEFAULT NULL,
  STAR NUMBER(11) DEFAULT NULL,
  BUSINESS VARCHAR(2000) DEFAULT NULL,
  PRIMARY KEY (ID)
) ;

INSERT INTO seller VALUES (1,'A服装店','13000000000','中国北京××区','www.a.com',5,'经营各式服装');
INSERT INTO seller VALUES (2,'B数码店','15800000000','中国浙江杭州市××区','www.b.com',4,'经营各类数码电子产品');
INSERT INTO seller VALUES (3,'C电器店','13012341234','中国广东深圳市××区','www.c.com',4,'经营各类家电');
INSERT INTO seller VALUES (4,'D书店','18600000000','中国陕西西安市××区','www.d.com',5,'经营各类实体书与电子书');



SELECT * FROM  COMMODITY;
SELECT * FROM  CUSTOMER;
SELECT * FROM  ORDERFORM;
SELECT * FROM  ORDERITEM;
SELECT * FROM  SELLER;