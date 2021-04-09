<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="board" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 페이지</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/static/bootstrap-4.6.0/css/bootstrap.min.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/static/bootstrap-4.6.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/jquery/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
        <%@ include file="/WEB-INF/module/top_nav.jsp" %>
    </header>

</body>
</html>