<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  ul{
   	list-style:none;
   }

</style>
</head>
<body>
	    <section>
             <c:forEach var="infos" items="${allAccount}">
				<ul>
					<li>${infos.account}</li>
					<li>${infos.userName}</li>
					<li>${infos.rate}</li>
					<li>${infos.createDate}</li>
					<li>${infos.balance}</li>
				</ul>
             </c:forEach>
        </section>
</body>
</html>