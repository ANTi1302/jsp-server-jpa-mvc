<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Class" 
				   onclick="window.location.href='add-class-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Mã Lớp</th>
					<th>Tên Lớp</th>
					<th>Số Phòng</th>
					<th>Số Tiết</th>
				</tr>
				
				<c:forEach var="tempClass" items="${LOPHOC_LIST}">
					<c:url var="tempLinkDetails" value="ClassControllerServlet">
						<c:param name="command" value="DETAILS" />
						<c:param name="maLop" value="${tempClass.maLop}" />
					</c:url>
					<!-- URL load -->
					<c:url var="tempLink" value="ClassControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="maLop" value="${tempClass.maLop}" />
					</c:url>

					<!--  URL delete -->
					<c:url var="deleteLink" value="ClassControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="maLop" value="${tempClass.maLop}" />
					</c:url>																		
					<tr>
						<td> ${tempClass.maLop} </td>
						<td> ${tempClass.tenLop} </td>
						<td> ${tempClass.soPhong} </td>
						<td> ${tempClass.soTiet} </td>
						<td> 
							<a href="${tempLinkDetails}">Xem chi tiết</a>
							<a href="${tempLink}">Update</a> 							 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>
</html>








