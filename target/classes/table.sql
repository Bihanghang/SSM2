DROP TABLE IF EXISTS `datasource`;
CREATE TABLE `datasource` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
insert into datasource(name) values ('ssm1DataSource');
insert into datasource(name) values ('ssm2DataSource');

