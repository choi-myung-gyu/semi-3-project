<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jspf" %>



<%
int num = 0, ref = 1, re_step = 0, re_level = 0;
String strV = "";
String id = (String)session.getAttribute("userid");
String passwd = (String)session.getAttribute("passwd");
try{
	if(request.getParameter("num")!=null){
		num = Integer.parseInt(request.getParameter("num"));
		ref = Integer.parseInt(request.getParameter("ref"));
		re_step= Integer.parseInt(request.getParameter("re_step"));
		re_level=Integer.parseInt(request.getParameter("re_level"));
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-4.6.0/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/board_write.css" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body bgcolor="<%=bodyback_c %>" >
	<section class="main_c">
		<div><h1>글쓰기</h1></div>
		<div class="write-form">
			<form method="post" name = "writeform"
			      action="writePro.do" enctype = "multipart/form-data">
			<input type = "hidden" name = "num" value = "<%=num %>">
			<input type = "hidden" name = "ref" value = "<%=ref %>">
			<input type = "hidden" name = "re_step" value = "<%=re_step %>">
			<input type = "hidden" name = "re_level" value = "<%=re_level %>">
			
			
			<table style = "margin-right:auto; margin-left:auto; ">
			   <tr>
<%-- 			    <td align="right" colspan="2" bgcolor="<%=value_c%>">
			    	<button type="button" onclick="location.href='list.do'" class="btn_list">글목록</button>
			   </td> --%>
			   	<br>
			   </tr>
			   <tr>
			    <td  width="70"  bgcolor="<%=value_c%>" align="center" style="font-weight:bold;">이 름</td>
			    <td  width="330" align="left">
			       <input type="text" size="10" maxlength="10" 
			          name="userid" style="ime-mode:active;" value="<%=id %>" readonly></td><!--active:한글-->
			  </tr>
			  <tr>
			    <td  width="70"  bgcolor="<%=value_c%>" align="center" style="font-weight:bold;">제 목</td>
			    <td  width="330" align="left">
			    <%
			    if(request.getParameter("num")==null)
			    	strV ="";
			    else
			    	strV = "[답글]";
			    %>
			    <input type="text" size="40" maxlength="50" name="title"
			         value="<%=strV%>" style="ime-mode:active;"></td>	
			  </tr>
			
			  <tr>
			    <td  width="70"  bgcolor="<%=value_c%>" align="center" style="font-weight:bold;">내 용</td>
			    <td  width="330" align="left">
			     <textarea name="content" rows="13" cols="40" 
			              style="ime-mode:active;"></textarea> </td>
			  </tr>
			  
			  <tr>
			    <td  width="70"  bgcolor="<%=value_c%>" align="center" style="font-weight:bold;">파일선택</td>
			    <td  width="330" align="left"><input type = "file"
			     	name = "selectfile"></td>
			  </tr>
			  
			  <tr>
			    <%-- <td  width="70"  bgcolor="<%=value_c%>" align="center" >비밀번호</td>
			    <td  width="330" align="left"> --%>
			     <input type="hidden" size="8" maxlength="12" 
			             name="passwd" style="ime-mode:inactive;" value = "<%=passwd%>"> 
				 <!-- </td> -->
			  </tr>
			  
			  <tr>
			    <td height="70px" colspan=2 bgcolor="<%=value_c%>" align="center"> 
			      <input type="submit" value="글쓰기" class="btn_write">  
			      <input type="reset" value="다시작성" class="btn_rewrite">
			      <input type="button" value="목록보기" OnClick="window.location='list.do'" class="btn_list">
			    </td>
			  </tr>
			</table>
			<%
			}catch(Exception e){}
			%> 
			</form>
		</div>
	</section>
</body>
</html>