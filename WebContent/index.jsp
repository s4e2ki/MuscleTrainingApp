<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>TODOアプリログイン画面</title>
</head>
<body style="text-align: center">
	<h1 style="padding: 60px 10px">Say!ムキムキ!性!モテモテ!アプリ</h1>
	<h2 class="h3 mt-2 mb-3 font-weight-normal">ログイン</h2>
	<span style="color: red">${errorMsg}</span>
	<form class="w-25 mx-auto" action="LoginServlet" method="post">
		<label for="name" class="sr-only"></label> <input class="form-control"
			type="text" name="name" placeholder="ユーザー名" required autofocus /> <label
			for="password" class="sr-only"></label> <input class="form-control"
			type="password" name="pass" placeholder="パスワード" required> <input
			class="btn btn-outline-primary my-1" type="submit" value="Sign In" />
	</form>
</body>
</html>