<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이체/입금/출금 내역 보기</title>
<style>
	
	*{
		font-size : 15px;
		margin-bottom:15px;
	}
	body{
		margin-top:50px;
		margin-left: 70px;
	}
	table{
		width:900px;
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
	
	<h2> 현재 userName : ${userVo.userName} </h2>
	
	<h2> 계좌번호를 누르면 입금,출금,이체 내역을 확인할 수 있습니다.</h2>
	
	
	<table>
		<thead>
	        <tr>
	          <th>계좌번호</th>
	          <th>현재잔고</th>
	          <th>이율</th>
	        </tr>
      	</thead>
      	<tbody>
			<c:forEach var="infos" items="${allAccount}" >
					<tr>
						<!-- <input type="radio" name ="info">  --> 
						<th><a href="<c:url value='/history/${infos.accountIdx}'/>">${infos.account}</a></th>
						<th>${infos.balance}</th>
						<th>${infos.rate}</th>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	
	
	
</body>
</html>