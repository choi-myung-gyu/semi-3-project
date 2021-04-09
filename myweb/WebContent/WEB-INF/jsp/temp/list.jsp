<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, temp.TempVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" 
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function sendAJAX() {
		$.ajax({
			url: "<%=request.getContextPath() %>/ajax/temp/list",
			type: "get",
			datatype: "json", 
			data: {
				name: "Ajax",
				value: "send data"
			},
			success: function(data) {
				alert("Ajax 통신이 완료되었습니다." + data.res);
				$("#res").val(data.res);
			}
		});
	}
</script>
</head>
<body>
	<% ArrayList<TempVO> datas = (ArrayList<TempVO>)request.getAttribute("datas"); %>
	<button type="button" onclick="location.href='<%=request.getContextPath() %>/temp/write'">작성</button>
	<div>
		<button type="button" onclick="sendAJAX();">Ajax 전송</button>
		<input type="text" id="res">
	</div>
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