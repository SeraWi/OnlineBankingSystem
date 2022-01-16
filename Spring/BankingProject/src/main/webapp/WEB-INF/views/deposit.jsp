<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입금하기</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	*{
		font-size : 15px;
	}
	body{
		margin-top:50px;
		margin-left: 70px;
	}
	
	.depositForm{
		width:1000px;
	
	}
	.title{
		/*전체 사이즈  */
		width:1000px;
	    height:43px;
	    line-height:43px;
	
	    font-size:14px;
		/* 실선 */
	    border-bottom: 0.1px solid #DBDBDB;
		
		/* 가로 정렬*/
	    display:flex;
	    flex-direction:row;
    }
    .title>div{
    	/* 가로 사이즈 */
    	width: 250px;
    }
    .infos{
    	display:flex;
	    flex-direction:column;
	    border-bottom: 0.1px solid #DBDBDB;
    
    }
    .list{
    	height:35px;
    	line-height:35px;
    	display:flex;
	    flex-direction:row;
	    border-bottom: 0.1px solid #DBDBDB;
    }
    .list div{
    	width:250px;
    }
    
    
</style>
</head>
<body>
	<h1> 현재 userName : ${userVo.userName}</h1>
	
	<h1> 현재 소유 계좌 목록</h1>
	<!-- userName에 해당하는 모든 계좌 보여주기 -->
	<form method="post" id="depositForm" class="depositForm">
			<div class="title">
				<div>계좌번호</div>
				<div>현재잔고</div>
				<div>이율</div>
				<div>선택</div>
			</div>
			
			<div class="infos">
				<c:forEach var="infos" items="${allAccount}" >
					<div class="list"> 
							<!-- <input type="radio" name ="info">  --> 
							<div>${infos.account}</div>
							<div>${infos.balance}</div>
							<div>${infos.rate}%</div>
							<input type="text" name ="depositAmount" placeholder="입금액을 쓰세요" size="20px" maxlength="10" required>
							<input type="hidden" name ="accountIdx" value="${infos.accountIdx}">
							<input type="button" value ="입금하기" >
					 </div> 
				</c:forEach> <!-- 계좌정보 하나씩 -->
			</div> <!-- 계좌 목록 끝 -->
	</form> <!-- from 끝 -->
	
	
	<div id="DepositResult">
	
	</div>
	
	<script>
	
	/* 입금하기 클릭했을 때 */
	
	$('#depositForm').on('click', 'input[type=button]', function(){
		
		/* 입금하기 버튼을 클릭한 계좌Idx와 입금액 */
		var accountIdx =$('input[type=hidden]', $(this).parent()).val();
		console.log(accountIdx);
		
		var depositAmount = $('input[type=text]', $(this).parent()).val();
		console.log(depositAmount);
		
		
		
		/* 문자열 숫자로 변환 */
		accountIdx= parseInt(accountIdx);
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
				   accountIdx: accountIdx,
				   depositAmount:depositAmount,
			   },
			   success: function(data){
				   	   /* 비동기통신 성공, 입금 완료 */
					   console.log(data);
					   alert('입금이 완료되었습니다.')
						
					   /* 아래쪽에 입금 후 내용 추가 */
						var html ='<div>';
		                /* html += '   <h2>' + data.userName+'</h2>'; */
		                html += '   <h2>[입금 완료]' + data.account+' 계좌로 '+ depositAmount+ '원 입금하였습니다 </h2>';
		                html += '   <h2> 입금 후 잔액은 ' + data.balance+' 원 입니다.</h2>';
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