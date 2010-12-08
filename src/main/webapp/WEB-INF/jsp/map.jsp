<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">
	var map;
	var marker;
	function initialize() {
	  var latlng = new google.maps.LatLng(-34.397, 150.644);
	  var myOptions = {
	    zoom: 8,
	    center: latlng,
	    mapTypeId: google.maps.MapTypeId.ROADMAP
	  }
	  map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

	  google.maps.event.addListener(map, 'click', function(event) {
	    placeMarker(event.latLng);
	  });
	}

	function placeMarker(location) {
	  var clickedLocation = new google.maps.LatLng(location);
	  marker = new google.maps.Marker({
	      position: location,
	      map: map
	  });
	  attachMessage(marker);
	  map.setCenter(location);
	}

	function attachMessage(marker) {
	  var message = document.getElementById("description").value;
	  var infowindow = new google.maps.InfoWindow(
	      { content: message,
	        size: new google.maps.Size(50,50)
	      });
	  google.maps.event.addListener(marker, 'click', function() {
	    infowindow.open(map,marker);
	  });
	}

</script>
</head>
<body onload="initialize()">
  <div id="map_canvas" style="width:400px; height:400px"></div>
  <input type="text" name="description" value=" " id="description" size="20">
</body>