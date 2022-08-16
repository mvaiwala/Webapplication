<%@page import="com.blog.app.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="css/mystyle.css" type="text/css"/">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
</head>
<body>
<!-- adding navbar  -->
<%@include file="normal_navbar.jsp" %>

	<main class="d-flex align-items-center" style="height : 90vh">
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
				<div class="card-header primary-background text-light"> 
					<p>login here</p>
				</div>
				
				
				<%
				
					Message msg = (Message)session.getAttribute("message");
					
					if(msg!=null)
					{
				%>
				
				<div class="alert <%=msg.getCssClass() %>" role="alert">
  					<%= msg.getContent() %>
				</div>
				<%
						session.removeAttribute("message");
					}
				%>
				
				<div class="card-body"> 
					
					<form action="LoginServlet" method="post">
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email address</label>
						    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required>
						    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">Password</label>
						    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
						  </div>
						 
						  <button type="submit" class="btn btn-primary ">Submit</button>
					</form>
					
				</div>
				
				<div class="card-body"></div>
				
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