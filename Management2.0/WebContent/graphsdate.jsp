<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Graph</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<script src="js/jquery.min.js"> </script>
<script src="js/Chart.js"></script>
<style type="text/css">
	#os-lbl {
    border-left: #666666 solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
	}
	
	#os-Other-lbl {
    border-left: #1abc9c solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
	}
	
	#os-Win-lbl {
    border-left: #d95459 solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;    
	}
	
	#os-Mac-lbl {
    border-left: #3BB2D0 solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
	}
	
	#os-server-lbl {
    border-left: #FF8C00 solid 1em;
    padding-left: .5em;
    font-size: 1em;
    color: #777F8C;
	}
</style>
</head>
<body>
<div id="wrapper">
       <!----->
        <nav class="navbar-default navbar-static-top" role="navigation">
             <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               
			   </div>
			 <div class=" border-bottom">
        	<div class="full-left">
        	  <section class="full-top">
				<button id="toggle"><i class="fa fa-arrows-alt"></i></button>	
			</section>
			
            <div class="clearfix"> </div>
           </div>
     
       
            <!-- Brand and toggle get grouped for better mobile display -->
		 
		   <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="drop-men" >
		        <ul class=" nav_1">
		           
		    		<li class="dropdown at-drop">
		              <a href="#" class="dropdown-toggle dropdown-at " data-toggle="dropdown"><i class="fa fa-globe"></i> <span class="number">5</span></a>
		              
		            </li>
					<li class="dropdown">
		              <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret">admin<i class="caret"></i></span><img src="images/wo.jpg"></a>
		              <ul class="dropdown-menu " role="menu">
		                <li><a href="profile.html"><i class="fa fa-user"></i>Edit Profile</a></li>
		                <li><a href="inbox.html"><i class="fa fa-envelope"></i>Inbox</a></li>
		                <li><a href="calendar.html"><i class="fa fa-calendar"></i>Calender</a></li>
		                <li><a href="inbox.html"><i class="fa fa-clipboard"></i>Tasks</a></li>
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
				<span>Graphs</span>
				</h2>
		    </div>
		<!--//banner-->
	
 	<!--//grid-->
 	<div class="graph">
	<div class="col-md-12 graph-box1 clearfix">	
				<div class="col-md-6 graph-1">
							<div class="grid-1">
								<h4>日期统计</h4>
								<canvas id="bar1" height="300" width="500"
									style="width: 500px; height: 300px;"></canvas>
								<script>
										var barChartData = {
											labels : ["Mon","Tue","Wed","Thu","Fri","Sat","Sun"],
											datasets : [
												{
													fillColor : "#FBB03B",
													strokeColor : "#FBB03B",
													data : [25,40,30,20,55,50,65]
												},
												{
													fillColor : "#FBB03B",
													strokeColor : "#FBB03B",
													data : [30,45,25,15,40,55,70]
												}
											]
											
										};
											new Chart(document.getElementById("bar1").getContext("2d")).Bar(barChartData);
									</script>
							</div>
						</div>			
						
	</div>			
	</div>
		<!---->
		
		</div>
		<div class="clearfix"> </div>
       </div>
  
<!---->

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
			

			
		});
		</script>

<!----->

<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
</body>
</html>