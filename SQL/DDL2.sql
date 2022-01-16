-- usertable 생성
CREATE TABLE banking.user(
	`userIdx` int NOT NULL AUTO_INCREMENT,
	`userName` varchar(50) COLLATE utf8_bin NOT NULL,
    `joinDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`userIdx`, `userName`),
    UNIQUE KEY `unique_userName` (`userName`)
);

drop table user;
-- 회원 정보 테이블
-- userIdx pk / userName (사용자 이름) unique / 가입일 


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
  
-- KEY `fk_userName_ac` (`userName`),
--  CONSTRAINT `fk_userName_ac` FOREIGN KEY (`userName`) REFERENCES `user` (`userName`) ON DELETE CASCADE
drop table banking.account2;


-- 같은 이름으로 여러개의 계좌를 오픈할 수 있다.
-- 동명이인은 없다. 
-- rate 소수점 첫째 자리까지 표현한다. 
-- userAccount는 - 를 저장하지 않는다. 
-- balance는 반올림한 값이다. 


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
drop table transfer;
-- 이체 : 한계좌에서 다른 계좌로 돈 보내기
-- 계좌만 다르면 된다. 내가 내계좌로 보내는것  + 내가 남 계좌로 보내기
-- 이체한다 1. 이체 내역을 저장한다. 2. 이체하고 나서 2개의 계좌 balance를 바꿔준다.


-- 입금
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
drop table deposit;
-- 입금은 오로지 내계좌만 된다.
-- 1. 입금한다. 2. 내계좌인지 확인한다.(?) -- 사용자 이름으로 확인
-- 3. 내 계좌이면 입금내역을 저장한다. 4. 입금 하고 나서 balance를 바꿔준다.

-- 출금
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
drop table withdraw;
-- 출금 : 내계좌만 가능
-- 1. 사용자 이름으로 해당 계좌 학인
-- 2. 출금한다 -> 출금 할때 현재 balance확인해서, balance보다 적게 출금하기
-- 3. 출금 완료 -> 출금내역에 저장

select @@global.time_zone;