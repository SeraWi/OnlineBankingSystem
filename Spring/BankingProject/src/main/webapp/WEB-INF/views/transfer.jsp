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

	
	*{	
		font-size : 15px;
	}
	
	body{
		margin-top:50px;
		margin-left:200px;
		margin-right:70px;
	}
	table{
		width:500px;
		border-top: 1px solid #444444;
		border-collapse: collapse;
	}
	
   	th, td {
   		border-bottom: 0.5px solid #444444;
    	padding : 10px;
   }
</style>
</head>
<body>
	
	<h1> 이체할 출금계좌를 선택하세요</h1>
	<table>
		<thead>
	        <tr>
	          <th>계좌번호</th>
	          <th>현재잔고</th>
	        </tr>
      	</thead>
      	
		<tbody>
			<c:forEach var="infos" items="${allAccount}" >
					<tr>
						<td><a href="<c:url value='/transfer/${infos.accountIdx}'/>">${infos.account}</a></td>
						<td>${infos.balance}</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
</body>
</html>