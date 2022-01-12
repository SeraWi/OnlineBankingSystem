<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입금, 출금, 이체 내역 조회</title>
<style>
	*{
		font-size : 25px;
		margin-bottom:15px;
	}
	body{
		margin-top:50px;
		margin-left: 70px;
	}

</style>
</head>
<body>

	<h2> ${userVo.userName}님의  계좌 번호  거래내역을 조회합니다.</h2>
	
	<h2> 입금 내역</h2>
	<c:forEach var="dinfos" items="${depositInfos}" >
			<div>
				입금일 :${dinfos.depositDate}
				입금액 :${dinfos.depositAmount}
			</div>
	</c:forEach>
	
	<hr>
	<h2> 출금 내역</h2>
	<c:forEach var="winfos" items="${withdrawInfos}" >
			<div>
				출금일 :${winfos.withdrawalDate}
				출금액 :${winfos.withdrawalAmount}
			</div>
	</c:forEach> 
	<hr>
	
	<h2> 이체 내역</h2>
	<c:forEach var="tinfos" items="${transferInfos}" >
			<div>
				이체계좌 : ${tinfos.userAccount}
				이체일 :${tinfos.transferDate}
				이체액 :${tinfos.transferAmount}
			</div>
	</c:forEach>
	
	
	
</body>
</html>