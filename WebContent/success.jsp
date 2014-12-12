<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.*,controller.*,details.*,java.io.*,favorite.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<title>Insert title here</title>
</head>
<body class="content_bg">

<form>
<div  class="content_bg">
<h2 class="style"> Successful!!!</h2>
<button name="Goback" value="goback" class="btn btn-primary btn-block">Go Back</button>
</div>
<%	String username = (String)session.getAttribute("myusername");
	FavoriteDao favoritedao=new FavoriteDao();
	List<dummyobj> ds= new ArrayList<dummyobj>();
	ds = favoritedao.selectallfavorite(username);
	if(ds!=null){
		for(dummyobj dt:ds) {
%>		<table>
				<tr><td><h2 class="style"><%= dt.getFavorite().getFavoriteid() %>(id)+</h2></td>
					<td><h2 class="style"><%= dt.getMk().getMake() %>+</h2></td>
					<td><h2 class="style"><%= dt.getMl().getModel() %>+</h2></td>
					<td><h2 class="style"><%= dt.getYr().getYear() %></h2></td>
				</tr>
		</table>
<%
		}
	}else{
		%><script>
		alert("There is no records available!");
		</script>
<%
	}
	String goback = request.getParameter("Goback");
	if("goback".equals(goback)){
		%><script>
		window.location.href="http://localhost:8080/finalproject/mainpage.jsp";
		</script><%
	}
	%>
	
</form>
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