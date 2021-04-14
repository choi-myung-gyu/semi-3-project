<%@page import="board.BoardDAO"%>
<%@page import="board.BoardVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "color.jspf" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-4.6.0/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/board_content.css" type="text/css">
<script type="text/javascript">
function download(filename){
	document.downloadForm.filename.value =filename; 
	document.downloadForm.submit();
}
</script>


</head>
<body bgcolor = "<%=bodyback_c %>">
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	SimpleDateFormat sdf =
			new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	try{
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = dbPro.getArticle(num);
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();	
%>


<section class="main_c">
	<div><h1>글내용 보기</h1></div>
	<div class="content-form">
		<form name="contentForm">
		<table class="table">  
		  <tr height="30">
		    <td align="center" width="125" bgcolor="<%=value_c%>" style="font-weight:bold;">글번호</td>
		    <td align="center" width="125" align="center">
			     <%=article.getNum()%></td>
		    <td align="center" width="125" bgcolor="<%=value_c%>" style="font-weight:bold;">조회수</td>
		    <td align="center" width="125" align="center">
			     <%=article.getViewcnt()%></td>
		  </tr>
		  <tr height="30">
		    <td align="center" width="125" bgcolor="<%=value_c%>" style="font-weight:bold;">작성자</td>
		    <td align="center" width="125" align="center">
			     <%=article.getUserid()%></td>
		    <td align="center" width="125" bgcolor="<%=value_c%>" style="font-weight:bold;">작성일</td>
		    <td align="center" width="125" align="center">
			     <%= sdf.format(article.getCreatedate())%></td>
		  </tr>
		  <tr height="30">
		    <td align="center" width="125" bgcolor="<%=value_c%>" style="font-weight:bold;">글제목</td>
		    <td align="center" width="375" align="center" colspan="3">
			     <%=article.getTitle()%></td>
		  </tr>
		  <tr>
		    <td align="center" width="125" bgcolor="<%=value_c%>" style="font-weight:bold;">글내용</td>
		    <td align="left" width="375" colspan="3">
		           <pre><%=article.getContent()%></pre></td>
		  </tr>
		  <tr>
		    <td align="center" width="125" bgcolor="<%=value_c%>" style="font-weight:bold;">파일다운로드</td>
		    <td align="left" width="375" colspan="3">
		           <%
		           String filename = article.getFilename();
		           if( filename !=null && !filename.equals("")) { %>
			           <a href="javascript:download('<%=filename %>')">
			           <%=filename %>
			           
			           </a>
		           <%} else { %>
		           파일이 없습니다.
		           <%}  %>
		    </td>
		  </tr>
		  <tr height="30">      
		    <td colspan="4" bgcolor="<%=value_c%>" align="right" > 
			  <input type="button" value="글수정" 
		       onclick="document.location.href='update.do?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'" class="btn_update">
			   &nbsp;&nbsp;&nbsp;&nbsp;
			  <input type="button" value="글삭제" 
		       onclick="document.location.href='delete.do?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'" class="btn_delete">
			   &nbsp;&nbsp;&nbsp;&nbsp;
		      <input type="button" value="답글쓰기" 
		       onclick="document.location.href='write.do?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'" class="btn_re">
			   &nbsp;&nbsp;&nbsp;&nbsp;
		       <input type="button" value="글목록" 
		       onclick="document.location.href='list.do?pageNum=<%=pageNum%>'" class="btn_list">
		    </td>
		  </tr>
		</table>    
		
		<%
			}catch(Exception e){}
		%>
		</form>
		
		<form name = "downloadForm" action = "downloadPro.jsp" method = "post">
			<input type = "hidden" name = "filename">
		</form>
	</div>
</section>
</body>
</html>