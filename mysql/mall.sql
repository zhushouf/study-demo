/*
Navicat MySQL Data Transfer

Source Server         : zhusf
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2018-04-24 16:12:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `detail`
-- ----------------------------
DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单明细ID',
  `oid` int(11) NOT NULL COMMENT '订单表ID',
  `pid` int(11) NOT NULL COMMENT '产品ID',
  `price` double NOT NULL COMMENT '价格',
  `number` int(11) NOT NULL COMMENT '数量',
  `totalcount` double NOT NULL COMMENT '总价格',
  `details` varchar(100) DEFAULT NULL COMMENT '订单描述',
  PRIMARY KEY (`id`),
  KEY `oid` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detail
-- ----------------------------
INSERT INTO `detail` VALUES ('1', '1', '1', '2500', '1', '2500', '华为荣耀P10');
INSERT INTO `detail` VALUES ('2', '2', '2', '8500', '1', '8500', '联想ST系列电脑');
INSERT INTO `detail` VALUES ('3', '3', '3', '18500', '1', '18500', 'iPad12');

update detail set details = '华为荣耀P10 大品牌,值得信赖!' where id = 1;
update detail set details = '联想ST系列电脑 京东购买立享95折优惠!' where id = 2;
update detail set details = 'iPad12 使用骁龙995处理器,给你带来极致的体验!' where id = 3;
-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `status` varchar(20) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`oid`),
  CONSTRAINT `fk_order_oid` FOREIGN KEY (`oid`) REFERENCES `detail` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '2018-04-24 15:40:33', '已付款');
INSERT INTO `order` VALUES ('2', '2', '2018-04-24 15:40:33', '已付款');
INSERT INTO `order` VALUES ('3', '3', '2018-04-24 15:40:33', '未付款');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `pname` varchar(50) NOT NULL COMMENT '产品名称',
  `pdetail` varchar(100) DEFAULT NULL COMMENT '产品描述',
  `price` double NOT NULL COMMENT '产品价格',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '手机', '华为', '2500');
INSERT INTO `product` VALUES ('2', '电脑', '联想', '8500');
INSERT INTO `product` VALUES ('3', 'iPad', '苹果', '18500');
INSERT INTO `product` VALUES ('4', 'MP4', '小米', '1500');
INSERT INTO `product` VALUES ('5', '安踏球鞋', '安踏', '799');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `phone` varchar(12) DEFAULT NULL COMMENT '联系方式',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '1681753919', '男', '2671264516@sina.com', '广州市天河大道20号');
INSERT INTO `user` VALUES ('2', '李四', '1951753919', '男', '7671264516@sina.com', '广州市天河区中山大道121号');
INSERT INTO `user` VALUES ('3', '李小花', '1951753919', '女', '69264516@163.com', '广州市黄埔区府前路98号');
INSERT INTO `user` VALUES ('4', '王五', '1581753919', '男', '89264516@qq.com', '广州市萝岗府前路22号');
INSERT INTO `user` VALUES ('5', '吴琳', '1911753919', '女', '69264516@162.com', '广州市海珠区天源路92号');
