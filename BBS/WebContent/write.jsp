<!-- 게시글 쓰기 페이지 view -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 쓰기</title>
<meta name="viewport" content="width=device-width" , initial-scale="1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<style>
.btn {
	text-decoration: none;
	color: white;
	padding: 10px 20px 10px 20px;
	margin: 20px;
	float: right;
}
</style>
<body>
	<%
		String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	%>
	<!-- 게시글 쓰기 페이지 코드 -->
	<div class="container">
		<div class="row">
			<!--  writeAction.jsp -->
			<form method="post" action="writeAction.jsp">
				<!-- 로그아웃 클릭시 login.jsp(로그인 페이지) 로 이동 -->
				<a href="login.jsp" class="btn btn-primary">로그아웃</a>
				<!--  게시글 쓰기 테이플 생성 -->
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eee; text-align: center;">게시글 쓰기
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="B_TITLE" maxlength="200"></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="작성자" name="USERID" maxlength="20"></td>
						</tr>
						<tr>
							<td><textarea type="text" class="form-control"
									placeholder="글 내용" name="B_CONTENT" maxlength="2048"
									style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<!-- 등록 클릭시 bbs.jsp로(게시판 페이지) 로 이동 -->
				<input type="submit" class="btn btn-primary pull-right" value="등록">
			</form>
		</div>
	</div>
</body>
</html>