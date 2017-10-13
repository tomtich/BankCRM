<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team Leader</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>
<script type="text/javascript">
var contentsAgents ="";
var contentsCustomers ="";
var contentsProgess ="";


	// This call is used to handle the Agent Table
	$(document).ready(function() {
		$("#agents").click(function() {
			var purl = contextPath + "/agents";
			$.ajax({
				url : purl,
				success : function(jsonData) {
					contentsAgents ='<table class="table table-bordered" style="width: 80%;"> <thead"><caption><h4 style="color:blue;">Active Agents</h4></caption><tr style="background-color:pink;"><th>ID</th> <th>Name</th> <th>Email</th><th>Contact</th><th>Status</th></tr></thead>';
									for (var x = 0; x < jsonData.length; x++) {
										addOneAgent(jsonData[x], x);
							
					}
									contentsAgents = contentsAgents + '</table><hr>';
									
					$("#agentsResult").html(contentsAgents);
				}
			});
		}); //end of the click event
	}); //end of ready handler

	// This function is used to add new Agent to list
	function addOneAgent(srow, index) {
		contentsAgents = contentsAgents + '  <tbody>';
		contentsAgents = contentsAgents + '<div id = "agentdiv'+ srow.id + '"><tr >';
		contentsAgents = contentsAgents
		+ '<td>'
		+ srow.id + '</td>';
		contentsAgents = contentsAgents
				+ '<td>'
				+ srow.name + '</td>';
				contentsAgents = contentsAgents
				+ '<td>'
				+ srow.email + '</td>';
				contentsAgents = contentsAgents
				+ ' <td>'
				+ srow.contactNumber + '</td>';
				contentsAgents = contentsAgents
				+ '            <td>'
				+ srow.status + '</td>';
				contentsAgents = contentsAgents + '      </tr>';
				contentsAgents = contentsAgents + '</div>';
				contentsAgents = contentsAgents + '  </tbody>';
		
	
	
	
	
	
	}
	
	// This call is used to handle the Accepted Customers Table
	$(document).ready(function() {
		$("#customers").click(function() {
			var purl = contextPath + "/acceptedcustomer";
			$.ajax({
				url : purl,
				success : function(jsonData) {
					contentsCustomers ='<table class="table table-bordered" style="width: 80%;"> <thead"><caption><h4 style="color:blue;">Approved Customers</h4></caption><tr style="background-color:#00bfff;"><th>ID</th> <th>Name</th> <th>Age</th><th>Contact</th><th>Loan Amount</th><th>Agent ID</th><th>Assign</th></tr></thead>';							for (var x = 0; x < jsonData.length; x++) {
										addOneCustomer(jsonData[x], x);
							
					}
									contentsCustomers = contentsCustomers + '</table>';
									
					$("#customersResult").html(contentsCustomers);
				}
			});
		}); //end of the click event
	}); //end of ready handler
	
	
	
	function changeAgent() {
			var id = document.getElementById("agent").value;
			alert(id);
			var purl = "http://localhost:8080/Bank/changeAgent/"+ id ;
			$.ajax({
						url : purl,
						type : 'PUT',
						success : function(jsonData) { //data= this.responseText
							//data is JavaScript object against JSON response coming fromm the server
							console.log("jsonData.status" + jsonData.status);
							if (jsonData.status == "success") {
								$("#agentdiv" + id).hide();
							} else {
								alert("Sorry!");
							}
						}
					});

	} //end of ready handler

	function uploadAgent() {
		var purl = "http://localhost:8080/Bank/uploadAgent" ;
		$.ajax({
					url : purl,
					type : 'POST',
					success : function(jsonData) { //data= this.responseText
						//data is JavaScript object against JSON response coming fromm the server
						console.log("jsonData.status" + jsonData.status);
						if (jsonData.status == "success") {
							$("#agentdiv" + id).hide();
						} else {
							alert("Sorry!");
						}
					}
				});

} //end of ready handler

	
	// This function is used to add new Customer to list
	function addOneCustomer(srow, index) {
		contentsCustomers = contentsCustomers + '  <tbody>';
		contentsCustomers = contentsCustomers + '<div id = "customerdiv'+ srow.id + '"><tr id= '+srow.id + '>';
		contentsCustomers = contentsCustomers
		+ '<td>'
		+ srow.id + '</td>';
		contentsCustomers = contentsCustomers
				+ '<td>'
				+ srow.name + '</td>';
				contentsCustomers = contentsCustomers
				+ '<td>'
				+ srow.age + '</td>';
				contentsCustomers = contentsCustomers
				+ ' <td>'
				+ srow.contactNumber + '</td>';
				contentsCustomers = contentsCustomers
				+ '            <td>'
				+ srow.loanAmount + '</td>';
				contentsCustomers = contentsCustomers
				+ '            <td><select id="agent"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option></select>'
				+'</td>';
				contentsCustomers = contentsCustomers
				+ '<td><a href="javascript:mailPopup();uploadAgent();changeCustomer('+ srow.id +') "><button class="btn btn-danger" id="Button">Assign</button></a></td>';
				
				contentsCustomers = contentsCustomers + '      </tr>';
				contentsCustomers = contentsCustomers + '</div>';
				contentsCustomers = contentsCustomers + '  </tbody>';
		
	}
	
	
	
	
	
	
	
	
	
	// This function is used to hide the customer information detail
	function hideTable(id) {
		$("#table" + id).hide();
	}

	// This function is used to show the customer information detail
	function showTable(id) {
		$("#table" + id).show();
	}
        		
	
    
	function mailPopup() {
		var id = document.getElementById("agent").value;
		
		var name = $("#" + id).children("td:nth-child(1)").text();
		var name1 = $("#" + id).children("td:nth-child(2)").text();
		var name2 = $("#" + id).children("td:nth-child(3)").text();
		var name3 = $("#" + id).children("td:nth-child(4)").text();
		var name4 = $("#" + id).children("td:nth-child(5)").text();
		var name5 = $("#" + id).children("td:nth-child(6)").text();
		//alert(name5);
		$("input[type='text'][name='cname']").val(name1);
		$("input[type='text'][name='cage']").val(name2);
		$("input[type='text'][name='ccontactNumber']").val(name3);
		$("input[type='text'][name='loanAmount']").val(name4);
		$("input[type='text'][name='aid']").val(id);
		
		
		
		//var agent = document.getElementById("agent").value;
		//alert (agent);
		//$("input[type='text'][name='agent']").val(email);
	
	//	$("#sendMailPopup").modal('show');
	}
	
	function changeCustomer(id) {
		//https://stackoverflow.com/questions/2153917/how-to-send-a-put-delete-request-in-jquery
		var purl = "http://localhost:8080/Bank/changeCustomer/" + id;
		$.ajax({
			url : purl,
			type : 'PUT',
			success : function(jsonData) { //data= this.responseText
				//data is JavaScript object against JSON response coming fromm the server
				console.log("jsonData.status" + jsonData.status);
				if (jsonData.status == "success") {
					$("#customerdiv" + id).hide();
				} else {
					alert("Sorry! data could not be deleted");
				}
			}
		});
	}
	
	
