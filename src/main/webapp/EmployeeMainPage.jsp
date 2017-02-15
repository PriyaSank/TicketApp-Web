
<!DOCTYPE html>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style>
#form{
margin-top:05%;
}
#top{
margin-left:30%;
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Main page</title>
</head>
<body style="background-color:#484846">
<div class="col-lg-12" id="top">
	<h1 id="h1" style="color:#ffffff">TICKET MANAGEMENT SYSTEM</h1>
	
	<div  class="col-lg-6" >
	<table>
	<tr>
	<td>
	<form action="../employee/viewTickets" method="GET" id="form">
	<input type="hidden" name="email" value=${EMAILID}>
		<button type="submit" class="btn-primary">View Tickets</button>
	</form>
	
		<br>
	
<form action="../employee/logout" method="GET">
	<button type="submit">Logout</button>
	</form>
	</td>
	<td>
	</td>
	</tr>
	</table>
	</div>
	
</div>	
</body>
</html>
