/*
Navicat MySQL Data Transfer

Source Server         : spring
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : world_cup

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-06-21 09:00:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bet`
-- ----------------------------
DROP TABLE IF EXISTS `bet`;
CREATE TABLE `bet` (
  `bet_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '下注ID',
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '竞猜人名字',
  `user_ip` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '竞猜人IP地址',
  `match_id` int(11) NOT NULL COMMENT '下注的比赛ID',
  `wager` int(11) DEFAULT NULL COMMENT '赌注',
  `bet_type` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '下注类型',
  `bet_time` datetime DEFAULT NULL COMMENT '下注时间',
  `bet_home` int(4) DEFAULT '0' COMMENT '选中第一个国家',
  `bet_away` int(4) DEFAULT '0' COMMENT '选中第二个国家队',
  `bet_draw` int(4) DEFAULT '0' COMMENT '选择平局',
  `hit` int(4) unsigned DEFAULT '0' COMMENT '是否猜中',
  `benefit` double DEFAULT '0' COMMENT '获得收益',
  `start` int(11) DEFAULT NULL,
  `end` int(11) DEFAULT NULL,
  PRIMARY KEY (`bet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bet
-- ----------------------------
INSERT INTO `bet` VALUES ('1', 'louis', '10.169.81.115', '1', '10', null, '2018-06-14 10:00:00', '0', '0', '1', '0', '0', null, null);
INSERT INTO `bet` VALUES ('13', null, '10.169.81.115', '6', '20', '客胜', '2018-06-19 17:01:41', '0', '0', '0', '0', '59', null, null);
INSERT INTO `bet` VALUES ('14', null, '10.169.81.115', '14', '200', '平局', '2018-06-20 09:06:05', '0', '0', '0', '0', '0', null, null);
INSERT INTO `bet` VALUES ('15', null, '10.169.81.115', '14', '300', '平局', '2018-06-20 09:23:59', '0', '0', '0', '0', '0', null, null);

-- ----------------------------
-- Table structure for `match`
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `match_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '比赛ID',
  `match_date` datetime DEFAULT NULL COMMENT '比赛时间',
  `home` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '主场',
  `away` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '客场',
  `home_odds` double DEFAULT NULL COMMENT '第一方胜利赔率',
  `draw_odds` double DEFAULT NULL COMMENT '平局赔率',
  `away_odds` double DEFAULT NULL COMMENT '第二方胜利赔率',
  `guess_deadline` datetime DEFAULT NULL COMMENT '竞猜截止时间',
  `score` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '比分（主场在前）',
  `start` int(11) DEFAULT NULL,
  `end` int(11) DEFAULT NULL,
  `result_type` varchar(11) COLLATE utf8_bin DEFAULT '-' COMMENT '1-主胜 2-平局 3-客胜',
  `rate` double DEFAULT '0' COMMENT '最终赔率',
  PRIMARY KEY (`match_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of match
-- ----------------------------
INSERT INTO `match` VALUES ('1', '2018-06-20 20:00:00', '葡萄牙', '摩洛哥', '1.6', '2.4', '3.6', '2018-06-20 19:00:00', null, null, null, null, '0');
INSERT INTO `match` VALUES ('2', '2018-06-19 18:00:00', '哥伦比亚', '日本', '1.54', '3.45', '5.25', '2018-06-19 17:30:00', '1:2', null, null, '客胜', '5.25');
INSERT INTO `match` VALUES ('6', '2018-06-19 21:00:00', '波兰', '塞内加尔', '2.19', '2.95', '3', '2018-06-19 20:30:00', '0:1', null, null, '客胜', '2.95');
INSERT INTO `match` VALUES ('7', '2018-06-17 23:00:00', '俄罗斯', '沙特阿拉伯', '2.1', '3', '8', '2018-06-17 22:00:00', '5:0', null, null, '主胜', '2.1');
INSERT INTO `match` VALUES ('8', '2018-06-18 21:00:00', '阿根廷', '冰岛', '1.6', '2.5', '5.4', '2018-06-18 20:00:00', '0:1', null, null, '客胜', '2.5');
INSERT INTO `match` VALUES ('9', '2018-06-15 20:00:00', '埃及', '乌拉圭', '8.2', '3.6', '1.9', '2018-06-15 19:00:00', '0:1', null, null, '客胜', '0');
INSERT INTO `match` VALUES ('10', '2018-06-19 09:00:00', '哥斯达黎加', '塞尔维亚', '4.5', '4', '3.5', '2018-06-19 08:00:00', '0:1', null, null, '客胜', '4');
INSERT INTO `match` VALUES ('11', '2018-06-18 21:00:00', '巴西', '瑞士', '1.2', '3.4', '7.5', '2018-06-18 21:00:00', '1:1', null, null, '平局', '0');
INSERT INTO `match` VALUES ('12', '2018-06-18 03:00:00', '西班牙', '葡萄牙', '2.1', '4.2', '5.4', '2018-06-18 02:00:00', '3:3', null, null, '平局', '0');
INSERT INTO `match` VALUES ('13', '2018-06-18 23:00:00', '德国', '墨西哥', '1.2', '2.4', '4.8', '2018-06-18 22:00:00', '0:1', null, null, '客胜', '0');
INSERT INTO `match` VALUES ('14', '2018-06-20 21:00:00', '韩国', '德国', '4.5', '3', '2.5', '2018-06-20 20:00:00', null, null, null, '-', '0');
INSERT INTO `match` VALUES ('15', '2018-06-17 03:00:00', '法国', '澳大利亚', '1.2', '4.5', '7.2', '2018-06-17 02:00:00', '2:1', null, null, '主胜', '0');
INSERT INTO `match` VALUES ('16', '2018-06-19 02:00:00', '突尼斯', '英格兰', '5.3', '3.9', '2.1', '2018-06-19 01:00:00', '1:2', null, null, '客胜', '0');

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '比赛结果ID',
  `match_id` int(11) DEFAULT NULL COMMENT '比赛ID',
  `first_score` int(11) DEFAULT '0' COMMENT '第一个国家队得分',
  `second_score` int(11) DEFAULT '0' COMMENT '第二个国家队得分',
  `first_win` tinyint(4) DEFAULT '0' COMMENT '第一个国家队获胜',
  `second_win` tinyint(4) DEFAULT '0' COMMENT '第二个国家队获胜',
  `draw` tinyint(4) DEFAULT '0' COMMENT '平局',
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '1', '5', '0', '1', '0', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `passWord` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'louisonly', '123456', '20', 'louisonly@163.com');
INSERT INTO `user` VALUES ('2', 'henty', '123456', '18', 'henry@163.com');
