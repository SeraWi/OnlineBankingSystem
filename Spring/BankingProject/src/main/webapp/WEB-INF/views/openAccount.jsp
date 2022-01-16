<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
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
	table{
		width:800px;
		border-top: 1px solid #444444;
		border-collapse: collapse;
	}
   th, td {
   		border-bottom: 0.5px solid #444444;
    	padding : 10px;
    	text-align : center;
   }
</style>
</head>
<body>
	<h1> ${sessionScope.userVo.userName}님, 계좌를 생성했습니다.</h1>
	
	<table>
		<thead>
	        <tr>
	          <th>계좌번호</th>
	          <th>현재잔고</th>
	          <th>이율</th>
	          <th>계좌생성일</th>
	        </tr>
      	</thead>
		<tbody>
			<tr>
				<td> ${accountInfo.account}</td>
				<td> ${accountInfo.balance}</td>
				<td> ${accountInfo.rate}%</td>
				<td> ${accountInfo.createDate}</td>
			</tr>
		</tbody>
		
	</table>
</body>
</html>