CREATE TABLE `favorite` (
  `favoriteid` int(255) NOT NULL,
  `userfavfk` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`favoriteid`,`userfavfk`),
  KEY `Usernamefav` (`userfavfk`),
  CONSTRAINT `Usernamefav` FOREIGN KEY (`userfavfk`) REFERENCES `user` (`USERNAME`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

