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
	<button type="button" onclick="location.href='<%=request.getContextPath() %>/temp/write'">작성</button>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>날짜</th>
		</tr>
		<% for(TempVO data : datas) { %>
			<tr>
				<td><%=data.getId() %></td>
				<td><a href="<%=request.getContextPath()%>/temp/detail?id=<%=data.getId()%>"><%=data.getName() %></a></td>
				<td><%=data.getCDate() %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>