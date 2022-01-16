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
		width:900px;
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
    	width: 333px;
    	text-align: center;
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
    	width:333px;
    }
	form{
		width:900px;
	}
	
</style>
</head>
<body>
	<h1> 현재 userName : ${userVo.userName}</h1>
	
	<h1> 현재 소유 계좌 목록</h1>
	<!-- userName에 해당하는 모든 계좌 보여주기 -->
	
	<form method="post" id="depositForm">
		<div class="title">
				<div>계좌번호</div>
				<div>현재잔고</div>
				<!-- <div>이율</div> -->
				<div>선택</div>
		</div>
		
		<div class="infos">
			<c:forEach var="infos" items="${allAccount}" >
				<div class="list"> 
					<!-- <input type="radio" name ="info">  --> 
					<div>${infos.account} </div>
					<input type="hidden" name ="userAccount" value1="${infos.accountIdx}" value2 ="${infos.balance}">
					<div class="balance">${infos.balance}</div>
					<input type="text" name ="withdrawalAmount" placeholder="출금액을 쓰세요" required>
					<input type="button" value ="출금하기" > 
				</div>
			</c:forEach>
		</div> <!-- 계좌 목록 끝 -->
	</form> <!-- form 끝 -->
	
	
	
	<div id="withdrawResult">
	
	
	
	</div>
	
	<script>
	
	/* 출금하기 버튼 클릭 */
	
	$('#depositForm').on('click', 'input[type=button]', function(){
		
		/* 출금하는 계좌Idx, 출금액, 현재 잔고 정보 */
		var accountIdx =$('input[type=hidden]', $(this).parent()).attr("value1");
		
		var withdrawalAmount = $('input[type=text]', $(this).parent()).val();
		
		var balance= $('input[type=hidden]', $(this).parent()).attr("value2");
		
		accountIdx = parseInt(accountIdx);
		withdrawalAmount = parseInt(withdrawalAmount);
		balance = parseInt(balance);
	
		
		/*  
			[출금불가]
		  1. 출금액 > 잔고
		  2. 출금액 < 0 
		*/
		
		
		/* 출금액과 잔고액 비교하기 */
		if(!withdrawalAmount){
			alert('출금액을 입력해주세요');
			return false;
		}else if(withdrawalAmount > balance){
			alert('[출금불가] 출금하려는 금액이 현재 잔액보다 큽니다.');
			return false;
		}else if(withdrawalAmount <=0){
			alert('0원이하를 입력했습니다. 출금액을 다시 입력해주세요');
			return false;
		}
		
	    /* 비동기 통신으로 출금하기 */
		 $.ajax({
			   url:'<c:url value="/afterWithdraw"/>',
			   type:'POST',
			   data:{
				   accountIdx: accountIdx,
				   withdrawalAmount:withdrawalAmount,
			   },
			   success: function(data){
				   
					   alert('출금이 완료되었습니다.')
						
						var html ='<div>';
		               /*  html += '   <h2>' + data.userName+'</h2>'; */
		                html += '   <h2> [출금완료]'+data.account+' 계좌로 ' + withdrawalAmount+'원 출금하였습니다</h2>';
		                html += '   <h2> 출금 후 잔액은 ' + data.balance+'원 입니다.</h2>';
		                html += '</div>';
		                html += '<hr>';
		                
		                
		                //div에 추가하기
		                $('#withdrawResult').append(html);
		                
		                /* 잔고 낮춰주기 */
				   
			   }/* success 끝 */
			   
		   });/*ajax끝 */
		   
		   $('input[type=text]', $(this).parent()).val("");
		   
		   /* 잔액 업데이트 */
		   var balance= $('input[type=hidden]', $(this).parent()).attr("value2", balance-withdrawalAmount);
	
	});/* click 끝 */
	</script>
	
	
	
		
</body>
</html>