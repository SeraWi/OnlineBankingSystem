CREATE TABLE banking.user(
  `userIdx` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) COLLATE utf8_bin NOT NULL,
  `userAccount` varchar(50) COLLATE utf8_bin NOT NULL,
  `balance`  int default 0,
  `rate` DECIMAL(2,1) NOT NULL,
  `accountCreatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userIdx`),
  UNIQUE KEY `unique_userName` (`userName`),
  UNIQUE KEY `unique_userAccount` (`userAccount`)
) ;

drop table banking.user;

-- rate 소수점 표현해야한다.

