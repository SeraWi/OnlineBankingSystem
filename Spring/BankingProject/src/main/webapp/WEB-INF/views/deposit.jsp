<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				현재 잔고 : ${infos.balance}
				이율 : ${infos.rate}
				<input type="text" name ="depositAmount" placeholder="입금액을 쓰세요" required>
				<input type="hidden" name ="userAccount" value="${infos.userAccount}">
				<input type="button" value ="입금하기" > 
			</div>
		</c:forEach>
	</form>
	
	<hr>
	
	<div id="DepositResult">
	
	
	
	</div>
	
	<script>
	
	/* 입금하기 클릭했을 때 */
	
	$('#depositForm').on('click', 'input[type=button]', function(){
		
		/* 입금하기 버튼을 클릭한 계좌번화 입금액 */
		var userAccount =$('input[type=hidden]', $(this).parent()).val();
		console.log(userAccount);
		
		var depositAmount = $('input[type=text]', $(this).parent()).val();
		console.log(depositAmount);
		
		
		
		/* 문자열 숫자로 변환 */
		userAccount = parseInt(userAccount);
		depositAmount = parseInt(depositAmount);
		
		
		/*  입금액 0원 이하이거나 입력하지 않았을 경우*/
		if(!depositAmount){
			alert('입금액을 입력해주세요');
			return false;
		}else if(depositAmount <=0 ){
			alert('입금액이 0원 이하입니다.다시 입력해주세요');
			return false;
		}
		
		/* 비동기 통신으로 입금하기 */
		 $.ajax({
			   url:'<c:url value="/afterDeposit"/>',
			   type:'POST',
			   data:{
				   userAccount: userAccount,
				   depositAmount:depositAmount,
			   },
			   success: function(data){
				   	   /* 비동기통신 성공, 입금 완료 */
					   console.log(data);
					   alert('입금이 완료되었습니다.')
						
					   /* 아래쪽에 입금 후 내용 추가 */
						var html ='<div>';
		                html += '   <h2>' + data.userName+'</h2>';
		                html += '   <h2> 입금 계좌 : ' + data.userAccount+'</h2>';
		                html += '   <h2> 입금 후 잔액:' + data.balance+'</h2>';
		                html += '</div>';
		                html += '<hr>';
		                
		                
		                //div에 추가하기
		                $('#DepositResult').append(html);
				   
			   }/* success 끝 */
			   
		   });/*ajax끝 */
		   
		   $('input[type=text]', $(this).parent()).val("");
		   
		
	});/* button 클릭 끝 */
	</script>
	
	
	
		
</body>
</html>