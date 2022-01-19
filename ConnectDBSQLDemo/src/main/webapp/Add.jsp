<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add" method="post">
	<table>
	
		<tr>
			<td>Name:</td>
			<td><input type="text" placeholder="name" name="name"></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td>  <input type="radio" name="gender" value="1">Male
                        <input type="radio" name="gender" value="0">Female</td>
		</tr>
		<tr>
			<td>Dob:</td>
			<td><input type="date" placeholder="dob" name="dob"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"></td>
			<td><input type="reset" placeholder="Reset"></td>
		</tr>
	</table>
	</form>
</body>
</html>