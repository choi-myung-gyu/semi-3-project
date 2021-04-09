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
	<form action="<%=request.getContextPath() %>/temp/write" method="post" enctype="multipart/form-data">
		<div>
			<label for="id_name">name</label>
			<input type="text" id="id_name" name="name">
		</div>
		<div>
			<label for="id_file">첨부</label>
			<input type="file" id="id_file" name="file">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>