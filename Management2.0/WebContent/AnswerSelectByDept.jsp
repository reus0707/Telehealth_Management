<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<script src="js/jquery.min.js"> </script>
<script src="js/bootstrap.min.js"> </script>
<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<!-- Mainly scripts -->
<script src="js/jquery.metisMenu.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<!-- Custom and plugin javascript -->
<link href="css/custom.css" rel="stylesheet">
<script src="js/custom.js"></script>
<script src="js/screenfull.js"></script>
		<script>
		$(function () {
			$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

			if (!screenfull.enabled) {
				return false;
			}

			

			$('#toggle').click(function () {
				screenfull.toggle($('#container')[0]);
			});
			
			$( "#datepicker" ).datepicker();
			$( "#datepicker1" ).datepicker();
			
		});
		</script>

<!----->

</head>
<body>
<div id="wrapper">
     <!----->
        <nav class="navbar-default navbar-static-top" role="navigation">
             <div class="navbar-header">
              <h1> <a class="navbar-brand" href="Home?userid=<s:property value="user.userid"/>">Home</a></h1>           
			   </div>
			 <div class=" border-bottom">
        	<div class="full-left">
               <script type="text/javascript">    
               function startTime(){  
					  var today=new Date()  
					  var week=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
					  var monthh=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
					  var month=today.getMonth()+1  
					  var date=today.getDate()  
					  var day=today.getDay()  
					  var h=today.getHours()  
					  var m=today.getMinutes()  
					  var s=today.getSeconds()  
					  // add a zero in front of numbers<10  
					  h=checkTime(h)  
					  m=checkTime(m)  
					  s=checkTime(s)  
					  document.getElementById('time').innerHTML=monthh[month-1]+" "+date+"th "+week[day]+"  "+h+":"+m+":"+s+" "  
					  t=setTimeout('startTime()',500)  
					 }  
					    
					 function checkTime(i){    
					 if (i<10)     
					   {i="0" + i}    
					   return i    
					 }    
					</script>    
					    
					<body onload="startTime()">    
					    
					<span id="time" class="nav-label"></span>
            <div class="clearfix"> </div>
           </div>
     
       
            <!-- Brand and toggle get grouped for better mobile display -->
		 
		   <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="drop-men" >
		        <ul class=" nav_1">
					<li class="dropdown">
		              <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret"><s:property value="user.username"/><i class="caret"></i></span><img src="<s:property value="user.picture"/>"></a>
		              <ul class="dropdown-menu " role="menu">
		                <li><a href="profile.html"><i class="fa fa-user"></i>Edit Profile</a></li>
		                <li><a href="calendar.html"><i class="fa fa-calendar"></i>Calender</a></li>
		              </ul>
		            </li>
		           
		        </ul>
		     </div><!-- /.navbar-collapse -->
			<div class="clearfix">
       
     </div>
	  
		    			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">

						<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-cog nav_icon"></i> <span class="nav-label">Settings</span><span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="login.html" class=" hvr-bounce-to-right"><i
										class="fa fa-sign-in nav_icon"></i>Signin</a></li>
								<li><a href="registration.html"
									class=" hvr-bounce-to-right"><i
										class="fa fa-sign-in nav_icon"></i>Singup</a></li>
								<li><a
									href="AdminInvite?userid=<s:property value="user.userid"/>"
									class=" hvr-bounce-to-right"><i
										class="fa fa-sign-in nav_icon"></i>Invite Manage</a></li>
								<li><a
									href="UserManage?userid=<s:property value="user.userid"/>"
									class=" hvr-bounce-to-right"><i
										class="fa fa-sign-in nav_icon"></i>User Manage</a></li>
							</ul></li>
							

							<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-list nav_icon"></i> <span class="nav-label">基础信息管理</span><span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li>
									<s:a action="PaVectSelect">
									<s:param name="userid">
										<s:property value="user.userid" />
									</s:param>
									<i class="fa fa-inbox nav_icon"></i>
									<span class="nav-label">患者管理</span>
									</s:a>
								</li>
								<li><s:a action="DoctorVectSelect">
										<s:param name="userid">
											<s:property value="user.userid" />
										</s:param>
										<i class="fa fa-picture-o nav_icon"></i>
										<span class="nav-label">医生管理</span>
									</s:a>
								</li>
								<li><s:a action="NurseVectSelect">
										<s:param name="userid">
											<s:property value="user.userid" />
										</s:param>
										<i class="fa fa-picture-o nav_icon"></i>
										<span class="nav-label">护士管理</span>
									</s:a>
								</li>
							</ul></li>
							
							<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-indent nav_icon"></i> <span class="nav-label">健康数据及病历管理</span><span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><s:a action="ExamVectSelect">
										<s:param name="userid">
											<s:property value="user.userid" />
										</s:param>
										<i class="fa fa-picture-o nav_icon"></i>
										<span class="nav-label">体检信息管理</span>
									</s:a>
								</li>
								<li><s:a action="CaseVectSelect">
										<s:param name="userid">
											<s:property value="user.userid" />
										</s:param>
										<i class="fa fa-picture-o nav_icon"></i>
										<span class="nav-label">电子病历管理</span>
									</s:a>
								</li>
							</ul>
							</li>
							
							<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-check-square-o nav_icon"></i> <span class="nav-label">诊前问答信息管理</span><span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><s:a action="QuestionVectSelect">
										<s:param name="userid">
											<s:property value="user.userid" />
										</s:param>
										<i class="fa fa-check-square-o nav_icon"></i>
										<span class="nav-label">诊前问题管理</span>
									</s:a>
								</li>
								<li><s:a action="AnswerVectSelect">
										<s:param name="userid">
											<s:property value="user.userid" />
										</s:param>
										<i class="fa fa-check-square-o nav_icon"></i>
										<span class="nav-label">患者答题管理</span>
									</s:a>
								</li>
							</ul>
							</li>
							
							<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-area-chart nav_icon"></i> <span class="nav-label">统计分析</span><span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li>
									<a href="graph?userid=<s:property value="user.userid"/>"
									class=" hvr-bounce-to-right"> <i
										class="fa fa-area-chart nav_icon"></i>统计分析饼形图
									</a>
								</li>
								<li><a
									href="graphs.html"
									class=" hvr-bounce-to-right"><i
										class="fa fa-area-chart nav_icon"></i>统计分析曲线图</a></li>
							</ul></li>
							
					</ul>
				</div>
			</div>
		    
        
        </nav>
		 <div id="page-wrapper" class="gray-bg dashbard-1">
       <div class="content-main">
 
 	<!--banner-->	
		     <div class="banner">
		    	<h2>
				<a href="Home?userid=<s:property value="user.userid"/>">Home</a>
				<i class="fa fa-angle-right"></i>
				<span>Add</span>
				</h2>
		    </div>
		<!--//banner-->
 	<!--grid-->
 	<div class="grid-form">
