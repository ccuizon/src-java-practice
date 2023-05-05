<html>
<head>
<title>Login Page</title>
</head>
<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet">
<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Login</h1>
		<pre>${errorMessage}</pre>
		<form method="post">
			Name: <input type="text" name="name"> Password: <input
				type="password" name="password"> <input type="submit">
		</form>
	</div>
</body>
</html>