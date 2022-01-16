# OnlineBankingSystem
Online Banking System 구현하기

사용한 기술 스택 : Java8, Spring framework 4.3.18, MySql, javascript, jQuery
DB:user(사용자정보), account(계좌정보), deposit(입금내역), withdraw(출금내역), transfer(이체내역)

API 구현
계좌 생성 
랜덤으로 8자리의 중복되지 않는 계좌번호를 생성하였습니다. 
이율은 0.1%이상 9.9%이하의 랜덤 숫자로 생성하였습니다. 
계좌 생성 시 잔액은 default로 0으로 하여 insert하였습니다.
계좌 조회 
userIdx로 사용자가 소유한 전체 계좌 정보를 반환합니다.
입금 
사용자가 소유한 전체 계좌 정보 중 특정 계좌를 선택하여 입금합니다. 
자바스크립트로 입금액이 음수인 경우와 0인 경우를 확인합니다. 
user 테이블의 잔액을 변경하고, deposit 테이블에 입금내역을 insert합니다. 입금 후 정보를 비동기통신으로 반환합니다. 
출금 
사용자가 소유한 전체 계좌 중 특정 계좌를 선택하여 출금합니다. 
자바스크립트로 현재 잔고보다 큰 금액을 출금하려는 경우, 출금액이 음수인경우, 출금액이 0인 경우를 확인합니다.  
user 테이블의 잔액을 변경하고, withdraw 테이블에 출금 내역을 insert합니다.
이체 
사용자의 출금계좌를 선택합니다. 
이체하고자 하는 금액이 출금계좌의 잔고보다 큰 경우, 이체액이 0이거나 음수인 경우를 자바스크립트로 확인합니다. 
비동기 통신으로 입금하는 계좌번호와 이름이 맞는지 확인합니다. 
이체에 성공하면 user테이블에서 두 계좌의 잔액을 변경하고, transfer 테이블에 이체 내역을 insert합니다.
계좌 내역 조회
입금내역은 입금, 입금 후 잔액, 입금일을 보여줍니다.
출금내역은 출금, 출금 후 잔액, 출금일을 보여줍니다. 
이체 내역은 이체하거나 이체받은 계좌번호, 이체액, 이체 출금 혹은 입금, 사용자 이름을 보여줍니다.
