/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2017-09-02 19:21:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT '' COMMENT '姓名',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT '0' COMMENT '年龄',
  `address` varchar(100) DEFAULT '' COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00000000000000000001', '张三', '1', '22', '少时诵诗书所');
INSERT INTO `user` VALUES ('00000000000000000002', '李四', '0', '11', '阿斯顿发生大发');
INSERT INTO `user` VALUES ('00000000000000000003', '李白', '1', '33', '啊啥敢不敢不敢不敢');
INSERT INTO `user` VALUES ('00000000000000000004', 'ss', '1', '22', '111111');
INSERT INTO `user` VALUES ('00000000000000000005', 'A', '1', '44', '2323e');
INSERT INTO `user` VALUES ('00000000000000000006', 'b', '1', '2', '12212121');
