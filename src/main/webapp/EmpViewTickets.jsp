
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
					
					<th>status</th>
					<th>Resolve ticket</th>
					<th>Reassign ticket</th>
					
				</tr>
			</thead>
	<c:forEach var="c" items="${TICKET_LIST}">
	
			<tbody>
				<tr>
					<td>${c.id}</td>
				
					<td>${c.subject}</td>

					<td>${c.description}</td>
				
					<td>${c.status}</td>

					<td><a href="../employee/replyPage?ticId=${c.id}">Resolve</a></td>
					<td><a href="../employee/reassignPage?ticId=${c.id}">Reassign</a></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	

	<br>
	<br>

</body>
</html>
