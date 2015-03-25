<%-- 
    Document   : accountinfo
    Created on : Mar 25, 2015, 3:10:47 PM
    Author     : Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title> DIWA </title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="style.css">
	<style>
            #infos{
                position: relative;
                left: 50;
            }
            #right{
                color: black;
            }
	</style>
	<script>
		
	</script>
</head>
<body>
	<div id="header">
		 <nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<h1>DIWA</h1>
					<h4>Disaster Information and Warning Application</h4> 
				</div>
				<div id="navbar" class="navbar-collapse collapse">
				  <div id="bar">
				  <ul class="nav navbar-nav navbar-right">
					<div class="nav nav-pills">
						<li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"> Account</a></li>
						<li><a href="#about"> <span class="glyphicon glyphicon-cog" aria-hidden="true"> Settings</a></li>
						<li><a href="#about"> <span class="glyphicon glyphicon-off" aria-hidden="true"> Logout</a></li>
						</div>
				  </ul>
				  </div>
				</div>
			</div>
		</nav>
	</div>
	<div id="main">
            <h4>Account Information</h4>
		<div id="left">
                    <span id="username"> <font size="10">Username</font></span><br>
                    <div id="infos">
                        <span id="firstname"><font size="6">Firstname</font></span>
                        <span id="lastname"> <font size="6">Lastname</font></span><br>
                        <span id="location"> <font size="6">location</font></span>
                    </div>
		</div>
		<div id="right">
                    <h4>Saved Locations</h4>
                    <ul class="list-group">
			<li class="list-group-item">Sta. Mesa</li>
			<li class="list-group-item">Mandaluyong</li>
                        <li class="list-group-item">Quezon City</li>
			<li class="list-group-item">Brgy. Don Bosco</li>
                    </ul>
		</div>
	</div>
	<div id="footer">
		<h5> Copyright 2015 Baldip Bhuller Francesco Salceda</h5>
	</div>
</body>
</html>