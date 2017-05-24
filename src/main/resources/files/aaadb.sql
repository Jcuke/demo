/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : aaadb

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-05-24 17:55:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `astu`
-- ----------------------------
DROP TABLE IF EXISTS `astu`;
CREATE TABLE `astu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count1` tinyint(4) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `count2` smallint(6) DEFAULT NULL,
  `count3` mediumint(9) DEFAULT NULL,
  `count4` bigint(20) DEFAULT NULL,
  `count5` double DEFAULT NULL,
  `count6` float DEFAULT NULL,
  `count7` decimal(10,2) DEFAULT NULL,
  `count8` decimal(10,2) DEFAULT NULL,
  `count9` bit(1) DEFAULT NULL,
  `count10` double DEFAULT NULL,
  `count11` tinyblob,
  `count12` blob,
  `count13` text,
  `count14` binary(255) DEFAULT NULL,
  `count15` point DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of astu
-- ----------------------------

-- ----------------------------
-- Table structure for `districturl`
-- ----------------------------
DROP TABLE IF EXISTS `districturl`;
CREATE TABLE `districturl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cityid` varchar(100) DEFAULT NULL,
  `districtid` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of districturl
-- ----------------------------
INSERT INTO `districturl` VALUES ('1', 'wh', 'jiangan', 'https://wh.lianjia.com/ershoufang/jiangan/');
INSERT INTO `districturl` VALUES ('2', 'bj', 'dongcheng', 'https://bj.lianjia.com/ershoufang/dongcheng/');
INSERT INTO `districturl` VALUES ('3', 'bj', 'xicheng', 'https://bj.lianjia.com/ershoufang/xicheng/');
INSERT INTO `districturl` VALUES ('4', 'wh', 'jianghan', 'https://wh.lianjia.com/ershoufang/jianghan/');
INSERT INTO `districturl` VALUES ('5', 'bj', 'chaoyang', 'https://bj.lianjia.com/ershoufang/chaoyang/');
INSERT INTO `districturl` VALUES ('6', 'sh', 'pudongxinqu', 'https://sh.lianjia.com/ershoufang/pudongxinqu/');
INSERT INTO `districturl` VALUES ('7', 'sh', 'minhang', 'https://sh.lianjia.com/ershoufang/minhang/');
INSERT INTO `districturl` VALUES ('8', 'sh', 'baoshan', 'https://sh.lianjia.com/ershoufang/baoshan/');
INSERT INTO `districturl` VALUES ('9', 'bj', 'haidian', 'https://bj.lianjia.com/ershoufang/haidian/');
INSERT INTO `districturl` VALUES ('10', 'sh', 'xuhui', 'https://sh.lianjia.com/ershoufang/xuhui/');
INSERT INTO `districturl` VALUES ('11', 'sh', 'putuo', 'https://sh.lianjia.com/ershoufang/putuo/');
INSERT INTO `districturl` VALUES ('12', 'wh', 'qiaokou', 'https://wh.lianjia.com/ershoufang/qiaokou/');
INSERT INTO `districturl` VALUES ('13', 'bj', 'fengtai', 'https://bj.lianjia.com/ershoufang/fengtai/');
INSERT INTO `districturl` VALUES ('14', 'sh', 'yangpu', 'https://sh.lianjia.com/ershoufang/yangpu/');
INSERT INTO `districturl` VALUES ('15', 'wh', 'dongxihu', 'https://wh.lianjia.com/ershoufang/dongxihu/');
INSERT INTO `districturl` VALUES ('16', 'sh', 'changning', 'https://sh.lianjia.com/ershoufang/changning/');
INSERT INTO `districturl` VALUES ('17', 'bj', 'shijingshan', 'https://bj.lianjia.com/ershoufang/shijingshan/');
INSERT INTO `districturl` VALUES ('18', 'wh', 'wuchang', 'https://wh.lianjia.com/ershoufang/wuchang/');
INSERT INTO `districturl` VALUES ('19', 'bj', 'tongzhou', 'https://bj.lianjia.com/ershoufang/tongzhou/');
INSERT INTO `districturl` VALUES ('20', 'sh', 'songjiang', 'https://sh.lianjia.com/ershoufang/songjiang/');
INSERT INTO `districturl` VALUES ('21', 'wh', 'qingshan', 'https://wh.lianjia.com/ershoufang/qingshan/');
INSERT INTO `districturl` VALUES ('22', 'bj', 'changping', 'https://bj.lianjia.com/ershoufang/changping/');
INSERT INTO `districturl` VALUES ('23', 'sh', 'jiading', 'https://sh.lianjia.com/ershoufang/jiading/');
INSERT INTO `districturl` VALUES ('24', 'wh', 'hongshan', 'https://wh.lianjia.com/ershoufang/hongshan/');
INSERT INTO `districturl` VALUES ('25', 'bj', 'daxing', 'https://bj.lianjia.com/ershoufang/daxing/');
INSERT INTO `districturl` VALUES ('26', 'wh', 'hanyang', 'https://wh.lianjia.com/ershoufang/hanyang/');
INSERT INTO `districturl` VALUES ('27', 'sh', 'huangpu', 'https://sh.lianjia.com/ershoufang/huangpu/');
INSERT INTO `districturl` VALUES ('28', 'bj', 'yizhuangkaifaqu', 'https://bj.lianjia.com/ershoufang/yizhuangkaifaqu/');
INSERT INTO `districturl` VALUES ('29', 'sh', 'jingan', 'https://sh.lianjia.com/ershoufang/jingan/');
INSERT INTO `districturl` VALUES ('30', 'wh', 'donghugaoxin', 'https://wh.lianjia.com/ershoufang/donghugaoxin/');
INSERT INTO `districturl` VALUES ('31', 'bj', 'shunyi', 'https://bj.lianjia.com/ershoufang/shunyi/');
INSERT INTO `districturl` VALUES ('32', 'sh', 'zhabei', 'https://sh.lianjia.com/ershoufang/zhabei/');
INSERT INTO `districturl` VALUES ('33', 'wh', 'jiangxia', 'https://wh.lianjia.com/ershoufang/jiangxia/');
INSERT INTO `districturl` VALUES ('34', 'bj', 'fangshan', 'https://bj.lianjia.com/ershoufang/fangshan/');
INSERT INTO `districturl` VALUES ('35', 'sh', 'hongkou', 'https://sh.lianjia.com/ershoufang/hongkou/');
INSERT INTO `districturl` VALUES ('36', 'sh', 'qingpu', 'https://sh.lianjia.com/ershoufang/qingpu/');
INSERT INTO `districturl` VALUES ('37', 'bj', 'mentougou', 'https://bj.lianjia.com/ershoufang/mentougou/');
INSERT INTO `districturl` VALUES ('38', 'sh', 'fengxian', 'https://sh.lianjia.com/ershoufang/fengxian/');
INSERT INTO `districturl` VALUES ('39', 'bj', 'pinggu', 'https://bj.lianjia.com/ershoufang/pinggu/');
INSERT INTO `districturl` VALUES ('40', 'sh', 'jinshan', 'https://sh.lianjia.com/ershoufang/jinshan/');
INSERT INTO `districturl` VALUES ('41', 'bj', 'huairou', 'https://bj.lianjia.com/ershoufang/huairou/');
INSERT INTO `districturl` VALUES ('42', 'sh', 'chongming', 'https://sh.lianjia.com/ershoufang/chongming/');
INSERT INTO `districturl` VALUES ('43', 'bj', 'miyun', 'https://bj.lianjia.com/ershoufang/miyun/');
INSERT INTO `districturl` VALUES ('44', 'sh', 'shanghaizhoubian', 'https://sh.lianjia.com/ershoufang/shanghaizhoubian/');
INSERT INTO `districturl` VALUES ('45', 'bj', 'yanqing', 'https://bj.lianjia.com/ershoufang/yanqing/');
INSERT INTO `districturl` VALUES ('46', 'bj', 'yanjiao', 'https://bj.lianjia.com/ershoufang/yanjiao/');
INSERT INTO `districturl` VALUES ('47', 'qd', 'shinan', 'https://qd.lianjia.com/ershoufang/shinan/');
INSERT INTO `districturl` VALUES ('48', 'qd', 'shibei', 'https://qd.lianjia.com/ershoufang/shibei/');
INSERT INTO `districturl` VALUES ('49', 'nj', 'gulou', 'https://nj.lianjia.com/ershoufang/gulou/');
INSERT INTO `districturl` VALUES ('50', 'nj', 'jianye', 'https://nj.lianjia.com/ershoufang/jianye/');
INSERT INTO `districturl` VALUES ('51', 'qd', 'licang', 'https://qd.lianjia.com/ershoufang/licang/');
INSERT INTO `districturl` VALUES ('52', 'nj', 'qinhuai', 'https://nj.lianjia.com/ershoufang/qinhuai/');
INSERT INTO `districturl` VALUES ('53', 'qd', 'laoshan', 'https://qd.lianjia.com/ershoufang/laoshan/');
INSERT INTO `districturl` VALUES ('54', 'nj', 'xuanwu', 'https://nj.lianjia.com/ershoufang/xuanwu/');
INSERT INTO `districturl` VALUES ('55', 'qd', 'sifang', 'https://qd.lianjia.com/ershoufang/sifang/');
INSERT INTO `districturl` VALUES ('56', 'nj', 'yuhuatai', 'https://nj.lianjia.com/ershoufang/yuhuatai/');
INSERT INTO `districturl` VALUES ('57', 'qd', 'huangdao', 'https://qd.lianjia.com/ershoufang/huangdao/');
INSERT INTO `districturl` VALUES ('58', 'nj', 'qixia', 'https://nj.lianjia.com/ershoufang/qixia/');
INSERT INTO `districturl` VALUES ('59', 'qd', 'chengyang', 'https://qd.lianjia.com/ershoufang/chengyang/');
INSERT INTO `districturl` VALUES ('60', 'nj', 'jiangning', 'https://nj.lianjia.com/ershoufang/jiangning/');
INSERT INTO `districturl` VALUES ('61', 'qd', 'jiaozhou', 'https://qd.lianjia.com/ershoufang/jiaozhou/');
INSERT INTO `districturl` VALUES ('62', 'nj', 'pukou', 'https://nj.lianjia.com/ershoufang/pukou/');
INSERT INTO `districturl` VALUES ('63', 'qd', 'jiaonan', 'https://qd.lianjia.com/ershoufang/jiaonan/');
INSERT INTO `districturl` VALUES ('64', 'nj', 'liuhe', 'https://nj.lianjia.com/ershoufang/liuhe/');
INSERT INTO `districturl` VALUES ('65', 'qd', 'jimo', 'https://qd.lianjia.com/ershoufang/jimo/');
INSERT INTO `districturl` VALUES ('66', 'nj', 'lishui', 'https://nj.lianjia.com/ershoufang/lishui/');
INSERT INTO `districturl` VALUES ('67', 'qd', 'pingdu', 'https://qd.lianjia.com/ershoufang/pingdu/');
INSERT INTO `districturl` VALUES ('68', 'nj', 'gaochun', 'https://nj.lianjia.com/ershoufang/gaochun/');
INSERT INTO `districturl` VALUES ('69', 'qd', 'laixi', 'https://qd.lianjia.com/ershoufang/laixi/');
INSERT INTO `districturl` VALUES ('70', 'tj', 'heping', 'https://tj.lianjia.com/ershoufang/heping/');
INSERT INTO `districturl` VALUES ('71', 'tj', 'nankai', 'https://tj.lianjia.com/ershoufang/nankai/');
INSERT INTO `districturl` VALUES ('72', 'tj', 'hexi', 'https://tj.lianjia.com/ershoufang/hexi/');
INSERT INTO `districturl` VALUES ('73', 'tj', 'hebei', 'https://tj.lianjia.com/ershoufang/hebei/');
INSERT INTO `districturl` VALUES ('74', 'tj', 'hedong', 'https://tj.lianjia.com/ershoufang/hedong/');
INSERT INTO `districturl` VALUES ('75', 'tj', 'hongqiao', 'https://tj.lianjia.com/ershoufang/hongqiao/');
INSERT INTO `districturl` VALUES ('76', 'tj', 'xiqing', 'https://tj.lianjia.com/ershoufang/xiqing/');
INSERT INTO `districturl` VALUES ('77', 'tj', 'beichen', 'https://tj.lianjia.com/ershoufang/beichen/');
INSERT INTO `districturl` VALUES ('78', 'tj', 'dongli', 'https://tj.lianjia.com/ershoufang/dongli/');
INSERT INTO `districturl` VALUES ('79', 'tj', 'jinnan', 'https://tj.lianjia.com/ershoufang/jinnan/');
INSERT INTO `districturl` VALUES ('80', 'tj', 'tanggu', 'https://tj.lianjia.com/ershoufang/tanggu/');
INSERT INTO `districturl` VALUES ('81', 'tj', 'kaifaqutj', 'https://tj.lianjia.com/ershoufang/kaifaqutj/');
INSERT INTO `districturl` VALUES ('82', 'sz', 'luohuqu', 'https://sz.lianjia.com/ershoufang/luohuqu/');
INSERT INTO `districturl` VALUES ('83', 'sz', 'futianqu', 'https://sz.lianjia.com/ershoufang/futianqu/');
INSERT INTO `districturl` VALUES ('84', 'sz', 'nanshanqu', 'https://sz.lianjia.com/ershoufang/nanshanqu/');
INSERT INTO `districturl` VALUES ('85', 'sz', 'yantianqu', 'https://sz.lianjia.com/ershoufang/yantianqu/');
INSERT INTO `districturl` VALUES ('86', 'sz', 'baoanqu', 'https://sz.lianjia.com/ershoufang/baoanqu/');
INSERT INTO `districturl` VALUES ('87', 'sz', 'longgangqu', 'https://sz.lianjia.com/ershoufang/longgangqu/');
INSERT INTO `districturl` VALUES ('88', 'sz', 'longhuaqu', 'https://sz.lianjia.com/ershoufang/longhuaqu/');
INSERT INTO `districturl` VALUES ('89', 'sz', 'guangmingxinqu', 'https://sz.lianjia.com/ershoufang/guangmingxinqu/');
INSERT INTO `districturl` VALUES ('90', 'sz', 'pingshanqu', 'https://sz.lianjia.com/ershoufang/pingshanqu/');
INSERT INTO `districturl` VALUES ('91', 'sz', 'dapengxinqu', 'https://sz.lianjia.com/ershoufang/dapengxinqu/');
INSERT INTO `districturl` VALUES ('92', 'cd', 'jinjiang', 'https://cd.lianjia.com/ershoufang/jinjiang/');
INSERT INTO `districturl` VALUES ('93', 'cd', 'qingyang', 'https://cd.lianjia.com/ershoufang/qingyang/');
INSERT INTO `districturl` VALUES ('94', 'cd', 'wuhou', 'https://cd.lianjia.com/ershoufang/wuhou/');
INSERT INTO `districturl` VALUES ('95', 'cd', 'gaoxin7', 'https://cd.lianjia.com/ershoufang/gaoxin7/');
INSERT INTO `districturl` VALUES ('96', 'cd', 'chenghua', 'https://cd.lianjia.com/ershoufang/chenghua/');
INSERT INTO `districturl` VALUES ('97', 'cd', 'jinniu', 'https://cd.lianjia.com/ershoufang/jinniu/');
INSERT INTO `districturl` VALUES ('98', 'cd', 'tianfuxinqu', 'https://cd.lianjia.com/ershoufang/tianfuxinqu/');
INSERT INTO `districturl` VALUES ('99', 'cd', 'shuangliu', 'https://cd.lianjia.com/ershoufang/shuangliu/');
INSERT INTO `districturl` VALUES ('100', 'cd', 'wenjiang', 'https://cd.lianjia.com/ershoufang/wenjiang/');
INSERT INTO `districturl` VALUES ('101', 'cd', 'pidou', 'https://cd.lianjia.com/ershoufang/pidou/');
INSERT INTO `districturl` VALUES ('102', 'cd', 'longquanyi', 'https://cd.lianjia.com/ershoufang/longquanyi/');
INSERT INTO `districturl` VALUES ('103', 'cd', 'xindou', 'https://cd.lianjia.com/ershoufang/xindou/');
INSERT INTO `districturl` VALUES ('104', 'cd', 'gaoxinxi1', 'https://cd.lianjia.com/ershoufang/gaoxinxi1/');
INSERT INTO `districturl` VALUES ('105', 'dl', 'ganjingzi', 'https://dl.lianjia.com/ershoufang/ganjingzi/');
INSERT INTO `districturl` VALUES ('106', 'dl', 'shahekou', 'https://dl.lianjia.com/ershoufang/shahekou/');
INSERT INTO `districturl` VALUES ('107', 'dl', 'zhongshan', 'https://dl.lianjia.com/ershoufang/zhongshan/');
INSERT INTO `districturl` VALUES ('108', 'dl', 'xigang', 'https://dl.lianjia.com/ershoufang/xigang/');
INSERT INTO `districturl` VALUES ('109', 'dl', 'gaoxinyuanqu', 'https://dl.lianjia.com/ershoufang/gaoxinyuanqu/');
INSERT INTO `districturl` VALUES ('110', 'dl', 'kaifaqudl', 'https://dl.lianjia.com/ershoufang/kaifaqudl/');
INSERT INTO `districturl` VALUES ('111', 'dl', 'jinzhou', 'https://dl.lianjia.com/ershoufang/jinzhou/');
INSERT INTO `districturl` VALUES ('112', 'cq', 'jiangbei', 'https://cq.lianjia.com/ershoufang/jiangbei/');
INSERT INTO `districturl` VALUES ('113', 'cq', 'yubei', 'https://cq.lianjia.com/ershoufang/yubei/');
INSERT INTO `districturl` VALUES ('114', 'cq', 'nanan', 'https://cq.lianjia.com/ershoufang/nanan/');
INSERT INTO `districturl` VALUES ('115', 'cq', 'banan', 'https://cq.lianjia.com/ershoufang/banan/');
INSERT INTO `districturl` VALUES ('116', 'cq', 'shapingba', 'https://cq.lianjia.com/ershoufang/shapingba/');
INSERT INTO `districturl` VALUES ('117', 'cq', 'jiulongpo', 'https://cq.lianjia.com/ershoufang/jiulongpo/');
INSERT INTO `districturl` VALUES ('118', 'cq', 'yuzhong', 'https://cq.lianjia.com/ershoufang/yuzhong/');
INSERT INTO `districturl` VALUES ('119', 'cq', 'dadukou', 'https://cq.lianjia.com/ershoufang/dadukou/');
INSERT INTO `districturl` VALUES ('120', 'cq', 'jiangjing', 'https://cq.lianjia.com/ershoufang/jiangjing/');
INSERT INTO `districturl` VALUES ('121', 'jn', 'lixia', 'https://jn.lianjia.com/ershoufang/lixia/');
INSERT INTO `districturl` VALUES ('122', 'jn', 'shizhong', 'https://jn.lianjia.com/ershoufang/shizhong/');
INSERT INTO `districturl` VALUES ('123', 'jn', 'tianqiao', 'https://jn.lianjia.com/ershoufang/tianqiao/');
INSERT INTO `districturl` VALUES ('124', 'jn', 'licheng', 'https://jn.lianjia.com/ershoufang/licheng/');
INSERT INTO `districturl` VALUES ('125', 'gz', 'tianhe', 'https://gz.lianjia.com/ershoufang/tianhe/');
INSERT INTO `districturl` VALUES ('126', 'jn', 'huaiyin', 'https://jn.lianjia.com/ershoufang/huaiyin/');
INSERT INTO `districturl` VALUES ('127', 'gz', 'yuexiu', 'https://gz.lianjia.com/ershoufang/yuexiu/');
INSERT INTO `districturl` VALUES ('128', 'jn', 'gaoxin', 'https://jn.lianjia.com/ershoufang/gaoxin/');
INSERT INTO `districturl` VALUES ('129', 'gz', 'liwan', 'https://gz.lianjia.com/ershoufang/liwan/');
INSERT INTO `districturl` VALUES ('130', 'jn', 'hainan', 'https://jn.lianjia.com/ershoufang/hainan/');
INSERT INTO `districturl` VALUES ('131', 'gz', 'haizhu', 'https://gz.lianjia.com/ershoufang/haizhu/');
INSERT INTO `districturl` VALUES ('132', 'jn', 'pingyin', 'https://jn.lianjia.com/ershoufang/pingyin/');
INSERT INTO `districturl` VALUES ('133', 'gz', 'panyu', 'https://gz.lianjia.com/ershoufang/panyu/');
INSERT INTO `districturl` VALUES ('134', 'jn', 'jiyang', 'https://jn.lianjia.com/ershoufang/jiyang/');
INSERT INTO `districturl` VALUES ('135', 'gz', 'baiyun', 'https://gz.lianjia.com/ershoufang/baiyun/');
INSERT INTO `districturl` VALUES ('136', 'jn', 'shanghe', 'https://jn.lianjia.com/ershoufang/shanghe/');
INSERT INTO `districturl` VALUES ('137', 'gz', 'huangpugz', 'https://gz.lianjia.com/ershoufang/huangpugz/');
INSERT INTO `districturl` VALUES ('138', 'gz', 'conghua', 'https://gz.lianjia.com/ershoufang/conghua/');
INSERT INTO `districturl` VALUES ('139', 'gz', 'zengcheng', 'https://gz.lianjia.com/ershoufang/zengcheng/');
INSERT INTO `districturl` VALUES ('140', 'gz', 'huadou', 'https://gz.lianjia.com/ershoufang/huadou/');
INSERT INTO `districturl` VALUES ('141', 'gz', 'luogang', 'https://gz.lianjia.com/ershoufang/luogang/');
INSERT INTO `districturl` VALUES ('142', 'gz', 'nansha', 'https://gz.lianjia.com/ershoufang/nansha/');
INSERT INTO `districturl` VALUES ('143', 'hz', 'xihu', 'https://hz.lianjia.com/ershoufang/xihu/');
INSERT INTO `districturl` VALUES ('144', 'hz', 'xiacheng', 'https://hz.lianjia.com/ershoufang/xiacheng/');
INSERT INTO `districturl` VALUES ('145', 'hz', 'jianggan', 'https://hz.lianjia.com/ershoufang/jianggan/');
INSERT INTO `districturl` VALUES ('146', 'hz', 'gongshu', 'https://hz.lianjia.com/ershoufang/gongshu/');
INSERT INTO `districturl` VALUES ('147', 'hz', 'shangcheng', 'https://hz.lianjia.com/ershoufang/shangcheng/');
INSERT INTO `districturl` VALUES ('148', 'hz', 'binjiang', 'https://hz.lianjia.com/ershoufang/binjiang/');
INSERT INTO `districturl` VALUES ('149', 'hz', 'yuhang', 'https://hz.lianjia.com/ershoufang/yuhang/');
INSERT INTO `districturl` VALUES ('150', 'hz', 'xiaoshan', 'https://hz.lianjia.com/ershoufang/xiaoshan/');
INSERT INTO `districturl` VALUES ('151', 'hz', 'xiasha', 'https://hz.lianjia.com/ershoufang/xiasha/');
INSERT INTO `districturl` VALUES ('152', 'xm', 'siming', 'https://xm.lianjia.com/ershoufang/siming/');
INSERT INTO `districturl` VALUES ('153', 'xm', 'huli', 'https://xm.lianjia.com/ershoufang/huli/');
INSERT INTO `districturl` VALUES ('154', 'xm', 'haicang', 'https://xm.lianjia.com/ershoufang/haicang/');
INSERT INTO `districturl` VALUES ('155', 'xm', 'jimei', 'https://xm.lianjia.com/ershoufang/jimei/');
INSERT INTO `districturl` VALUES ('156', 'xm', 'xiangan', 'https://xm.lianjia.com/ershoufang/xiangan/');
INSERT INTO `districturl` VALUES ('157', 'xm', 'tongan', 'https://xm.lianjia.com/ershoufang/tongan/');
INSERT INTO `districturl` VALUES ('158', 'cs', 'yuhua', 'https://cs.lianjia.com/ershoufang/yuhua/');
INSERT INTO `districturl` VALUES ('159', 'cs', 'yuelu', 'https://cs.lianjia.com/ershoufang/yuelu/');
INSERT INTO `districturl` VALUES ('160', 'cs', 'tianxin', 'https://cs.lianjia.com/ershoufang/tianxin/');
INSERT INTO `districturl` VALUES ('161', 'cs', 'kaifu', 'https://cs.lianjia.com/ershoufang/kaifu/');
INSERT INTO `districturl` VALUES ('162', 'cs', 'furong', 'https://cs.lianjia.com/ershoufang/furong/');
INSERT INTO `districturl` VALUES ('163', 'sy', 'tiexi', 'https://sy.lianjia.com/ershoufang/tiexi/');
INSERT INTO `districturl` VALUES ('164', 'sy', 'heping1', 'https://sy.lianjia.com/ershoufang/heping1/');
INSERT INTO `districturl` VALUES ('165', 'sy', 'shenhe', 'https://sy.lianjia.com/ershoufang/shenhe/');
INSERT INTO `districturl` VALUES ('166', 'sy', 'hunnanxinqu', 'https://sy.lianjia.com/ershoufang/hunnanxinqu/');
INSERT INTO `districturl` VALUES ('167', 'sy', 'dadong', 'https://sy.lianjia.com/ershoufang/dadong/');
INSERT INTO `districturl` VALUES ('168', 'sy', 'huanggu', 'https://sy.lianjia.com/ershoufang/huanggu/');
INSERT INTO `districturl` VALUES ('169', 'sy', 'yuhong', 'https://sy.lianjia.com/ershoufang/yuhong/');
INSERT INTO `districturl` VALUES ('170', 'sy', 'sujiatun', 'https://sy.lianjia.com/ershoufang/sujiatun/');
INSERT INTO `districturl` VALUES ('171', 'sy', 'shenbeixinqu', 'https://sy.lianjia.com/ershoufang/shenbeixinqu/');
INSERT INTO `districturl` VALUES ('172', 'hf', 'baohe', 'https://hf.lianjia.com/ershoufang/baohe/');
INSERT INTO `districturl` VALUES ('173', 'hf', 'shushan', 'https://hf.lianjia.com/ershoufang/shushan/');
INSERT INTO `districturl` VALUES ('174', 'hf', 'luyang', 'https://hf.lianjia.com/ershoufang/luyang/');
INSERT INTO `districturl` VALUES ('175', 'hf', 'yaohai', 'https://hf.lianjia.com/ershoufang/yaohai/');
INSERT INTO `districturl` VALUES ('176', 'hf', 'zhengwu', 'https://hf.lianjia.com/ershoufang/zhengwu/');
INSERT INTO `districturl` VALUES ('177', 'hf', 'binhuxinqu', 'https://hf.lianjia.com/ershoufang/binhuxinqu/');
INSERT INTO `districturl` VALUES ('178', 'hf', 'jingkai2', 'https://hf.lianjia.com/ershoufang/jingkai2/');
INSERT INTO `districturl` VALUES ('179', 'hf', 'gaoxin8', 'https://hf.lianjia.com/ershoufang/gaoxin8/');
INSERT INTO `districturl` VALUES ('180', 'hf', 'xinzhan', 'https://hf.lianjia.com/ershoufang/xinzhan/');
INSERT INTO `districturl` VALUES ('181', 'hf', 'feidong', 'https://hf.lianjia.com/ershoufang/feidong/');
INSERT INTO `districturl` VALUES ('182', 'hf', 'feixi', 'https://hf.lianjia.com/ershoufang/feixi/');
INSERT INTO `districturl` VALUES ('183', 'hf', 'changfeng', 'https://hf.lianjia.com/ershoufang/changfeng/');

-- ----------------------------
-- Table structure for `residence`
-- ----------------------------
DROP TABLE IF EXISTS `residence`;
CREATE TABLE `residence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `district` varchar(100) DEFAULT NULL,
  `districtid` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `cityid` varchar(100) DEFAULT NULL,
  `xiaoqu` varchar(100) DEFAULT NULL,
  `xiaoquid` varchar(100) DEFAULT NULL,
  `jiage` decimal(8,2) DEFAULT NULL,
  `danjia` decimal(8,2) DEFAULT NULL,
  `area` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of residence
-- ----------------------------
INSERT INTO `residence` VALUES ('1', '1245t45t45t54t54t5453', null, null, null, null, null, null, null, null, null);
