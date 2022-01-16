<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 계좌 조회</title>
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
		width:1000px;
		border-top: 1px solid #444444;
		border-collapse: collapse;
	}
   th, td {
   		text-align : center;
   		border-bottom: 0.5px solid #444444;
    	padding : 10px;
   }
</style>
</head>
<body>

	<h2>${userVo.userName}님의 전체 계좌를 조회합니다.</h2>
	
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
			<c:forEach var="infos" items="${allAccount}" >
					<tr>
						<td>${infos.account}</td>
						<td>${infos.balance}</td>
						<td>${infos.rate}%</td>
						<td>${infos.createDate}</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>