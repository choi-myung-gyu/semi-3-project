<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./pop.js"></script> 
</head>
<body>
	<form action="./semi-logout" method="post">
		<input type="hidden" name="logout_ans">
		<button type="submit" onclick="pop()">로그아웃</button>
	</form>
	
	
</body>
</html>