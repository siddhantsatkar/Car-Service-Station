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
    <script>
function validateForm() {
    var x = document.forms["myForm"]["Email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
    	alert("Not a valid e-mail address");
        //document.forms["myForm"]["message"].setText("Not a valid e-mail address");
        return false;
    }
}
</script>

</head>

<body>

        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Registration</h2>
                    <h3 class="section-subheading text-muted">Customer Registration</h3>
                </div>
            </div>
            <form id="dateRangeForm" name="myForm" method="post" action="RegistrationServlet" class="form-horizontal" onsubmit="return validateForm();">
  <div class="form-group">
    <label class="control-label col-sm-3" for="usr">First Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr1" name="First Name" placeholder="Enter First name" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Last Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr2" name="Last Name" placeholder="Enter Last Name" required>
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Address</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr3" name="Address" placeholder="Enter Address" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Email id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr4" name="Email" placeholder="Enter Email-id" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Password</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" id="usr5" name="Password" placeholder="Enter Password" required>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="usr">Contact</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="usr6" name="Contact" placeholder="Enter contact" required>
    </div>
  </div>
  
    <div class="form-group">
        <div class="col-xs-6 col-xs-offset-3">
            <button type="submit" class="btn btn-primary" href="http://localhost:8080/CharlotteCarServicingCenter/Login.jsp">Submit</button>
        </div>
    </div>
</form>
                    </div> 
                    </body>
</html>