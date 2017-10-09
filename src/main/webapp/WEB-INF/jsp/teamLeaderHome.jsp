<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-2.2.4.min.js">
</script>
<!-- <script>
jQuery(document).ready(function() {
$.get("teamLeaderHomeAgents.html", { // change this to the url of Rest API
}, function(responseText) {
$.each(responseText, function(key1, value1) {
	$("#activeAgents").append(value1);
});
});

$.get("teamLeaderHomeCustomers.html", { // change this to the url of Rest API
}, function(responseText) {
$.each(responseText, function(key1, value1) {
	$("#acceptedCustomers").append(value1);
});
});
});
</script> -->
<!-- <script>
jQuery(document).ready(function() {
$.ajax({
		 type:'GET',
		 url:'teamLeaderHomeCustomers.html',
		 dataType:"json",
		 contentType:'application/json',
		 mimeType: 'application/json',
		 success: function(responseText) {
			 alert(responseText);
			 var json = $.parseJSON(responseText);
		    		   
			 $.each(json, function(key1, value1) {
				 $("#acceptedCustomers").append(value1);
			});
			 //$("#catItems").append('<option>OTHERS</option>'); 
		 }
	 });
});
</script> -->
<script>
//var selectedName = "";
//function that render the online agents
$(document).ready(function(){
	
	var purl ="teamLeaderHomeAgents";
	$.ajax({
			url : purl,
			type : 'GET',
			dataType : 'json',
			contentType : 'application/json',
			mimeType : 'application/json',
			success : function(jsonData) {
				alert(jsonData);
			},
			error : function(data, status, er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		}

	);//end of ajax call
});

</script>

</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	Hello Team Agent!
	<div id="activeAgents"></div> <!-- Show online agents here -->
	<div id="acceptedCustomers"></div> <!-- Show accepted customers here -->
</body>
</html>