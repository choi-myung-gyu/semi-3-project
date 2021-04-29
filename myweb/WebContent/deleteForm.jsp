<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "color.jspf" %>

<%
int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 삭제</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-4.6.0/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/board_delete.css" type="text/css">
<script type = "text/javascript">
<!--
function deleteSave(){
	if(!document.delForm.passwd.value){
		alert("비밀번호를 입력하십시오.");
		document.delForm.passwd.focus();
		return false;
	}
}
-->
</script>
</head>
<body bgcolor = "<%= bodyback_c%>">
<section class="main_c">
	<div><h1>글삭제</h1></div>
	<div class="delete-form">
		<br>
		<form method = "POST" name = "delForm"
			action = "deletePro.do?pageNum=<%= pageNum%>"
			onsubmit = "return deleteSave()">
		<table style = "margin-right:auto; margin-left:auto;">
			<tr height = "20">
				<b>글을 삭제하시려면<br>아이디와 비밀번호를 입력해 주세요.</b>
			</tr>
			
			<tr height = "30" style="font-weight:bold;">
				<td align = center>아이디: 
					<input type = "text" name = "id" size = "13" maxlength = "12">
					<input type = "hidden" name = "num" value = "<%=num %>"> </td>
			</tr>
			<tr height = "30" style="font-weight:bold;">
				<td align = center>비밀번호:
					<input type = "password" name = "passwd" size = "13" maxlength = "12">
					<input type = "hidden" name = "num" value = "<%=num %>"> </td>
			</tr>
			<tr height = "30">
				<td align = center bgcolor ="<%= value_c%>">
					<br>
					<input type = "submit" value = "글삭제" class="btn_delete">
					<input type = "hidden" value = "글목록"
						onclick = "document.location.href='list.do?page<%=pageNum %>'"> 
				</td>
			</tr>
			
		</table>
		</form>
	</div>
</section>
</body>
</html>