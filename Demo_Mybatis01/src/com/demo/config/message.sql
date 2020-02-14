CREATE TABLE MESSAGE (
  ID number(11)  NOT NULL,
  COMMAND varchar(16) DEFAULT NULL ,
  DESCRIPTION varchar(32) DEFAULT NULL ,
  CONTENT varchar(2048) DEFAULT NULL,
  PRIMARY KEY (ID)
) ;

CREATE TABLE COMMAND (
  ID number(11) NOT NULL,
  NAME varchar(255) DEFAULT NULL,
  DESCRIPTION varchar(255) DEFAULT NULL
);

CREATE TABLE COMMANDCONTENT (
  ID number(11) NOT NULL,
  CONTENT varchar(255) DEFAULT NULL,
  COMMAND_ID varchar(255) DEFAULT NULL
) ;

INSERT INTO  COMMAND (ID, NAME, DESCRIPTION) VALUES ('1', '段子', '搞笑段子');
INSERT INTO  COMMAND (ID, NAME, DESCRIPTION) VALUES ('2', '新闻', '每日新闻');
INSERT INTO  COMMAND (ID, NAME, DESCRIPTION) VALUES ('3', '广告', '商业广告');

INSERT INTO COMMANDCONTENT (ID, CONTENT, COMMAND_ID) VALUES ('1', '段子11111111111', '1');
INSERT INTO COMMANDCONTENT (ID, CONTENT, COMMAND_ID) VALUES ('2', '段子2222', '1');
INSERT INTO COMMANDCONTENT (ID, CONTENT, COMMAND_ID) VALUES ('3', '段子33333', '1');
INSERT INTO COMMANDCONTENT (ID, CONTENT, COMMAND_ID) VALUES ('4', '每日新闻22222', '2');
INSERT INTO COMMANDCONTENT (ID, CONTENT, COMMAND_ID) VALUES ('5', '每日新闻33333', '2');
INSERT INTO COMMANDCONTENT (ID, CONTENT, COMMAND_ID) VALUES ('6', '内容66666', '3');
INSERT INTO COMMANDCONTENT (ID, CONTENT, COMMAND_ID) VALUES ('7', '内容7777', '3');

INSERT INTO MESSAGE VALUES (1, '查看', '精彩内容', '精彩内容');
INSERT INTO MESSAGE VALUES (2, '段子', '精彩段子', '如果你的月薪是3000块钱，请记得分成五份，一份用来买书，一份给家人，一份给女朋友买化妆品和衣服，一份请朋友们吃饭，一份作为同事的各种婚丧嫁娶的份子钱。剩下的2999块钱藏起来，不要告诉任何人');
INSERT INTO MESSAGE VALUES (3, '新闻', '今日头条', '7月17日，马来西亚一架载有298人的777客机在乌克兰靠近俄罗斯边界坠毁。另据国际文传电讯社消息，坠毁机型为一架波音777客机，机载约280名乘客和15个机组人员。\r\n乌克兰空管部门随后证实马航MH17航班坠毁。乌克兰内政部幕僚表示，这一航班在顿涅茨克地区上空被击落。马来西亚航空公司确认，该公司从阿姆斯特丹飞往吉隆坡的MH17航班失联，并称最后与该客机取得联系的地点在乌克兰上空。图为马航客机坠毁现场。');
INSERT INTO MESSAGE VALUES (4, '娱乐', '娱乐新闻', '昨日，邓超在微博分享了自己和孙俪的书法。夫妻同样写幸福，但差距很大。邓超自己都忍不住感慨字丑：左边媳妇写的。右边是我写的。看完我再也不幸福了。');
INSERT INTO MESSAGE VALUES (5, '电影', '近日上映大片', '《忍者神龟》[2]真人电影由美国派拉蒙影业发行，《洛杉矶之战》导演乔纳森·里贝斯曼执导。 \r\n片中四只神龟和老鼠老师都基于漫画和卡通重新绘制，由动作捕捉技术实现。\r\n其中皮特·普劳泽克饰演达芬奇(武器：武士刀)，诺尔·费舍饰演米开朗基罗(武器：双节棍)，阿伦·瑞奇森饰演拉斐尔(武器：铁叉)，杰瑞米·霍华德饰演多拉泰罗(武器：武士棍)。\r\n该片计划于2014年8月8日在北美上映。');
INSERT INTO MESSAGE VALUES (6, '彩票', '中奖号码', '查啥呀查，你不会中奖的！');