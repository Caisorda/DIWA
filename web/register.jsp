<%-- 
    Document   : register
    Created on : Mar 28, 2015, 7:22:59 PM
    Author     : Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title> DIWA </title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="style.css">
	<script src="script.js"></script>
	<style>
		label{
			padding:5px;
			width: 150px;
		}
	</style>
        <% 
            String firstname=null;
            String lastname=null;
            String username=null;
            String password=null;
            String confirmPassword=null;
            
            Cookie[] cookies = request.getCookies();
            if(cookies !=null)
            {
                for(Cookie cookie: cookies){
                    if(cookie.getName().equals("data")){
                        if(cookie.getValue() != null){
                            String deData[] = cookie.getValue().split(" ");
                            firstname=deData[0];
                            lastname=deData[1];
                            username=deData[2];
                            password=deData[3];
                            confirmPassword=deData[4];
                        }else{
                            firstname="";
                            lastname="";
                            username="";
                            password="";
                            confirmPassword="";
                        }
                             
                        
                    }
                }
            }
            else{
                firstname="";
                lastname="";
                username="";
                password="";
                confirmPassword="";
            }
        %>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" style="margin:0px;">
			<div class="container">
				<div class="navbar-header">
					 <h2>WELCOME TO DIWA</h2>
					 <h4>Disaster Information and Warning Application</h4>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
				  
				  <ul class="nav navbar-nav navbar-right" style="margin-top:20px;">
				  
					<li><a href="diwahomepage.html"><span class="glyphicon glyphicon-home" aria-hidden="true"> Home</a></li>
					<li><a href="#about"> <span class="glyphicon glyphicon-info-sign" aria-hidden="true"> About</a></li>
				  
				  </ul>
				  
				</div>
			</div>
	</nav>
	<div id="main">
		<div id="left">
			<h4>REGISTER</h4>
                        <form class="form-inline" action="RegisterServlet" method="post">
				<div class="form-group">
                                <label>Firstname:</label>
				<input type="text" class="form-control" id="fname" placeholder="Enter firstname" value="">
				</div>
				<br>  <br>
				<label>Lastname:</label>
				<input type="text" class="form-control" id="lname" placeholder="Enter lastname" value="">
				<br>  <br>
				<label>Username:</label>
				<input type="text" class="form-control" id="username" placeholder="Enter username" value="">
				<br>  <br>
				<label>Password:</label>
				<input type="password" class="form-control" id="password" placeholder="Enter password" value="">
				<br> </br>
				<label>Confirm Password:</label>
				<input type="password" class="form-control" id="configpassword" placeholder="Enter password" value="">
				<br> </br>
				<button type="button" class="btn btn-primary btn-lg" id="registerbtn">Register</button>
			</form>
		</div>
		<div id="right">
			<img id ="map" src="mock.jpg">
		</div>
	</div>
	<footer>
		<h5> Copyright 2015 Baldip Bhuller Francesco Salceda</h5>
	</footer>
</body>
</html>

