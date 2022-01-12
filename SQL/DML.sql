SELECT * FROM banking.user;

-- 계좌 오픈하기 insert
insert into banking.user (userName, userAccount, rate)
values('위세라', 1000, 9.2);
insert into banking.user (userName, userAccount, rate)
values('위세라', 20000, 9.2);
insert into banking.user (userName, userAccount, rate)
values('위세라', 1001, 6.5);
insert into banking.user(userName, userAccount, balance, rate)
values('박주원', 1002, 1006, 2);

-- 이체하기 ( 내 -> 남, 내-> 내)
select * from banking.transfer;
insert into banking.transfer(myIdx, yourIdx, transferAmount)
values(1,3,2000);
insert into banking.transfer(myIdx, yourIdx, transferAmount)
values(1,2,2000);

-- 이체 내역 보기
select u.userName, u.userAccount, t.transferAmount, t.yourIdx
from user as u inner join transfer as t
where u.userIdx = t.myIdx;

select * from deposit;


-- 작성해야 하는 쿼리문
-- 계좌번호를 랜덤으로 생성하고 현재 계좌번호와 겹치지 않게 생성한다.
select *
from user
where userAccount =1000; -- 존재하면 다른 계좌번호 만들기

-- 계좌 오픈하기 insert userName은 세션에 저장되어 있는 userName, 
-- userAccount는 랜덤 생성한 account
-- rate도 랜덤생성한 걸로!

insert into banking.user (userName, userAccount, rate)
values('위세라', 1000, 9.2);

-- 계좌 정보를 반환한다 -> 이름, 계좌번호, 현재 잔고, 생성일, 이율

select *
from user;
select * from user
where userAccount = 1000;



-- 계좌를 조회한다 -> 이름이 같은 사람의 전체 계좌를 조회한다. username이 같은 행을 모두 출력해서 보여주기

select userName, userAccount, balance, rate, createDate
from user
where userName = '위세라';




-- 입금절차
-- 입금액과 입금 계좌가 필요.
-- 입금계좌를 해당 userName으로 조회해서 존재하는 지 확인, 본인거 맞는지 확인(session에 userName을 저장하기?)
-- 입금하기전 입금전 balance * 이율 + 입금액으로 update한다.
-- 계좌 입금내역 저장하기
-- 입금후 잔고를 반환한다. 

select * from deposit;
select * from user;

-- 입금내역 insert
insert into deposit(userAccount, depositAmount)
values(18831361, 2000);

update user
set balance = 100
where userAccount = 18831361 ;

-- 입금내역 update하기
update user
set balance = balance * (1+ rate/100) + 2000
where userAccount = 18831361 ;




-- 출금 
-- 출금액과 출금계좌 확인
-- 출금계좌가 본인것이 맞는지, 출금계좌의 balance를 확인하기
-- 출금하는 계좌 1개의 balance를 select해서 출금하는 금액과 비교하기
-- 비교한뒤 balance보다 작으면 balance를 update하기
-- 계좌 출금 내역을 저장하기 

select * from withdraw;
insert into withdraw (userAccount, withdrawalAmount)
values();

update user
set balance = balance - 20000
where userAccount = 18831361;

select *
from user
where userAccount = 18831361;




-- 이체하기
-- 내 계좌와 보내는 계좌의 balance를 update 하기 + 이체 내역에 저장하기
-- 내 계좌의 balance가 이체금 보다 작은경우실행한다.


