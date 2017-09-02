CREATE TABLE `user` (
  `id` bigint(22) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT '' COMMENT '姓名',
  `sex` tinyint(2) DEFAULT NULL COMMENT '性别',
  `age` tinyint(4) DEFAULT '0' COMMENT '年龄',
  `address` varchar(100) DEFAULT '' COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
