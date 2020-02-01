CREATE TABLE `mall`.`pms_brand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '品牌名称',
  `firstLetter` varchar(4) NOT NULL DEFAULT '' COMMENT '首字母',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序字段',
  `factoryStatus` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否品牌制造商，1是，0不是',
  `showStatus` tinyint(2) NOT NULL COMMENT '展示状态1展示，0不展示',
  `proCount` int(11) NOT NULL DEFAULT 0 COMMENT '产品数量',
  `commentCount` int(11) NOT NULL DEFAULT 0 COMMENT '产品评论数量',
  `logo` varchar(100) NOT NULL DEFAULT '' COMMENT '品牌logo',
  `picLoc` varchar(255) NOT NULL DEFAULT '' COMMENT '图片地址',
  `brandStory` varchar(500) NOT NULL DEFAULT '' COMMENT '品牌故事',
  `ctime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `state` tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态，1有效，0无效',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 COMMENT = '品牌表';

INSERT INTO `pms_brand` (name, firstLetter, sort, factoryStatus, showStatus, proCount, commentCount, logo, picLoc, brandStory, ctime, state) VALUES ('万和', 'W', '1', '1', '1', '100', '10000', 'WANHE', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg(5).jpg','Victoria\'s Secret的故事', NOW(), 1);
INSERT INTO `pms_brand` (name, firstLetter, sort, factoryStatus, showStatus, proCount, commentCount, logo, picLoc, brandStory, ctime, state) VALUES ('三星', 'S', '100', '1', '1', '100', '1000', 'SAMXING', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (1).jpg','三星的故事');
INSERT INTO `pms_brand` (name, firstLetter, sort, factoryStatus, showStatus, proCount, commentCount, logo, picLoc, brandStory, ctime, state) VALUES ('华为', 'H', '100', '1', '1', '100', '100', 'HUAWEI', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/17f2dd9756d9d333bee8e60ce8c03e4c_222_222.jpg','Victoria\'s Secret的故事', NOW(), 1);
INSERT INTO `pms_brand` (name, firstLetter, sort, factoryStatus, showStatus, proCount, commentCount, logo, picLoc, brandStory, ctime, state) VALUES ('格力', 'G', '30', '1', '1', '100', '100', 'GRIEE', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/dc794e7e74121272bbe3ce9bc41ec8c3_222_222.jpg','Victoria\'s Secret的故事', NOW(), 1);
INSERT INTO `pms_brand` (name, firstLetter, sort, factoryStatus, showStatus, proCount, commentCount, logo, picLoc, brandStory, ctime, state) VALUES ('方太', 'F', '20', '1', '1', '100', '100', 'FANGTAI', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (4).jpg','Victoria\'s Secret的故事', NOW(), 1);
