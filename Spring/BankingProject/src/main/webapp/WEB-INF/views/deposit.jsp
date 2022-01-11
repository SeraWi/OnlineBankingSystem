<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
	
		font-size: 25px;
	}

</style>
</head>
<body>
	<h1> 현재 userName : ${userVo.userName}</h1>
	
	<h1> 현재 소유 계좌 목록</h1>
	<!-- userName에 해당하는 모든 계좌 보여주기 -->
	
	<form>
		<c:forEach var="infos" items="${allAccount}" >
			<div>
				<input type="radio" name ="account"> ${infos.account} 
				현재 잔고 : ${infos.balance}
				<input type="text" placeholder="입금액을 쓰세요">
				<input type="hidden" value="${infos.account}">
			</div>
		</c:forEach>
		<input type="submit" value =" 입금하기"> 
	</form>
	
		
</body>
</html>