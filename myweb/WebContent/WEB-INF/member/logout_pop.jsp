<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<script type="text/javascript">
	
	var result = confirm("로그아웃 하시겠습니까?");

	if(result) {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null) {
			if(session.getAttribute("login").equals("true")) {
				session.invalidate();
			}
		}
		
		response.sendRedirect(request.getContextPath());
		
	}
	
	</script>
</body>
</html>