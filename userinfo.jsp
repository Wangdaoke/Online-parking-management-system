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
    .elegant-aero {
    margin-left:auto;
    margin-right:auto;

    max-width: 500px;
    background: #D2E9FF;
    padding: 20px 20px 20px 20px;
    font: 12px Arial, Helvetica, sans-serif;
    color: #666;
    }
    .elegant-aero h1 {
    font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
    padding: 10px 10px 10px 20px;
    display: block;
    background: #C0E1FF;
    border-bottom: 1px solid #B8DDFF;
    margin: -20px -20px 15px;
    }
    .elegant-aero h1>span {
    display: block;
    font-size: 11px;
    }

    .elegant-aero label>span {
    float: left;
    margin-top: 10px;
    color: #5E5E5E;
    }
    .elegant-aero label {
    display: block;
    margin: 0px 0px 5px;
    }
    .elegant-aero label>span {
    float: left;
    width: 20%;
    text-align: right;
    padding-right: 15px;
    margin-top: 10px;
    font-weight: bold;
    }
    .elegant-aero input[type="text"], .elegant-aero input[type="email"], .elegant-aero input[type="password"],.elegant-aero textarea, .elegant-aero select {
    color: #888;
    width: 70%;
    padding: 0px 0px 0px 5px;
    border: 1px solid #C5E2FF;
    background: #FBFBFB;
    outline: 0;
    -webkit-box-shadow:inset 0px 1px 6px #ECF3F5;
    box-shadow: inset 0px 1px 6px #ECF3F5;
    font: 200 12px/25px Arial, Helvetica, sans-serif;
    height: 30px;
    line-height:15px;
    margin: 2px 6px 16px 0px;
    }
    .elegant-aero textarea{
    height:100px;
    padding: 5px 0px 0px 5px;
    width: 70%;
    }
    .elegant-aero select {
    background: #fbfbfb url('down-arrow.png') no-repeat right;
    background: #fbfbfb url('down-arrow.png') no-repeat right;
    appearance:none;
    -webkit-appearance:none;
    -moz-appearance: none;
    text-indent: 0.01px;
    text-overflow: '';
    width: 70%;
    }
    .elegant-aero .button{
    padding: 10px 30px 10px 30px;
    background: #66C1E4;
    border: none;
    color: #FFF;
    box-shadow: 1px 1px 1px #4C6E91;
    -webkit-box-shadow: 1px 1px 1px #4C6E91;
    -moz-box-shadow: 1px 1px 1px #4C6E91;
    text-shadow: 1px 1px 1px #5079A3;

    }
    .elegant-aero .button:hover{
    background: #3EB1DD;
    }
    
    
</style>
<%@ page import="java.util.*" %>
<%@ page import="cn.ch.dao.*,cn.ch.bean.*,cn.ch.util.*" %>
<%
	String path = pageContext.getServletContext().getContextPath();
	String qmail = request.getParameter("qmail");
	User user = new User();
	user = UserDao.getByMail(qmail);
	application.setAttribute("user1",user);
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
				<div style="width:80%">
					<button style="float:right;background-color: skyblue;box-shadow:-10px 5px 10px skyblue;width:60px;height:40px;"><a href="userindex.jsp">跳过</a></button>
				</div>
				<div class="outter-wp" style="text-align:center">
					
					<h2>完善个人信息</h2>
					<form action="<%=path %>/SaveUserInfo" method="post" class="elegant-aero">
					    
					    <b>在相应的位置填入用户详细信息</b>
					    <label style="display:block">
					    <span>id</span>
					    <input id="userid" type="text" name="userid" value="<%=user.getUserid()%>"/>
					    </label>
					    <label>
					    <span>姓&nbsp;&nbsp;&nbsp;&nbsp;名 :</span>
					    <input id="name" type="text" name="name" value="<%=user.getName()%>"/>
					    </label>
					
					    <label>
					    <span>身份证号 :</span>
					    <input id="idcard" type="text"  name="idcard" value="<%=user.getIdcard()%>" />
					    </label>
					
					    <label>
					    <span>家庭住址 :</span>
					    <input id="address" type="text"  name="address" value="<%=user.getAddress()%>"/>
					    </label>
					    <label>
					    <span>联系电话:</span>
					    <input id="phone" type="text" name="phone"  value="<%=user.getPhone()%>"/>
					    </label>
					    <label>
					    <span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
					    <input id="email" type="email" name="email" value="<%=user.getQmail()%>" placeholder="Valid Email Address" />
					    </label>
					     <label>
					    <span>密&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
					     <input id="passwordsignup" name="password"  type="password" placeholder="eg. X8df!90EO"/>
					    </label>
					     <label>
					    <span>确认密码</span>
					     <input id="passwordsignup_confirm" name="passwordsignup_confirm" onkeyup="validate()" type="password" placeholder="eg. X8df!90EO"/>
					    </label>
					    <span id="tishi1"></span>
					    <label>
					    <div style="text-align:center; vertical-align:middel;">
					    <input type="submit" align="center" class="button" value="保存" />
					    </div>
					    
					    </label>
					    </form>
						
						
					
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
					href="#"><span class=" name-caret"><%=user.getName()%></span></a>
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
	<script type="text/javascript">
		function validate() {
              var pwd1 = document.getElementById("passwordsignup").value;
              var pwd2 = document.getElementById("passwordsignup_confirm").value;
              if(pwd1 == pwd2) {
                  document.getElementById("tishi1").innerHTML="<font size='2' color='green'>验证通过</font>";
                  document.getElementById("submit").disabled = false;
              }
              else {
                  document.getElementById("tishi1").innerHTML="<font size='2' color='red'>两次密码不相同</font>";
               	  document.getElementById("submit").disabled = true;
              }
          }
	</script>
	<!--js -->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>