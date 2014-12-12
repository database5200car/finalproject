CREATE TABLE `model` (
  `carid` int(11) NOT NULL DEFAULT '0',
  `model` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`carid`),
  KEY `makemodel` (`model`),
  CONSTRAINT `makemodel` FOREIGN KEY (`model`) REFERENCES `make` (`model`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

