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
		margin-bottom:15px;
	}
	body{
		margin-top:50px;
		margin-left: 70px;
		margin-right:70px;
	}

</style>
</head>
<body>

<%-- 	<h1>출금계좌를 선택하세요</h1>
	<!-- userName에 해당하는 모든 계좌 보여주기 -->

	<c:forEach var="infos" items="${allAccount}">
		<div>
			<!-- <input type="radio" name ="info">  -->
							계좌 번호: <a href="<c:url value='/transfer/details/${infos.userAccount}'/>">${infos.account}</a>
				현재 잔고 : ${infos.balance}
		</div>
	</c:forEach> --%>

	<h1>입금 계좌와 이름을 입력하세요.</h1>
	<hr>

	<form method="post">
		<div>
			계좌번호 : <input type="text" name="toAccount" class="toAccount" required>
			이름: <input type="text" name="userName" class="userName" required>
			이체액: <input type="text" name="transferAmount" class="transferAmount" required>
			 <input type="hidden" name ="fromIdx" value="${curAccount.userIdx}">
			 <input type="submit" value="이체하기" class="form_submit">
		</div>
	</form>
	
	
	
	<script>
	

	/* 현재 출금 계좌 */
	const fromAccount = '${curAccount.userAccount}';
	console.log(fromAccount);
	
	/* 현재 출금 계좌 잔고 */
	const balance ='${curAccount.balance}';
	console.log(balance);
	
	/* 현재 Idx */
	const userIdx ='${curAccount.userIdx}';
	
	$(document).ready(function(){
	
	/* 이체하기 클릭 */
	$('.form_submit').click(function(){
				
		/* 입금 계좌번호 */
		var toAccount = parseInt($('.toAccount').val());
		console.log(toAccount);
				
			
		/* 입금 계좌의 userName */
		var userName = $('.userName').val();
		console.log(userName);
				
				
		/* 이체액 transferAmount */
		var transferAmount = parseInt($('.transferAmount').val());
		console.log(transferAmount)
				
		if(!transferAmount){
			alert('이체액을 입력하세요');
			return false;
		}
						
		/*  
			[이체불가]
			1. 출금계좌와 입금계좌가 동일할때 
			2. 이체하려는 금액과 잔고를 비교하기 : 잔고 < 이체하려는 금액
			3. 이체액 0이하일경우
			4. 입금계좌와 사용자이름 맞지 않을 때 (ajax)
		*/
				
		if(fromAccount == toAccount){
			alert('[이체불가] 출금계좌와 입금계좌가 동일합니다. 다시 입력해주세요');
			return false;
		}else if( transferAmount > balance){
			alert('[이체불가] 잔고 부족');
			return false;
		}else if(transferAmount <= 0){
			alert('0원 이상을 입력하세요.');
			return false;
		}
		
			/*  비동기 통신으로 입금계좌와 사용자이름 확인*/
			$.ajax({
				url:'<c:url value="/checkAccount"/>',
				type:'GET',
				data:{
					userAccount:toAccount,
					userName:userName
				},
				success: function(data){
					/* 1이면 일치 확인  */
					if(data == 0){
						alert('[이체 불가] 정보가 일치하지 않습니다.');
						location.href = '<c:url value="/transfer/'+userIdx+'"/>';
						return false;
					}else{
						/* 1이면 이체하기 */
						alert('[알람]' + userName+'님, ' + toAccount+' 계좌로' + transferAmount+ '원을 이체합니다.');
					}
						
				}/* success 끝 */
						
			});/* ajax 끝 */	
			
			
		});/* submit 눌렀을 때  */
			
	});/* document.ready 끝 */
	</script>



</body>
</html>