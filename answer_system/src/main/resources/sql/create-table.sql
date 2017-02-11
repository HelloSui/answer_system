USE DATABASE answer_system;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '登录名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


