<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HomeAdmin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<script src="js/jquery.min.js"> </script>
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
			

			
		});
</script>
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
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

					<span id="time" class="nav-label"></span>
					<div class="clearfix"></div>
			</div>


			<!-- Brand and toggle get grouped for better mobile display -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="drop-men">
				<ul class=" nav_1">
					<li class="dropdown at-drop"><a href="#"
						class="dropdown-toggle dropdown-at " data-toggle="dropdown"><i
							class="fa fa-globe"></i> <span class="number">7</span></a>
						<ul class="dropdown-menu menu1 " role="menu">
							<li><a href="#">

									<div class="user-new">
										<p>New user registered</p>
										<span>40 seconds ago</span>
									</div>
									<div class="user-new-left">

										<i class="fa fa-user-plus"></i>
									</div>
									<div class="clearfix"></div>
							</a></li>
							<li><a href="#">
									<div class="user-new">
										<p>Someone special liked this</p>
										<span>3 minutes ago</span>
									</div>
									<div class="user-new-left">

										<i class="fa fa-heart"></i>
									</div>
									<div class="clearfix"></div>
							</a></li>
							<li><a href="#">
									<div class="user-new">
										<p>John cancelled the event</p>
										<span>4 hours ago</span>
									</div>
									<div class="user-new-left">

										<i class="fa fa-times"></i>
									</div>
									<div class="clearfix"></div>
							</a></li>
							<li><a href="#">
									<div class="user-new">
										<p>The server is status is stable</p>
										<span>yesterday at 08:30am</span>
									</div>
									<div class="user-new-left">

										<i class="fa fa-info"></i>
									</div>
									<div class="clearfix"></div>
							</a></li>
							<li><a href="#">
									<div class="user-new">
										<p>New comments waiting approval</p>
										<span>Last Week</span>
									</div>
									<div class="user-new-left">

										<i class="fa fa-rss"></i>
									</div>
									<div class="clearfix"></div>
							</a></li>
							<li><a href="#" class="view">View all messages</a></li>
						</ul></li>
				<li class="dropdown">
					
					
					<!-- <a href="index11.jsp">
						+ 点击跳转 &nbsp
						</a> -->
					
					<a href="NewKuangjia?userid=<s:property value="user.userid"/>">
					+ 点击进入远程医疗服务管理员系统 &nbsp
					</a>
					
					<a href="#"
						class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span
							class=" name-caret"><s:property value="user.username" /><i
								class="caret"></i></span><img src="<s:property value="user.picture"/>"></a>
						<ul class="dropdown-menu " role="menu">
							<li><s:a action="Profile">
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



			<div class="navbar-default sidebar" role="navigation" hidden=true>
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">

						<li><a href="#" class=" hvr-bounce-to-right"><i
								class="fa fa-cog nav_icon"></i> <span class="nav-label">设置</span><span
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

				</div>
				<!--//banner-->
				<!--content-->
				<link rel="stylesheet" href="css/graph.css">
				<!--//graph-->
				<div class="content-mid">

					<div class="col-md-5">
						<div class="cal1 cal_2">
							<div class="clndr">
								<div class="clndr-controls">
									<div class="clndr-control-button">
										<p class="clndr-previous-button">previous</p>
									</div>
									<div class="month">July 2015</div>
									<div class="clndr-control-button rightalign">
										<p class="clndr-next-button">next</p>
									</div>
								</div>
								<table class="clndr-table" border="0" cellspacing="0"
									cellpadding="0">
									<thead>
										<tr class="header-days">
											<td class="header-day">S</td>
											<td class="header-day">M</td>
											<td class="header-day">T</td>
											<td class="header-day">W</td>
											<td class="header-day">T</td>
											<td class="header-day">F</td>
											<td class="header-day">S</td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td
												class="day adjacent-month last-month calendar-day-2015-06-28"><div
													class="day-contents">28</div></td>
											<td
												class="day adjacent-month last-month calendar-day-2015-06-29"><div
													class="day-contents">29</div></td>
											<td
												class="day adjacent-month last-month calendar-day-2015-06-30"><div
													class="day-contents">30</div></td>
											<td class="day calendar-day-2015-07-01"><div
													class="day-contents">1</div></td>
											<td class="day calendar-day-2015-07-02"><div
													class="day-contents">2</div></td>
											<td class="day calendar-day-2015-07-03"><div
													class="day-contents">3</div></td>
											<td class="day calendar-day-2015-07-04"><div
													class="day-contents">4</div></td>
										</tr>
										<tr>
											<td class="day calendar-day-2015-07-05"><div
													class="day-contents">5</div></td>
											<td class="day calendar-day-2015-07-06"><div
													class="day-contents">6</div></td>
											<td class="day calendar-day-2015-07-07"><div
													class="day-contents">7</div></td>
											<td class="day calendar-day-2015-07-08"><div
													class="day-contents">8</div></td>
											<td class="day calendar-day-2015-07-09"><div
													class="day-contents">9</div></td>
											<td class="day calendar-day-2015-07-10"><div
													class="day-contents">10</div></td>
											<td class="day calendar-day-2015-07-11"><div
													class="day-contents">11</div></td>
										</tr>
										<tr>
											<td class="day calendar-day-2015-07-12"><div
													class="day-contents">12</div></td>
											<td class="day calendar-day-2015-07-13"><div
													class="day-contents">13</div></td>
											<td class="day calendar-day-2015-07-14"><div
													class="day-contents">14</div></td>
											<td class="day calendar-day-2015-07-15"><div
													class="day-contents">15</div></td>
											<td class="day calendar-day-2015-07-16"><div
													class="day-contents">16</div></td>
											<td class="day calendar-day-2015-07-17"><div
													class="day-contents">17</div></td>
											<td class="day calendar-day-2015-07-18"><div
													class="day-contents">18</div></td>
										</tr>
										<tr>
											<td class="day calendar-day-2015-07-19"><div
													class="day-contents">19</div></td>
											<td class="day calendar-day-2015-07-20"><div
													class="day-contents">20</div></td>
											<td class="day calendar-day-2015-07-21"><div
													class="day-contents">21</div></td>
											<td class="day calendar-day-2015-07-22"><div
													class="day-contents">22</div></td>
											<td class="day calendar-day-2015-07-23"><div
													class="day-contents">23</div></td>
											<td class="day calendar-day-2015-07-24"><div
													class="day-contents">24</div></td>
											<td class="day calendar-day-2015-07-25"><div
													class="day-contents">25</div></td>
										</tr>
										<tr>
											<td class="day calendar-day-2015-07-26"><div
													class="day-contents">26</div></td>
											<td class="day calendar-day-2015-07-27"><div
													class="day-contents">27</div></td>
											<td class="day calendar-day-2015-07-28"><div
													class="day-contents">28</div></td>
											<td class="day calendar-day-2015-07-29"><div
													class="day-contents">29</div></td>
											<td class="day calendar-day-2015-07-30"><div
													class="day-contents">30</div></td>
											<td class="day calendar-day-2015-07-31"><div
													class="day-contents">31</div></td>
											<td
												class="day adjacent-month next-month calendar-day-2015-08-01"><div
													class="day-contents">1</div></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<!----Calender -------->
						<link rel="stylesheet" href="css/clndr.css" type="text/css" />
						<script src="js/underscore-min.js" type="text/javascript"></script>
						<script src="js/moment-2.2.1.js" type="text/javascript"></script>
						<script src="js/clndr.js" type="text/javascript"></script>
						<script src="js/site.js" type="text/javascript"></script>
						<!----End Calender -------->
					</div>
					<div class="col-md-7 mid-content-top">
						<div class="middle-content">
							<h3>Latest Images</h3>
							<!-- start content_slider -->
							<div id="owl-demo" class="owl-carousel text-center">
								<div class="item">
									<img class="lazyOwl img-responsive" data-src="images/timg2.jpg"
										alt="name">
								</div>
								<div class="item">
									<img class="lazyOwl img-responsive" data-src="images/timg1.jpg"
										alt="name">
								</div>
								<div class="item">
									<img class="lazyOwl img-responsive" data-src="images/timg2.jpg"
										alt="name">
								</div>
								<div class="item">
									<img class="lazyOwl img-responsive" data-src="images/timg1.jpg"
										alt="name">
								</div>
								<div class="item">
									<img class="lazyOwl img-responsive" data-src="images/timg2.jpg"
										alt="name">
								</div>
								<div class="item">
									<img class="lazyOwl img-responsive" data-src="images/timg1.jpg"
										alt="name">
								</div>
								<div class="item">
									<img class="lazyOwl img-responsive" data-src="images/timg2.jpg"
										alt="name">
								</div>

							</div>
						</div>
						<!--//sreen-gallery-cursual---->
						<!-- requried-jsfiles-for owl -->
						<link href="css/owl.carousel.css" rel="stylesheet">
						<script src="js/owl.carousel.js"></script>
						<script>
				$(document).ready(function() {
					$("#owl-demo").owlCarousel({
						items : 3,
						lazyLoad : true,
						autoPlay : true,
						pagination : true,
						nav:true,
					});
				});
			</script>
						<!-- //requried-jsfiles-for owl -->
					</div>
					<div class="clearfix"></div>
				</div>
				<!----->
				<div class="content-bottom">
					<div class="col-md-6 post-top">
						<div class="post">
							<form class="text-area">
								<textarea required=""> What are you doing...</textarea>
							</form>
							<div class="post-at">
								<ul class="icon">


									<div class="post-file">
										<i class="fa fa-location-arrow"></i> <input id="input-1"
											name="input1[]" type="file" multiple="" class="">
									</div>
									<div class="post-file">
										<i class="fa fa-camera"></i> <input id="input-2"
											name="input2[]" type="file" multiple="" class="">
									</div>
									<div class="post-file">
										<i class="fa fa-video-camera"></i> <input id="input-3"
											name="input3[]" type="file" multiple="" class="">
									</div>
									<div class="post-file">
										<i class="fa fa-microphone"></i> <input id="input-4"
											name="input4[]" type="file" multiple="" class="">
									</div>

									<script>
							$(document).on('ready', function() {
								$("#input-1").fileinput({showCaption: false});
							});
							</script>
									<script>
							$(document).on('ready', function() {
								$("#input-2").fileinput({showCaption: false});
							});
							</script>
									<script>
							$(document).on('ready', function() {
								$("#input-3").fileinput({showCaption: false});
							});
							</script>
									<script>
							$(document).on('ready', function() {
								$("#input-4").fileinput({showCaption: false});
							});
							</script>
								</ul>
								<form class="text-sub">
									<input type="submit" value="post">
								</form>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="post-bottom"></div>
					</div>

				</div>
				<div class="col-md-6">
					<div class="weather">
						<div class="weather-top">
							<div class="weather-top-left">
								<div class="degree">
									<figure class="icons"> <canvas id="partly-cloudy-day"
										width="64" height="64"> </canvas> </figure>
									<span>23°</span>
									<div class="clearfix"></div>
								</div>
								<script>
							 var icons = new Skycons({"color": "#1ABC9C"}),
								  list  = [
									"clear-night", "partly-cloudy-day",
									"partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
									"fog"
								  ],
								  i;

							  for(i = list.length; i--; )
								icons.set(list[i], list[i]);

							  icons.play();
						</script>
								<p>
									Wednesday <label>5</label> <sup>th</sup> Jun
								</p>
							</div>
							<div class="weather-top-right">
								<p>
									<i class="fa fa-map-marker"></i>Harbin
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="weather-bottom">
							<div class="weather-bottom1">
								<div class="weather-head">
									<h4>Cloudy</h4>
									<figure class="icons"> <canvas id="cloudy" width="58"
										height="58"></canvas> </figure>
									<script>
							 var icons = new Skycons({"color": "#999"}),
								  list  = [
									"clear-night", "cloudy",
									"partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
									"fog"
								  ],
								  i;

							  for(i = list.length; i--; )
								icons.set(list[i], list[i]);

							  icons.play();
						</script>
									<h6>23°</h6>
									<div class="bottom-head">
										<p>Jun 6</p>
										<p>Thursday</p>
									</div>
								</div>
							</div>
							<div class="weather-bottom1 ">
								<div class="weather-head">
									<h4>Sunny</h4>
									<figure class="icons"> <canvas id="clear-day"
										width="58" height="58"> </canvas> </figure>
									<script>
							 var icons = new Skycons({"color": "#999"}),
								  list  = [
									"clear-night", "clear-day",
									"partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
									"fog"
								  ],
								  i;

							  for(i = list.length; i--; )
								icons.set(list[i], list[i]);

							  icons.play();
						</script>
									<h6>22°</h6>
									<div class="bottom-head">
										<p>Jun 7</p>
										<p>Friday</p>
									</div>
								</div>
							</div>
							<div class="weather-bottom1">
								<div class="weather-head">
									<h4>Cloudy</h4>
									<figure class="icons"> <canvas id="rain" width="58"
										height="58"> </canvas> </figure>
									<script>
							 var icons = new Skycons({"color": "#999"}),
								  list  = [
									"clear-night", "clear-day",
									"partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
									"fog"
								  ],
								  i;

							  for(i = list.length; i--; )
								icons.set(list[i], list[i]);

							  icons.play();
						</script>

									<h6>24°</h6>
									<div class="bottom-head">
										<p>Jun 8</p>
										<p>Saturday</p>
									</div>
								</div>
							</div>
							<div class="weather-bottom1 ">
								<div class="weather-head">
									<h4>Snowy</h4>
									<figure class="icons"> <canvas id="wind" width="58"
										height="58"> </canvas> </figure>
									<script>
							 var icons = new Skycons({"color": "#999"}),
								  list  = [
									"clear-night", "clear-day",
									"partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
									"fog"
								  ],
								  i;

							  for(i = list.length; i--; )
								icons.set(list[i], list[i]);

							  icons.play();
						</script>
									<h6>21°</h6>
									<div class="bottom-head">
										<p>Jun 9</p>
										<p>Sunday</p>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>


					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--//content-->


			<!---->
			<!---->
			<!--scrolling js-->
			<script src="js/jquery.nicescroll.js"></script>
			<script src="js/scripts.js"></script>
			<!--//scrolling js-->
			<script src="js/bootstrap.min.js"> </script>
</body>
</html>

