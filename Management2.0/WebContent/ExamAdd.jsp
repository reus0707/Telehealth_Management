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

<link rel="icon" href="assets/images/favicon.ico"/>
<link rel="stylesheet" href="assets/libs/layui/css/layui.css">
<link rel="stylesheet" href="assets/common.css">

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
	<div class="grid-form1">
	<form class="layui-form" action="ExamAdd" method="post">
		<input type="hidden" name=userid value=<s:property value="user.userid"/> /> 
	  	
	  	<div class="layui-form-item">
		    <label class="layui-form-label">体检信息ID</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="exam_id" id="focusedinput" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">姓名</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="patientname" id="focusedinput" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">性别</label>
		    <div class="layui-input-inline">
			    <select name="sex">
			        <option value="男" selected="">男</option>
			        <option value="女">女</option>
			    </select>
		  	</div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">年龄</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="age" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-inline">
			<label class="layui-form-label">体检时间</label>
			<div class="layui-input-inline">
				<input type="text" name="time" id="date" lay-verify="date" placeholder="yyyy-MM-dd"  class="layui-input">
			</div>
	    </div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">身高</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="height"  placeholder="(cm)" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">体重</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="weight"  placeholder="(kg)" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">心率</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="pulserate"  placeholder="(次/分钟)" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">血压</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="bloodpressure"  placeholder="(mmHg)" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">血氧</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="spo"  placeholder="(%)" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">体温</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="temperature"  placeholder="(℃)" class="layui-input">
		    </div>
	  	</div>
	  	<div class="layui-form-item">
		    <label class="layui-form-label">三围</label>
		    <div class="layui-input-inline">
		    	<input type="text" name="bwh"  placeholder="15/20/25" class="layui-input">
		    </div>
	  	</div>
	
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn">提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	</div>
	</div>
	 	
	<script src="assets/libs/layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
	layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  
	  //日期
	  laydate.render({
	    elem: '#date'
	  });
	
	});
	</script>
 	
 	

 	<!--//grid-->
		<!---->
     <!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
<!---->

</body>
</html>


