<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Student Management System</title>
</head>

<body>

	<div class="container">

		<h3>Student Management System</h3>
		<hr>

		
			<!-- Add a button -->
			<a href="/StudentManagementSystem/Student/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student Info </a>
				<a href="/StudentManagementSystem/logout" class="btn btn-primary btn-sm mb-3">
				 Logout</a>
				
			
  <table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Country</th>
					<th>Department</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Student}" var="tempObj">
					<tr>
						<td><c:out value="${tempObj.name}" /></td>
						<td><c:out value="${tempObj.country}" /></td>
						<td><c:out value="${tempObj.department}" /></td>
						<td>
							 <a
							href="/StudentManagementSystem/Student/showFormForUpdate?stId=${tempObj.id}"
							class="btn btn-info btn-sm"> Update </a> 
							<a href="/StudentManagementSystem/Student/delete?stId=${tempObj.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete ?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>