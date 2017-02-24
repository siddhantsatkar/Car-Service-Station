<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Charlotte Car Servicing</title>

   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/agency.css" rel="stylesheet">
 <link rel="stylesheet/less" type="text/css" href="css/timepicker.less" />
  <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
 <link type="text/css" href="css/bootstrap-timepicker.min.css" />
     <link href="assets/pygments.css" type="text/css" rel="stylesheet" />
    <link href="assets/prettify/prettify.css" type="text/css" rel="stylesheet" />
    <!-- Custom CSS -->
    <link href="css/agency.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 
  </head>

	


<body id="page-top" class="index">
	<!-- Include Bootstrap Datepicker -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>

<style type="text/css">
/**
 * Override feedback icon position
 * See http://formvalidation.io/examples/adjusting-feedback-icon-position/
 */
#dateRangeForm .form-control-feedback {
    top: 0;
    right: -15px;
}
</style>
   <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="index.jsp">Car service station</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
		              <a class="page-scroll" href="#">Services</a>
		            </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Reservation</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#bookings">My Bookings</a>
                    </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="LoadProfileServlet">Update profile</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="addcar.jsp">Update cars</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="LogoutServlet">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Welcome To Our Service Station!</div>
                <div class="intro-heading">It's Nice To Meet You</div>
                <a href="#services" class="page-scroll btn btn-xl">Tell Me More</a>
            </div>
        </div>
    </header>

    <!-- Services Section -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Services</h2>
                    <h3 class="section-subheading text-muted">We provide these services</h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-3">
                <img src="http://3.imimg.com/data3/UD/XG/MY-3528538/restoration-of-accidental-cars-500x500.jpg" class="img-rounded" alt="Cinque Terre" width="200" height="136">
                    
                    <h4 class="service-heading">Accidental</h4>
                    <p class="text-muted">We recover the cars from accident</p>
                </div>
                <div class="col-md-3">
                   <img src="http://hubgarage.s3.amazonaws.com/photos/5553937/283003_10151221583769602_1624720215_n_detail.jpg" class="img-rounded" alt="Cinque Terre" width="200" height="136"> 
                    <h4 class="service-heading">Washing</h4>
                    <p class="text-muted">We make your car look brand new.</p>
                </div>
                <div class="col-md-3">
                   <img src="http://hubgarage.s3.amazonaws.com/photos/5553937/283003_10151221583769602_1624720215_n_detail.jpg" class="img-rounded" alt="Cinque Terre" width="200" height="136"> 
                    <h4 class="service-heading">Washing</h4>
                    <p class="text-muted">We make your car look brand new.</p>
                </div>
                <div class="col-md-3">
                    <img src="http://dakstoyota.com/wp-content/uploads/2015/01/Spare-Parts_01.jpg" class="img-rounded" alt="Cinque Terre" width="200" height="136">
                    <h4 class="service-heading">Parts change</h4>
                    <p class="text-muted">We replace the spare parts of the car.</p>
                </div>
            </div>
        </div>
    </section>
  
  <section id="portfolio" class="bg-light-gray">
		
			<div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Reservation</h2>
                    <h3 class="section-subheading text-muted">Book your car servicing slot</h3>
                </div>
            </div>

			


  <form id="getVIN" role="form" action="CarDetails" method="POST" class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-sm-3" for="VIN">VIN number</label>
    <div class="col-sm-6">
      <select id="VIN" class="form-control" name="VIN" onchange="this.form.submit();">
      	<c:choose>
      		<c:when test="${fn:length(vehicles) lt 1}">
      			<option class="form-control" value="No Cars Added" selected>No Cars Added</option>
			</c:when>
      		<c:otherwise>
      			<option class="form-control" value="Please select a car" disabled="disabled" selected="selected">Please select a car</option>
      			<c:forEach var="vehicle" items="${vehicles}">
					<option class="form-control" value="${vehicle.getVin_no()}" ${vehicle.getVin_no()==selectedCar.getVin_no() ? 'selected' : ''}>${vehicle.getVin_no()}</option>      				
				</c:forEach>
			</c:otherwise>
      	</c:choose>
      </select>
    </div>
  </div>
 </form>
 <form id="getServicingType" role="form" action="ServicingDetails" method="POST" class="form-horizontal">
