/*
Navicat MySQL Data Transfer

Source Server         : spring
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : guess

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-06-15 16:35:26
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
  `bet_time` datetime DEFAULT NULL COMMENT '下注时间',
  `bet_first` tinyint(4) DEFAULT '0' COMMENT '选中第一个国家',
  `bet_second` tinyint(4) DEFAULT '0' COMMENT '选中第二个国家队',
  `bet_draw` tinyint(4) DEFAULT '0' COMMENT '选择平局',
  `goal` tinyint(4) DEFAULT '0' COMMENT '是否猜中',
  `benefit` double DEFAULT '0' COMMENT '获得收益',
  PRIMARY KEY (`bet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bet
-- ----------------------------
INSERT INTO `bet` VALUES ('1', 'louis', '10.169.81.115', '1', '10', '2018-06-14 10:00:00', '0', '0', '1', '0', '0');
INSERT INTO `bet` VALUES ('2', 'louis', null, '1', '20', null, '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `match`
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match` (
  `match_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '比赛ID',
  `match_date` datetime DEFAULT NULL COMMENT '比赛时间',
  `first_country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `second_country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `first_odds` double DEFAULT NULL COMMENT '第一方胜利赔率',
  `draw_odds` double DEFAULT NULL COMMENT '平局赔率',
  `second_odds` double DEFAULT NULL COMMENT '第二方胜利赔率',
  `guess_deadline` datetime DEFAULT NULL COMMENT '竞猜截止时间',
  PRIMARY KEY (`match_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of match
-- ----------------------------
INSERT INTO `match` VALUES ('1', '2018-06-14 23:00:00', '俄罗斯', '沙特阿拉伯', '1.32', '4.02', '8.11', '2018-06-14 22:54:00');

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
