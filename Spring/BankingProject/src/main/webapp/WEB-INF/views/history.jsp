<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 내역</title>
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
	
	<h2> 현재 userName : ${userVo.userName} </h2>
	
	<h2> 계좌번호를 누르면 입금,출금,이체 내역을 확인할 수 있습니다.</h2>
	
	<c:forEach var="infos" items="${allAccount}" >
			<div>
				<!-- <input type="radio" name ="info">  --> 
				계좌 번호: <a href="<c:url value='/history/details/${infos.userAccount}'/>">${infos.account}</a>
				현재 잔고 : ${infos.balance}
				이율 : ${infos.rate}
			</div>
	</c:forEach>
	
	
	
	
	
	
</body>
</html>