<c:if test="${selectedCar != null}"> 
<div class="form-group">
    <label class="control-label col-sm-3" for="carNumber">Car number</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" required id="carNumber" name="carNumber" placeholder="Enter the number on your car's number plate" value="${selectedCar.getCar_no()}">
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-3" for="carType">Car type</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="carType" name="carType" required placeholder="Enter Car type: SUV, SEDAN, Hatchback" value="${selectedCar.getCar_type()}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="model">Car model</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="model" name="model" required placeholder="Enter Car Model" value="${selectedCar.getCar_model()}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="brand">Brand Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="brand" name="brand" required placeholder="Enter Brand name eg. Honda, Toyota etc" value="${selectedCar.getBrand_name()}">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="email">E-mail</label>
    <div class="col-sm-6">
      <input type="email" rclass="form-control" id="email" name="email" required placeholder="Enter your email" value="${selectedCar.getEmail_id()}">
    </div>
  </div>
 </c:if>
 
 
 <div class="form-group">
		   <label class="control-label col-sm-3" for="SlotDate"> Start Date: </label>
		   <div class="col-sm-6">
		   <input type="text" class="form-control" required placeholder="Enter Start Date" id="SlotDate" name="SlotDate" value="${slotDate}"/>
		</div>
		</div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="servicingType">Servicing Type</label>
    <div class="col-sm-6">
      <select id="servicingType" class="form-control" name="servicingType" onchange="this.form.submit();">
      	<c:choose>
      		<c:when test="${fn:length(ServicingTypes) lt 1}">
      			<option class="form-control" value="No Cars Added" selected>No Servicing Types Available. Select a VIN and Date first</option>
			</c:when>
      		<c:otherwise>
      			<option class="form-control" value="Please select a type" disabled="disabled" selected="selected">Please select a servicing Type</option>
      			<c:forEach var="type" items="${ServicingTypes}">
					<option class="form-control" value="${type.getService_name()}" ${type.getService_name()==selectedType.getService_name() ? 'selected' : ''}>${type.getService_name()}</option>      				
				</c:forEach>
			</c:otherwise>
      	</c:choose>
      </select>
    </div>
  </div>
		 
		 
		 <!-- <div class="form-group bootstrap-timepicker timepicker">
		<label class="control-label col-sm-3" for="timepicker1">Time</label>
		<div class="col-sm-6">
		            <input id="timepicker1" name="timepicker1" type="text" required class="form-control input-small">
		            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
		       </div>
		</div>-->
</form>
<form id="slotBooking" role="form" action="SlotBookingServlet" method="POST" class="form-horizontal">

				<c:if test="${timeSlots != null}">
					<div class="form-group">
						<label class="control-label col-sm-3" for="servicingSlot">Servicing
							Time Slot</label>
						<div class="col-sm-6">
							<select id="servicingSlot" class="form-control"
								name="servicingSlot">
								<c:choose>
									<c:when test="${fn:length(timeSlots) lt 1}">
										<option class="form-control" value="No Slots Available" selected>No
											Slots Available for today. Select a Different Date</option>
									</c:when>
									<c:otherwise>
										<option class="form-control" value="Please select a time slot"
											disabled="disabled" selected="selected">Please
											select a time slot</option>
										<c:forEach var="slot" items="${timeSlots}">
											<option class="form-control"
												value="${slot}">${slot}</option>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</select>
						</div>
					</div>
				</c:if>
				
				
			<div class="form-group">
			
        <div class="col-xs-6 col-xs-offset-3">
            <button type="submit" class="btn btn-default">Book</button>
        </div>
    </div>
    <c:if test="${bookingError != null}">
					<div class="alert alert-info">
				            <label>${bookingError}</label>
				    </div>
				</c:if>
			</form>
    <!-- Plugin JavaScript -->
    
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/agency.js"></script>
    

<script>

$("#SlotDate").datepicker();

</script>
<script>
	$("#SlotDate").change(function() {
		var slotDate = document.getElementById("SlotDate").value;
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth() + 1; //January is 0!
		var yyyy = today.getFullYear();
		if (dd < 10) {
			dd = '0' + dd
		}
		if (mm < 10) {
			mm = '0' + mm
		}
		today = mm + '/' + dd + '/' + yyyy;
		if ((Date.parse(slotDate) < Date.parse(today))) {
			alert("Booking date should be equal to or more than today's date");
			document.getElementById("SlotDate").value = "";
		}
	});
