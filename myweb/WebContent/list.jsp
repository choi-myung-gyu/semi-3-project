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
	String id = (String)session.getAttribute("userid");
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
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-4.6.0/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/board_list.css" type="text/css">
<script type="text/javascript">
	function pop() {
		var res = confirm("로그아웃 하시겠습니까?");
		
		console.log(res);
		
		if(res) {
			document.getElementsByName("logout_ans")[0].value = "true";
			document.getElementById("logout_confirm").submit();
		}
	}
</script> 
<style type="text/css">
	@import url(https://fonts.googleapis.com/css?family=Roboto:300);
	a:link { color: black; text-decoration: none;}
/* 	a:visited { color: purple; text-decoration: none;} */
	a:hover { color: blue; text-decoration: underline;}
</style>

</head>
<body bgcolor = "<%=bodyback_c %>">

<section class="main_c">
<div>
	<h1>게시판</h1>
	<h3>글목록(전체 글: <%=count %>)</h3>
</div>
<div class="list-form">
	<div class="button_div">
		<div style = "float:left">
			<button type="button" onclick="location.href='write.do'" class="btn_write">글쓰기</button>
		</div>
		<div style = "float:right">
			<form action="./semi-logout" method="post" id="logout_confirm">
				<input type="hidden" name="logout_ans">
				<button type="button" onclick="pop()" class="btn_logout">로그아웃</button>
			</form>
		</div>
		<br>
	</div>
	<div>
		<br><br>
	</div>
	<% if(count == 0) { %>
		<h2 style="font-size:13pt; font-weight:bold;">게시판에 저장된 글이 없습니다<br>글쓰기 버튼을 눌러 글을 작성하세요</h2>
	<% } else { %>
	<table class="table" style = "margin-right:auto; margin-left:auto;">
		<tr height="30" bgcolor="<%=value_c %>">
			<td align="center" width="50">번호</td>
			<td align="center" width="250">제 목</td>
			<td align="center" width="100">작성자</td>
			<td align="center" width="150">작성일</td>
			<td align="center" width="65">조회수</td>
		</tr>
	<% 
		for(int i =0; i < articleList.size(); i++){
			BoardVO article = articleList.get(i);
	%>
		<tr height = "30">
			<td width="50"> <%=number-- %> </td>
			<td width="250" align="center">
	<%
			/* int wid=0; */
			if(article.getRe_level() > 0){
				/* wid=5*(article.getRe_level()); */
				for(int j = 0; j < article.getRe_level(); j++) { 
	%>
				&nbsp;&nbsp;&nbsp;
	<% } %>
				<img src ="<%=request.getContextPath()%>/static/re.png">
	<% }else { %>
	<% } %>
	
				<a href = "content.do?num=<%=article.getNum() %>&pageNum=<%=currentPage %>">
					<%=article.getTitle() %>
				</a>
	<% if(article.getViewcnt() >= 20) { %>
				<img src= "images/hot.png" border="0" height = "16"> <% } %>
			</td>
			<td width = "100" align = "center">
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
				<a href = "list.do?pageNum=<%= i%>" style="font-size:10pt; font-weight:bold;">[<%= i%>]</a>
	<%		}
			
			if(endPage < pageCount) { %>
			<a href = "list.do?pageNum=<%=startPage + 10 %>">[다음]</a>
	<%
			}
		}
	%>
</div>
</section>
</body>
</html>