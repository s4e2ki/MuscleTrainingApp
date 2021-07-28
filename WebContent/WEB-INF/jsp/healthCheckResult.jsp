<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MuscleHustle</title>
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel=stylesheet href="css/bootstrap.min.css">
</head>
<body>
	<div style="text-align: center">
		<h1>あなたの体型は...</h1>
		<h1>${health.bodyType}体型です！</h1>
		<h2 style="color: red">一言アドバイス</h2>
		<h3 style="color: red">${health.bodyTypeAdv}</h3>
	</div>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">身長</th>
				<th scope="col">体重</th>
				<th scope="col">BMI</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${ health.height }</td>
				<td>${ health.weight }</td>
				<td>${ health.bmi }</td>
			</tr>
		</tbody>
	</table>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">BMI</th>
				<th scope="col">肥満度</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>18.5未満</td>
				<td>低体重</td>
			</tr>
			<tr>
				<td>18.5～25未満</td>
				<td>普通体重</td>
			</tr>
			<tr>
				<td>25～30未満</td>
				<td>肥満度 1</td>
			</tr>
			<tr>
				<td>30～35未満</td>
				<td>肥満度 2</td>
			</tr>
			<tr>
				<td>35～40未満</td>
				<td>肥満度 3</td>
			</tr>
			<tr>
				<td>40以上</td>
				<td>肥満度 4</td>
			</tr>
		</tbody>
	</table>
	<hr>
	<form action="ListServlet" method="post">
		<p style="text-align:center"><input type="submit" value="戻る"></p> <br>
	</form>
</body>
</html>