</script>



			</div><!-- end Container-->

		
	</section><!-- Call to action -->
	<section id="bookings" class="bg-light-gray">
		
			<div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">My Bookings</h2>
                    <h3 class="section-subheading text-muted">view details of your bookings</h3>
                </div>
            </div>

			<table id="invoiceTable"
				class="tablesorter table table-bordered table-striped">

				<thead>
					<tr>
						<th class="header">Booking Ref No</th>
						<th>Booking Date</th>
						<th>Booking Slot</th>
						<th>Status</th>
						<th>Invoice No.</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="booking" items="${bookings }">
						<form id="bookingId" name="bookingId"
							action="BookingDetails" method="post">
							<tr>
								<td><label id="refNo" name="refNo"><c:out
											value="${booking.getBooking_ref_no()}" /></label><input
									type="hidden" id="refNo1" name="refNo1"
									value="${booking.getBooking_ref_no()}" /></td>
								<td><label id="bDate" name="bDate"><c:out
											value="${booking.getBooking_date()}" /></label><input
									type="hidden" id="bDate1" name="bDate1"
									value="${booking.getBooking_date()}" /></td>
								<td><label id="timeSlot" name="timeSlot"><c:out
											value="${booking.getTime_slot()}" /></label><input type="hidden"
									id="timeSlot1" name="timeSlot1"
									value="${booking.getTime_slot()}" /></td>
								<td><label id="status" name="status"><c:out
											value="${booking.getStatus()}" /></label><input type="hidden"
									id="status1" name="status1"
									value="${booking.getStatus()}" /></td>
								<td><label id="invoice" name="invoice">
								<c:choose>
									<c:when test="${booking.getInvoiceNo()==0}">
										<c:out value="NA"/>
									</c:when>
									<c:otherwise>
										<c:out
											value="${booking.getInvoiceNo()}" />
									</c:otherwise>
								</c:choose>
								</label><input type="hidden"
									id="invoice1" name="invoice1"
									value="${booking.getInvoiceNo()}" /></td>
								<c:if test="${booking.getStatus()!='New'}">
								<td><input type="submit" value="viewDetails"
									id="submit_button" /></td>
							</tr>
							</c:if>
						</form>
						<c:if test="${booking.getStatus()=='New'}">
							<form id="bookingId" name="bookingId" action="DeleteBooking" method="post">
								<td><input
									type="hidden" id="refNo1" name="refNo1"
									value="${booking.getBooking_ref_no()}" />
								<input type="submit" value="Delete"
									id="submit_button" />
								</td>
							</tr>
							</form>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${fn:length(bookings) lt 1}">
	          	 <div class="panel-heading">
                <h4 class="panel-title">
                    <a>You do not have any Bookings for Now. Its time to get started!!</a>
                </h4>
            </div>
	          </c:if>
	          <c:if test="${errorBookingDetails!=null }">
			<div class="alert alert-info">
				<label>${errorBookingDetails}</label>
			</div>
		</c:if>
		    
		    
		    </div>
    </section>

	
	
	
	
	<footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Copyright &copy; Your Website 2014</span>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li><a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                        <li><a href="#">Privacy Policy</a>
                        </li>
                        <li><a href="#">Terms of Use</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    
   
 <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/agency.js"></script>
<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
  <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/agency.js"></script>
    
    <script>
