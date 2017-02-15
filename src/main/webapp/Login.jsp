
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login page</title>
</head>
<body>
<h2>User Login</h2>
	<form action="user/login" method="GET">
		Email : <input type="text" name="email" required autofocus /> <br>
		Password : <input
			type="password" name="pwd" required /><br>
		<button type="submit">Submit</button><br>
<br>
${ERROR}
	</form>
<a href="UserSignUp.jsp">New User Register here</a>
	
</body>
</html>
