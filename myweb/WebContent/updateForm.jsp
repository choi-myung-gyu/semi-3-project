<%@page import="board.BoardDAO"%>
<%@page import="board.BoardVO"%>
<%@page import="board.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "color.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-4.6.0/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/board_update.css" type="text/css">
<script type = "text/javascript" src = "script.js"></script>
</head>
<body bgcolor = "<%=bodyback_c%>">
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	String id = (String)session.getAttribute("userid");
	String passwd = (String)session.getAttribute("passwd");
	String strV = "";
	
	try{
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = dbPro.updateGetArticle(num);
%>
<section class="main_c">
	<div><h1>글수정</h1></div>
	<div class="update-form">
		<br>
		<form method = "post" name = "updateform"
		action = "updatePro.do?pageNum=<%=pageNum%>" onsubmit = "return writeSave()"
		enctype = "multipart/form-data">
		<table style = "margin-right:auto; margin-left:auto;">
			<tr>
				<td width = "70" bgcolor = "<%= value_c%>" align = "center" style="font-weight:bold;">이름</td>
				<td align = "left" width = "330">
				<input type = "text" size ="10" maxlength = "10" name = "id"
				value = "<%=id%>" style = "ime-mode:active;" readonly>
				<input type = "hidden" name = "num" value = "<%=article.getNum() %>"></td>
			</tr>
			<tr>
				<td width = "70" bgcolor = "<%= value_c%>" align = "center" style="font-weight:bold;">제목</td>
				<td align = "left" width = "330">
				<input type = "text" size ="40" maxlength = "50" name = "title"
				value = "<%=article.getTitle() %>" style = "ime-mode:active;">
				</td>
			</tr>
			<%
		    if(request.getParameter("num")==null)
		    	strV ="";
		    else
		    	strV = "[수정]";
		    %>
			
			<tr>
				<td width = "70" bgcolor = "<%= value_c%>" align = "center" style="font-weight:bold;">내 용</td>
				<td align = "left" width = "330">
				<textarea name = "content" rows = "13" cols = "40" style = "ime-mode:active;"><%=article.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				
				<input type = "hidden" size ="8" maxlength = "12" 
				name = "passwd" style = "ime-mode:inactive;" value="<%=passwd%>">
				<!-- </td> -->
			</tr>
			<tr>
				<td colspan=2 bgcolor="<%=value_c%>" align = "center">
					<input type = "submit" value="글수정" class="btn_update">
					<input type = "button" value="목록보기"
					onclick = "document.location.href = 'list.do?pageNum=<%=pageNum %>'" class="btn_list">
				</td>
			</tr>
		</table>
		</form>
		<%}catch(Exception e){}%>
	</div>
</section>
</body>
</html>