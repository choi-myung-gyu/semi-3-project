<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바빈즈 폼</title>
</head>
<body>
	<form action="writeAction.jsp" method="post">
		TITLE : <input type="text" name="B_TITLE"><br>
		USERID : <input type="text" name="USERID"><br>
		CONTENT : <input type="text" name="B_CONTENT"><br>
	</form>
</body>
</html>