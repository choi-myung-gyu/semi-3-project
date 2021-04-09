<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardVO, java.util.ArrayList" %>
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
    <%
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	%>
    <section class="container" style="margin-top: 1rem;">
        
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>좋아요</th>
                </tr>
            </thead>
            <tbody>
            <%
                ArrayList<BoardVO> datas = (ArrayList<BoardVO>)request.getAttribute("datas");
                for(BoardVO data: datas) {
            %>
                    <tr>
                        <td><%=data.getBtype() %></td>
                        <td><%=data.getTitle() %></td>
                        <td><%=data.getId() %></td>
                        <td><%=data.getCreateDate() %></td>
                        <td><%=data.getViewCnt() %></td>
                        <td><%=data.getCreateDate() %></td>
                    </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <div class="form-group text-right">
            <a class="btn btn-sm btn-outline-dark" href="./board/write">글쓰기</a>
        </div>
    </section>
</body>
</html>