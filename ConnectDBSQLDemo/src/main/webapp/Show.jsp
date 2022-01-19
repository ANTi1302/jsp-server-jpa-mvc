

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<table border="1px solid black">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Dob</th>
		</tr>
		<c:forEach items="${list}" var="x">
			<tr>
				<td>${x.id}</td>
				<td>${x.name}</td>
				<td>${x.gender}</td>
				<td>${x.dob}</td>
				<td><a href="update?sid=${x.id}">update</a> 
				<%--                         <a href="delete?sid=${x.id}">delete</a> --%>
					<a href="#" onclick="showMess(${x.id})">delete</a></td>
			</tr>
		</c:forEach>

	</table>
	<a href="Add.jsp">Create student</a>
</body>
<script>
function showMess(id) {
	var option= confirm('Are you muon xoa');
	if(option===true){
		window.location.href='delete?sid='+id;
	}
}
</script>
</html>
