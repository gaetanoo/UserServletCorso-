<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title> Home </title>
</head>
<body>

<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color:  #0040bf">
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/add.jsp"
					class="nav-link">Add New Users</a></li>
			</ul>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">List Users</a></li>
			</ul>
		</nav>
	</header>
	
	<h1 class= "h1text"> Benvenuto nella Homepage </h1>
	
<!--  <a href= "add.jsp"> Add User</a>
<a href= "list"> User List</a>   -->

</body>
</html>