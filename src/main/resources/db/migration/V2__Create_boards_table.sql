CREATE TABLE `boards`
(
`id`bigint(20) NOT NULL AUTO_INCREMENT,
`title` varchar(30) NOT NULL,
`contents` LONGTEXT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
