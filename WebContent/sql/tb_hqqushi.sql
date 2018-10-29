/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : donghetea

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2018-07-24 16:21:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_hqqushi`
-- ----------------------------
DROP TABLE IF EXISTS `tb_hqqushi`;
CREATE TABLE `tb_hqqushi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cankaojia` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `qihuojia` int(11) NOT NULL,
  `quoid` int(11) NOT NULL,
  `rizhangdiee` int(11) NOT NULL,
  `rizhangdiefu` int(11) NOT NULL,
  `zhangdiee` int(11) NOT NULL,
  `zhangdiefu` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_hqqushi
-- ----------------------------
INSERT INTO `tb_hqqushi` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1');
