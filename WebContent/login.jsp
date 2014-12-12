<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>login page</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
<script src="js/jquery.js"></script>
</head>
<div class="container">
<body>
	<h1>Hello world</h1>
	<form action="/finalproject/loginAction" method="post">


<input id="username" name="username" placeholder="Name" class="form-control"/>
<input id="password" name="password" placeholder="Password" class="form-control"/>
<button id="create" class="btn btn-primary btn-block">Create</button>
<button id="login" class="btn btn-primary btn-block">Login</button>
<script>
	$(function(){
		$("#create").click(createHandler);
	});
	function createHandler(){
		var newUser ={"username":$("#username").val(),"password":$("#password").val()};
		createUser(newUser);
		
	}
	function createUser(user){
		$.ajax({
			url:"http://localhost:8080/finalproject/user/login/create",
			type:"post",
			data:JSON.stringify(user),
			dataType:"json",
			contentType:"application/json",
			success:function(response){
				session.setAttribute("aaa",user);
				window.location.href="http://localhost:8080/finalproject/homepage.jsp";
				}
		})
		
	};
</script>
</form>
</body>
</div>
</html>