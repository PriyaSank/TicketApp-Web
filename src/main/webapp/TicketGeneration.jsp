
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Generation page</title>
</head>
<body>

<h2>Ticket Generation</h2><br>
	<form action="../user/ticketGen" method="GET">
	<input type="hidden" name="email" value=${EMAILID}>
		Subject : <input type="text" name="sub" required autofocus /> <br><br>
		Description : <input type="text" name="desc" required /><br><br>
		Department : <select name="dept">
		<option value="HR">HR</option>
		<option value="Software">Software</option>
		</select><br><br>
		Priority :<select name="prior">
		<option value="High">High</option>
		<option value="Medium">Medium</option>
		<option value="Low">Low</option>
		</select><br><br>
		<button type="submit">Submit</button>
${ERROR}
${MSG}
	</form>

	
</body>
</html>
