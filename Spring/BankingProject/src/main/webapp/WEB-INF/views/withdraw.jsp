<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출금하기, Withdraw</title>
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
	<h1> 현재 userName : ${userVo.userName}</h1>
	
	<h1> 현재 소유 계좌 목록</h1>
	<!-- userName에 해당하는 모든 계좌 보여주기 -->
	
	<form method="post" id="depositForm">
		<c:forEach var="infos" items="${allAccount}" >
			<div>
				<!-- <input type="radio" name ="info">  --> 
				계좌 번호 : ${infos.account} 
				<input type="hidden" name ="userAccount" value1="${infos.userAccount}" value2 ="${infos.balance}">
				현재 잔고 : ${infos.balance}
				<input type="text" name ="withdrawalAmount" placeholder="출금액을 쓰세요">
				<input type="button" value ="출금하기" > 
			</div>
		</c:forEach>
	</form>
	
	<hr>
	
	<div id="withdrawResult">
	
	
	
	</div>
	
	<script>
	
	/* 출금하기 버튼 클릭 */
	
	$('#depositForm').on('click', 'input[type=button]', function(){
		
		/* 출금하는 계좌, 출금액, 현재 잔고 정보 */
		var userAccount =$('input[type=hidden]', $(this).parent()).attr("value1");
		console.log(userAccount);
		
		var withdrawalAmount = $('input[type=text]', $(this).parent()).val();
		console.log(withdrawalAmount);
		
		var balance= $('input[type=hidden]', $(this).parent()).attr("value2");
		console.log(balance);
		
		/* 문자열 비교 막기 위해 문자를 숫자로 변환*/
		userAccount = parseInt(userAccount);
		withdrawalAmount = parseInt(withdrawalAmount);
		balance = parseInt(balance);
	
		
		/* 출금액과 잔고액 비교하기 */
		if(!withdrawalAmount){
			alert('출금액을 입력해주세요');
			return false;
		}else if(withdrawalAmount > balance){
			alert('[출금불가] 출금하려는 금액이 현재 잔액보다 큽니다.');
			return false;
		}else if(withdrawalAmount ==0){
			alert('0원 입력했습니다. 출금액을 다시 입력해주세요');
			return false;
		}
		
	    /* 비동기 통신으로 출금하기 */
		 $.ajax({
			   url:'<c:url value="/afterWithdraw"/>',
			   type:'POST',
			   data:{
				   userAccount: userAccount,
				   withdrawalAmount:withdrawalAmount,
			   },
			   success: function(data){
				   
					   console.log(data);
					   alert('출금이 완료되었습니다.')
						
						var html ='<div>';
		                html += '   <h2>' + data.userName+'</h2>';
		                html += '   <h2> 출금 계좌 :' + data.userAccount+'</h2>';
		                html += '   <h2> 출금 후 잔액: ' + data.balance+'</h2>';
		                html += '</div>';
		                html += '<hr>';
		                
		                
		                //div에 추가하기
		                $('#withdrawResult').append(html);
				   
			   }/* success 끝 */
			   
		   });/*ajax끝 */
		   
		   $('input[type=text]', $(this).parent()).val("");
		   
		
	});/* click 끝 */
	</script>
	
	
	
		
</body>
</html>