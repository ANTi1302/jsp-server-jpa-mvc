<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Update Class</title>
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
		<h3>Update Class</h3>
		<form action="ClassControllerServlet" method="GETS">
			<input type="hidden" name="command" value = "UPDATE"/>
			<input type="hidden" name="maLop" value = "${THE_STUDENT.maLop }"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Mã Lớp : </label></td>
						<td><input type="text" name = "maLop" 
									value="${THE_STUDENT.maLop}"/></td>
					</tr>
					<tr>
						<td><label>Tên Lớp : </label></td>
						<td><input type="text" name = "tenLop" 
									value="${THE_STUDENT.tenLop }"/></td>
					</tr>
					<tr>
						<td><label>Số phòng : </label></td>
						<td><input type="text" name = "soPhong" 
									value="${THE_STUDENT.soPhong }"/></td>
					</tr>
					<tr>
						<td><label>Số tiết : </label></td>
						<td><input type="text" name = "soTiet" 
									value="${THE_STUDENT.soTiet }"/></td>
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