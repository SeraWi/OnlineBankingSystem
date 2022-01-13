<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체하기</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	input{
	
		font-size: 25px;
	}
	
	*{	
		
		font-size : 25px;
	}
	
	body{
		margin-top:50px;
		margin-left: 70px;
	}
</style>
</head>
<body>
	<h2> 이체하기 </h2>
	
	<!-- 내계좌 보여주기  -->
	<!-- 이체하기 누르기 -->
	<!-- 출금계좌, 이체 가능 금액 balance 보여주고, 받는부, 입금할 계좌번호, 보낼금액 -->
	<h1> 출금계좌를 선택하세요</h1>
	<!-- userName에 해당하는 모든 계좌 보여주기 -->

	<c:forEach var="infos" items="${allAccount}" >
			<div>
				<!-- <input type="radio" name ="info">  --> 
				계좌 번호: <a href="<c:url value='/transfer/details/${infos.userAccount}'/>">${infos.account}</a>
				현재 잔고 : ${infos.balance}
			</div>
	</c:forEach>
	
	
	<hr>
	
	
	
	
	
</body>
</html>