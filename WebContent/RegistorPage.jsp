<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/mystyle.css" type="text/css"/">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<!-- adding navbar  -->
<%@include file="normal_navbar.jsp" %>

<main class="d-flex align-items-center" style="height : 130vh">
	<div class="container">
		<div class="col-md-6 offset-md-3">
			<div class="card-header primary-background text-light"> 
					<p>Registor your self here</p>
			</div>
		
			<div class="card-body"> 
					
					<form action="RegistorServlet "  method="post">
						  <div class="form-group">
						    <label for="user_name">User Name</label>
						    <input name="user_name" type="text" class="form-control" id="user_name"  placeholder="Enter your name" required>
						  </div>
						  
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email address</label>
						    <input name="user_email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
						    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						  </div>
						  
						  <div class="form-group">
						    <label for="exampleInputPassword1">Password</label>
						    <input name="user_password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
						  </div>
						  
						  <div class="form-group">
						    <label for="gender">Select Gender</label>
						    <br>
						    <input type="radio"  id="gender" name="gender" value="Male" required > Male
						    <input type="radio"  id="gender" name="gender" value="Female" required> Female
						  </div>
						  
						  <div class="form-check">
						  	<textarea name="about" class="form-control" rows="5" cols="3" placeholder="Something about your self"></textarea>
						  </div>
						  
						  <br>
						  
						  <div class="form-check">
						    <input name="checkbox" type="checkbox" class="form-check-input" id="exampleCheck1" required>
						    <label class="form-check-label" for="exampleCheck1">Terms and condition</label>
						  </div>
						  <button type="submit" class="btn btn-primary ">Submit</button>
					</form>
					
				</div>
		
		</div> 
	</div>
</main>




<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="js/myjs.js" type="text/javascript"></script>
</body>
</html>