<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
	<style>
		li{
			font-size :25px;
		}
	
	
	</style>

</head>
<body>

<h1> 현재 userName : ${sessionScope.userVo.userName}</h1>

<ul>
	<li><a href="<c:url value='/create/account'/>"> 계좌 생성 </a></li>
	<li><a href="<c:url value='/search/account'/>"> 계좌 조회 </a></li>
	<li><a href="<c:url value='/deposit'/>"> 입금 </a></li>
	<li><a href="<c:url value='/withdraw'/>"> 출금 </a></li>
	<li><a href="<c:url value='/transfer'/>"> 이체 </a></li>
	<li><a href="<c:url value='/history'/>"> 입금/출금/이체 내역보기 </a></li>
</ul>


</body>
</html>
