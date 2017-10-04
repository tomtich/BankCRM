<%@page import="com.web.bank.controller.model.CustomerForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.web.bank.controller.model.*" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
     <style type="text/css">
    .bs-example{
    	margin-left:120px;
    }
    
   .parentimage {
	width: 60px;
	height: 60px; 
	-webkit-transition: all .3s ease-out;
	-moz-transition: all .3s ease-out;
	-o-transition: all .3s ease-out;
	transition: all .3s ease-out;
} 
.parentimage:hover {
	-moz-transform: scale(3);
	-webkit-transform: scale(3);
	-o-transform: scale(3);
	-ms-transform: scale(3);
	transform: scale(3);
} 
    
</style>

</head>

<body>
Hello Bank Manager!

<div class="bs-example">
    <table class="table table-bordered" style="width: 90%;">
        <thead>
            <tr style="background-color: rgba(1, 171, 114, 0.18);">
                <th>Customer ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Age</th>
                <th>Loan Amount</th>
                <th>SSN</th>
                <th>Status</th>
            </tr>
        </thead>
        
        <%
        List<CustomerForm> customerList = (List<CustomerForm>) request.getAttribute("customerList");
        int count=1;
        System.out.println(customerList);
        for(CustomerForm cf : customerList) {
        %>
        <tbody>
            <tr id="<%=cf.getCid() %>">
                <td><%=cf.getCid() %></td>
                <td><%=cf.getName() %></td>
                <td><%=cf.getAddress() %></td>
                <td><%=cf.getContact() %></td>
                <td><%=cf.getAge() %></td>
                <td><%=cf.getLoan() %></td>
                <td><%=cf.getSsn() %></td>
                <td><%=cf.getStatus() %></td>
            </tr>
            <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>