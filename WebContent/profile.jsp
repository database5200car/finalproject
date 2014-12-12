<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="user.*, java.util.*, friend.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.js"></script>
<div class="content_bg">
<h2 class="style">Please put your old password!</h2>
<form>
<input id="oldpassword" type="password" name="oldpassword" placeholder="OldPassword" class="form-control"/>
<button name="Check" value="check" class="btn btn-primary btn-block">Check</button>
<%
	UserDao userdao=new UserDao();
	String update = request.getParameter("Check");
	String oldpassword = request.getParameter("oldpassword");
	String username = (String)session.getAttribute("myusername");
	User userprofile=null;
	if("check".equals(update))
	{
		if((oldpassword==null||oldpassword.equals(""))){
			%>
			<table>
				<tr><td>Please put your old password to get the access!</td></tr>
			</table>
			<%
		}
		else{
			userprofile= userdao.findUserByUsernamePassword(username, oldpassword);
			if(userprofile!=null){
				%><script>
				window.location.href="http://localhost:8080/finalproject/changepassword.jsp";
				</script><%
			}else{
				%><script>
						alert("The password is not correct!");
				</script>
				<%
				}
		}
	}%>
</form>
</div>
<div class="content_bg">
<form action="homepage.jsp">
<button name="Goback" class="btn btn-primary btn-block">Go Back</button>
</form>
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