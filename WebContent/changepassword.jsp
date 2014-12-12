<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="user.*, java.util.*, friend.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<div class="content_bg">
<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.js"></script>
<div  class="content_bg">
<h2 class="style">Please enter your new password: </h2>
<form>
<input id="password" type="password" name="password" placeholder="Password" class="form-control"/>
<input id="password2" type="password" name="password2" placeholder="Password Again" class="form-control"/>
<button name="Update" value="update" class="btn btn-primary btn-block">Update</button>
</form>
<form action="profile.jsp">
<button name="Goback" value="goback" class="btn btn-primary btn-block">Go Back</button>
</form>
<%
	UserDao userdao=new UserDao();
	String update = request.getParameter("Update");
	String password = request.getParameter("password");
	String password2 = request.getParameter("password2");
	String username = (String)session.getAttribute("myusername");

	if("update".equals(update))
	{
		if((password==null||password.equals(""))||(password2==null||password2.equals(""))){
			
			%><script>
			alert("Please enter new password!");
			</script>
			<%
		}
		else if(password.equals(password2)){
			User user = new User(username,password);
			userdao.updateUser(user);		
			%><script>
			window.location.href="http://localhost:8080/finalproject/homepage.jsp";
			</script><%
		}else{
			%><script>
			alert("Please make sure your two passwrods are same!");
			</script>
			<%
		}
	}
		%>
</div>
</div>
<div class="footer_bg">
<div class="wrap">
<div class="wrapper">
<div class="footer">
</div>
</div>
</div>
</div>
</body>
</html>