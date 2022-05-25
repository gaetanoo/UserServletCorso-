<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href ="./css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>UserList</title>
</head>
<body>
<header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color:  #0040bf;">
                
                <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>" class="navbar-brand">Home</a></li>
                    </ul>

              <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/add.jsp" class="navbar-brand">New User</a></li>
                    </ul>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="navbar-brand">Users List</a></li>
                    </ul>
                </nav>
            </header>
	<div>
	<br> 
	
	<table class= "table table-bordered">
		<thead>
	
			<tr>
				<th>Id</th> 
				<th>Name</th>
				<th>Email</th>
				<th>Age</th>
				<th>DateofBirth</th>
				<th>Country</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUser}">

				<tr>
					<td><c:out value="${user.id}" /></td> 
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.age}" /></td>
					<td><c:out value="${user.dateOfBirth}" /></td>
					<td><c:out value="${user.country}" /></td>
					
				 	<td><a href="edit?id=<c:out value='${user.id}'/>">Edit </a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${user.id}' />">Delete</a></td> 
				</tr> 
			</c:forEach>
			</tbody>
			</table>
			</div>
</body>
</html>