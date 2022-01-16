
-- 기존 user(account)
CREATE TABLE banking.user(
  `userIdx` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) COLLATE utf8_bin NOT NULL,
  `userAccount` int(8) zerofill NOT NULL,
  `balance`  int default 0,
  `rate` DECIMAL(2,1) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userIdx`),
  UNIQUE KEY `unique_userAccount` (`userAccount`)
) ;

drop table banking.user;

-- 같은 이름으로 여러개의 계좌를 오픈할 수 있다.
-- 동명이인은 없다. 
-- rate 소수점 첫째 자리까지 표현한다. 
-- userAccount는 - 를 저장하지 않는다. 
-- balance는 반올림한 값이다. 

CREATE TABLE banking.transfer(
  `transferIdx` int NOT NULL AUTO_INCREMENT,
  `fromAccount` int(8) zerofill NOT NULL,
  `toAccount` int(8) zerofill NOT NULL,
  `transferAmount` int NOT NULL,
  `transferDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transferIdx`),
  KEY `fk_fromAccount_tr` (`fromAccount`),
  KEY `fk_toAccount_tr` (`toAccount`),
  CONSTRAINT `fk_fromAccount_tr` FOREIGN KEY (`fromAccount`) REFERENCES `user` (`userAccount`) ON DELETE CASCADE,
  CONSTRAINT `fk_toAccount_tr` FOREIGN KEY (`toAccount`) REFERENCES `user` (`userAccount`) ON DELETE CASCADE
) ;

CREATE TABLE banking.transfer(
  `transferIdx` int NOT NULL AUTO_INCREMENT,
  `fromIdx` int NOT NULL,
  `toIdx` int not NULL,
  `transferAmount` int NOT NULL,
  `transferDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`transferIdx`),
  KEY `fk_fromIdx_tr` (`fromIdx`),
  KEY `fk_toIdx_tr` (`toIdx`),
  CONSTRAINT `fk_fromIdx_tr` FOREIGN KEY (`fromIdx`) REFERENCES `user` (`userIdx`) ON DELETE CASCADE,
  CONSTRAINT `fk_toIdx_tr` FOREIGN KEY (`toIdx`) REFERENCES `user` (`userIdx`) ON DELETE CASCADE
) ;
drop table transfer;
-- 이체 : 한계좌에서 다른 계좌로 돈 보내기
-- 계좌만 다르면 된다. 내가 내계좌로 보내는것  + 내가 남 계좌로 보내기
-- 이체한다 1. 이체 내역을 저장한다. 2. 이체하고 나서 2개의 계좌 balance를 바꿔준다.


-- 입금
CREATE TABLE banking.deposit(
  `depositIdx` int NOT NULL AUTO_INCREMENT,
  `userAccount` int(8) zerofill NOT NULL,
  `depositAmount` int NOT NULL,
  `depositDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`depositIdx`),
  KEY `fk_userAccount_di` (`userAccount`),
  CONSTRAINT `fk_userAccount_di` FOREIGN KEY (`userAccount`) REFERENCES `user` (`userAccount`) ON DELETE CASCADE
) ;
CREATE TABLE banking.deposit(
  `depositIdx` int NOT NULL AUTO_INCREMENT,
  `userIdx` int NOT NULL,
  `depositAmount` int NOT NULL,
  `depositDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`depositIdx`),
  KEY `fk_userIdx_di` (`userIdx`),
  CONSTRAINT `fk_userIdx_di` FOREIGN KEY (`userIdx`) REFERENCES `user` (`userIdx`) ON DELETE CASCADE
) ;
drop table deposit;
-- 입금은 오로지 내계좌만 된다.
-- 1. 입금한다. 2. 내계좌인지 확인한다.(?) -- 사용자 이름으로 확인
-- 3. 내 계좌이면 입금내역을 저장한다. 4. 입금 하고 나서 balance를 바꿔준다.

-- 출금
CREATE TABLE banking.withdraw(
  `withdrawalIdx` int NOT NULL AUTO_INCREMENT,
  `userAccount` int(8) zerofill NOT NULL,
  `withdrawalAmount` int NOT NULL,
  `withdrawalDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`withdrawalIdx`),
  KEY `fk_userAccount_wi` (`userAccount`),
  CONSTRAINT `fk_userAccount_wi` FOREIGN KEY (`userAccount`) REFERENCES `user` (`userAccount`) ON DELETE CASCADE
) ;
CREATE TABLE banking.withdraw(
  `withdrawalIdx` int NOT NULL AUTO_INCREMENT,
  `userIdx` int NOT NULL,
  `withdrawalAmount` int NOT NULL,
  `withdrawalDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`withdrawalIdx`),
  KEY `fk_userIdx_wi` (`userIdx`),
  CONSTRAINT `fk_userIdx_wi` FOREIGN KEY (`userIdx`) REFERENCES `user` (`userIdx`) ON DELETE CASCADE
) ;
drop table withdraw;
-- 출금 : 내계좌만 가능
-- 1. 사용자 이름으로 해당 계좌 학인
-- 2. 출금한다 -> 출금 할때 현재 balance확인해서, balance보다 적게 출금하기
-- 3. 출금 완료 -> 출금내역에 저장

select @@global.time_zone;