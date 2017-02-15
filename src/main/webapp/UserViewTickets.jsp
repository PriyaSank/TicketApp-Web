
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket View page</title>
</head>
<body>

	<h1>TICKETS</h1>
	<br>
	<br>
	<br>

	<table border="1">
			<thead>
				<tr>
					<th>Ticket id</th>
					<th>subject</th>
					<th>description</th>
					<th>status</th>
					<th>Reopen ticket</th>
					<th>Close ticket</th>
					
				</tr>
			</thead>
	<c:forEach var="c" items="${TICKET_LIST}">
	
			<tbody>
				<tr>
					<td>${c.id}</td>
				
					<td>${c.subject}</td>

					<td>${c.description}</td>
					<td>${c.status}</td>

					<td><a href="../user/reopenTicket?ticId=${c.id}">Reopen</a></td>
					<td><a href="../user/closeTicket?ticId=${c.id}">Close</a></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	

	<br>
	<br>

</body>
</html>
