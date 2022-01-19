<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  action="student-response.jsp"-->

		<table border="1px solid black">
		<tr>
			<th>ID</th>
			<th>firstName</th>
			<th>lastName</th>
			<th>specialty</th>
			<th>phone</th>
			<th>departmentId</th>
			<th>email</th>
			<th>certifications</th>
		</tr>
		<c:forEach items="${list}" var="x">
			<tr>
				<td>${x.id}</td>
				<td>${x.email}</td>
				<td>${x.firstName}</td>
				<td>${x.lastName}</td>
				<td>${x.phone}</td>
				<td>${x.specialty}</td>
				<td>${x.certifications}</td>
				<td>${x.department.id}</td>
			</tr>
		</c:forEach>

	</table>

	

</body>
</html>