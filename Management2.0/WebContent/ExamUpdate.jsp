<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Equipment</title>
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
							class="fa fa-angle-right"></i> <span>修改体检信息</span>
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
								<form class="form-horizontal" action="ExamUpdate" method="post">
									<input type="hidden" name=userid value=<s:property value="user.userid"/> /> 
									<div class="form-group">
										<label for="disabledinput" class="col-sm-2 control-label">体检信息ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1"
												id="focusedinput"
												name=exam_id
												value="<s:property value="Ex.exam_id"/>"
												readonly="readonly">
										</div>
									</div>
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="patientname" value="<s:property value="Ex.patientname"/>"
												readonly="readonly">
										</div>
									</div>


									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">体检时间</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="datepicker"
												name="time" value="<s:property value="Ex.time"/>">
										</div>
									</div>

									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">身高</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="height" value="<s:property value="Ex.height"/>">
										</div>
									</div>

									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">体重</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="weight" value="<s:property value="Ex.weight"/>"
												>
										</div>
									</div>

									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">心率</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="pulserate" value="<s:property value="Ex.pulserate"/>"
												>
										</div>
									</div>

									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">血压</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="bloodpressure" value="<s:property value="Ex.bloodpressure"/>">
										</div>
									</div>

									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">血氧</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="spo" value="<s:property value="Ex.spo"/>">
										</div>
									</div>
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">体温</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="temperature" value="<s:property value="Ex.temperature"/>"
												>
										</div>
									</div>
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">三围</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput"
												name="bwh" value="<s:property value="Ex.bwh"/>"
												>
										</div>
									</div>
									
									<div class="panel-footer">

										<div class="row">
											<div class="col-sm-8 col-sm-offset-2">
												<button class="btn-primary btn">提交修改</button>
												<!-- <button>大大大大大大</button> -->
												<!-- <s:a href="CsUpdate?userid==%{user.id}&EquNumber=%{EquNumber}"><input type="button" value="OK" class="btn-primary btn"></s:a>-->
												<!--  
												<s:a href="Home?userid=%{user.id}">
													<input type="button" value="Ok" class="btn-default btn">
												</s:a>
												-->
												
												<a href="Home?userid=<s:property value="user.userid"/>">
													<input type="button" value="点击返回" class="btn-inverse btn">
												</a>
												
												<!-- 
												<s:a
													href="CsUpdate?userid=%{user.id}&EquNumber=%{EquNumber}">
													<input type="button" value="reset" class="btn-inverse btn">
												</s:a>
												 -->

												<a
												href="ExamSelect?userid=<s:property value="user.userid"/>&id=<s:property value="Pat.id"/>">
												<input type="button" value="reset" class="btn-inverse btn">
												</a>

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


