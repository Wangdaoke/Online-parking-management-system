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
<!-- 导入jquery样式相关的css文件 -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/jquery-ui.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<link href="css/master.css" rel="stylesheet" type="text/css" />
<!-- jQuery -->

<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- /js -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="js/jquery-ui.js"></script>
<!-- //js-->
<style type="text/css">
	.orderfrom {
		position: absolute;
		top: 0;
		left: 25%;
		/*background-color: red;*/
		z-index: 998;
		overflow: auto;
	}

</style>
<%@ page import="java.util.*" %>
<%@ page import="cn.ch.dao.*,cn.ch.bean.*,cn.ch.util.*" %>
<%
	List<Car> cars = new ArrayList<Car>();
	cars = CarDao.getAllCars();
	String path = pageContext.getServletContext().getContextPath();
	String name = (String)session.getAttribute("user");
	User user = UserDao.getByMail(name);
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
						<div class="srch">
							<button></button>
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
									<a href="Logout"  style="color: #000"> <img style="width:40px;height:auto" alt="" src="images/exit.png"> </a>
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
					<!--sub-heard-part-->
					<div class="sub-heard-part">
						<ol class="breadcrumb m-b-0">
							<li><a href="userindex.jsp">主页</a></li>
							<li class="active">用户租车</li>
						</ol>
					</div>
				
				
				<!-- 租车信息的表单 -->
					<div style="display:none" id="wrapper" class="orderfrom">
				        <!-- HEADER -->
				        <div id="header">
				                     <img src="img/logo.png" alt="" width="200" height="23" id="logo"/>
				        </div>
				        <!-- /HEADER -->
				        <!-- MAIN GREEN AREA -->
				        <div id="main_container" >
				        <!-- form -->
				        <form action="<%=path %>/AddOrder" method="post" id="myform" class="expose" > 
				                <fieldset class="col_f_1">	
				                        <label>汽车编号</label><input type="text" id="carid" name="carid"  class="required" value="" /> 
				                        <label>用户编号</label><input type="text" name="userid" id="userid"  class="required"  />
				                        
				                </fieldset>
				                <fieldset class="col_f_2">
				                		<label>租车时间</label> <input type="date" name="starttime" />	
				                        <label>还车时间</label> <input type="date" name="returntime"  class="required"  />
				                 </fieldset>
				                 <div class="clr"></div>
				                 <hr />
				                 <button type="submit">提交</button>
				                 <button type="button" onclick="javascript:document.getElementById('wrapper').style.display='none'">取消</button>
				        </form>	
				        <!--/form -->
				         <div id="header_content">
				                     <h1>Rent now<strong>It's totaly free</strong></h1>
				                     <h2>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis viverra, leo sit amet auctor fermentum, risus lorem posuere tortor.</h2>
				         </div>
				         <div class="clr"></div>
				     	</div>
					</div>
				
					
				<!-- 汽车列表开始 -->
				
				<div class="container" style="position:relative;left:10px;">
				  <%for(Car car: cars) {%>
				  	<div class="card " style="width:200px;height:350px;pisition:relative;float:left;right:10px;">
					    <img class="card-img-top" src="<%=car.getImage() %>" alt="Card image" style="width:100%;height:35%">
					    <div class="card-body">
					      <h4 class="card-title "><%=car.getModel() %></h4>
					      <h5 ><%=car.getPrice() %>￥</h5>
					      <p class="card-text"><%=car.getDescribe() %></p>
					      <a href="#" onclick="showOrder('<%=car.getCarid() %>','<%=user.getUserid() %>')" class="btn btn-primary">立即租车</a>
					    </div>
				    </div>
				  <%} %>				 
				</div>
								
				<!-- 汽车列表结束 -->
				</div>
				<!--//outer-wp-->
				<!--footer section start-->
				
				
				
				<footer>
					<p>
						租车网
					</p>
				</footer>
				<!--footer section end-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a> <a href="404.html"> <span id="logo">
						
				</span> <!--<img id="logo" src="" alt="Logo"/>-->
				</a>
			</header>
			<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
			<!--/down-->
			<div class="down">
				<a href="managers.jsp"><img src="images/admin.jpg"></a> <a
					href="managers.jsp"><span class=" name-caret"><%=name %></span></a>
			
				
			</div>
			<!--//down-->
			<div class="menu">
				<ul id="menu">
					
				</ul>
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
		
		function showOrder(x,y) {
			$("#carid").val(x);
			$("#userid").val(y);
			console.log(x+y);
			console.log("++++++++++++++");
			document.getElementById("wrapper").style.display = "block";
		}
	</script>
	<!--js -->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>