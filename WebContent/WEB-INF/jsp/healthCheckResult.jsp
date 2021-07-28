<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>筋トレ</title>
</head>
<body>
	<h1>筋トレ</h1>
	<p>
		身長:${ health.height }<br> 体重:${ health.weight }<br>
		BMI:${ health.bmi }<br> 体型:${ health.bodyType }<br>
	</p>
	<form action="ListServlet" method="post">
		<input type="submit" value="戻る"> <br>
		</form>
</body>
</html>