/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : manchey

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-05-28 19:41:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('2');

-- ----------------------------
-- Table structure for `mc_users`
-- ----------------------------
DROP TABLE IF EXISTS `mc_users`;
CREATE TABLE `mc_users` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mc_users
-- ----------------------------
INSERT INTO `mc_users` VALUES ('1', '33', 'zhanan');

-- ----------------------------
-- Table structure for `region`
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `regionCode` int(10) NOT NULL COMMENT '大区代码',
  `regionName` varchar(20) NOT NULL COMMENT '大区名称',
  `regionType` varchar(20) DEFAULT NULL COMMENT '类型：月卡、点卡',
  PRIMARY KEY (`regionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES ('1000001', '电信一区', '月卡');
INSERT INTO `region` VALUES ('1001001', '网通一/二区', '月卡');
INSERT INTO `region` VALUES ('1001003', '网通三区', '点卡');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleName` varchar(20) NOT NULL COMMENT '角色名',
  `serverCode` int(10) NOT NULL COMMENT '服务器代码',
  `level` int(3) DEFAULT NULL COMMENT '等级',
  `roleType` varchar(10) DEFAULT NULL COMMENT '角色类型：由门派和体型限制',
  PRIMARY KEY (`id`),
  KEY `F_SERVERCODE` (`serverCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '萧墨衣', '1001', '90', 'cyam');
INSERT INTO `role` VALUES ('2', '萧牡蛎', '1001', null, null);
INSERT INTO `role` VALUES ('3', '铁锅炖大鹅', '1001', null, null);

-- ----------------------------
-- Table structure for `rolerelation`
-- ----------------------------
DROP TABLE IF EXISTS `rolerelation`;
CREATE TABLE `rolerelation` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleId` int(10) DEFAULT NULL COMMENT '角色主键',
  `targetRoleId` int(10) DEFAULT NULL COMMENT '目标角色主键',
  `targetNickName` varchar(20) DEFAULT NULL COMMENT '目标昵称（用户自定义）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolerelation
-- ----------------------------

-- ----------------------------
-- Table structure for `roletype`
-- ----------------------------
DROP TABLE IF EXISTS `roletype`;
CREATE TABLE `roletype` (
  `roleType` varchar(10) NOT NULL COMMENT '前两字符代表门派，第三个字符：a-成年,c-幼年；第四个字符：m-male,f-famale',
  `unit` varchar(20) NOT NULL COMMENT '门派',
  `bodyType` varchar(10) NOT NULL COMMENT '体型',
  `roleNick` varchar(20) DEFAULT NULL COMMENT '玩家昵称',
  PRIMARY KEY (`roleType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roletype
-- ----------------------------
INSERT INTO `roletype` VALUES ('cyaf', '纯阳', '成女', '道姑');
INSERT INTO `roletype` VALUES ('cyam', '纯阳', '成男', '道长');
INSERT INTO `roletype` VALUES ('cycf', '纯阳', '萝莉', '咩萝');
INSERT INTO `roletype` VALUES ('cycm', '纯阳', '正太', '咩太');

-- ----------------------------
-- Table structure for `secretdetail`
-- ----------------------------
DROP TABLE IF EXISTS `secretdetail`;
CREATE TABLE `secretdetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleId` int(10) NOT NULL COMMENT '角色主键',
  `targetRoleId` int(10) NOT NULL COMMENT '目标角色主键',
  `content` varchar(500) NOT NULL COMMENT '内容',
  `targetExist` tinyint(1) DEFAULT NULL COMMENT '目标是否存在 TRUE FALSE',
  `postTime` date DEFAULT NULL COMMENT '发送时间',
  `isResponse` tinyint(1) DEFAULT NULL COMMENT '是否回复用户提示信息',
  `isPost` tinyint(1) DEFAULT NULL COMMENT '是否推送给目标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of secretdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `server`
-- ----------------------------
DROP TABLE IF EXISTS `server`;
CREATE TABLE `server` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `serverCode` int(10) NOT NULL COMMENT '服务器代码',
  `serverName` varchar(20) NOT NULL COMMENT '服务器名称',
  `regionCode` int(10) NOT NULL COMMENT '大区代码',
  PRIMARY KEY (`id`),
  KEY `FK_REGIONS` (`regionCode`),
  CONSTRAINT `FK_REGIONS` FOREIGN KEY (`regionCode`) REFERENCES `region` (`regionCode`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of server
-- ----------------------------
INSERT INTO `server` VALUES ('1', '1001', '天鹅坪', '1001003');
INSERT INTO `server` VALUES ('2', '1002', '破阵子', '1001003');
