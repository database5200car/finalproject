<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>login page</title>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">



<link href="css\style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<link href="css/camera.css" rel="stylesheet" type="text/css" media="all" />
    <script type='text/javascript' src='js/jquery.min.js'></script>
    <script type='text/javascript' src='js/jquery.mobile.customized.min.js'></script>
    <script type='text/javascript' src='.js/jquery.easing.1.3.js'></script> 
    <script type='text/javascript' src='js/camera.min.js'></script> 
    
    <script>
		jQuery(function(){
			
			jQuery('#camera_wrap_1').camera({
				thumbnails: true
			});

			jQuery('#camera_wrap_2').camera({
				height: '400px',
				loader: 'bar',
				pagination: false,
				thumbnails: true
			});
		});
	</script>
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
	<div class="clear"></div>
</div>
</div>
</div>
</div>
<!-- start slider -->

<!-- start content -->
<div class="content_bg">
<div class="wrap">
<div class="wrapper">
	<div class="main">
	<!-- start content_left -->
	<div class="content_left">
	 <div class="search1">
	 	 	<h2>Login Please!</h2>
			<form action="/finalproject/loginAction" method="post">
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<label>Username:</label>
				<input type="text" name="username" />
			<label>Password:</label>
				<input type="password" name="password"  />
				<input type="submit" value="Submit" name="submit" class="submit" />
				<input type="submit" value="Register" name="submit" class="submit" />
			</form>			
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	</div>
</div>
	<!-- start content_right -->
	<div class="content_right">
			 <div class="gallery">
			 	<h2>Welcome to Car Search for CS5200!</h2>
			 	
							<section>
						<ul class="lb-album">
							<li>
								<a href="#image-1">
									<img src="images/gallery1.jpg" alt="">
									<span> </span>
								</a>
								<div class="lb-overlay" id="image-1">
									<img src="images/gallery1.jpg" alt="">
									<a href="#page" class="lb-close"> </a>
								</div>
							</li>
							<li>
								<a href="#image-2">
									<img src="images/gallery2.jpg" alt="">
									<span> </span>
								</a>
								<div class="lb-overlay" id="image-2">
										<img src="images/gallery2.jpg" alt=""> 
									<a href="#page" class="lb-close"> </a>
								</div>
							</li>
							<li>
								<a href="#image-3">
									<img src="images/gallery3.jpg" alt="">
									<span> </span>
								</a>
								<div class="lb-overlay" id="image-3">
									<img src="images/gallery3.jpg" alt="image03">
									<a href="#page" class="lb-close"> </a>
								</div>
							</li>
							<li>
								<a href="#image-4">
									<img src="images/gallery4.jpg" alt="">
									<span> </span>
								</a>
								<div class="lb-overlay" id="image-4">
									<img src="images/gallery4.jpg" alt="image04">
									<a href="#page" class="lb-close"> </a>
								</div>
							</li>
								<div class="clear"></div>
						</ul>
					</section>
					</div>
                    
				<div class="image group">
				<div class="grids_of_2">
					<div class="grid images_3_of_1">
						<img src="images/pic1.jpg">
					</div>
					<div class="grid span_2_of_3">
						<h3>Enough Detailed Information</h3>
						<p class="para">By clicking the button, our website could provide the most detailed information for you.</p>
				   </div>
				  	<div class="clear"></div>
				  	</div>
				  	<div class="grids_of_2 top">
				  	<div class="grid images_3_of_1">
						<img src="images/pic2.jpg">
					</div>
					<div class="grid span_2_of_3">
						<h3>Friendly UI</h3>
						<p class="para">Our website provide friendly UI for you to manage your relationship.</p>
				   </div>
				  	<div class="clear"></div>
				  	</div>
		   		</div>
	</div>
	<div class="clear"></div>
</div>
</div>
</div>
</div>
<div class="footer_bg">
<div class="wrap">
<div class="wrapper">
	
</div>
</div>
</div>

</body>
</html>