
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Assign page</title>
</head>
<body>

	<h1>TICKET ASSIGNMENT</h1>
	<br>
	<br>
	<br>

	<form action="../admin/assignEmp" method="GET">
		

		Employee Id : <input
			type="text" name="empId" required /><br><br><br>
		<button type="submit">Assign</button><br>
<br><br><br>
${ERROR}
	</form>

	<br>
	<br>

</body>
</html>
