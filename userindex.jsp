<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- /js -->
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/move.js"></script>
<script type="text/javascript" src="js/tuozhuai.js"></script>
<!-- //js-->


<style type="text/css">
html, body, div, p, img, a {
	margin: 0 auto;
	padding: 0;
}
html, body {
	height: 100%;
}
body {
	padding: 0px 20px;
	box-sizing: border-box;
	font-family: "微软雅黑";
	font-size: 14px;
	background-color: #00c6d0;
}

.img_100 img {
	width: 100%;
	max-width: 100%;
}
.margin_bottom_15 {
	margin-bottom: 15px;
}
.text_center {
	text-align: center;
}
.drag_div {
	margin-top: 30px;
	width: 1300px;
	height: 760px;
	overflow: hidden;
	position: relative;
}
.drag_div>div {
	background: #fff;
	padding: 5px;
	box-sizing: border-box;
	overflow: hidden;
}
.drag_div>div.one {
	position: absolute;
	top: 0;
	left: 0;
	width: 20%;
	height: 240px;
}
.drag_div>div.two {
	position: absolute;
	top: 260px;
	left: 0;
	width: 20%;
	height: 240px;
}
.drag_div>div.three {
	position: absolute;
	top: 520px;
	left: 0;
	width: 20%;
	height: 240px;
}
.drag_div>div.four {
	position: absolute;
	top: 0px;
	left: 21%;
	width: 37%;
	height: 760px;
}
.drag_div>div.five {
	position: absolute;
	top: 0px;
	left: 59%;
	width: 20%;
	height: 280px;
}
.drag_div>div.six {
	position: absolute;
	top: 300px;
	left: 59%;
	width: 20%;
	height: 220px;
}
.drag_div>div.seven {
	position: absolute;
	top: 540px;
	left: 59%;
	width: 20%;
	height: 220px;
}
.drag_div>div.eight {
	position: absolute;
	top: 0px;
	left: 80%;
	width: 20%;
	height: 280px;
}
.drag_div>div.nine {
	position: absolute;
	top: 300px;
	left: 80%;
	width: 20%;
	height: 220px;
}
.drag_div>div.ten {
	position: absolute;
	top: 540px;
	left: 80%;
	width: 20%;
	height: 220px;
}
.drag_div>div.one img, .drag_div>div.two img, .drag_div>div.three img {
	width: 100%;
	height: 180px;
}
.drag_div>div.four img {
	width: 100%;
	height: 700px;
}
.drag_div>div.five img, .drag_div>div.eight img {
	width: 100%;
	height: 220px;
}
.drag_div>div.six img, .drag_div>div.seven img, .drag_div>div.nine img, .drag_div>div.ten img {
	width: 100%;
	height: 160px;
}
</style>

<%
	String name = (String)session.getAttribute("user");
%>

</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="inner-content">
				<!-- header-starts -->
				<div class="header-section">
					<!--menu-right-->
					<div class="top_menu">
						<div class="main-search">
							<form>
								<input type="text" value="Search" onFocus="this.value = '';"
									onBlur="if (this.value == '') {this.value = 'Search';}"
									class="text" /> <input type="submit" value="" />
							</form>
							<div class="close">
								<img src="images/cross.png" />
							</div>
						</div>
						
						<script type="text/javascript">
							$('.main-search').hide();
							$('button').click(function() {
								$('.main-search').show();
								$('.main-search text').focus();
							});
							$('.close').click(function() {
								$('.main-search').hide();
							});
						</script>
						<!--/profile_details-->
						<div class="profile_details_left">
							<ul class="nofitications-dropdown">
								

								<li class="dropdown note">
									<a href="Logout"  style="color: #000"><img style="width:40px;height:auto" alt="" src="images/exit.png"></a>
								</li>
								
								<div class="clearfix"></div>
							</ul>
						</div>
						<div class="clearfix"></div>
						<!--//profile_details-->
					</div>
					<!--//menu-right-->
					<div class="clearfix"></div>
				</div>
				<!-- //header-ends -->
				<!--outter-wp-->
				<div class="outter-wp">
					
					
					<div class="drag_div" id="drag_div">
					  <div class="one">
					    <p class="img_100 margin_bottom_15"><img src="images/a4.png"></p>
					    <p class="text_center"><a href="userinfo.jsp?qmail=<%=name %>">个人信息</a>  </p>
					  </div>
					  <div class="two">
					    <p class="img_100 margin_bottom_15"><img src="images/a5.png"></p>
					    <p class="text_center"><a href="userorder.jsp">订单查询</a> </p>
					  </div>
					  <div class="seven">
					    <p class="img_100 margin_bottom_15"><img src="images/a3.png"></p>
					    <p class="text_center"><a href="userrent.jsp">租车</a> </p>
					  </div>
					  <div class="four">
					    <p class="img_100 margin_bottom_15"><img src="images/a1.png"></p>
					    <p class="text_center"><a href="#"></a> </p>
					  </div>					  
					  <div class="six">
					    <p class="img_100 margin_bottom_15"><img src="images/a6.png"></p>
					    <p class="text_center"><a href="discount.jsp">优惠信息</a> </p>
					  </div>
					  <div class="five" style="opacity: 0;">
					   
					  </div>
					  <div class="three" style="opacity: 0;">
					   
					  </div>
					
					  
					</div>
					
					
				</div>
				
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a> <a href="404.html"> <span id="logo">
						<h1>导航栏</h1>
				</span> <!--<img id="logo" src="" alt="Logo"/>-->
				</a>
			</header>
			<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
			<!--/down-->
			<div class="down">
				<a href="#"><img src="images/admin.jpg"></a> <a
					href="#"><span class=" name-caret"><%=name %></span></a>
				<p>欢迎登录</p>
				
			</div>
			
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!--js -->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>