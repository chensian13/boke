/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : csaplat2

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-07-08 18:26:41
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
INSERT INTO `boke_boke` VALUES ('070ea56b2b2c42e7895f6368d8e66a1f', '蚊子进化论之晓 卷3——晓的意图', 'ce29add3f54f4861b0cdd41da8dae09f', '蚊子进化论之晓 卷3——晓的意图', 'BOKE202007069963', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594027699496', '0', '0', '<p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp;它，窥视人类的一举一动，小c虽知如此，但却无可奈何，自己在明对方在暗，明阳阴暗，蚊子的来临试图打破这个阴阳平衡，小c更是如此，杀不死它是人类的耻辱！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 小c明白，它在学人类思考，这个觉悟在于他多晚被叮咬的觉悟，他深知叮咬它的蚊子是同一只。它在学习，掌握了人类的弱点！但是没人知道晓的真正意图，它们为什么要派这么一位探员来到人间？现在，小c有点了解了。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 蚊晓的成立预言着这么一个未来——蚊子的进化，借助人类之手，它们将迎来新的世纪，这是晓的愿望和初衷。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 人类为什么会制霸，所有生物都把人类当作舶来品，就像人类观察UFO的视角，一个多维度俯视低维度的转变，一种戏虐和玩世不恭的态度。人类的自大让他们只局限于自己的视角，以自身为中心。蚊子开始研究人类，才有了晓组织。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 研究人类，就不能具备人类的中心思想，不能围绕一个中心打转，这大概就是地球冲不出银河系的原因！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 不能围绕一个中心，有了中心，人类才会暴露自己弱点的所在。</p>', '0', '0', null, null, null, '1594115426758', '0', '1', null);
INSERT INTO `boke_boke` VALUES ('1ecdfe7c80114b49b48d19c8423b6a54', '2019', 'c2d4c6a52270449a866bd196d51eb62c', '2019', 'BOKE202007060425', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026971404', '0', '0', '<img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/189d8a35ca1e407eb79fe2b558d8812a.gif\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/2bd72c28344f4828b4c6e9b4a899a252.jpg\" width=\"100%\" height=\"\"><br>', '0', '0', null, null, null, '1594115609775', '0', '1', null);
INSERT INTO `boke_boke` VALUES ('23c513cd1bc649f3adcb95ff77939749', 'win10壁纸', 'c2d4c6a52270449a866bd196d51eb62c', 'win10壁纸+android', 'BOKE202007065952', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594017822045', '0', '0', '<img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/15174ef6001341cc9eeab89adb12c216.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/0e54f3289d7741dabacc7e56f85d9ef4.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/b3e0767aef7e4deda9914dd795ccf9fd.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/d0e80a9a4db0434b9629edb2dd385572.jpg\" width=\"100%\" height=\"\"><br>', '0', '0', null, null, null, '1594027137967', '0', '1', null);
INSERT INTO `boke_boke` VALUES ('303ff02c7a28441a8f72d839eaa4a611', '蚊子进化论之晓 卷2', 'ce29add3f54f4861b0cdd41da8dae09f', '蚊子进化论之晓 卷2', 'BOKE202007062483', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594027643321', '0', '0', '<p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 这并不代表小c与晓之间的战争结束了，The game aways start！小c在墙上布置了电热蚊香，他想了想：不该有蚊子的地方是觉得没有蚊子的！还没转过神来，一只飞蚊闯过那片领空，引得小c观望，虽然这只是一只过路的蚊子，它没有在意小c异样的眼光盯着自己，而是悠然自得的姿调：途人莫名回望我，只因我的怪摸样。人类不知，他们的形象在其它生物眼中也是怪莫怪样。&nbsp; &nbsp;&nbsp;</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 小c立刻使出\"如来神掌\"中的第10式——双峰贯耳，一招制敌，蚊子没想到\"佛祖\"会对自己出手，虽然只是路过，但是吸血有罪，杀生有罪，这是\"佛祖\"所不容的！它甚至怀疑，自己遇到的是不是佛祖！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 人类总是喜欢将自己遇到的其它生物作为对手（在人类还没有想起养宠物之前）。虽然这只死去的蚊子生前没有想过要将小c作为对手，它只为生存而捕猎，而从不为了娱乐伤害其它生命。但是小c却将它视为对手，并且对这位\"可敬的对手\"做了一个评价：<span style=\"font-weight: 600;\">在我平生所遇的蚊子对手中，你是最弱的</span>！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp;小c的举动彻底激怒了晓组织，这个飞蚊世界中的组织，成员不多，但却是精兵入线。来自晓的一位成员曾经两次与小c交锋，对方的\"如来神掌\"的确名不虚传，但是却有一个缺陷，所有人到了晚上只能任蚊宰割。对此蚊香，蚊灯花样层次不穷，然而这样真的消灭蚊子了？&nbsp;</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; &nbsp;小c的电热蚊香的确起到了作用，既然晓的成员难缠，那就通过这种蚊虫的精神结界消除冲突，对方也消停了。一连几晚都是如此，直到一天，耳边的嗡嗡声再度响起。小c假寐，当声音来临时听声辨位，啪！自己扇自己耳光，虽然小c不愿意承认，但事实如此！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 人类从不愿意承认自己的错误，小c承认自己犯了一个错误，蚊子适应了电热蚊香的环境，甚至行动自如。当电热蚊香第一次亮起的夜晚，当晓的成员被新型的光亮吸引，但是它过去以后发现这里什么也没有，它知道这是人类的陷阱，于是尽力飞离了这里。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 后面的几天，这位晓成员没有去人类方位，因为他知道人类还在警觉中，它等待，制造了自己被电热蚊香欺骗的假象，当它察觉到人类洋洋得意地放松警觉时，它出击了，直击要害，小c第二天带起了口罩，人类不愿意承认自己地败绩，而是想方设法地遮掩。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 小c意识到，那只蚊子可能没死，它开始怀疑电热蚊香的功效。蚊子产生了抗体！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 还是受干扰的凌晨，它采取了轰炸策略，小c只有招架之功。对于人类的密防，飞蚊无法下手，它转变了策略，减少了攻击次数，将每次的攻击作为迂回试探。几次干扰后，小c以为蚊子只是虚张声势，逐渐睡去。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 忽从梦中惊坐起，小c摸了摸脸上几个大包，蚊子的杰作！脑海中想起一个词语——瞒天过海。他没想到蚊子居然会使用三十六计中的战胜计，心中不由闪过一丝恐惧。这种恐惧有点像是人类知道自己将被其它生物替代的恐惧...</p>', '0', '0', null, null, null, '1594115560949', '0', '1', null);
INSERT INTO `boke_boke` VALUES ('a8bfb3de292340e4863716eb6f86b415', '蚊子进化论之晓 卷5——终篇', 'ce29add3f54f4861b0cdd41da8dae09f', '蚊子进化论之晓 卷5——终篇', 'BOKE202007067928', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594027765562', '0', '0', '<p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">春分345，夏为678，蚊子家族的活跃在芒种正式开始，实际上芒种只是一个分界点，在长江以北会进入雨季，这个时候的蚊子活跃会明显增加，像是分子遇热扩散一样。</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 晓的基地...&nbsp;</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 晓的首领——芒，实际上晓的团员——null，已经在4月14号离开组织前往人间，两个月过去了，跟随null的另外一位成员——盈，返回了组织，盈带回来null已经被人类格毙的消息。</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 格毙null的人类名叫小c，盈说：“null本来是不必死亡的，只是它忘记了非中心思想，小c就是它的中心，有了中心就会暴露了自己的弱点。”</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 边上的鲨蚊说道：“能够击杀我们之中飞行技术最好的null，看来那名人类不简单。”，它身上蓝白色的花纹告诉别人它的剧毒性，这种蚊子身上的剧毒曾经导致人类住院的记录。</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 芒对返回的盈说：“我想跟那名人类谈谈，盈，把他带过来。”</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 盈的最擅长的技能是追踪，它可以监视60公里以内的目标，它为什么会被选入晓组织的原因。盈再次踏上了旅途。</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 七月初，小暑前期，降雨不停。盈带领着那位来自人类的代表——小c，在这雨蒙蒙中，来临了，这是一个郊外的偏区，教堂，人类的信仰往往要远离喧嚣的城市才能找到。</p><p style=\"margin-bottom: 25px; word-break: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 小c举着伞，他瞧着盈朝教堂飞去了。</p>', '0', '0', null, null, null, '1594027927250', '0', '0', null);
INSERT INTO `boke_boke` VALUES ('b12693c3f3494678b9e91de8951bec8b', '蚊子进化论之晓 卷1——晓的成立  陈dawn', 'ce29add3f54f4861b0cdd41da8dae09f', '蚊子进化论之晓 卷1——晓的成立  陈dawn', 'BOKE202007062496', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594027264696', '0', '0', '<div><span style=\"background-color: rgb(255, 255, 255); color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px;\">&nbsp; &nbsp; 春尽夏初，早在春季就开始活跃的蚊子集体兴奋起来，它们组成了蚊晓集团，这是一个有组织有预谋的集团，自蚊子诞生起，人类与蚊子的战争就没有停止过，它们发生在这个世界的各个角落。</span></div><div><span style=\"background-color: rgb(255, 255, 255); color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px;\">&nbsp; &nbsp; 人类甚至想通过大量的药物，灭蚊器等，想要打破它们的雌雄比例，但是蚊子的数量却只增不减，想要灭绝蚊子恐怕要比摧毁全人类还要难。</span><br></div><div><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 小c不明白为什么蚊子的生命力如此之强，虽然他并不痛恨所有生物，但是蚊子的时常袭击和叮扰让他倍感头疼。为此小c患上了数字强迫症，人类对数字是最感兴趣的，据小c统计，五月份以来他依据解决了51只想要cosplay嗜血一组的\"魔怪\"，我说的是蚊子。<br>&nbsp; &nbsp; 蚊子往往是弱小的，它们具备极度敏感的嗅觉和温度湿度感知力，但是视觉稍微弱了点儿，由于的它感知到了电脑的温度（误以为是发光的人类），加上昆虫的趋光性，误打误撞地飞向了电脑屏幕，小c一看飞蚊，以为是自己的眼睛需要休息了，后来仔细一瞧是只迷途地蚊子，于是乎，将近有半数地蚊子是死于电脑游戏，看来网游真心祸害不浅，蚊子一族是这么认为的。<br>&nbsp; &nbsp; 直到后来蚊晓组织的成立就是为了蚊子家族改变这一个现状，误打误撞不会使蚊子走向灭绝，相反，它们认为误打误撞的蚊子行为反而可以壮大蚊子家族，然而并非所有的蚊子都有资格加入晓组织，只有精英中的精英才有入选的权力。<br>这回，“如来神掌”小c遭遇了一位来自晓集团的成员。<br>&nbsp; &nbsp; \"如来神掌\"的封号来自于小c擅长的手法，当蚊子停在墙上时一但被发现，说明它的cosplay生涯就此结束了。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; \"如来神掌\"与这位来自蚊晓的一员正式交锋发生在这天下午，依旧是下班归来的他，偶然看见一只硕大蚊子（相对蚊子家族而言）停在空中，像是逗留在领空中的直升机，转瞬即逝。没过多久，先前那只消失的蚊子又出现在了小c眼前，嗡嗡作响，小c的如来神掌只能使出一半不到的功力，因为那只蚊子没有老老实实地呆在墙上，而是在他眼前晃过，小c当即使出\"如来神掌\"第十式——双峰贯耳。对于截击在空中的蚊子，小c还是很有经验的，小c一击落空，蚊子不翼而飞，作者当场打脸！<br>&nbsp; &nbsp; 那天，小c以为事情就这么过去了，实际上他太低估了蚊晓集团的成员了。<br>&nbsp; &nbsp; 晚上，寂静十分，伴随走廊深处的\"狗吠\"，它来了，带着异国风光般地轻快情调：怀自信，我永不怕夜航；到困倦，我自扇翅膀。嗡嗡嗡，很是心烦。<br>&nbsp; &nbsp; 这是蚊子常用地手段，在黑暗中，你摸不着它，当你打开灯，它如同那黑玫瑰，依旧在天上。如此反复循环，终于折腾个够本，睡去，任那蚊子叮咬。但是这位蚊晓集团地成员并不这么简单，实际上人们只要打开空调，释放冷气，蚊子咬人地速度就会变慢，甚至无法下口，但是这位蚊晓成员似乎不受冷气地影响，夜往往时蚊子最佳地屏障，但是它从不在夜间下口，而是等到了天晓，人睡意最浓但也是最容易受到干扰地时候。这折磨人的阶段，小c买的花露水都失去了作用。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 小c与蚊晓之间的战争终于爆发了。<br>&nbsp; &nbsp; 那天，小c见一只蚊子就停在桌上，这只蚊子显然与小c平日里见到的凡蚊不同，它像一支带刺的黑玫瑰。这是个好机会，小c当即使出一记抹面掌，仿佛在对蚊子说：“面对疾风吧！”<br>&nbsp; &nbsp; 一掌落下，蚊子飞走了，小c呆滞片刻。<br>&nbsp; &nbsp; 赤裸裸地挑衅行为，同时也在展现晓的实力！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 曾经一晚，13只蚊子命丧\"如来神掌\"之手，别看是“如来”，可一点儿不慈悲，那得看谁使！<br>&nbsp; &nbsp; 小c的光荣战绩，对付的蚊子也都不简单，个个吸血不眨眼！好像蚊子也不会眨眼。但是两次在晓的成员手里吃了亏。<br>&nbsp; &nbsp; 晓！究竟是何等的存在？</p></div>', '0', '0', null, null, null, '1594115536065', '0', '1', null);
INSERT INTO `boke_boke` VALUES ('d5395317b5a84dd6885b51282db1d10f', '无题', 'c2d4c6a52270449a866bd196d51eb62c', '无题', 'BOKE202007060552', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026473513', '0', '0', '<img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/3fe1c4839de443de9f8cc4d2baca288b.jpeg\" width=\"100%\" height=\"\"><br><img width=\"100%\" height=\"\"><br><img width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/e80ac07a0873428b92311325ef6a88a5.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/b97ad0cc5fdf4fb8b9370553fe17da36.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/1aecf4aac1d74237b0317ff45b95fdf0.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/8e61e506375d424dbae3c70d689444e9.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/393e148dfcdd477496262400055f1352.jpg\" width=\"100%\" height=\"\"><br><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/81e62c6c27a544d7a0345a9640941522.jpg\" width=\"100%\" height=\"\"><br><br><br>', '0', '0', null, null, null, '1594027019648', '0', '1', null);
INSERT INTO `boke_boke` VALUES ('dc860f0449994bf4ab4eaf65226f2cc7', '转为路人定制的提速指南', 'c2d4c6a52270449a866bd196d51eb62c', '提速指南', 'BOKE202007083528', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594202417589', '0', '0', '&nbsp; &nbsp; 这是一个加速的时代，<br><br>', '0', '0', null, null, null, '1594203664917', '0', '1', null);
INSERT INTO `boke_boke` VALUES ('e287f627e8144dcab825ab1a27ec017f', '蚊子进化论之晓 卷4——泯灭', 'ce29add3f54f4861b0cdd41da8dae09f', '蚊子进化论之晓 卷4——泯灭', 'BOKE202007060947', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594027736742', '0', '0', '<p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\"><img src=\"http://imgs/a8d54e799fa04d4f9f5f8d795638d2bd/8d1906285c704b4aad87c0e8afba749d.jpg\" width=\"80%\" height=\"\" style=\"background-color: whitesmoke; color: rgb(119, 119, 119); font-family: &quot;Open Sans&quot;, Arial, sans-serif; font-size: 13px;\"></p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp;小c注意到了，它停在桌旁的墙上，熟悉的黑色，只有真正具备吸血夜族的蚊子才具备的黑色。小c停顿下来，在没有把握出击距离的时候他不想打草惊蛇。小c屏住呼吸慢慢靠近，直到双方距离2尺左右，最佳击杀距离，小c认为自己准备好了，当即使出一招太极揽雀尾，这回他不使用\"如来神掌\"了，他要用人类的招式打败这只蚊子，为人类挽回失去的尊严。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 小c一掌追风，速度之快，但是这位晓成员没有给他第二次出击的机会，它在小c一掌落下时消失了，甚至连\"尸体\"都没留下，很显然它已经离开了小c的视线。小c站在原地良久，他终于明白为什么太极只适合养生了。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 夜，伴随着失落。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 也许是不满人类的偷袭手段，这位晓成员不屑地望了小c一眼，仿佛要说：\"你也不过如此，只会站在对方身后。\"，于是，它螺旋而来，这种扰乱人视线的飞行方式，小c一掌高探马，与它擦身而过，它以为自己避开了，谁知小c翻手使个拿法，将它抓在手中。&nbsp; &nbsp;</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 一切仿佛就要落幕了，晓的成员被困在人类的手中，就像当年大闹天宫的孙悟空遇见了如来佛祖。它并没有乱飞舞动，而是警觉地落在指间。小c乱捏一阵，飞蚊在他手中沉浮。当小c张开手时，蚊子一动不动地落在手里，小c以为它挂了，飞蚊没有马上飞走，当小c觉得不对时，它突然起飞，直旋上空，小c一掌盖下，落空！</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 那夜，蚊子疯狂地向小c发动袭击，它已经了解了人类地弱点，但是却忘记了自己的目的，此时小c如同一个中心，将它吸引，它的袭击每次都精确无误，指东打西，游击战术运用地炉火纯青，让小c完全无法定位敌人的方位，一会儿在脚步中招，一会脸部沦陷，最后双手也没能幸免蚊子的叮咬。小c开始怀疑对方可能不止一个，但是蚊子一般都是单独行动的，它们还组团进攻？很显然这一战，它打出了风格，打出了水平。</p><p style=\"margin-bottom: 20px; word-break: break-word; color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; 直到清晨，小c突发奇想，他爬起看了看四周，啪！一掌，毫无征兆，小c躺下继续睡去，墙上众多地蚊子印中多了一个黑印，它被永远定格在那...</p>', '0', '0', null, null, null, '1594083937886', '0', '1', null);

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
INSERT INTO `boke_type` VALUES ('9f3ab1c592414f978b45b4eb43a20504', 'TYPE202005119187', '微服务', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589161732080', '1589161732080', '0', '', '32');
INSERT INTO `boke_type` VALUES ('b4b12fb9ae6844fb865cf3344c1cc034', 'TYPE202005114587', 'java', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589162126287', '1589162126287', '0', '', '12');
INSERT INTO `boke_type` VALUES ('c2d4c6a52270449a866bd196d51eb62c', 'TYPE202005114795', '日常', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1589162143258', '1589162143258', '0', '', '7');
INSERT INTO `boke_type` VALUES ('ce29add3f54f4861b0cdd41da8dae09f', 'TYPE202007068160', '蚊子进化论', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594027296071', '1594027296071', '0', '', '1');

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
INSERT INTO `file_picture` VALUES ('0e54f3289d7741dabacc7e56f85d9ef4', '4.jpg', 'jpg', 'PICTURE202007069234', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594017881240', null, '0', '1594017881240', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/0e54f3289d7741dabacc7e56f85d9ef4.jpg');
INSERT INTO `file_picture` VALUES ('15174ef6001341cc9eeab89adb12c216', 'CachedImage_1920_1080_POS22.jpg', 'jpg', 'PICTURE202007063522', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594017802206', null, '0', '1594017802206', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/15174ef6001341cc9eeab89adb12c216.jpg');
INSERT INTO `file_picture` VALUES ('189d8a35ca1e407eb79fe2b558d8812a', null, 'gif', 'PICTURE202007067576', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026962603', null, '0', '1594026962603', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/189d8a35ca1e407eb79fe2b558d8812a.gif');
INSERT INTO `file_picture` VALUES ('1aecf4aac1d74237b0317ff45b95fdf0', null, 'jpg', 'PICTURE202007065200', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026782858', null, '0', '1594026782858', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/1aecf4aac1d74237b0317ff45b95fdf0.jpg');
INSERT INTO `file_picture` VALUES ('23b3670701a748af8c9d2df9f9e7d057', null, 'jpg', 'PICTURE202007083109', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594192706551', null, '0', '1594192706551', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/23b3670701a748af8c9d2df9f9e7d057.jpg');
INSERT INTO `file_picture` VALUES ('2bd72c28344f4828b4c6e9b4a899a252', null, 'jpg', 'PICTURE202007060137', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026969050', null, '0', '1594026969050', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/2bd72c28344f4828b4c6e9b4a899a252.jpg');
INSERT INTO `file_picture` VALUES ('392616bab8024278b176d39965dbc6ff', null, 'jpg', 'PICTURE202007087634', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594201195337', null, '0', '1594201195337', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/392616bab8024278b176d39965dbc6ff.jpg');
INSERT INTO `file_picture` VALUES ('393e148dfcdd477496262400055f1352', null, 'jpg', 'PICTURE202007067295', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026803088', null, '0', '1594026803088', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/393e148dfcdd477496262400055f1352.jpg');
INSERT INTO `file_picture` VALUES ('3f41dfa3d14a44708fccde1a254b0e5b', null, 'jpg', 'PICTURE202007085927', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594200423484', null, '0', '1594200423484', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/3f41dfa3d14a44708fccde1a254b0e5b.jpg');
INSERT INTO `file_picture` VALUES ('3fe1c4839de443de9f8cc4d2baca288b', null, 'jpeg', 'PICTURE202007066483', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026458931', null, '0', '1594026458931', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/3fe1c4839de443de9f8cc4d2baca288b.jpeg');
INSERT INTO `file_picture` VALUES ('7cc236d8a3a245eebcf6c883cad9207f', null, 'jpg', 'PICTURE202007064262', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026900074', null, '0', '1594026900074', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/7cc236d8a3a245eebcf6c883cad9207f.jpg');
INSERT INTO `file_picture` VALUES ('81e62c6c27a544d7a0345a9640941522', null, 'jpg', 'PICTURE202007064428', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026809902', null, '0', '1594026809902', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/81e62c6c27a544d7a0345a9640941522.jpg');
INSERT INTO `file_picture` VALUES ('8d1906285c704b4aad87c0e8afba749d', null, 'jpg', 'PICTURE202007073283', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594083864589', null, '0', '1594083864589', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/8d1906285c704b4aad87c0e8afba749d.jpg');
INSERT INTO `file_picture` VALUES ('8e61e506375d424dbae3c70d689444e9', null, 'jpg', 'PICTURE202007063426', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026795551', null, '0', '1594026795551', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/8e61e506375d424dbae3c70d689444e9.jpg');
INSERT INTO `file_picture` VALUES ('b3e0767aef7e4deda9914dd795ccf9fd', 'timg.jpg', 'jpg', 'PICTURE202007061231', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594017941392', null, '0', '1594017941392', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/b3e0767aef7e4deda9914dd795ccf9fd.jpg');
INSERT INTO `file_picture` VALUES ('b97ad0cc5fdf4fb8b9370553fe17da36', null, 'jpg', 'PICTURE202007062796', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026674049', null, '0', '1594026674049', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/b97ad0cc5fdf4fb8b9370553fe17da36.jpg');
INSERT INTO `file_picture` VALUES ('d0e80a9a4db0434b9629edb2dd385572', null, 'jpg', 'PICTURE202007069018', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594027108630', null, '0', '1594027108630', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/d0e80a9a4db0434b9629edb2dd385572.jpg');
INSERT INTO `file_picture` VALUES ('e80ac07a0873428b92311325ef6a88a5', null, 'jpg', 'PICTURE202007062751', 'a8d54e799fa04d4f9f5f8d795638d2bd', '1594026548634', null, '0', '1594026548634', null, '0', 'a8d54e799fa04d4f9f5f8d795638d2bd/e80ac07a0873428b92311325ef6a88a5.jpg');

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
