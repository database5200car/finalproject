<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="user.*, java.util.*, friend.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head class="content_bg">
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title style="border:2 width:300px ext-align:center solid #9966FF">Welcome to Connection</title>
</head>
<body class="content_bg">
<h2 class="style" >Hello <%=(String)session.getAttribute("myusername") %> </h1>
<link href="css/bootstrap.css" rel="stylesheet"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/camera.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery.js"></script>
<div class="content_bg" >
<form action="homepage.jsp">
<div class="button"><span>
<input id="usernamefr" name="usernamefr" placeholder="Namefr" class="form-control"/>
</span></div>
<div><span>
<select name="comment" placeholder="Comment">
<option value="good">good</option>
<option value="close">close</option>
<option value="family">family</option>
<option value="normal">normal</option>
<option value="attractive">attractive</option>
</select>
</span></div>
<div class="button"><span>
<input id="year" name="year" placeholder="Year" class="form-control"  />
</span></div>
<div class="button" ><span>
<button style="width=25px;height:50px" name="action" value="createfr"  class="btn btn-primary btn-block">Create Friend</button>
</span></div>
<div class="button"><span>
<button style="width=50px;height:50px" name="action" value="update"  class="btn btn-primary btn-block">Update</button>
</span></div>
<div class="button"><span>
<button style="width=50px;height:50px" name="action" value="findallfriend"  class="btn btn-primary btn-block">Find All Friends</button>
</span></div>
<div class="button"><span>
<button name="action" value="findfriendbyusername"  class="btn btn-primary btn-block">Find Friend by Username</button>
</span></div>
<div class="button"><span>
<button name="action" value="findfriendbyyear"  class="btn btn-primary btn-block">Find Friend by Year</button>
</span></div>
<div class="button"><span>
<button name="action" value="findfriendbycomment"  class="btn btn-primary btn-block">Find Friend by Comment</button>
</span></div>
<div class="button"><span>
<button name="action" value="delete"  class="btn btn-primary btn-block">Delete</button>
</span></div>
</form>
<%	
	FriendDao dao=new FriendDao();
	String action = request.getParameter("action");
	String usernamefr = request.getParameter("usernamefr");
	String comment = request.getParameter("comment");
	String year = request.getParameter("year");
	String usernamefk = (String)session.getAttribute("myusername");
	System.out.println(usernamefk);
	Friend friend =null;
	List<Friend> friends=new ArrayList<Friend>();
	
	if("findallfriend".equals(action)){
		friends=dao.selectallfriend(usernamefk);
		if(friends!=null){
			System.out.println("aaa");
			for(Friend fd:friends) {
			%>
			<table>
				<tr><td><h2 class="style">*<%= fd.getUsernamefr() %>**</h2></td>
					<td><h2 class="style"> **<%= fd.getComment() %>**</h2></td>
					<td><h2 class="style"> **<%= fd.getYear() %>**</h2></td>
					<td><h2 class="style">** <%= fd.getUsernamefk() %>**</h2></td>
				</tr>
			</table>
			<%}
		}else{
			%><script>
						alert("There is no records available!");
			</script>
			<%
		}
	}else if("findfriendbyusername".equals(action)){
		if(usernamefr==null||usernamefr.equals("")){
			%><script>
						alert("Please type your friend's username!");
					</script>
			<%
		}else{
			friend=dao.selectfrByUsername(usernamefr,usernamefk);
			if(friend!=null){
			%>
			<table>
				<tr><td><h2 class="style"> **<%= friend.getUsernamefr() %>**</h2></td>
					<td><h2 class="style"> **<%= friend.getComment() %>**</h2></td>
					<td><h2 class="style"> **<%= friend.getYear() %>***</h2></td>
					<td><h2 class="style"> **<%= friend.getUsernamefk() %>**</h2></td>
				</tr>
			</table>
			<%}else{
				%><script>
						alert("here is no records available!");
					</script>
				<%
				}
		}
	}else if("createfr".equals(action)){
		if((usernamefr==null||usernamefr.equals(""))&(comment==null||comment.equals(""))&(year==null||year.equals(""))){
			%><script>
						alert("Please put enough details!");
					</script>
			<%
		}else{
			int yearI = Integer.parseInt(year);
			friend= new Friend(usernamefr,comment,yearI,usernamefk);
			dao.create(friend);
			friends=dao.selectallfriend(usernamefk);
			if(friend!=null){
				for(Friend fd:friends) {
				%>
				<table>
					<tr><td><h2 class="style"> **<%= fd.getUsernamefr() %>**</h2></td>
					<td><h2 class="style">** <%= fd.getComment() %>**</h2></td>
					<td><h2 class="style"> **<%= fd.getYear() %>**</h2></td>
					<td><h2 class="style"> **<%= fd.getUsernamefk() %>**</h2></td></tr>
				</table>
				<%}
				}else{
					%>
					<script>
						alert("There is no records available!");
					</script>
					<%
				}
		}
	}else if("update".equals(action))
	{
		if((usernamefr==null||usernamefr.equals(""))&(year==null||year.equals(""))){
			%>
			<script>
				alert("Please put enough details!");
			</script>
			<%
		}
		else{
			int yearI = Integer.parseInt(year);
			friend= new Friend(usernamefr,comment,yearI,usernamefk);
			dao.update(friend);
			friends=dao.selectallfriend(usernamefk);
			if(friend!=null){
				for(Friend fd:friends) {
					%>
					<table>
						<tr><td>**<h2 class="style"><%= fd.getUsernamefr() %> **</h2></td>
						<td><h2 class="style"> **<%=fd.getComment() %>**</h2></td>
						<td><h2 class="style">** <%= fd.getYear() %>**</h2></td>
						<td><h2 class="style"> **<%= fd.getUsernamefk() %>**</h2></td></tr>
					</table> 
					<%}
			}else{
				%>
				<script>
					alert("There is no records available!");
				</script>
				<%
			}
		}
	}else if("delete".equals(action)){
		if((usernamefr==null||usernamefr.equals(""))){
			%>
			<script>
				alert("Please indicate who will be removed!");
			</script>
			<%
		}else{
			dao.delete(usernamefr,usernamefk);
			friends=dao.selectallfriend(usernamefk);
			if(friends!=null){
				for(Friend fd:friends) {
				%>
				<table>
					<tr><td><h2 class="style"> **<%= fd.getUsernamefr() %> **</h2></td>
						<td><h2 class="style"> **<%= fd.getComment() %> **</h2></td>
						<td><h2 class="style"> **<%= fd.getYear() %>**</h2></td>
						<td><h2 class="style"> **<%= fd.getUsernamefk() %>**</h2></td></tr>
				</table>
				<%
				}
			}
			else{%>
			<script>
				alert("There is no records available.");
			</script>
			<%}
		}
	}else if("findfriendbyyear".equals(action)){
		if((year==null||year.equals(""))){
			%>
			<script>
				alert("Please put the year!");
			</script>
			<%
		}
		else{
			int yearI = Integer.parseInt(year);
			friends=dao.selectfrbyyear(yearI, usernamefk);
			if(friends!=null){
			for(Friend fd:friends) {
			%>
				<table>
			<tr><td><h2 class="style">** <%= fd.getUsernamefr() %>**</h2></td>
				<td><h2 class="style">** <%= fd.getComment() %>**</h2></td>
				<td><h2 class="style">** <%= fd.getYear() %>**</h2></td>
				<td><h2 class="style">** <%= fd.getUsernamefk() %>**</h2></td></tr>
				</table>
			<%}}
			else{%>
			<script>
				alert("There is no records available!");
			</script>
				<%
			}
		}
	}else if("findfriendbycomment".equals(action)){
			friends=dao.selectfrbycomment(comment, usernamefk);
			if(friends!=null){
				for(Friend fd:friends) {
				%>
					<table>
				<tr><td><h2 class="style">** <%= fd.getUsernamefr() %>**</h2></td>
					<td><h2 class="style">** <%= fd.getComment() %>**</h2></td>
					<td><h2 class="style">** <%= fd.getYear() %>**</h2></td>
					<td><h2 class="style">** <%= fd.getUsernamefk() %>**</h2></td></tr>
					</table>
				<%
				}
			}
			else{%>
			<script>
				alert("There is no records available.");
			</script>
				<%
			}
		}
	%>
</div>





<div class="content_bg">
<form action="/finalproject/profile.jsp">
<button name="changeprofile" value="Profile" class="btn btn-primary btn-block">Profile</button>
</div>
</form>
<form action="/finalproject/mainpage.jsp">
<div class="content_bg">
<button name="GoBacktoMain" value="gobacktomain" class="btn btn-primary btn-block">GoBackToMain</button>
</div>
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