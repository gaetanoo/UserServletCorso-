<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Add User</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color:  #0040bf">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>"
					class="navbar-brand">Home</a></li>
			</ul>



			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/add.jsp"
					class="navbar-brand">New User</a></li>
			</ul>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="navbar-brand">Users List</a></li>
			</ul>
		</nav>
	</header>
	<div align="center">
  <h1>New User</h1>
  
  <form action="<%=request.getContextPath()%>/add" method="post">
  <c:if test="${errorName != null}">
      <h2>${errorName}</h2>                      
     </c:if>
  <div class="container col-md-5">
		<div class="card">
			<div class="card-body">
  	<fieldset class="form-group" width = "50">
					<label>Name</label> <input type="text"
						value='${user.name}' class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value='${user.email}' class="form-control"
						name="email" width= "80">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="text"
						value='${user.age}' class="form-control"
						name="age">
				</fieldset>

				<fieldset class="form-group">
					<label>Date of Birth</label> <input type="text"
						value='${user.dateOfBirth}' class="form-control"
						name="dateOfBirth">
				</fieldset>



				<fieldset class="form-group">
					<label> Country </label> <input type="text"
						value='${user.country}' class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</div>
				</div>
				</div>
				</form>
 
 </div>
</body>
</html>