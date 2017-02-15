
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Sign up page</title>
</head>
<body>

<h2>Employee Registration</h2><br><br><br>
	<form action="emp/reg" method="POST">
		User name <input type="text" name="uname" required autofocus /> <br><br>
		EmailId : <input type="text" name="emailId" required /><br><br>
		Password : <input type="password" name="pwd" required /><br><br>
		Department : <select name="dept">
		<option value="HR">HR</option>
		<option value="Software">Software</option>
		</select><br><br>
		Role : <select name="dept">
		<option value="Admin">Admin</option>
		<option value="Developer">Developer</option>
		<option value="Tester">Tester</option>
		<option value="HRExecutive">HR Executive</option>
		</select><br><br>
		<button type="submit">Register</button>

	</form>

	
</body>
</html>
