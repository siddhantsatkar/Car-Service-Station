<%@ page import="java.sql.*" %>
<%ResultSet resultset1 =null;%>
<%ResultSet resultset2 =null;%>
<%ResultSet resultset3 =null;%>
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Holiday Planning</title>

   
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
 <style>body {
	background-image:
		url("http://wallpapercraze.com/images/wallpapers/carofscience-913071.jpeg");
	background-color: #cccccc;
	background-repeat: no-repeat;
	background-size: cover;
}</style>
  </head>

<body id="page-top" class="index">
    <br>
    <div class="navbar-wrapper">
      <div class="container">
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
                <a class="navbar-brand page-scroll" href="index.jsp">Charlotte Car Servicing</a>
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
                        <a class="page-scroll" href="index.jsp#portfolio">Reservation</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="index.jsp#bookings">My Bookings</a>
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


      </div>
    </div>
 <section id="Service_slot">
 <div class="container">
<% if (request.getAttribute("msg")==null) {}else{%>
    <label class="has-error control-label col-sm-3" for="usr7"></label>
    <div class="col-sm-6">
      <label id="usr7" style="color=red"><%=request.getAttribute("msg") %></label>
    </div>
  <%} %>
  </div>
<h3>Enter car details</h3>
 <form id="dateRangeForm" role="form" action="CustAddVehicleServlet" method="POST" class="form-horizontal">
 <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Select the Brand name:</label>
    <div class="col-sm-6">
                   
               
               <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dbproject","root","");

       Statement statement = connection.createStatement() ;
       resultset1 =statement.executeQuery("select distinct(Brand_name) from vehicles") ;
       //Set the hidden del id from previous page here 
       %>
		<select class="form-control col-sm-6" name = "brandname">
        <%  while(resultset1.next()){ %>
            <option class="form-control"><%= resultset1.getString(1)%></option>
        <% } %>
        </select>
        </div>
        <%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>               

    </div>
    
 <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Select the Car model:</label>
    <div class="col-sm-6">
      
               
               
               
               
               <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dbproject","root","");

       Statement statement = connection.createStatement() ;
       resultset1 =statement.executeQuery("select distinct(Car_model) from vehicles") ;
       //Set the hidden del id from previous page here 
       %>
		<select class="form-control col-sm-6" name = "carmodel">
        <%  while(resultset1.next()){ %>
            <option ><%= resultset1.getString(1)%></option>
        <% } %>
        </select>
        </div>
        <%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>              
                              
               
           

    </div>
    
    
    <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Car type</label>
    <div class="col-sm-6">
      
               
               
               
               
               <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dbproject","root","");

       Statement statement = connection.createStatement() ;
       resultset1 =statement.executeQuery("select distinct(car_type) from vehicles") ;
       //Set the hidden del id from previous page here 
       %> 
		<select class="form-control col-sm-6" name = "cartype">
        <%  while(resultset1.next()){ %>
            <option  class="form-control" ><%= resultset1.getString(1)%></option>
        <% } %>
        </select>
       
        <%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>              
                              
            

    </div>
    </div>
    
 <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Vin number</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr" name="vinno" placeholder="Enter VIN number" required>
    </div>
    </div>
     <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Car number</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr" name="carno" placeholder="Enter car number" required>
    </div>
    </div>
 <div class="form-group">
        <div class="col-xs-6 col-xs-offset-3">
            <button type="submit" class="btn btn-primary">Add car</button>
        </div>
</div>
 
 </section>

	<!-- Latest compiled and minified JavaScript -->
	<script src="http://code.jquery-2.2.2.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</body>	
</html>