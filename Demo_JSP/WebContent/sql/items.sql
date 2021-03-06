-- ----------------------------
-- Oracle 建表
-- ----------------------------
CREATE TABLE items (
  id Number(10) ,
  name Varchar2(50) ,
  city Varchar2(50) ,
  price Number(10,2) ,
  "number"  Number(10) ,
  picture Varchar2(500) ,
  PRIMARY KEY  (id)
)  ;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO items VALUES ('1', '沃特篮球鞋', '佛山', '180', '500', '001.jpg');
INSERT INTO items VALUES ('2', '安踏运动鞋', '福州', '120', '800', '002.jpg');
INSERT INTO items VALUES ('3', '耐克运动鞋', '广州', '500', '1000', '003.jpg');
INSERT INTO items VALUES ('4', '阿迪达斯T血衫', '上海', '388', '600', '004.jpg');
INSERT INTO items VALUES ('5', '李宁文化衫', '广州', '180', '900', '005.jpg');
INSERT INTO items VALUES ('6', '小米3', '北京', '1999', '3000', '006.jpg');
INSERT INTO items VALUES ('7', '小米2S', '北京', '1299', '1000', '007.jpg');
INSERT INTO items VALUES ('8', 'thinkpad笔记本', '北京', '6999', '500', '008.jpg');
INSERT INTO items VALUES ('9', 'dell笔记本', '北京', '3999', '500', '009.jpg');
INSERT INTO items VALUES ('10', 'ipad5', '北京', '5999', '500', '010.jpg');