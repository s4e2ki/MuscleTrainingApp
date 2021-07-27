<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Yomogi&display=swap" rel="stylesheet">
<link rel="shortcut icon" href="images/favicon.ico">
<link rel=stylesheet href="css/bootstrap.min.css">
<title>TODOアプリ出力画面</title>
</head>
<body onload="selectboxChange();">
	<div style="text-align: right;">
		<a href="LogoutServlet">ログアウト</a>
	</div>
	<div style="text-align: center">
		<img src="./images/MuscleHustle.png" alt="ロゴ" width="400" height="100">
	</div>
	<h2 style="text-align: center" style="font-family: 'Yomogi' , cursive">${user.name}さんのTODO</h2>
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
	<hr>
	<span style="color: red">${todo.errorMsg}</span>
	<table class="table" border='1' id="targetTable">
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">重要度</th>
				<th scope="col">内容</th>
				<th scope="col">期日</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="todo" items="${todoList}" varStatus="status">
				<tr>
					<th scope="row">${status.count}</th>
					<td>${todo.importance}</td>
					<td>${todo.content}</td>
					<td>${todo.deadline}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<form action="UpdateServlet" method="post">
		変更No<select name="no" id="no" onchange="selectboxChange();">
			<c:forEach var="todo" items="${todoList}" varStatus="status">
				<option value="${todo.id}">${status.count}</option>
			</c:forEach>
		</select> <select name="importance" id="importance">
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
		</select> <input type="text" name="content" id="content" size="20" value="">
		<input type="date" name="deadline" id="deadline" value=""> <input
			type="submit" value="変更">
	</form>
	<hr>
	<c:if test="${not empty removeErrorMsg}">
		<div class="alert alert-danger" role="alert">${removeErrorMsg}</div>
	</c:if>
	<form action="RemoveServlet" method="post">
		削除No:<select name="no">
			<c:forEach var="todo" items="${todoList}" varStatus="status">
				<option value="${todo.id}">${status.count}</option>
			</c:forEach>
		</select><input type="submit" value="削除">
	</form>
	<hr>
	<form action="LoginServlet" method="get">
		<input type="submit" value="戻る"> <br>
	</form>
	<script type="text/javascript">
		function selectboxChange() {
			//選択された変更Noを取得
			var row = document.getElementById("no").selectedIndex + 1;
			//TODOリストのテーブルを取得
			var table = document.getElementById('targetTable');
			//選択された変更NoからTODOリストのテーブルの行・列の値を取得し、変更情報としてinput要素のvalueに設定
			document.getElementById("importance").options[(5 - table.rows[row].cells[1].innerText)].selected = true;
			document.getElementById('content').value = table.rows[row].cells[2].innerText;
			document.getElementById('deadline').value = table.rows[row].cells[3].innerText;
		}
	</script>
</body>
</html>