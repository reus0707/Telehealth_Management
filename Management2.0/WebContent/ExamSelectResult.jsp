<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Select Result</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Home Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />

<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">

<script src="js/jquery.min.js"> </script>
<script src="js/bootstrap.min.js"> </script>

<!-- Mainly scripts -->
<script src="js/jquery.metisMenu.js"></script>
<script src="js/jquery.slimscroll.min.js"></script>
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #ffffff;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #5182bb;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #5182bb;
	font-size: 11px;
	color: #FFFFFF;
}

table.hovertable tr {
	background-color: #ffffff;
	border-width: 1px;
	border-style: solid;
	border-color: #5182bb;
	font-size: 11px;
	color: #ffffff;
}

table.hovertable td {
	border-width: 0px;
	padding: 8px;
	border-style: solid;
	border-color: #5182bb;
	color: #333333;
}

.blank1 {
	float: right;
	width: 35%;
	height: 23px
}

.blank2 {
	float: right;
	width: 150px;
	height: 23px
}

.unread {
	float: right;
	width: 75px;
	height: 23px
}

.readed {
	float: right;
	width: 75px;
	height: 23px
}
</style>

</head>
<body>
	<div id="wrapper">
		<!----->
		<nav class="navbar-default navbar-static-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
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
						<div id="time"></div>
				</div>
			</div>
	
	
			<!-- Brand and toggle get grouped for better mobile display --> <!-- Collect the nav links, forms, and other content for toggling -->
			<div class="drop-men">
				<ul class=" nav_1">
					<li class="dropdown">
					<!-- 
						<s:a action="AddPatient">
									<s:param name="userid">
										<s:property value="user.userid" />
									</s:param>
									<button class="btn-primary btn">+ 点击添加</button>
						</s:a>
					
					 -->
						
						
						<a href="ExamAddJump?userid=<s:property value="user.userid"/>">
						+ 点击添加 &nbsp
						</a>
	
						<a href="#"
							class="dropdown-toggle dropdown-at" data-toggle="dropdown">
							<span
								class=" name-caret"><s:property value="user.username" /><i class="caret"></i>
								<img src="<s:property value="user.Picture"/>">
							<%-- <img src="images/wo.jpg"> --%>
							</span>
						</a>
						<ul class="dropdown-menu " role="menu">
							<li><s:a action="Profile">
									<s:param name="userid">
										<s:property value="user.userid" />
									</s:param>
									<i class="fa fa-user"></i>Profile</s:a></li>
							<li><a href="calendar.html"><i class="fa fa-calendar"></i>Calender</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
			<div class="clearfix"></div>
	
		</nav>
		
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="content-main">

				<!--banner-->
				<div class="banner">
					<h2>
						<a href="Home?userid=<s:property value="user.userid"/>">Home</a> <i
							class="fa fa-angle-right"></i> <span>体检信息管理</span>
					</h2>
				</div>
				<!--//banner-->
				<!--faq-->
				<div class="blank">
					<form class="form" action="ExamQuery" method="post">
						<div class="input-group input-group-in">
							<input type="text" name="Aim" class="form-control2"
								placeholder="Search..."> <input type="hidden"
								name=userid value=<s:property value="user.userid"/> /> <input
								type="hidden" name=page value=<s:property value="0"/> /> <span
								class="input-group-btn">
								<button class="btn btn-success" type="submit">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
						<!-- Input Group -->
					</form>

					<div class="blank-page">

						<form class="form" action="" method="post">
							<input type="hidden" name=userid
								value=<s:property value="user.userid"/> />
							<table class="hovertable">
								<tr>
									<th>管理</th>
								
									<th>id</th>
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									
									<th>体检时间</th>
									<th>身高</th>
									<th>体重</th>
									
									<th>心率</th>
									<th>血压</th>
									<th>血氧</th>
									<th>体温</th>
									<th>三围</th>


								</tr>
								<s:iterator value="ExamVect" var="Lend">
									<tr onmouseover="this.style.backgroundColor='#fdf5e6';"
										onmouseout="this.style.backgroundColor='#ffffff';">
										<td>
											<a href="RetirButton?userid=<s:property value="user.userid"/>&exam_id=<s:property value="#Lend.exam_id"/>">删除<br/></a>
											<a href="ExamSelect?userid=<s:property value="user.userid"/>&exam_id=<s:property value="#Lend.exam_id"/>">修改<br/></a>
										</td>
										<td><s:property value="#Lend.exam_id" /></td>
										<td><s:property value="#Lend.patientname" /></td>
										<td><s:property value="#Lend.sex" /></td>
										<td><s:property value="#Lend.age" /></td>
										
										<td><s:property value="#Lend.time" /></td>
										<td><s:property value="#Lend.height" /></td>
										<td><s:property value="#Lend.weight" /></td>
										
										<td><s:property value="#Lend.pulserate" /></td>
										<td><s:property value="#Lend.bloodpressure" /></td>
										<td><s:property value="#Lend.spo" /></td>
										<td><s:property value="#Lend.temperature" /></td>
										<td><s:property value="#Lend.bwh" /></td>
										
									</tr>
								</s:iterator>

							</table>
						</form>
					</div>
					<ul class="pagination">
						<li><a
							href="ExamVectSelect?userid=<s:property value="user.userid"/>&page=0">&laquo;</a></li>
						<% for(int i=0;i<10;i++){ %>
						<li><a
							href="ExamVectSelect?userid=<s:property value="user.userid"/>&page=<%=i%>"><%=i%></a></li>
						<%}%>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--//faq-->
	<!---->

	<!---->
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
</body>
</html>

