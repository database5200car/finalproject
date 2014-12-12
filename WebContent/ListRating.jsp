<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*,java.util.*,controller.*,details.*,java.io.*,favorite.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
<%
String make = request.getParameter("make");
String model = request.getParameter("model");
String year = (String)request.getParameter("year");
carJSON_description cd = new carJSON_description();
	car c = new car();
	car c1 = new car();
	c = cd.getCarMakeBymmy(make, model, year);
	int id = c.getStyle_id();
	Integer temp = (Integer) id;
	String car_id = temp.toString();
	c1 = cd.getCarMakeById(car_id);
	
	Float rat = c.rating;
	int cou = c.rev_count;
	String img = c1.getImg();

	FavoriteDao favoritedao=new FavoriteDao();
	List<Favorite> favorites= new ArrayList<Favorite>();
	String username = (String)session.getAttribute("myusername");
%>			
<div class="content_bg">
<div class="wrap">
<div class="wrapper">
	<div class="main">
		<div class="details">
			<img src=<%=img %>> >
			<h2 class="style">Customer rating for your selection:(<%= year %> <%= make %>+<%= model %>)</h2>	
		</div>
		<div>
				 <h2 class="style"> review from: <%= cou %> Edmunds users </h2>>
		</div>
				 <h2 class="style"> average rating: <%=rat %></h2>
			</div>	 
				 
				 <h2 class="style">Data report from edmunds.com<a ></a></h2>
</div>
</div>
</div>
<form action="success.jsp">
<button name="like" value="like" class="btn btn-primary btn-block">I like it!</button>
<%	if((username==null||username.equals(""))){%><script><%=(String)session.getAttribute("myusername") %>
			alert("Please log in before you add your favorite car!");
			</script>
	<%}else{
		int yearI=Integer.parseInt(year);
		Favorite favorite= new Favorite(id,username);
		make mk=new make(model,make);
		model ml=new model(id,model);
		year yr=new year(id,yearI);
		
		favoritedao.createfav(favorite);
		favoritedao.createmake(mk);
		favoritedao.createmodel(ml);
		favoritedao.createyr(yr);
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