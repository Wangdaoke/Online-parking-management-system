<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
 <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
      <title>Login or Registration</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
      <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
      <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
      <meta name="author" content="Codrops" />
      <link rel="shortcut icon" href="../favicon.ico"> 
      <link rel="stylesheet" type="text/css" href="css/demo.css" />
      <link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<%
	String path = request.getContextPath();
	String mainPange = path+"/index.jsp";
	String checkLogin = path+"/Login";
	//System.out.println(path);
%>
<style type="text/css">
#btncode{
 width: 100px;
 height: 30px;
 background-color: #ff3000;
 border: 0;
 border-radius: 5px;
 color: #fff;
}
#btncode.on {
 background-color: #eee;
 color: #ccc;
 cursor: not-allowed;
}
</style>
<script type="text/javascript">
	
	
	
$(document).ready(function(){
	$("#submitLogin").click(function(){ 
		
	    $.ajax({
	        url : "${pageContext.request.contextPath}/UserLogin", //后台查询验证的方法
	        dataTpye : "json",
	        data : {
	            "username" : $('#username').val(),
	            "password" : $('#password').val(),
	            "usercode" : $('#usercode').val()
	        }, 
	        type : "post",
	        success : function(msg) {
	            //根据后台返回前台的msg给提示信息加HTML
	            
	            if ("true" == msg) {
	               
	            	window.location.href="/RentCar/userinfo.jsp?qmail="+$('#username').val();
	            } else if("false1" == msg) {
	                // 账号不存在
	                //alert("登录失败，请检查用户名密码后重试");
	                document.getElementById("tishi").innerHTML="<font size='2' color='red'>输入的验证码有误，请检查后重试</font>";
	            }else if("false2" == msg){
	            	document.getElementById("tishi").innerHTML="<font size='2' color='red'>密码错误，请检查后重试</font>";
	            }
	        },
	        error:function(){  //请求失败的回调方法
	        	alert("登录失败，请重试");
	        }
	    });
		});
	
	
	$("#btncode").click(function(){ 
			$.ajax({
		        url : "${pageContext.request.contextPath}/CreateMailCode", //后台查询验证的方法
		        dataTpye : "json",
		        data : {
		            "mail" : $('#username').val()
		        }, 
		        type : "post",
		        success : function(msg) {
		           
		        },
		        error:function(){  //请求失败的回调方法
		        	alert("获取验证码失败，请重试");
		        }
		    });
			});
	    
	});
	
</script>


<body>
 <div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
               
                <span class="right">
                	<strong><a href="login.jsp" class="to_register">管理员登录</a></strong>
                    <strong>小型汽车租赁系统</strong>
                </span>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            <header>
                <h1>欢迎登录我们的系统<span>We are here</span></h1>
				
            </header>
         <div style="text-align:center;clear:both;">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>  
			<section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="#" autocomplete="on"> 
                                <h1>登录</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 账户 </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                                </p>
                                
                                <div id="pwdlogin">
	                                <p> 
	                                    <label for="password" class="youpasswd" data-icon="p"> 密码 </label>
	                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
	                                </p>
                               </div>
                               
                               <div id="codelogin" style="display:none">
	                               <p> 
	                                    <label for="password" class="youpasswd" data-icon="p"> 验证码登陆<button id="btncode"  type="button" >获取验证码</button></label>
	                                    <input id="usercode" name="code" required="required" type="text" placeholder="eg. X8df!90EO" /> 
	                                </p>
                               </div >
                                <p>
									<button id="cbtn" onclick="changemethod()">验证码登陆</button>
									<button id="mbtn" style="display:none" onclick="changemethod1()">密码登陆</button>
								</p>
                                <span id="tishi"></span>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">保持登录</label>
								</p>
                                <p class="login button"> 
                                    <input id="submitLogin" type="button" value="登录" /> 
								</p>
								
                                <p class="change_link">
									还没有账户
									<a href="#toregister" class="to_register">加入我们</a>
								</p>
                            </form>
                        </div>



                        <div id="register" class="animate form">
                            <form  action="/RentCar/UserSign" method="POST" autocomplete="on"> 
                                <h1> 注册 </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">账户（邮箱）</label>
                                    <input id="usernamesignup" name="username" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 姓名 </label>
                                    <input id="username" name="name" required="required" type="text" />
                                </p>
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 身份证号 </label>
                                    <input id="username" name="idcard" required="required" type="text" />
                                </p>
                                <div>
                                	<p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">密码 </label>
                                    <input id="passwordsignup" name="password" required="required" type="password" placeholder="eg. X8df!90EO"/>
                               		</p>
                                </div>
                                <div>
                                	<p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">再次输入密码</label>
                                    <input id="passwordsignup_confirm" onkeyup="validate()" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                	</p>	
                                </div>
                               
                                <span id="tishi1"></span>
                                <p class="signin button"> 
									<input type="submit" value="注册"/> 
								</p>
                                <p class="change_link">  
									已经有账户？
									<a href="#tologin" class="to_register"> 登录 </a>
								</p>
                            </form>
                        </div>
                        
						
                    </div>
                </div>  
            </section>
        </div>
        
        
<script>
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
	function changemethod(){
		document.getElementById('mbtn').style.display = 'block';
		document.getElementById('codelogin').style.display = 'block';
		document.getElementById('pwdlogin').style.display = 'none';
		document.getElementById('cbtn').style.display = 'none';
	}
	function changemethod1(){
		document.getElementById('mbtn').style.display = 'none';
		document.getElementById('codelogin').style.display = 'none';
		document.getElementById('pwdlogin').style.display = 'block';
		document.getElementById('cbtn').style.display = 'block';
	}
	$("#btncode").click(btnCheck);
	 /**
	 * [btnCheck 按钮倒计时常用于获取手机短信验证码]
	 */
	 function btnCheck() {
	  $("#btncode").addClass("on");
	  var time = 5;
	  $("#btncode").attr("disabled", true);
	  var timer = setInterval(function() {
	   if (time == 0) {
	    clearInterval(timer);
	    $("#btncode").attr("disabled", false);
	    $("#btncode").html("再次获取");
	    $("#btncode").removeClass("on");
	   } else {
	    $('#btncode').html(time+"秒");
	    console.log("time is %d", time);
	    time--;
	   }
	  }, 1000);
	 }
</script>
</body>
</html>