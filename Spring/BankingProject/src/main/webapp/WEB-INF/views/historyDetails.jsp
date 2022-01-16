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
		margin-bottom: 50px;
	}
   th, td {
   		border-bottom: 0.5px solid #444444;
    	padding : 10px;
   }

</style>
</head>
<body>

	<h2> ${userVo.userName}님의 거래내역을 조회합니다.</h2>
	
	<h2> 이체 내역</h2>
	<table>
		<thead>
			<tr>
				<td>계좌번호</td>
				<td>이체액</td>
				<td>이체일</td>
				<td>이체 입금/출금</td>
				<td>이름</td>
			</tr>
		</thead>
		<tbody>
			<c:if test ="${empty transferIn && empty transferOut}">
				<tr>
					<td>이체 내역이 없습니다.</td>
					<td></td>
					<td></td>
					
				</tr>
			</c:if>
				<c:forEach var="tIn" items="${transferIn}" >
						<tr>
							<td>${tIn.account}</td>
							<td>${tIn.transferAmount}</td>
							<td>${tIn.transferDate}</td>
							<td style="color:blue">이체 입금</td>
							<td>${tIn.userName}</td>
						</tr>
				</c:forEach>
				<c:forEach var="tOut" items="${transferOut}" >
						<tr>
							<td>${tOut.account}</td>
							<td>${tOut.transferAmount}</td>
							<td>${tOut.transferDate}</td>
							<td style="color:red">이체 출금</td>
							<td>${tOut.userName}</td>
						</tr>
				</c:forEach>
		</tbody>
	</table>
	
	<h2> 입금 내역</h2>
	<table>
		<thead>
			<tr>
				<td>입금액</td>
				<td>입금 후 잔액</td>
				<td>입금일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test ="${empty depositInfos}">
				<tr>
					<td>입금 내역이 없습니다.</td>
					<td></td>
					<td></td>
					
				</tr>
			</c:if>
			<c:forEach var="dinfos" items="${depositInfos}" >
					<tr>
						<td>${dinfos.depositAmount}</td>
						<td>${dinfos.currentBalance}</td>
						<td>${dinfos.depositDate}</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2> 출금 내역</h2>
	<table>
		<thead>
			<tr>
				<td>출금액</td>
				<td>출금 후 잔액</td>
				<td>출금일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test ="${empty withdrawInfos}">
				<tr>
					<td>출금 내역이 없습니다.</td>
					<td></td>
					<td></td>
				</tr>
			</c:if>
			<c:forEach var="winfos" items="${withdrawInfos}" >
					<tr>
						<td>${winfos.withdrawalAmount}</td>
						<td>${winfos.currentBalance}</td>
						<td>${winfos.withdrawalDate}</td>
					</tr>
			</c:forEach> 
		</tbody>
	</table>
	
</body>
</html>