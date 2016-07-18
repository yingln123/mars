/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : mars

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2016-07-14 16:44:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
#用户表
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `login_name` varchar(20) NOT NULL COMMENT '登录用户名',
  `name` varchar(20) NOT NULL COMMENT '显示名称',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_status` int(11) DEFAULT '0' COMMENT '用户状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#系统访问记录 
CREATE TABLE `t_request_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL COMMENT '访问IP',
  `url` varchar(255) DEFAULT NULL COMMENT '请求路径',
  `action_name` varchar(40) DEFAULT NULL COMMENT '操作名称',
  `parameters` varchar(255) DEFAULT NULL COMMENT '参数列表',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


