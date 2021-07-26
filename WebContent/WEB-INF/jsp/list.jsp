<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="images/favicon.ico">
<title>TODOアプリ出力画面</title>
</head>
<body onload="selectboxChange();">
<div style="text-align: right;"><a href="LogoutServlet">ログアウト</a></div>
	<h1>TODOアプリケーション</h1>
	<h2>${user.name}のTODOリスト</h2>
	<span style="color: red">${todo.errorMsg}</span>
	<table border='1' id="targetTable">
		<thead>
			<tr>
				<th>No</th>
				<th>重要度</th>
				<th>内容</th>
				<th>期日</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="todo" items="${todoList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
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
		</select>
			<select name="importance" id="importance">
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
		</select>
			<input type="text" name="content"id="content"size="20"value="">
			<input type="date" name="deadline"id="deadline" value="">
			<input type="submit"value="変更">
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
		</select><input type="submit"value="削除">
	</form>
	<hr>
	<form action="InputServlet" method="get">
		<input type="submit"value="戻る">
	<br>
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