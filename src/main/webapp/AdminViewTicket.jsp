
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
${ERROR}
	<table border="1">
			<thead>
				<tr>
					<th>Ticket id</th>
					<th>Subject</th>
					<th>Description</th>
					
					<th>Status</th>
					<th>Employee Id</th>
					<th>Assign Ticket</th>
					<th>Delete Ticket</th>
				</tr>
			</thead>
	<c:forEach var="c" items="${TICKET_LIST}">
	
			<tbody>
				<tr>
					<td>${c.id}</td>
				
					<td>${c.subject}</td>

					<td>${c.description}</td>
				
					<td>${c.status}</td>
					<td>${c.emp.id}</td>
					<td><a href="../admin/assignPage?ticId=${c.id}">Assign</a></td>
						<td><a href="../admin/deleteTicket?ticId=${c.id}">Delete</a></td>
					
				</tr>
			</tbody>
			</c:forEach>
		</table>
	

	<br>
	<br>

</body>
</html>
