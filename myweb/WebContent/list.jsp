<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.BoardDAO"%>
<%@page import="board.BoardVO"%>
<%@ page import = "java.util.List"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ include file="color.jspf" %>

<%!
	int pageSize = 5;
	SimpleDateFormat sdf =
		new SimpleDateFormat("yyyy-MM-dd HH:mm");
	

%>

<%
	String pageNum = request.getParameter("pageNum");
	String passwd = (String)session.getAttribute("passwd");
	String id = (String)session.getAttribute("id");
	String email = (String)session.getAttribute("email");

	if(pageNum == null){
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);	
	int startRow = (currentPage - 1) * pageSize + 1;	
	int endRow = currentPage * pageSize;	
	int count = 0;
	int number = 0;
	List<BoardVO> articleList = null;
	
	BoardDAO dbPro = BoardDAO.getInstance();
	count = dbPro.getArticleCount();	
	
	if(count > 0){
		
		articleList = dbPro.getArticles(startRow, endRow);
	}
	
	number = count-(currentPage-1)*pageSize;
%>

<!DOCTYPE html>
<html>
<head>
<link href="style.css?after" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

body {
  font-family: "Roboto", sans-serif;    
}
.widwid{
	width:726px;
	margin-right:auto;
	margin-left:auto;
}

a:link { color: red; text-decoration: none;}
a:visited { color: black; text-decoration: none;}
a:hover { color: blue; text-decoration: underline;}
</style>

</head>
<body bgcolor = "<%=bodyback_c %>">
<p>글목록(전체 글: <%=count %>)</p>
<div class = "widwid">
<div style = "float:left">
<table>
	<tr>
		<td align="right" bgcolor="<%=value_c %>">
			<a href="write.do">글쓰기</a>
		</td>
	</tr>
</table>
</div>
<div style = "float:right">
<table>
	<tr>
		<td align="right" bgcolor="<%=value_c %>" >
			<a href="logout.jsp">로그아웃</a>
		</td>
	</tr>
</table>
</div>
</div>

<% if(count == 0) { %>

<table>
<tr>
	<td align="center">
		게시판에 저장된 글이 없습니다.
	</td>
</tr>
</table>

<% } else { %>
<table style = "margin-right:auto; margin-left:auto; ">
	<tr height="30" bgcolor="<%=value_c %>">
		<td align="center" width="50">번 호</td>
		<td align="center" width="250">제 목</td>
		<td align="center" width="100">작성자</td>
		<td align="center" width="150">작성일</td>
		<td align="center" width="50">조 회</td>
	</tr>
<% 
	for(int i =0; i < articleList.size(); i++){
		BoardVO article = articleList.get(i);
%>
	<tr height = "30">
		<td width="50"> <%=number-- %> </td>
		<td width="250" align="left">
<%
		int wid=0;
		if(article.getRe_level() > 0){
			wid=5*(article.getRe_level());
%>
			<img src="images/level.png" width="<%=wid %>" height="16">
			<img src ="images/re.png">
<% }else { %>
			<img src = "images/re.png" width = "<%=wid %>" height = "16">
<% } %>

			<a href = "content.do?num=<%=article.getNum() %>&pageNum=<%=currentPage %>">
				<%=article.getTitle() %>
			</a>
<% if(article.getViewcnt() >= 20) { %>
			<img src= "images/hot.png" border="0" height = "16"> <% } %>
		</td>
		<td width = "100" align = "left">
			<a href = "mailto: <%=id %>">
				<%=article.getUserid() %>
			</a>
		</td>
		<td width = "150"><%= sdf.format(article.getCreatedate()) %> </td>
		<td width = "50"><%= article.getViewcnt() %> </td>
	</tr>

<% } %>
</table>
<% } %>
<%
	if(count > 0) {
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1;
		
		if(currentPage % 10 != 0)
			startPage = (int)(currentPage/10)*10 + 1;
		else
			startPage = ((int)(currentPage/10)-1)*10 + 1;
			
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) endPage = pageCount;
		
		if(startPage > 10) { %>
			<a href = "list.do?pageNum=<%= startPage - 10 %>">[이전]</a>
<% 		}
		
		for(int i = startPage; i <=endPage; i++) { %>
			<a href = "list.do?pageNum=<%= i%>">[<%= i%>]</a>
<%		}
		
		if(endPage < pageCount) { %>
		<a href = "list.do?pageNum=<%=startPage + 10 %>">[다음]</a>
<%
		}
	}
%>

</body>
</html>