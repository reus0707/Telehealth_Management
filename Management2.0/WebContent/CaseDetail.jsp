<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<body>
	<div id="wrapper">
		<!----->
		<nav class="navbar-default navbar-static-top" role="navigation">
		<div class="navbar-header">

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
					<div class="clearfix"></div>
			</div>


			<!-- Brand and toggle get grouped for better mobile display -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="drop-men">
				<ul class=" nav_1">
					<li class="dropdown"><a href="#"
						class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span
							class=" name-caret"><s:property value="user.username" /><i
								class="caret"></i></span><img src="<s:property value="user.picture"/>"></a>
						<ul class="dropdown-menu " role="menu">
							<li><a href="profile.html"><i class="fa fa-user"></i>Edit
									Profile</a></li>
							<li><a href="calendar.html"><i class="fa fa-calendar"></i>Calender</a></li>
						</ul></li>

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
							class="fa fa-angle-right"></i> <span>查看详情</span>
					</h2>
				</div>
				<!--//banner-->
				<!--grid-->
				<!--//grid-->
					<!---->
					<!--scrolling js-->
					<script src="js/jquery.nicescroll.js"></script>
					<script src="js/scripts.js"></script>
					<!--//scrolling js-->
					<!---->



<div class="grid-form">
<div class="grid-form1">
	<div style="display: flex; margin-top: 10px;">
		
		<div style="width: 100%;">
			<div style="width: 100%; border: 1px solid gray; padding: 20px;">
				<div style="display: flex; width: 100%;">
					<img src="images/in5.jpg">
					<div style="width: 50%;">
						<div
							style="display: flex; flex-direction: column; width: 30%; border: 1px solid gray;">
							<span
								style="width: 100%; display: flex; justify-content: center;">患者基本信息</span>
							<span style="width: 100%; padding-left: 10px;">ID: <span
								style="color: blue;"> <s:property value="Ca.patient_id"/> </span></span> <span
								style="width: 100%; padding-left: 10px;">姓名: <span
								style="color: blue;"> <s:property value="Ca.patientname"/> </span></span> <span
								style="width: 100%; padding-left: 10px;">性别: <span
								style="color: blue;"> <s:property value="Ca.patientsex"/> </span></span> <span
								style="width: 100%; padding-left: 10px;">年龄: <span
								style="color: blue;"> <s:property value="Ca.patientage"/> </span></span>
						</div>
					</div>
					
					<div style="width: 50%;">
						<div
							style="display: flex; flex-direction: column; width: 30%; border: 1px solid gray;">
							<span
								style="width: 100%; display: flex; justify-content: center;">医生基本信息</span>
							<span style="width: 100%; padding-left: 10px;">ID: <span
								style="color: blue;"> <s:property value="Ca.doctor_id"/> </span></span> <span
								style="width: 100%; padding-left: 10px;">姓名: <span
								style="color: blue;"> <s:property value="Ca.doctorname"/> </span></span> <span
								style="width: 100%; padding-left: 10px;">性别: <span
								style="color: blue;"> <s:property value="Ca.doctorsex"/> </span></span> <span
								style="width: 100%; padding-left: 10px;">年龄: <span
								style="color: blue;"> <s:property value="Ca.doctorage"/> </span></span>
						</div>
					</div>
				</div>
				<div
					style="padding-left: 20px; height: 76px; border: 1px solid gray; margin-top: 5px;">
					
					

					病历id：<span style="color: blue;"> <s:property value="Ca.case_id"/> </span>
					</br>
					科室：<span style="color: blue;"> <s:property value="Ca.department"/> </span>
					</br>
					时间：<span style="color: blue;"> <s:property value="Ca.date"/> </span>

				</div>
			</div>
			<div
				style="padding-left: 20px; height: 180px; border: 1px solid gray; margin-top: 5px;">
				 <s:property value="Ca.description"/> </div>
			<div
				style="padding-left: 20px; height: 180px; border: 1px solid gray; margin-top: 5px;">
				 <s:property value="Ca.diagnose"/> </div>
		</div>
	</div>
	
	</br>
	<a href="Home?userid=<s:property value="user.userid"/>"

			style="height: 35px; margin: 10px;">
		<input type="button" value="点击返回" >
	</a>
	</br>
	</div>
</div>
	

	
	
	
</body>
</html>