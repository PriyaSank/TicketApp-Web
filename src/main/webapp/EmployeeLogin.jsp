
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login page</title>
</head>
<body>
<h2>Employee Login</h2>
	<form action="employee/login" method="GET">
		Email : <input type="text" name="email" required autofocus /> <br>
		Password : <input
			type="password" name="pwd" required /><br>
		<button type="submit">Submit</button><br>
${ERROR}
	</form>

	
</body>
</html>
