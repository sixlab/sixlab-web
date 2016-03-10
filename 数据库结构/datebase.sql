/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : sixlab

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-03-10 17:59:11
*/

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE IF NOT EXISTS sixlab DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

-- ----------------------------
-- Table structure for sixlab_meta
-- ----------------------------
DROP TABLE IF EXISTS `sixlab_meta`;
CREATE TABLE `sixlab_meta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key_id` int(11) DEFAULT NULL,
  `key` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tools_record_item
-- ----------------------------
DROP TABLE IF EXISTS `tools_record_item`;
CREATE TABLE `tools_record_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tools_record_val
-- ----------------------------
DROP TABLE IF EXISTS `tools_record_val`;
CREATE TABLE `tools_record_val` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `record_date` datetime DEFAULT NULL,
  `record_val` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