<!----->

<!---->
  <div class="grid-form1">
  	         <div class="tab-content">
						<div class="tab-pane active" id="horizontal-form">
							<form class="form-horizontal" action="AnswerMakeExam" method="post" >
								<!--这个动作要完成生成试卷，返回试卷界面即做测试界面-->
							 	<input type="hidden" name=userid value=<s:property value="user.userid"/> /> 

								<div class="form-group">
									<label for="focusedinput" class="col-sm-2 control-label">接诊号recep_id</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="focusedinput" name="recep_id">
									</div>
								</div>
								
								<div class="form-group">
									<label for="selector1" class="col-sm-2 control-label">科室</label>
									<div class="col-sm-8"><select name="department" id="selector1" class="form-control1">
										<option>内科</option>
										<option>骨科</option>
										<option>牙科</option>
									</select></div>
								</div>
								
								<div class="panel-footer">
								<div class="row">
									<div class="col-sm-8 col-sm-offset-2">
										<button class="btn-primary btn">开始答题
											
										</button>
										<a href="Home?userid=<s:property value="user.userid"/>">
													<input type="button" value="点击返回" class="btn-inverse btn">
										</a>
										<!-- 
										<s:a href="HomeSelect?userid=%{user.id}"><input type="button" value="Cancel" class="btn-default btn"></s:a>
										<a href="Home?userid=<s:property value="user.userid"/>">
													<input type="button" value="点击返回" class="btn-inverse btn">
										</a>
										 -->
										
									</div>
								</div>
								</div>	
						 </form>
						 </div>																				
						
						</div>
					</div>
					
					<div class="bs-example" data-example-id="form-validation-states">

  					</div>
 	</div>
 	<!--//grid-->
		<!---->
     <!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
<!---->

</body>
</html>


