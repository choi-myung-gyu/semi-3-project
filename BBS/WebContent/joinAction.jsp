<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="USERID" />
<jsp:setProperty name="user" property="USERPASSWORD" />
<jsp:setProperty name="user" property="USERPASSWORD" />
<jsp:setProperty name="user" property="USERNAME" />
<jsp:setProperty name="user" property="USEREMAIL" />
<jsp:setProperty name="user" property="USERPHONE" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 게시판 웹사이트</title>
</head>
<body>
	<%
		String USERID = null;
		if (session.getAttribute("USERID") != null) {
			USERID = (String) session.getAttribute("USERID");
		}
		if (USERID != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인 되어있습니다.')");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		if (user.getUserID() == null || user.getUserPassword() == null || user.getUserPassword() == null || user.getUserName() == null
				|| user.getUserMail() == null|| user.getUserPhone() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("<script>");
		} else {
			UserDAO userDAO = new UserDAO(); 
			int result = userDAO.join(user);
			if (result == -1) { 
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디 입니다.')");
				script.println("history.back()");
				script.println("</script>");
			} 
			else {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'main.jsp'");
				script.println("</script>");
			}
		}
	%>
</body>
</html>