<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Lend</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Minimal Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
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
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable tr {
	background-color: #d4e3e5;
}

table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>
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
			

			
		});
		</script>
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
				<h1>
					<a class="navbar-brand"
						href="Home?userid=<s:property value="user.userid"/>">Minimal</a>
				</h1>
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
				  document.getElementById('time').innerHTML=monthh[month]+" "+date+"th "+week[day]+"  "+h+":"+m+":"+s+" "  
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


			<!-- Brand and toggle get grouped for better mobile display -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="drop-men">
				<ul class=" nav_1">
					<li class="dropdown"><a href="#"
						class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span
							class=" name-caret"><s:property value="user.username" /><i
								class="caret"></i></span><img src="images/wo.jpg"></a>
						<ul class="dropdown-menu " role="menu">
							<li><s:a action="UserSelect">
									<s:param name="userid">
										<s:property value="user.userid" />
									</s:param>
									<i class="fa fa-user"></i>Profile</s:a></li>
							<li><a href="calendar.html"><i class="fa fa-calendar"></i>Calender</a></li>
						</ul></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
			<div class="clearfix"></div>

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-indent nav_icon"></i> <span class="nav-label">Equipment
									Class</span><span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="404.html" class=" hvr-bounce-to-right"> <i
										class="fa fa-area-chart nav_icon"></i>Refrigeration
								</a></li>

								<li><a href="404.html" class=" hvr-bounce-to-right"><i
										class="fa fa-map-marker nav_icon"></i>Incubator</a></li>

								<li><a href="404.html" class=" hvr-bounce-to-right"><i
										class="fa fa-file-text-o nav_icon"></i>heating</a></li>

							</ul></li>
						<li><a href="404.html" class=" hvr-bounce-to-right"><i
								class="fa fa-inbox nav_icon"></i> <span class="nav-label">Equipment
									Manage</span> </a></li>

						<li><s:a action="UserGally">
								<s:param name="userid">
									<s:property value="user.userid" />
								</s:param>
								<i class="fa fa-picture-o nav_icon"></i>
								<span class="nav-label">Select</span>
							</s:a></li>

						<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-list nav_icon"></i> <span class="nav-label">Lend
									Management</span><span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><s:a action="Lendinfor">
										<s:param name="userid">
											<s:property value="user.userid" />
										</s:param>
										<i class="fa fa-align-left nav_icon"></i>
										<span class="nav-label">Lend in</span>
									</s:a></li>
								<li><a href="404.html" class=" hvr-bounce-to-right"><i
										class="fa fa-check-square-o nav_icon"></i>Lend out</a></li>
							</ul></li>

						<li><a href="404.html" class=" hvr-bounce-to-right"><i
								class="fa fa-th nav_icon"></i> <span class="nav-label">Retirement</span>
						</a></li>


						<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-cog nav_icon"></i> <span class="nav-label">Settings</span><span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="index.html" class=" hvr-bounce-to-right"><i
										class="fa fa-sign-in nav_icon"></i>Signin</a></li>
								<li><a href="registration.html"
									class=" hvr-bounce-to-right"><i
										class="fa fa-sign-in nav_icon"></i>Singup</a></li>
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
						<a href="Home?userid=<s:property value="user.userid"/>">Home</a> <i
							class="fa fa-angle-right"></i> <span>Lend information</span>
					</h2>
				</div>
				<!--//banner-->
				<!--faq-->
				<div class="blank">


					<div class="blank-page">
						<form class="form" action="" method="post">
							<input type="hidden" name=userid
								value=<s:property value="user.userid"/> />
							<table class="hovertable">
								<tr>
									<th>Title</th>
									<th>EquName</th>
									<th>EquID</th>
									<th>LendUnit</th>
									<th>Sta</th>
								</tr>
								<tr onmouseover="this.style.backgroundColor='#F0F8FF';"
									onmouseout="this.style.backgroundColor='#d4e3e5';">
									<td><s:property value="lend.maintext" /></td>
									<td><s:property value="lend.LendEqu" /></td>
									<td><s:property value="lend.Lendid" /></td>
									<td><s:property value="lend.LendUnit" /></td>
									<td><s:property value="lend.Sta" /></td>
								</tr>
							</table>
						</form>
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

