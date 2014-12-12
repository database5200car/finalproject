<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=GB18030"  
    pageEncoding="GB18030"%>
<html>
<head>
<title>Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css\style.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<!--start header-->
<div class="h_bg">
<div class="wrap">
<div class="wrapper">
<div class="header">
		<div class="logo">
		<h2 class="style">Car Comparison for CS5200</h2>
		<h3 style="color:#ffffff">Wei Zhu, Tuo Li, Zhichao Huang</h3>
	</div>
	<div class="cssmenu">
	<ul>
	   <li class="active"><a href="index.jsp"><span>Log Out</span></a></li>
	   <li class="active"><a href="mainpage.jsp"><span>Go Back</span></a></li>
	 <div class="clear"></div>
	 </ul>
	</div>
	<div class="clear"></div>
</div>
</div>
</div>
</div>
<!-- start content -->
<div class="content_bg">
<div class="wrap">
<div class="wrapper">
	<div class="main">
		<div class="details">
			<h2 class="style">Put the information of car please!</h2>
		<div class="det_pic img_style">
			<img src="images/det-pic.jpg" alt="">		
		</div>		
		</div>
		<div >
   <form action="ListRating.jsp">
    <h2 class="style">Make</h2>
	<input id="make"   name="make" value="" ></input>
	 <h2 class="style">Model</h2>
	<input id="model"  name="model" value=""/></input>
	 <h2 class="style">Year</h2>
	<input id="year"  name="year" value=""/></input>
	<div><span>
	<input type="submit" value="Submit" name="submit" class="submit" />
	</span></div><%
	String submission = request.getParameter("submit");
	String make = request.getParameter("make");
	String model = request.getParameter("model");
	String year = request.getParameter("year");
	if("Submit".equals(submission)){
		if((make==null||make.equals(""))&(year==null||year.equals(""))&(model==null||model.equals(""))){
			%>
			<script>
				alert("Please put enough details!");
			</script>
			<%
		}
	}
	%>
   </form>
		</div>
	</div>
</div>
</div>
</div>
<div class="footer_bg">
<div class="wrap">
<div class="wrapper">
	<div class="footer">
		<div class="copy">
			<p class="w3-link"></a></p>
		</div>

		<div class="clear"></div>
	</div>
</div>
</div>
</div>

</body>
</html>