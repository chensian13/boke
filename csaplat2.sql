/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : csaplat2

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-07-06 14:41:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `boke_boke`
-- ----------------------------
DROP TABLE IF EXISTS `boke_boke`;
CREATE TABLE `boke_boke` (
  `boke_id` varchar(32) NOT NULL,
  `boke_subtitle` varchar(40) DEFAULT NULL,
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
  PRIMARY KEY (`boke_id`),
  UNIQUE KEY `code` (`boke_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boke_boke
-- ----------------------------

-- ----------------------------
-- Table structure for `boke_collect`
-- ----------------------------
DROP TABLE IF EXISTS `boke_collect`;
CREATE TABLE `boke_collect` (
  `collect_id` varchar(32) NOT NULL,
  `user_code` varchar(40) DEFAULT NULL,
  `boke_code` varchar(40) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boke_collect
-- ----------------------------

-- ----------------------------
-- Table structure for `boke_comment`
-- ----------------------------
DROP TABLE IF EXISTS `boke_comment`;
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

-- ----------------------------
-- Records of boke_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `boke_special`
-- ----------------------------
DROP TABLE IF EXISTS `boke_special`;
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
  PRIMARY KEY (`special_id`),
  UNIQUE KEY `code` (`special_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boke_special
-- ----------------------------
INSERT INTO `boke_special` VALUES ('27cbd804c8b011e99c9300ffae4ef909', 'SPECIAL20190827000002', '1', '失落古堡', 'string', 'USER20190827000001', null, '20190827161051', '0');
INSERT INTO `boke_special` VALUES ('6b97b79ec8a211e99c9300ffae4ef909', 'SPECIAL20190827000001', '1', '我的散文集', 'string', 'USER20190827000001', null, '20190827161051', '0');
INSERT INTO `boke_special` VALUES ('eaea9b05c93111e99c9300ffae4ef909', 'SPECIAL20190828000001', '1', '神偷奶爸集', '神偷奶爸电影', 'USER20190827000002', null, '20190827161051', '0');

-- ----------------------------
-- Table structure for `boke_type`
-- ----------------------------
DROP TABLE IF EXISTS `boke_type`;
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

-- ----------------------------
-- Records of boke_type
-- ----------------------------
INSERT INTO `boke_type` VALUES ('645b5b81d6ce4f6b9a74ea8a7179bc35', 'TYPE202005117550', '计算机', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589161047084', '1589161047084', '0', '', '2');
INSERT INTO `boke_type` VALUES ('9f3ab1c592414f978b45b4eb43a20504', 'TYPE202005119187', '微服务', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589161732080', '1589161732080', '0', '', '32');
INSERT INTO `boke_type` VALUES ('b4b12fb9ae6844fb865cf3344c1cc034', 'TYPE202005114587', 'java', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589162126287', '1589162126287', '0', '', '12');
INSERT INTO `boke_type` VALUES ('c2d4c6a52270449a866bd196d51eb62c', 'TYPE202005114795', '日常', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589162143258', '1589162143258', '0', '', '7');

-- ----------------------------
-- Table structure for `boke_user`
-- ----------------------------
DROP TABLE IF EXISTS `boke_user`;
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

-- ----------------------------
-- Records of boke_user
-- ----------------------------
INSERT INTO `boke_user` VALUES ('4bd06c206b40411e8a7b2bfe241e8efa', '1975291043@qq.com', 'b9f87e0af5d2ec41718b05c0d453fc6b', '妖关玄冰', 'USER202007020151', '妖关玄冰', '0e0a948d8d3748dab21c3ed8b8e723a2', null, null, '1593657524169', '0', '1', '13995971833', '1593657524169');
INSERT INTO `boke_user` VALUES ('a8d54e799fa04d4f9f5f8d795638d2bd', '1975291043@qq.com', '93dac933eebc5a32c8aa09be46a737d4', '懒龙卧道', 'USER202005122701', '陈思安', '0d0ecc49c14e4378a1be85078c7117fa', null, 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589247996353', '0', '1', '13995971833', '1589247996353');
INSERT INTO `boke_user` VALUES ('f7453e9dd31a449fac50cd688068af01', '222222@qq.com', '679d9331e571bc14705f11882dda6a8e', 'ww', 'USER202007022724', '1', '1ffd29b215f345f1880d8684abe21e21', null, null, '1593658147993', '0', '1', '13994958233', '1593658147993');

-- ----------------------------
-- Table structure for `file_picture`
-- ----------------------------
DROP TABLE IF EXISTS `file_picture`;
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

-- ----------------------------
-- Records of file_picture
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_admin`
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
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

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('27b3fc355fef4f52bbaf4b00f7c7828b', 'admin202003031087', '胡瑾', '胡瑾', '2b8f42a4e9cbb37178cd2ea6747bdd1e', 'e3f3f2d96a45425b883e9fd14f2e6ebd', '22222@qq.com', '13995971822', null, '0', null, '1583208633436', '1583843536238', '0');
INSERT INTO `sys_admin` VALUES ('2bd35989994a4f5f8024404b14790631', 'admin202003271991', '测试', 'sfse', 'a88cd67feb75d08827a232226baf0967', '22e09624676842d68813f68e9792f216', '1975291043@qq.com', '13994958233', null, '1', null, '1585275438689', '1588918230762', '0');
INSERT INTO `sys_admin` VALUES ('2e1b60e727a24a9ea7a8e6c0c9f752a5', 'admin202003033983', 'bitmap', 'bitmap', '8237622600e7d2eb65bb1403ece5cf28', 'eab49edc83d4481aa7ff226a941f7d99', '1975291043@qq.com', '13995971866', null, '1', null, '1583208461687', '1584886878874', '0');
INSERT INTO `sys_admin` VALUES ('a00c24d967db4e019ec4143580858de5', 'admin202003103600', '陈思安', '陈思安', '6300928a429d003cc79dac6eb9273a81', '4254548030e345d9963450738e93fffb', '1975432910@qq.com', '13995971833', null, '1', null, '1583843370358', '1585042573237', '0');
INSERT INTO `sys_admin` VALUES ('aab5821bf1344c16967bb69e75671ce8', 'admin202003033646', '未解之谜', 'm4a1', '5fa05a4c320fd13c5d789340e964711d', '0f6c78b9ad0b42c7983e9f5a74e1d6f0', '666666@qq.com', '13995971832', null, '1', null, '1583208926874', '1584243229032', '0');
INSERT INTO `sys_admin` VALUES ('ab8fa4abc4a94d458bcb525cd6b47dce', 'admin202003030774', '范子文', '无', '4a784be08e6f8a474f173a88710d7c9e', 'f48d2c8678bf401685dfeb68d5c5113c', '333333@qq.com', '13995971222', null, '1', null, '1583210323028', '1583844098340', '0');
INSERT INTO `sys_admin` VALUES ('b8f1cec4eb7c4982884489227c474789', 'admin202003165402', '海绵宝宝', '不叫我', '0bbbd9c50a0910e5eb56878c6eedff5e', 'a4e5edfd3826434aa128a570b836b7be', '', '13894890933', null, '0', null, '1584329051941', '1584329097989', '0');
INSERT INTO `sys_admin` VALUES ('c4fd5e04f30d4a82b0cd995131364c81', 'admin202004021767', '艾莉', '艾莉', '2ac0c9f6b625c78c98ab96015c4307d2', '45c5bacdf36e4218b42521b368f6e9c0', '1975291043@qq.com', '13994958233', null, '0', null, '1585797074172', '1585797142170', '0');

-- ----------------------------
-- Table structure for `sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
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

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('003', 'dic_root2', '数据字典', null, 'dic_root', '1', null, null, null, null, null);
INSERT INTO `sys_dictionary` VALUES ('09e62b89c47c4485b786dff22b1abf10', 'dic202003086114', '日记', 'a6c68a0600ec4ed0a80e445b0b6a26af', 'riji', '0', '', '1583657659136', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('1266932fd49a4119800ef02005b50965', 'dic202003084171', '平原', '68c0697975894302ad81f2a1c85648ae', 'pingyuan', '', '', '1583657840305', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('1f1c53629fe24958b442b48a86bdcd68', 'dic202003222062', '桌面', 'a6c68a0600ec4ed0a80e445b0b6a26af', 'zhuomian', '0', '', '1584887363304', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('24d646e1b0d342d589da45ba4d634130', 'dic202002254108', '明星', 'a6c68a0600ec4ed0a80e445b0b6a26af', 'star', '0', '', '1582633819278', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('2d43cd35c1334bb18882b7ff959c5286', 'dic202003086464', '城市', '68c0697975894302ad81f2a1c85648ae', 'city', '0', '', '1583658202779', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('31fa311b7ebc400e857936c2ff3ad36f', 'dic202003124644', '少女', '80ee54d97b3240779783eceb73ef6ee1', 'shaonv', '0', '', '1584007702839', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('548c346d243648c1b36a69f9e61f38b7', 'dic202003081752', '森林', '68c0697975894302ad81f2a1c85648ae', 'trees', '0', '', '1583657565414', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('68c0697975894302ad81f2a1c85648ae', 'dic202003082139', '视野', 'f32159998e9344eeb5b83a9325c79054', 'shiye', '1', '', '1583657410161', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('80ee54d97b3240779783eceb73ef6ee1', 'dic202003126152', '美女', 'f32159998e9344eeb5b83a9325c79054', 'meinv', '1', '', '1584007629271', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('a6c68a0600ec4ed0a80e445b0b6a26af', 'dic202003085538', '日常', 'f32159998e9344eeb5b83a9325c79054', 'richang', '1', '', '1583657469240', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('b6d18976212a4a1d9ad77f9a37974eb0', 'dic202003080643', '汽车', 'fa5ddb487e6a479b909d40bf528e1ec7', 'car', '0', '', '1583657798934', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('bda88ec9fefb4731a3b6261bbafe75fb', 'dic202003085286', '海洋', '68c0697975894302ad81f2a1c85648ae', 'sea', '0', '', '1583657488185', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('c2f88dac4c52457d8ed4f29b6ad2483b', 'dic202003081670', '少女', 'da774e422dad4cd6aeb64b3b51f9a756', 'shaonv', '0', '', '1583657613807', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('da774e422dad4cd6aeb64b3b51f9a756', 'dic202003083370', '二次元', 'f32159998e9344eeb5b83a9325c79054', 'erciyuan', '1', '', '1583657433024', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('f32159998e9344eeb5b83a9325c79054', 'dic202003088260', '素材类型', '003', 'pic_type', '1', '', '1583657377585', null, null, null);
INSERT INTO `sys_dictionary` VALUES ('fa5ddb487e6a479b909d40bf528e1ec7', 'dic202003085594', '新闻', 'f32159998e9344eeb5b83a9325c79054', 'new', '1', '', '1583657783336', null, null, null);

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
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

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('001', 'menu', '资源管理', null, null, '', '', '', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('6a567d35896a41419bcd4ff193b94ea5', 'menu202002265497', '权限管理', '2', '1', '', '001', 'sys:grant', null, '1582720059003', null, null);
INSERT INTO `sys_menu` VALUES ('6efceedd8b2f43ce83822f094559225b', 'menu202003018568', '角色管理', 'role_manage.html', '2', '', '6a567d35896a41419bcd4ff193b94ea5', 'sys:grant:role', null, '1583065724246', null, null);
INSERT INTO `sys_menu` VALUES ('7d726bb833404ab0977346c6aaf4391f', 'menu202002269567', '编辑用户', '', '2', '', '83881592bdc5404b83852275262cc199', '', null, '1582712412199', null, null);
INSERT INTO `sys_menu` VALUES ('83881592bdc5404b83852275262cc199', 'menu202002264360', '管理员', '1', '1', 's', '001', '', null, '1582712301100', null, null);
INSERT INTO `sys_menu` VALUES ('e6771d2a40ad4bd39037a2877b557c81', 'caidan', '菜单管理', '', '1', '', '001', 'sys:grant:menu', null, '1583065753829', null, null);

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `pid` varchar(32) NOT NULL,
  `permisson` varchar(40) DEFAULT NULL,
  `admin_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
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

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('13b80bb0b47845d6859a8810fb8723cb', 'role202003032048', '用户管理员', '', '0', '1583202907311', null);
INSERT INTO `sys_role` VALUES ('2dac371d48ca406db5fc0147d9c47f9d', 'role202003030260', '边缘人', '', '0', '1583202944534', null);
INSERT INTO `sys_role` VALUES ('a86d5a403aca40e696a7af3b92fca908', 'role202003032196', '学姐', '', '0', '1583202968204', null);
INSERT INTO `sys_role` VALUES ('ba235b3bf016463e8d1093cfefb5795c', 'role202003032128', '黑衣杀手', '', '0', '1583202981260', null);
INSERT INTO `sys_role` VALUES ('c4c25b098e8846ffb64029286425c15f', 'role202003035174', '超管', '', '0', '1583202914172', null);
INSERT INTO `sys_role` VALUES ('dd9bab77e4d44cdfb9fd31459d50aed8', 'role202003032117', '抽象工程师', '构建抽象架构', '0', '1583210275472', null);
INSERT INTO `sys_role` VALUES ('f0990790deb3425aa32517df23e42b85', 'role202003037376', '大佬', '', '0', '1583202994909', null);

-- ----------------------------
-- Table structure for `sys_role_admin`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_admin`;
CREATE TABLE `sys_role_admin` (
  `role_id` varchar(32) DEFAULT '' COMMENT '角色ID',
  `admin_id` varchar(32) DEFAULT '' COMMENT 'ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_admin
-- ----------------------------
INSERT INTO `sys_role_admin` VALUES ('f0990790deb3425aa32517df23e42b85', 'ab8fa4abc4a94d458bcb525cd6b47dce');
INSERT INTO `sys_role_admin` VALUES ('ba235b3bf016463e8d1093cfefb5795c', 'ab8fa4abc4a94d458bcb525cd6b47dce');
INSERT INTO `sys_role_admin` VALUES ('2dac371d48ca406db5fc0147d9c47f9d', 'ab8fa4abc4a94d458bcb525cd6b47dce');
INSERT INTO `sys_role_admin` VALUES ('2dac371d48ca406db5fc0147d9c47f9d', 'aab5821bf1344c16967bb69e75671ce8');
INSERT INTO `sys_role_admin` VALUES ('a86d5a403aca40e696a7af3b92fca908', 'b8f1cec4eb7c4982884489227c474789');
INSERT INTO `sys_role_admin` VALUES ('dd9bab77e4d44cdfb9fd31459d50aed8', '2e1b60e727a24a9ea7a8e6c0c9f752a5');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(32) DEFAULT '' COMMENT '角色ID',
  `menu_id` varchar(32) DEFAULT '' COMMENT 'ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('13b80bb0b47845d6859a8810fb8723cb', '83881592bdc5404b83852275262cc199');
INSERT INTO `sys_role_menu` VALUES ('13b80bb0b47845d6859a8810fb8723cb', '7d726bb833404ab0977346c6aaf4391f');
INSERT INTO `sys_role_menu` VALUES ('c4c25b098e8846ffb64029286425c15f', '001');
INSERT INTO `sys_role_menu` VALUES ('c4c25b098e8846ffb64029286425c15f', '6a567d35896a41419bcd4ff193b94ea5');
INSERT INTO `sys_role_menu` VALUES ('c4c25b098e8846ffb64029286425c15f', '6efceedd8b2f43ce83822f094559225b');
INSERT INTO `sys_role_menu` VALUES ('c4c25b098e8846ffb64029286425c15f', 'e6771d2a40ad4bd39037a2877b557c81');
INSERT INTO `sys_role_menu` VALUES ('c4c25b098e8846ffb64029286425c15f', '83881592bdc5404b83852275262cc199');
INSERT INTO `sys_role_menu` VALUES ('c4c25b098e8846ffb64029286425c15f', '7d726bb833404ab0977346c6aaf4391f');
INSERT INTO `sys_role_menu` VALUES ('a86d5a403aca40e696a7af3b92fca908', '001');
INSERT INTO `sys_role_menu` VALUES ('a86d5a403aca40e696a7af3b92fca908', '6a567d35896a41419bcd4ff193b94ea5');
INSERT INTO `sys_role_menu` VALUES ('a86d5a403aca40e696a7af3b92fca908', '6efceedd8b2f43ce83822f094559225b');
INSERT INTO `sys_role_menu` VALUES ('a86d5a403aca40e696a7af3b92fca908', 'e6771d2a40ad4bd39037a2877b557c81');
INSERT INTO `sys_role_menu` VALUES ('a86d5a403aca40e696a7af3b92fca908', '83881592bdc5404b83852275262cc199');
INSERT INTO `sys_role_menu` VALUES ('a86d5a403aca40e696a7af3b92fca908', '7d726bb833404ab0977346c6aaf4391f');
INSERT INTO `sys_role_menu` VALUES ('ba235b3bf016463e8d1093cfefb5795c', '6a567d35896a41419bcd4ff193b94ea5');
INSERT INTO `sys_role_menu` VALUES ('ba235b3bf016463e8d1093cfefb5795c', '6efceedd8b2f43ce83822f094559225b');
INSERT INTO `sys_role_menu` VALUES ('ba235b3bf016463e8d1093cfefb5795c', 'e6771d2a40ad4bd39037a2877b557c81');
INSERT INTO `sys_role_menu` VALUES ('dd9bab77e4d44cdfb9fd31459d50aed8', 'e6771d2a40ad4bd39037a2877b557c81');
INSERT INTO `sys_role_menu` VALUES ('2dac371d48ca406db5fc0147d9c47f9d', '6a567d35896a41419bcd4ff193b94ea5');
INSERT INTO `sys_role_menu` VALUES ('2dac371d48ca406db5fc0147d9c47f9d', '6efceedd8b2f43ce83822f094559225b');
INSERT INTO `sys_role_menu` VALUES ('2dac371d48ca406db5fc0147d9c47f9d', 'e6771d2a40ad4bd39037a2877b557c81');

-- ----------------------------
-- Function structure for `fn_fixNum`
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_fixNum`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_fixNum`(`maxNum` bigint,`len` int) RETURNS varchar(40) CHARSET utf8
BEGIN
	#设置指定长度的数字编号
	DECLARE codeString VARCHAR(40) DEFAULT '';
	DECLARE i INT DEFAULT 1;

	WHILE i<len-LOG10(maxNum) DO
		SET codeString=CONCAT(codeString,0);
		SET i=i+1;
	END WHILE;

	RETURN CONCAT(codeString,maxNum);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `fn_generateCode`
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_generateCode`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_generateCode`(`type` varchar(40)) RETURNS varchar(40) CHARSET utf8
BEGIN
	#记录code的生成方案
	#定义一个变量装载生成的code
	DECLARE codeString VARCHAR(40) DEFAULT '';
	DECLARE nowDay VARCHAR(40) DEFAULT '00000000';
	#定义最大记录数
	DECLARE maxNum BIGINT DEFAULT 1;
	#year(CURRENT_DATE),month(CURRENT_DATE),day(CURRENT_DATE)
	#now()函数可以返回一个格式化的字符串，从第一个字符截取10个
	SET nowDay=SUBSTRING(CONCAT(NOW(),''),1,10);

	#判断code类型
	if type='USER' THEN
		SET codeString='USER';
		SELECT count(1)+1 INTO maxNum FROM boke_user WHERE createtime LIKE CONCAT(nowDay,'%');
	ELSEIF type='BOKE' THEN
		#boke春秋
		SET codeString='CQBOKE';
		SELECT count(1)+1 INTO maxNum FROM boke_boke WHERE createtime LIKE CONCAT(nowDay,'%');
	ELSEIF type='SPECIAL' THEN
		#专辑
		SET codeString='SPECIAL';
		SELECT count(1)+1 INTO maxNum FROM boke_special WHERE createtime LIKE CONCAT(nowDay,'%');
	ELSEIF type='PICTURE' THEN
		#boke春秋
		SET codeString='PICTURE';
		SELECT count(1)+1 INTO maxNum FROM file_picture WHERE createtime LIKE CONCAT(nowDay,'%');
	ELSEIF type='ADMIN' THEN
		#boke春秋
		SET codeString='ADMIN';
		SELECT count(1)+1 INTO maxNum FROM sys_admin WHERE createtime LIKE CONCAT(nowDay,'%');
	END IF;

	#替换字符里面的'-'为空字符串
	SET nowDay=REPLACE(nowDay,'-','');
	RETURN CONCAT(codeString,nowDay,fn_fixNum(maxNum,6));
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `fn_uuid32`
-- ----------------------------
DROP FUNCTION IF EXISTS `fn_uuid32`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fn_uuid32`() RETURNS varchar(32) CHARSET utf8
BEGIN
	#32位uuid生成方案
	RETURN REPLACE(UUID(),'-','');
END
;;
DELIMITER ;
