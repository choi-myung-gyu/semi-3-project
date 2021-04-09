<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8"); 
%>
<!-- 한명의 회원정보를 담는 user클래스를 자바 빈즈로 사용 -->
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page" />
<jsp:setProperty name="bbs" property="B_TITLE" />
<jsp:setProperty name="bbs" property="USERID" />
<jsp:setProperty name="bbs" property="B_CONTENT" />
<%
	System.out.println(bbs);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 쓰기 동작</title>
</head>
<body>
	<%
		String USERID = null;
	if(session.getAttribute("USERID") != null){
		USERID = (String)session.getAttribute("USERID");
	}
	if(USERID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.')");
		script.println("location.href = 'login.jsp'");
		script.println("</script>");
		}else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='bbs.jsp'");
			script.println("</script>");
			}
	%>
</body>
</html>