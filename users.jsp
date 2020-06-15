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
<!-- jQuery -->

<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- /js -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery-ui.js"></script>
<!-- //js-->
 <style type="text/css">

        #all_light { /*整个弹窗的页面*/
            opacity: 0.8; /*透明度*/
            width: 100%; /*宽度*/
            height: 500px; /*高度，不能百分百*/
            background: skyblue; /*背景色*/
            position: absolute;
            top: 0;
            left: 0; /*定位*/
            display: none; /*隐藏*/
            z-index:1; /*覆盖*/
        }

        #contes { /* 弹框的页面*/
           
            background: #fff; /*背景色*/
            display: none; /*隐藏*/
            z-index: 2; /*覆盖*/
            position: absolute;
            top: 0;
            left: 300px; /* 定位*/
        }

</style>
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
    .elegant-aero input[type="text"], .elegant-aero input[type="email"], .elegant-aero textarea, .elegant-aero select {
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
	List<User> users = new ArrayList<User>();
	users = UserDao.getAllUsers();
	String path = pageContext.getServletContext().getContextPath();
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
							<li><a href="404.html">主页</a></li>
							<li class="active">用户管理</li>
						</ol>
					</div>
					
					<div id="dialog" style="display:none" title="基本的对话框">
 						<form action="<%=path %>/AddUser" method="post" class="elegant-aero">
					    
					    <b>在相应的位置填入用户详细信息</b>
					    <label>
					    <span>姓&nbsp;&nbsp;&nbsp;&nbsp;名 :</span>
					    <input id="name" type="text" name="name" />
					    </label>
					
					    <label>
					    <span>身份证号 :</span>
					    <input id="idcard" type="text"  name="idcard"  />
					    </label>
					
					    <label>
					    <span>家庭住址 :</span>
					    <input id="address" type="text"  name="address"  />
					    </label>
					    <label>
					    <span>联系电话:</span>
					    <input id="phone" type="text" name="phone"  />
					    </label>
					    <label>
					    <span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
					    <input id="email" type="email" name="email" placeholder="Valid Email Address" />
					    </label>
					    <label>
					    <div style="text-align:center; vertical-align:middel;">
					    <input type="submit" align="center" class="button" value="添加" />
					    </div>
					    
					    </label>
					    </form>
					</div>
					
					
					<!--//sub-heard-part-->
					<div class="graph-visual tables-main">
					
						<h3 class="inner-tittle two">顾客信息表</h3>
						<img onclick="showdialog()"  alt="" src="images/add.jpg" style="width:40px;height:auto">
						<div class="graph">
							<div class="tables">

								<table class="table table-hover">
									<thead>
										<tr>
											<th>顾客编号</th>
											<th>姓名</th>
											<th>身份证号</th>
											<th>家庭住址</th>
											<th>联系电话</th>
											<th>邮箱</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									<%for(User user:users){ int i = 0;%>
										<tr>
											<th scope="row"><%=user.getUserid() %></th>
											<td><%=user.getName() %></td>
											<td><%=user.getIdcard() %></td>
											<td><%=user.getAddress() %></td>
											<td><%=user.getPhone() %></td>
											<%if(user.getQmail() != null) {%>
												<td><%=user.getQmail()%></td>
											<%}else{ %>
												<td>暂未绑定</td>
											<%} %>
											<td>												
												<a id="change"  href="javascript:void(0)" onclick="change('<%=user.getUserid() %>','<%=user.getName() %>','<%=user.getAddress() %>','<%=user.getPhone() %>','<%=user.getQmail()%>')" 
												style="color: black"><img style="width:auto;height:35%" alt="" src="images/change.png"></a>
												&nbsp;
												<a id="del"  href="javascript:if(confirm('确实要删除吗?'))location='/RentCar/Deluser?id=<%=user.getUserid() %>'" 
												style="color: black"><img style="width:auto;height:35%" alt="" src="images/del.png"></a>
											</td>
										</tr>
									<%} %>
										
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!--//graph-visual-->
				</div>
				<!--//outer-wp-->
				<!--footer section start-->
				
				<div id="dialog1"  style="display:none" title="基本的对话框">
 						<form action="<%=path %>/ChangeUserInfo" method="post" class="elegant-aero">
					    
					    <b>在相应的位置填入用户详细信息</b>
					    <label>
					    <span>i&nbsp;&nbsp;&nbsp;&nbsp;d:</span>
					    <input readonly="readonly" id="userid" type="text" name="userid" />
					    </label>
					    
					    <label>
					    <span>姓&nbsp;&nbsp;&nbsp;&nbsp;名</span>
					    <input readonly="readonly" id="name1" type="text" name="name" />
					    </label>
					
					    <label>
					    <span>家庭住址 :</span>
					    <input id="address1" type="text"  name="address"  />
					    </label>
					    <label>
					    <span>联系电话:</span>
					    <input id="phone1" type="text" name="phone"  />
					    </label>
					    <label>
					    <span>邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</span>
					    <input id="email1" type="email" name="email" placeholder="Valid Email Address" />
					    </label>
					    <label>
					    <div style="text-align:center; vertical-align:middel;">
					    <input type="submit" align="center" class="button" value="修改" />
					    </div>
					    
					    </label>
					    </form>
				</div>
				
				
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
						<h1>导航栏</h1>
				</span> <!--<img id="logo" src="" alt="Logo"/>-->
				</a>
			</header>
			<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
			<!--/down-->
			<div class="down">
				<a href="managers.jsp"><img src="images/admin.jpg"></a> <a
					href="managers.jsp"><span class=" name-caret">管理员</span></a>
				<p>System Administrator in Company</p>
				
			</div>
			<!--//down-->
			<div class="menu">
				<ul id="menu">
					<li><a href="index.jsp"><i class="fa fa-tachometer"></i>
							<span>主页</span></a></li>
					<li id="menu-academico"><a href="cars.jsp"><i class="fa fa-table"></i>
							<span> 汽车管理</span> </span></a>
						</li>
					<li id="menu-academico"><a href="#"><i
							class="fa fa-file-text-o"></i> <span>用户管理</span> </span></a>
						</li>
					<li><a href="discount.jsp"><i class="lnr lnr-pencil"></i>
							<span>优惠政策</span></a></li>
					<li id="menu-academico"><a href="orders.jsp"><i
							class="lnr lnr-book"></i> <span>订单管理</span> </a>
						</li>
					<li><a href="managers.jsp">
					<i class="lnr lnr-envelope"></i> <span>管理员用户管理
								</a>
						</li>
					<li id="menu-academico"><a href="logs.jsp"><i
							class="lnr lnr-layers"></i> <span>系统日志</span> </a>
						</li>
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
	</script>
	<!--js -->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script>

    function change(id,name,addr,phone,mail) {
    	document.getElementById('userid').value = id;
    	document.getElementById('name1').value = name;
    	document.getElementById('address1').value = addr;
    	document.getElementById('phone1').value = phone;
    	document.getElementById('email1').value = mail;
    	$( "#dialog1" ).dialog({
    		width:500,
    		height:500,
    		title:"更改信息"
    	});
    }
    function deluser(id){
    	
    }
    function cancel(){
    	 document.getElementById('all_light').style.display = 'none';
         document.getElementById('contes').style.display = 'none';

    }
	</script>
	<script>
	$(function() {
	    $( "#dialog" ).hide();
	    $( "#dialog1" ).hide();
	   
	});
	function showdialog(){
		$( "#dialog" ).dialog({
			width:500,
			height:500,
			title:"添加用户"
		});
	}
	</script>
</body>
</html>