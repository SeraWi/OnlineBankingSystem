-- 사용자정보
CREATE TABLE banking.user(
	`userIdx` int NOT NULL AUTO_INCREMENT,
	`userName` varchar(50) COLLATE utf8_bin NOT NULL,
    `joinDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`userIdx`, `userName`),
    UNIQUE KEY `unique_userName` (`userName`)
);


-- 사용자 정보 저장
insert into user(userName)values('sera123456');
insert into user(userName)values('tim123456');
insert into user(userName)values('mia123456');
insert into user(userName)values('julia123');
insert into user(userName)values('harry123');

-- 계좌 정보
CREATE TABLE banking.account(
  `accountIdx` int NOT NULL AUTO_INCREMENT,
  `userIdx` int NOT NULL,
  `userName` varchar(50) COLLATE utf8_bin NOT NULL,
  `userAccount` int(8) zerofill NOT NULL,
  `balance`  int default 0,
  `rate` DECIMAL(2,1) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`accountIdx`),
  UNIQUE KEY `unique_userAccount` (`userAccount`),
  KEY `fk_userIdx_ac` (`userIdx`),
  CONSTRAINT `fk_userIdx_ac` FOREIGN KEY (`userIdx`) REFERENCES `user` (`userIdx`) ON DELETE CASCADE,
  KEY `fk_userName_ac` (`userName`),
  CONSTRAINT `fk_userName_ac` FOREIGN KEY (`userName`) REFERENCES `user` (`userName`) ON DELETE CASCADE
  ) ;
  
  
  -- 이체 내역
  CREATE TABLE banking.transfer(
  `transferIdx` int NOT NULL AUTO_INCREMENT,
  `fromIdx` int NOT NULL,
  `toIdx` int not NULL,
  `transferAmount` int NOT NULL,
  `transferDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transferIdx`),
  KEY `fk_fromIdx2_tr` (`fromIdx`),
  CONSTRAINT `fk_fromIdx2_tr` FOREIGN KEY (`fromIdx`) REFERENCES `account` (`accountIdx`) ON DELETE CASCADE,
   KEY `fk_toIdx2_tr` (`toIdx`),
  CONSTRAINT `fk_toIdx2_tr` FOREIGN KEY (`toIdx`) REFERENCES `account` (`accountIdx`) ON DELETE CASCADE
) ;

-- 입금 내역
CREATE TABLE banking.deposit(
  `depositIdx` int NOT NULL AUTO_INCREMENT,
  `accountIdx` int NOT NULL,
  `depositAmount` int NOT NULL,
  `currentBalance` int NOT Null,
  `depositDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`depositIdx`),
  KEY `fk_accountIdx_di` (`accountIdx`),
  CONSTRAINT `fk_accountIdx_di` FOREIGN KEY (`accountIdx`) REFERENCES `account` (`accountIdx`) ON DELETE CASCADE
) ;

-- 출금 내역
CREATE TABLE banking.withdraw(
  `withdrawalIdx` int NOT NULL AUTO_INCREMENT,
  `accountIdx` int NOT NULL,
  `withdrawalAmount` int NOT NULL,
  `currentBalance` int NOT Null,
  `withdrawalDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`withdrawalIdx`),
  KEY `fk_accountIdx_wi` (`accountIdx`),
  CONSTRAINT `fk_accountIdx_wi` FOREIGN KEY (`accountIdx`) REFERENCES `account` (`accountIdx`) ON DELETE CASCADE
) ;

drop table user;
drop table withdraw;
drop table deposit;
drop table account;
drop table transfer;