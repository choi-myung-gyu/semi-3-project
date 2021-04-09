<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardVO, java.util.ArrayList" %>
<%@ page info="board" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<%@ include file="/WEB-INF/module/css.jsp" %>
</head>
<body>
    <header>
        <%@ include file="/WEB-INF/module/top_nav.jsp" %>
    </header>
    <section class="container" style="margin-top: 1rem;">
    	<form action="./write" method="post">
            <div class="form-group">
                <label for="id_title">제목</label>
                <input class="form-control" type="text" id="id_title" name="title" maxlength="200" required>
            </div>
            <div class="form-group">
                <label for="id_btype">구분</label>
                <select class="form-control" id="id_btype" name="btype">
                    <option value="notice">공지사항</option>
                    <option value="free" selected>자유게시판</option>
                    <option value="humor">유머게시판</option>
                </select>
            </div>
            <div class="form-group">
                <label for="id_author">작성자</label>
                <input class="form-control" type="text" id="id_author" name="author" maxlength="20" required>
            </div>
            <div class="form-group">
                <label for="id_context">내용</label>
                <textarea class="form-control" id="id_context" name="context" rows="20" required></textarea>
            </div>
            <div class="form-group text-right">
                <button class="btn btn-sm btn-outline-primary" type="submit">글쓰기</button>
            </div>
    	</form>
    </section>
</body>
</html>