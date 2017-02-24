<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page language="java" session="true"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Admin Home</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.2.js"></script>
<link href="css/agency.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
body {
	background-image:
		url("https://awesomewallpapers.files.wordpress.com/2010/05/white.jpg");
	background-color: #cccccc;
	background-repeat: no-repeat;
	background-size: cover;
}

.ta-bar {
	margin: 0 auto;
	background-color: rgba(255, 255, 255, 0.5);
}
</style>

</head>

<body>
	<br>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="admin_home.jsp">Charlotte Car Servicing</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Stock<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="add_stock.jsp">Add stock</a></li>
									<li><a href="PickStock.jsp">Update stock</a></li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Employees<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="EmployeeRegistration.jsp">Add Employees</a></li>
									<li><a href="PickEmployee.jsp">Update Employees</a></li>
								</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Service type<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="addservice.jsp">Add service type</a></li>
									<li><a href="pickService.jsp">Update service type</a></li>
								</ul></li>
							
							</ul>
							<ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="AdminLogoutServlet">Logout</a>
                    </li>
                    </ul>
					</div>
				</div>
			</nav>

		</div>
	</div>
	<section id="Service_slot">
		<div class="container">

			<h3>Generate Invoice</h3>
			<form id="service_slot" name="service_slot" action="AddInvoiceDetails"
				method="post">
				<table class="tablesorter table table-bordered table-striped"
					id="serviceTable">

					<thead>
						<tr>
							<th class="header">Stock Id</th>
							<th>Stock Name</th>
							<th>Quantity</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="stock" items="${stocks }">

							<tr>
								<td><input
									type="text" id="stockId1" name="stockId1" readonly="readonly"
									value="${stock.getStock_id()}" /></td>
								<td><input type="text"
									id="stockName1" name="stockName1" readonly="readonly"
									value="${stock.getName()}" /></td>
								<td><input type="number"
									id="${stock.getStock_id()}" name="${stock.getStock_id()}" min="0" max="${ stock.getQuantity()}"
									 />
								</td>
								<td><input type="text"
									id="Price" name="Price" readonly="readonly"
									 value="${ stock.getPrice()}"/>
								</td>
							</tr>

						</c:forEach>
						<tr>
								<td></td>
								<td></td>
								<td>
								</td>
								
								<td><input type="submit" value="Add" id="submit_button"
									value="Add" class="btn btn-default"/></td>
							</tr>

					</tbody>
				</table>
			</form>
			<c:if test="${fn:length(pendingServicings) lt 1}">
	          	 <div class="panel-heading">
                <h4 class="panel-title">
                    <a>All Servicings are complete. No servicings are in queue!!</a>
                </h4>
            </div>
	          </c:if>
			<c:if test="${statusUpdated!=null }">
				<label>${statusUpdated}</label>
			</c:if>
		</div>
	</section>
	<section id="invoice">
		<div class="container">
			<h3>Invoice</h3>

			<table id="invoiceTable"
				class="tablesorter table table-bordered table-striped">

				<thead>
					<tr>
						<th class="header">Invoice number</th>
						<th>Booking ref no.</th>
						<th>Service type</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="serviceSlot" items="${finishedServicings }">
						<form id="service_slot" name="service_slot"
							action="GenerateInvoice" method="post">
							<tr>
								<td><label id="refNo" name="refNo"><c:out
											value="${serviceSlot.getBooking_ref_no()}" /></label><input
									type="hidden" id="refNo1" name="refNo1"
									value="${serviceSlot.getBooking_ref_no()}" /></td>
								<td><label id="timeSlot" name="timeSlot"><c:out
											value="${serviceSlot.getTime_slot()}" /></label><input type="hidden"
									id="timeSlot1" name="timeSlot1"
									value="${serviceSlot.getTime_slot()}" /></td>
								<td><label id="timeSlot" name="timeSlot"><c:out
											value="${serviceSlot.getStatus()}" /></label><input type="hidden"
									id="timeSlot1" name="timeSlot1"
									value="${serviceSlot.getStatus()}" /></td>
								<td><input type="submit" value="GetInvoice"
									id="submit_button" /></td>
							</tr>
						</form>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${fn:length(finishedServicings) lt 1}">
	          	 <div class="panel-heading">
                <h4 class="panel-title">
                    <a>All Invoices generated. Keep up the good work!!</a>
                </h4>
            </div>
	          </c:if>
	          <c:if test="${invoiceGenerated!=null }">
			<label>${invoiceGenerated}</label>
		</c:if>
		</div>
		
		
	</section>
	<!-- Latest compiled and minified JavaScript -->
	<script src="http://code.jquery-2.2.2.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
</body>
</html>