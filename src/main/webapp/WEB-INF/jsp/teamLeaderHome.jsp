<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-2.2.4.min.js">
</script>

<script>
/**
 * Function that renders the online Agents and accepted Customers by
 submitting an AJAX request to the server.
 */
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
				console.log(jsonData);
			},
			error : function(data, status, er) {
				alert("error: " + data + " status: " + status + " er:" + er);
				console.log(data);
			}
		}

	);//end of ajax call
	
	var qurl = "teamLeaderHomeCustomers";
	$.ajax({
		url : qurl,
		type : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		mimeType : 'application/json',
		success : function(jsonData) {
			alert(jsonData);
			console.log(jsonData);
		},
		error : function(data, status, er) {
			alert("error: " + data + " status: " + status + " er:" + er);
			console.log(data);
		}
	}

	);//end of ajax call
	
	var rurl = "teamLeaderHomeAssignments";
	$.ajax({
		url : rurl,
		type : 'GET',
		dataType : 'json',
		contentType : 'application/json',
		mimeType : 'application/json',
		success : function(jsonData) {
			alert(jsonData);
			console.log(jsonData);
		},
		error : function(data, status, er) {
			alert("error: " + data + " status: " + status + " er:" + er);
			console.log(data);
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
	Hello Team Leader!
	<div id="activeAgents"></div> <!-- Show online agents here -->
	<div id="acceptedCustomers"></div> <!-- Show accepted customers here -->
</body>
</html>