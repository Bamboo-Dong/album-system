/*
Navicat MySQL Data Transfer

Source Server         : kuwo
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : kuwoalbum

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-06-26 14:59:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfo`;
CREATE TABLE `tb_userinfo` (
  `account` char(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` char(20) NOT NULL,
  `qq` char(20) DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

-- ----------------------------
-- Records of tb_userinfo
-- ----------------------------
INSERT INTO `tb_userinfo` VALUES ('1', '11111111111111111111', '', null);
INSERT INTO `tb_userinfo` VALUES ('2', '2', '', null);
