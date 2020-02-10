CREATE TABLE `mall`.`red_packet`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '红包主键',
  `userId` int(12) NOT NULL DEFAULT 0 COMMENT '发红包用户id',
  `amount` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '红包总金额',
  `sendDate` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发放时间',
  `total` int(12) NOT NULL DEFAULT 0 COMMENT '红包总数',
  `perAmount` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '单个红包金额',
  `stock` int(12) NOT NULL DEFAULT 0 COMMENT '剩余红包数',
  `version` int(12) NOT NULL DEFAULT 0 COMMENT '版本',
  `note` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 COMMENT = 'red_packet';

CREATE TABLE `mall`.`user_red_packet`  (
  `id` int(12) NOT NULL AUTO_INCREMENT COMMENT '抢红包主键id',
  `redPacketId` int(12) NOT NULL DEFAULT 0 COMMENT '红包主键id',
  `userId` int(12) NOT NULL DEFAULT 0 COMMENT '用户id',
  `perAmount` decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '抢红包金额',
  `grabTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '抢红包时间',
  `note` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 COMMENT = '抢红包表';

insert into red_packet (userId, amount, sendDate, total, perAmount, stock, version, note) values (23119313, 200000, now(), 20000, 10, 20000, 1, '第一个红包');
insert into red_packet (userId, amount, sendDate, total, perAmount, stock, version, note) values (23119313, 200000, now(), 20000, 10, 20000, 1, '第二个红包');
insert into red_packet (userId, amount, sendDate, total, perAmount, stock, version, note) values (23119313, 200000, now(), 20000, 10, 20000, 1, '第三个红包');
insert into red_packet (userId, amount, sendDate, total, perAmount, stock, version, note) values (23119313, 200000, now(), 20000, 10, 20000, 1, '第四个红包');
insert into red_packet (userId, amount, sendDate, total, perAmount, stock, version, note) values (23119313, 200000, now(), 20000, 10, 20000, 1, '第五个红包');
insert into red_packet (userId, amount, sendDate, total, perAmount, stock, version, note) values (23119313, 200000, now(), 20000, 10, 20000, 1, '第六个红包');