</script>
<style>
body {
	background-color: #ffffff;
}
</style>

</head>
<body>
	<img alt="" src="${pageContext.request.contextPath}/img/2.gif"
		height="120px;"
		style="width: 100px; display: inline; margin-left: 40px;">
	<h2 style="color: #4000ff; display: inline; margin-left: 40px;">Leader Home Page</h2>
	<hr style="border-width: 10px;" />
	<div style="margin-left: 30px;">
		<div class="form-group">
			<form name="pendingList">
				<button type="button" class="btn btn-primary" id="agents">Show Agents</button>
			<button type="button" class="btn btn-primary" id="customers">Show Customers</button>
			<button type="button" class="btn btn-primary" id="progress">Show Progress</button>
			</form>
		</div>
		<br />
		
		<div id="agentsResult"></div>
		<div id="customersResult"></div>
		<div id="progressResult"></div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="sendMailPopup" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">
						<img src="" height="80px;" id="sphotoTitle"> This Customer is assigned
					</h4>
				</div>
				<div class="modal-body">
					<form name="assign"
						id="assign">
						<input type="hidden" class="form-control" id="sdid" name="id"
							style="width: 200px;" />
						
						<div class="form-group">
							<label>To :</label> <input type="text" class="form-control"
								id="cname" placeholder="Agent ID" name="cname">
						</div>
						<div class="form-group">
							<label>To :</label> <input type="text" class="form-control"
								id="cage" placeholder="Agent ID" name="cage">
						</div>
						
						<div class="form-group">
							<label>To :</label> <input type="text" class="form-control"
								id="ccontactNumber" placeholder="Agent ID" name="ccontactNumber">
						</div>
						<div class="form-group">
							<label>To :</label> <input type="text" class="form-control"
								id="loanAmount" placeholder="Agent ID" name="loanAmount">
						</div>
						
						<div class="form-group">
							<label>To :</label> <input type="text" class="form-control"
								id="aid" placeholder="Agent ID" name="aid">
						</div>
						
												<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn btn-danger"
								id="cancel">Cancel</button>
							<button class="btn btn-danger"
								id="Button">Assign</button>
						</div>
					</form>
				</div>

			</div>

		</div>
	</div>
	
</body>
</html>