<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영합니다!</title>
</head>
<body>
	<%
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('아이디 또는 비밀번호가 일치하지 않습니다.')");
		script.println("history.back()");
		script.println("</script>");
	%>
</body>
</html>