<%-- 
    Document   : mainscreen
    Created on : Mar 25, 2015, 3:12:49 PM
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
    #viewbtn{
		margin-left: 200px;
	}
	</style>
        
        <!-- Google Maps and Places API -->
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>

	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

    <script type="text/javascript"> 
        //declare namespace
		var up206b = {};

		//declare map
		var map;
      function initialize() {
        var mapCanvas = document.getElementById('map');
        var mapOptions = {
          center: new google.maps.LatLng(14.6319794, 121.0186019),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        map = new google.maps.Map(mapCanvas, mapOptions)
      }
      google.maps.event.addDomListener(window, 'load', initialize);   
		

//set the geocoder
var geocoder = new google.maps.Geocoder();

		function trace(message) 
		{
			if (typeof console != 'undefined') 
			{
				console.log(message);
			}
		}
 
		//Function that gets run when the document loads
		up206b.initialize = function()
		{
			var latlng = new google.maps.LatLng(34.070264, -118.4440562);
			var myOptions = {
				zoom: 13,
				center: latlng,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};
			map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
		}

//geocode function
up206b.geocode = function() 
{
    var address = $('#address').val();
    geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) 
        {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map, 
                position: results[0].geometry.location
            });
        } 
        else 
        {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });
}

function savedLocation(location){
    var address = location;
    geocoder.geocode( { 'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) 
        {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map, 
                position: results[0].geometry.location
            });
        } 
        else 
        {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });
}

function newLocation()
{
    var location = $('#address').val();
    var ul = document.getElementById("thesaved");
    var li = document.createElement("li");
    var button = document.createElement("button");
    var span = document.createElement("span");
    button.setAttribute('class',"btn btn-default btn-sm");
    button.setAttribute('style',"float: right;");
    span.setAttribute('class', "glyphicon glyphicon-chevron-right");
    span.setAttribute('aria-hidden', "true");
    span.setAttribute('onclick', "savedLocation('"+location+"');");
    li.setAttribute('class',"list-group-item")
    li.appendChild(document.createTextNode(location));
    button.appendChild(span);
    li.appendChild(button);
    ul.appendChild(li);
}

	</script>
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
		<h4><%/*location*/.getLocationName();%></h4>
			<div id="map"></div><br>
			<form class="form-inline">
					<button type="button" class="btn btn-primary btn-lg" id="viewbtn" onclick="savedLocation('De La Salle University');">View Current Location</button>
			</form>
		</div>
		<div id="right">
				<h3>Disaster Probability</h2>
				Typhoon
				<div id="typhoon" class="progress">
					<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<%/*location*/.getLocationName();%>" aria-valuemin="0" aria-valuemax="100" style="width: 20%;">
						<%/*location*/.getLocationName();%>%
					</div>
				</div>
				Flood
				<div id="flood" class="progress">
					<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<%/*location*/.getLocationName();%>" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
						<%/*location*/.getLocationName();%>%
					</div>
				</div>
				Earthquake
				<div id="earthquake" class="progress">
					<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<%/*location*/.getLocationName();%>" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
						<%/*location*/.getLocationName();%>%
					</div>
				</div>
				Volcanic Eruption
			
				<div id="volcanic" class="progress">
					<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="<%/*location*/.getLocationName();%>" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
						<%/*location*/.getLocationName();%>%
					</div>
				</div>
				Storm Surge
				<div id="storm" class="progress">
					<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="<%/*location*/.getLocationName();%>" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
						<%/*location*/.getLocationName();%>%
					</div>
				</div>
				
			<h3>Disaster Occurence</h2>
                         <%
                                if(/*DisasterOccurence*/!= null && /*DisasterOccurence*/.getSize() > 0){
                                    for(int i = 0; i < /*DisasterOccurence*/.getSize(); i++){
                                        /*DisasterOccurence disasterOccurence = DisaserOccurence.get(i);*/
                                    if(/*DisasterOccurence.getImminentness() == "Danger"*/){
                            %>
			<div class="alert alert-danger" role="alert">
				<strong><%/*DisasterOccurence.getTitle()*/%></strong>
				 Stock up on
				<a href="" class="alert-link">Useful Resources</a>
				and read the
				<a href="" class="alert-link">Safety Guidelines</a>
			</div>
                        <%} else if(/*DisasterOccurence.getImminentness() == "Imminent"*/){%>
                            
                        <div class="alert alert-warning" role="alert">
				<strong><%/*DisasterOccurence.getTitle()*/%></strong>
				 Stock up on
				<a href="" class="alert-link">Useful Resources</a>
				and read the
				<a href="http://www.ready.gov/natural-disasters" class="alert-link">Safety Guidelines</a>
                        </div>
                        <%      } 
                            }
                        else{
                        %>
			<div class="alert alert-success" role="alert"><strong>Hurray!</strong> No Disaster imminent. <strong>Have a nice day!</strong></div>
                        <%}%>
                </div>
	</div>
	<footer>
		<h5> Copyright 2015 Baldip Bhuller Francesco Salceda</h5>
	</footer>
</body>
</html>