var monster = {
	set: function(name, value, days, path, secure) {
		var date = new Date(),
			expires = '',
			type = typeof(value),
			valueToUse = '',
			secureFlag = '';
		path = path || "/";
		if (days) {
			date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
			expires = "; expires=" + date.toUTCString();
		}
		if (type === "object" && type !== "undefined") {
			if (!("JSON" in window)) throw "Bummer, your browser doesn't support JSON parsing.";
			valueToUse = encodeURIComponent(JSON.stringify({
				v: value
			}));
		}
		else {
			valueToUse = encodeURIComponent(value);
		}
		if (secure) {
			secureFlag = "; secure";
		}
		document.cookie = name + "=" + valueToUse + expires + "; path=" + path + secureFlag;
	},
	get: function(name) {
		var nameEQ = name + "=",
			ca = document.cookie.split(';'),
			value = '',
			firstChar = '',
			parsed = {};
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) == ' ') c = c.substring(1, c.length);
			if (c.indexOf(nameEQ) === 0) {
				value = decodeURIComponent(c.substring(nameEQ.length, c.length));
				firstChar = value.substring(0, 1);
				if (firstChar == "{") {
					try {
						parsed = JSON.parse(value);
						if ("v" in parsed) return parsed.v;
					}
					catch (e) {
						return value;
					}
				}
				if (value == "undefined") return undefined;
				return value;
			}
		}
		return null;
	}
};
if (!monster.get('cookieConsent')) {
	var cookieConsentAct = function() {
			document.getElementById('cookieConsent').style.display = 'none';
			monster.set('cookieConsent', 1, 360, '/');
		};
	document.getElementById('cookieConsent').style.display = 'block';
	var cookieConsentEl = document.getElementById('cookieConsentAgree');
	if (cookieConsentEl.addEventListener) {
		cookieConsentEl.addEventListener('click', cookieConsentAct, false);
	}
	else if (cookieConsentEl.attachEvent) {
		cookieConsentEl.attachEvent("onclick", cookieConsentAct);
	}
	else {
		cookieConsentEl["onclick"] = cookieConsentAct;
	}
}
</script>
    <script src="js/google-code-prettify/prettify.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
	<script>
	if (top.location != location) {
    top.location.href = document.location.href ;
  }
		$(function(){
			window.prettyPrint && prettyPrint();
			$('#dp1').datepicker({
				format: 'mm-dd-yyyy'
			});
			$('#dp2').datepicker();
			$('#dp3').datepicker();
			$('#dp3').datepicker();
			$('#dpYears').datepicker();
			$('#dpMonths').datepicker();
			
			
			var startDate = new Date(2012,1,20);
			var endDate = new Date(2012,1,25);
			$('#dp4').datepicker()
				.on('changeDate', function(ev){
					if (ev.date.valueOf() > endDate.valueOf()){
						$('#alert').show().find('strong').text('The start date can not be greater then the end date');
					} else {
						$('#alert').hide();
						startDate = new Date(ev.date);
						$('#startDate').text($('#dp4').data('date'));
					}
					$('#dp4').datepicker('hide');
				});
			$('#dp5').datepicker()
				.on('changeDate', function(ev){
					if (ev.date.valueOf() < startDate.valueOf()){
						$('#alert').show().find('strong').text('The end date can not be less then the start date');
					} else {
						$('#alert').hide();
						endDate = new Date(ev.date);
						$('#endDate').text($('#dp5').data('date'));
					}
					$('#dp5').datepicker('hide');
				});

        // disabling dates
        var nowTemp = new Date();
        var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

        var checkin = $('#dpd1').datepicker({
          onRender: function(date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
          }
        }).on('changeDate', function(ev) {
          if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date)
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
          }
          checkin.hide();
          $('#dpd2')[0].focus();
        }).data('datepicker');
        var checkout = $('#dpd2').datepicker({
          onRender: function(date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
          }
        }).on('changeDate', function(ev) {
          checkout.hide();
        }).data('datepicker');
		});
	</script>
	<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
<script type="text/javascript">
_uacct = "UA-106117-1";
urchinTracker();
</script>
        <script type="text/javascript">
            $('#timepicker1').timepicker();
        </script>
            <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assets/prettify/prettify.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/2.5.1/less.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-timepicker.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#timepicker1').timepicker();

            $('#timepicker2').timepicker({
                minuteStep: 1,
                template: 'modal',
                appendWidgetTo: 'body',
                showSeconds: true,
                showMeridian: false,
                defaultTime: false
            });

            $('#timepicker3').timepicker({
                minuteStep: 5,
                showInputs: false,
                disableFocus: true
            });

            $('#timepicker4').timepicker({
                minuteStep: 1,
                secondStep: 5,
                showInputs: false,
                modalBackdrop: true,
                showSeconds: true,
                showMeridian: false
            });

            $('#timepicker5').timepicker({
                template: false,
                showInputs: false,
                minuteStep: 5
            });

            setTimeout(function() {
              $('#timeDisplay').text($('#timepicker1').val());
            }, 100);

            $('#timepicker1').on('changeTime.timepicker', function(e) {
              $('#timeDisplay').text(e.time.value);
            });
        });
    </script>
</body>	
</html>