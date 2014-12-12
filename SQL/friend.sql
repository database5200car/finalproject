CREATE TABLE `friend` (
  `USERNAMEFR` varchar(255) NOT NULL DEFAULT '',
  `COMMENT` varchar(255) DEFAULT NULL,
  `YEAR` int(11) DEFAULT NULL,
  `usernamefk` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`USERNAMEFR`,`usernamefk`),
  KEY `frineduser` (`usernamefk`),
  KEY `commentfriend` (`COMMENT`),
  CONSTRAINT `commentfriend` FOREIGN KEY (`COMMENT`) REFERENCES `comment` (`commentid`),
  CONSTRAINT `frineduser` FOREIGN KEY (`usernamefk`) REFERENCES `user` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

