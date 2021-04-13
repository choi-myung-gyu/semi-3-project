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
	<form action="<%=request.getContextPath() %>/temp/update" method="post">
		<div>
<<<<<<< HEAD
			<input type="hidden" name="id" value="<%=data.getId() %>">
		</div>
		<div>
			<label for="id_name">name</label>
			<input type="text" id="id_name" name="name" value="<%=data.getName() %>">
=======
			<input type="hidden" name="id" value="<%=data.getUserId() %>">
		</div>
		<div>
			<label for="id_name">name</label>
			<input type="text" id="id_name" name="name" value="<%=data.getUserName() %>">
>>>>>>> refs/remotes/origin/이성한
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>