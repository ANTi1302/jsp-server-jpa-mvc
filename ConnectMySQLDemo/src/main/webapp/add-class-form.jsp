<!DOCTYPE html>
<html>
<head>
	<title>Add Student</title>
	<link type="text/css" rel="stylesheet" href = "css/style.css">
	<link type="text/css" rel="stylesheet" href = "css/add-student-style.css">
</head>

<body>
	<div id = "wrapper">
		<div id = "header">
			<h2>FooBar University</h2>
		</div>
	</div>
	<div id = "container">
		<h3>Add Class</h3>
		<form action="ClassControllerServlet" method="GET">
			<input type="hidden" name="command" value = "ADD"/>
			<table>
				<tbody>
					<tr>
						<td><label>Class name : </label></td>
						<td><input type="text" name = "firstName" /></td>
					</tr>
					<tr>
						<td><label>Room number : </label></td>
						<td><input type="text" name = "lastName" /></td>
					</tr>
					<tr>
						<td><label>Number of periods : </label></td>
						<td><input type="text" name = "email" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value = "Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style= "clear: both;"></div>
		<p>
			<a href="ClassControllerServlet">Back to List</a>
		</p>
		
	</div>
	

</body>
</html>