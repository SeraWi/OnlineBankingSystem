<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		font-size : 15px;
		margin-bottom:15px;
	}
	body{
		margin-top:50px;
		margin-left: 70px;
		margin-right:70px;
	}

</style>
</head>
<body>
	<h1> [이체 완료 ]</h1>
	<hr>
	
	<h1> ${toInfo.userName}님의 ${toInfo.toAccount2} 계좌로 ${toInfo.transferAmount}원 입금이 완료되었습니다.</h1>
	<div>
		<h1>출금계좌 : ${accountInfo.account}</h1>
		<h1>이체 후 잔액 : ${accountInfo.balance}</h1>
	</div>

</body>
</html>