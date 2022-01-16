-- user table insert
insert into user(userName)
values('세라');
insert into user(userName)
values('지현');
select * from user;

-- account insert
-- user 계좌 생성
insert into account (userIdx,userName,userAccount,rate)
values(1,'세라',11111, 1.0);
insert into account (userIdx,userName,userAccount,rate)
values(1,'세라',22222, 1.0);
insert into account (userIdx,userName,userAccount,rate)
values(3,'지현',111119, 1.0);

-- account select, 전체 계좌 조회
select * from account;
select * from account where userIdx =1;


select * from deposit;
select * from account;

-- 1. deposit 입금후 잔액 update
update account
set balance = 20000
where accountIdx= 3; 

-- 2. 잔액 반환
select balance
from account
where accountIdx = 1;

-- 3. 입금 내역 insert
select * from deposit;
insert into deposit(accountIdx, depositAmount,currentBalance)
values(1,10000,20000);


-- withdraw
select * from withdraw;
select * from account;
-- 잔액 업데이트
update account
set balance = 8000
where accountIdx = 1;
-- 현재 잔액 반환
select balance
from account
where accountIdx = 1;
-- withdraw 에 insert
insert into withdraw(accountIdx, withdrawalAmount,currentBalance)
values(1,2000,8000);

-- 입금 내역 select
select a.userAccount,d.depositAmount,d.currentBalance, d.depositDate
from deposit d natural join account a
where accountIdx = 1;

-- 출금 내역 select
select a.userAccount,w.withdrawalAmount,w.currentBalance,w.withdrawalDate
from withdraw w natural join account a
where accountIdx =1;

select * from account;

select accountIdx
from account
where userAccount = 00111119;

-- 이체 내역
select * from transfer;
select * from account;

insert into transfer (fromIdx,toIdx,transferAmount)
values(1,6,1000);  -- 1번이 2번에게
insert into transfer (fromIdx,toIdx,transferAmount)
values(6,1,1000); -- 2번이 1번에게 
-- 이체 출금(준거)
select a.userAccount,a.userName, t.transferAmount, t.transferDate
from transfer t inner join account a
on t.toIdx = a.accountIdx
where fromIdx = 1;

-- 이체 입금(받은거)
select a.userAccount,a.userName, t.transferAmount,t.transferDate
from transfer t inner join account a
on t.fromIdx = a.accountIdx
where toIdx = 1;







