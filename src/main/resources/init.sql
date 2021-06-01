-- ----------------------------
-- Table structure for tb_one
-- ----------------------------
DROP TABLE IF EXISTS `tb_one`;
CREATE TABLE `tb_one` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_one
-- ----------------------------
INSERT INTO `tb_one` VALUES ('1', '数据源一');



-- ----------------------------
-- Table structure for tb_two
-- ----------------------------
DROP TABLE IF EXISTS `tb_two`;
CREATE TABLE `tb_two` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_two
-- ----------------------------
INSERT INTO `tb_two` VALUES ('1', '数据源二');


-- ----------------------------
-- Table structure for tb_three
-- ----------------------------
DROP TABLE IF EXISTS `tb_three`;
CREATE TABLE `tb_three` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_three
-- ----------------------------
INSERT INTO `tb_three` VALUES ('1', '数据源三');