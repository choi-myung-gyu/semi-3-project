<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function pop() {
		var res = confirm("로그아웃 하시겠습니까?");
		
		console.log(res);
		
		if(res) {
			document.getElementsByName("logout_ans")[0].value = "true";
			document.getElementById("logout_confirm").submit();
		} else {
			history.back();
		};
	}
</script> 
</head>
<body>
	<form action="./semi-logout" method="post" id="logout_confirm">
		<input type="hidden" name="logout_ans">
		<button type="button" onclick="pop()">로그아웃</button>
	</form>
</body>
</html>