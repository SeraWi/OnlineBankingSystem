select * from transfer;
select * from user;

insert into transfer(fromAccount, toAccount, transferAmount)
values(30915375,55650875,300);

update user
set balance = balance - 300
where userAccount =30915375;

update user
set balance = balance + 300
where userAccount =55650875;

-- 거래 내역 조회
-- 계좌 내역 조회 : 특정 계좌의 입금/출금/이체 내역을 반환

-- 입금 내역
select *
from deposit
where userAccount = 30764194;







