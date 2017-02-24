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
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Agency - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/agency.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        
    <![endif]-->
<style>
    body  {
      background-image: url("https://awesomewallpapers.files.wordpress.com/2010/05/white.jpg");
      background-color: #cccccc;
      background-repeat: no-repeat;
      background-size: cover;
    }
    .ta-bar {
      margin: 0 auto;
      background-color: rgba(255,255,255,0.5);
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
	<br><br>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Registration</h2>
                    <h3 class="section-subheading text-muted">Employee Registration</h3>
                </div>
            </div>
         <div class="container">
  <% if (request.getAttribute("msg")==null) {}else{%>
    <label class="has-error control-label col-sm-3" for="usr7"></label>
    <div class="col-sm-6">
      <label id="usr7" style="color=red"><%=request.getAttribute("msg") %></label>
    </div>
  <%} %>
  </div>   
            
            <form id="dateRangeForm" method="post" action="AddEmployeeServlet" class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Employee ID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr1" name="empid" placeholder="Enter Employee ID" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr2" name="empName" placeholder="Enter Employee Name" required>
    </div>
    </div>
    <div class="form-group">
    
               
              <label class="control-label col-sm-3" for="usr">Select the Service type:</label>
               <div class="col-sm-6">
               
               <%
    			try{
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/dbproject","root","");

       Statement statement = connection.createStatement() ;
       resultset1 =statement.executeQuery("select distinct(service_name) from servicing_type") ;
       //Set the hidden del id from previous page here 
       %>
		<select class="form-control" name = "empservicename">
        <%  while(resultset1.next()){ %>
            <option class="form-control"><%= resultset1.getString(1)%></option>
        <% } %>
        </select>
        </div>
        </div>
        <%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>               </tr><td></td><td></td>
               <tr>
                 
               <td></td><td></td>
                              
               
               
           </tr>
           </table>
    
  </div>
    
  
  
    <div class="form-group">
        <div class="col-xs-6 col-xs-offset-3">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>
</form>
                    </div> 
                    </body>
</html>