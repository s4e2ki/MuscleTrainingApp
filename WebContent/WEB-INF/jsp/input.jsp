<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel=stylesheet href="css/bootstrap.min.css">
<link rel="shortcut icon" href="images/favicon.ico">
<title>TODOアプリ出力画面</title>
</head>
<body>
	<h1>TODOアプリケーション</h1>
	<h2>${user.name}のTODOリスト</h2>
	<span style="color: red">${errorMsg}</span>
	<form action="/MuscleTrainingApp/InputServlet" method="post">
		重要度:<select name="importance">
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
		</select><br> 内容:<input type="text" name="content"><br> 期日:<input
			type="date" name="deadline"><br> <input type="submit"
			value="登録">
	</form>
</body>
</html>