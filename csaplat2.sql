-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: csaplat2
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `boke_boke`
--

DROP TABLE IF EXISTS `boke_boke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boke_boke` (
  `boke_id` varchar(32) NOT NULL,
  `boke_subtitle` varchar(500) DEFAULT NULL,
  `boke_type` varchar(40) DEFAULT NULL,
  `boke_title` char(40) DEFAULT NULL,
  `boke_code` varchar(40) DEFAULT NULL,
  `creater` varchar(40) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  `version` varchar(40) DEFAULT NULL,
  `info` text,
  `collect_num` int(11) DEFAULT NULL,
  `state` varchar(40) DEFAULT NULL,
  `picture_code` varchar(40) DEFAULT NULL COMMENT '关联图片code',
  `path` varchar(500) DEFAULT NULL COMMENT '封面路径',
  `admin_code` varchar(40) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  `submittime` bigint(20) DEFAULT NULL,
  `ispublic` varchar(40) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `special` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`boke_id`),
  UNIQUE KEY `code` (`boke_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `boke_collect`
--

DROP TABLE IF EXISTS `boke_collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boke_collect` (
  `collect_id` varchar(32) NOT NULL,
  `user_code` varchar(40) DEFAULT NULL,
  `boke_code` varchar(40) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `boke_comment`
--

DROP TABLE IF EXISTS `boke_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boke_comment` (
  `comment_id` varchar(32) NOT NULL,
  `creater` varchar(40) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `info` varchar(500) DEFAULT NULL,
  `target_type` varchar(40) DEFAULT NULL,
  `target` varchar(32) DEFAULT NULL,
  `who` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `boke_special`
--

DROP TABLE IF EXISTS `boke_special`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boke_special` (
  `special_id` varchar(32) NOT NULL,
  `special_code` varchar(40) NOT NULL,
  `ispublic` varchar(40) DEFAULT NULL,
  `special_name` varchar(40) DEFAULT NULL,
  `info` text,
  `creater` varchar(40) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`special_id`),
  UNIQUE KEY `code` (`special_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `boke_type`
--

DROP TABLE IF EXISTS `boke_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boke_type` (
  `type_id` varchar(32) NOT NULL,
  `type_code` varchar(40) DEFAULT NULL,
  `type_name` varchar(40) DEFAULT NULL,
  `creater` varchar(32) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `seq` int(6) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `boke_user`
--

DROP TABLE IF EXISTS `boke_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boke_user` (
  `user_id` varchar(32) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  `user_code` varchar(40) NOT NULL,
  `realname` varchar(40) DEFAULT NULL,
  `salt` varchar(40) DEFAULT NULL,
  `info` text,
  `creater` varchar(40) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  `gender` varchar(40) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `code` (`user_code`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `file_picture`
--

DROP TABLE IF EXISTS `file_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_picture` (
  `picture_id` varchar(32) NOT NULL,
  `picture_name` varchar(40) DEFAULT NULL,
  `suffix` varchar(20) DEFAULT NULL,
  `picture_code` varchar(40) DEFAULT NULL,
  `creater` varchar(40) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `table_id` varchar(32) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  `info` varchar(500) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`picture_id`),
  UNIQUE KEY `code` (`picture_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_admin`
--

DROP TABLE IF EXISTS `sys_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_admin` (
  `admin_id` varchar(32) NOT NULL,
  `admin_code` varchar(40) DEFAULT NULL,
  `admin_name` varchar(40) DEFAULT NULL,
  `real_name` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `salt` varchar(40) DEFAULT '',
  `email` varchar(40) DEFAULT NULL,
  `tel` bigint(11) DEFAULT NULL,
  `type` varchar(40) DEFAULT NULL,
  `gender` varchar(40) DEFAULT NULL,
  `info` varchar(440) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_code` (`admin_code`),
  UNIQUE KEY `admin_name` (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_dictionary`
--

DROP TABLE IF EXISTS `sys_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dictionary` (
  `dic_id` varchar(32) NOT NULL,
  `dic_code` varchar(40) DEFAULT NULL,
  `dic_name` varchar(40) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `value` varchar(40) DEFAULT NULL,
  `dic_type` varchar(40) DEFAULT NULL,
  `info` varchar(440) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  `creater` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`dic_id`),
  UNIQUE KEY `dic_code` (`dic_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` varchar(32) NOT NULL,
  `menu_code` varchar(40) DEFAULT NULL,
  `menu_name` varchar(40) DEFAULT '' COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `info` varchar(440) DEFAULT '' COMMENT '备注',
  `parent_id` varchar(32) DEFAULT '' COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(40) DEFAULT '' COMMENT '授权(如：sys:user:create)',
  `type` varchar(40) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `pid` varchar(32) NOT NULL,
  `permisson` varchar(40) DEFAULT NULL,
  `admin_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL,
  `role_code` varchar(40) DEFAULT NULL,
  `role_name` varchar(40) DEFAULT NULL,
  `info` varchar(440) DEFAULT NULL,
  `isdel` varchar(40) DEFAULT NULL,
  `createtime` bigint(20) DEFAULT NULL,
  `modtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_admin`
--

DROP TABLE IF EXISTS `sys_role_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_admin` (
  `role_id` varchar(32) DEFAULT '' COMMENT '角色ID',
  `admin_id` varchar(32) DEFAULT '' COMMENT 'ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(32) DEFAULT '' COMMENT '角色ID',
  `menu_id` varchar(32) DEFAULT '' COMMENT 'ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-29  8:47:14
