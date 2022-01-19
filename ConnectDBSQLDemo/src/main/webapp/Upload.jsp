
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
	<table>
	<tr>
			<td>ID:</td>
			<td><input type="text" placeholder="id" name="id" value="${st.id}"></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" placeholder="name" name="name" value="${st.name}"></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td>  <input type="radio" name="gender"  value="true" ${st.gender == true? "checked":"" }>Male
                        <input type="radio" name="gender" value="false" ${st.gender == false?"checked":""}>Female</td>
		</tr>
		<tr>
			<td>Dob:</td>
			 <c:set var = "now" value = "${st.dob}" />
			<td><input type="date" placeholder="dob" name="dob" value = "${now}"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"></td>
			<td><input type="reset" placeholder="Reset"></td>
		</tr>
	</table>
	</form>
</body>
</html>