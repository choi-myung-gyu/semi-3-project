<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, temp.TempVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<TempVO> datas = (ArrayList<TempVO>)request.getAttribute("datas"); %>
	<button type="button" onclick="locaion.href='<%=request.getContextPath() %>/temp/write]'">작성</button>
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>핸드폰번호</th>
			<th>가입일</th>
		</tr>
		<% for(TempVO data: datas) { %>
			<tr>
				<td><%=data.getUserId() %></td>
				<td><a href="<%=request.getContextPath() %>/temp/detail?userId="><%=data.getUserName() %></a></td>
				<td><%=data.getUserPassword() %></td>
				<td><%=data.getUserEmail() %></td>
				<td><%=data.getUserPhone() %></td>
				<td><%=data.getJoinDate() %></td>
			</tr>
		<% }%>
	</table>
</body>
</html>