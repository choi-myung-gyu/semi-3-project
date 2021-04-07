<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="temp.TempVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% TempVO data = (TempVO)request.getAttribute("data"); %>
	
	<p><%=data.getId() %></p>
	<p><%=data.getName() %></p>
	<p><%=data.getCDate() %></p>
	
	<div>
		<button type="button" onclick="location.href='<%=request.getContextPath() %>/temp/update?id=<%=data.getId()%>'">수정</button>
		<button type="button" onclick="location.href='<%=request.getContextPath() %>/temp/delete?id=<%=data.getId()%>'">삭제</button>
		<button type="button" onclick="location.href='<%=request.getContextPath() %>/temp/write'">목록</button>
	</div>
</body>
</html>