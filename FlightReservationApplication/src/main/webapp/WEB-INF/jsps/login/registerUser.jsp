<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Registration User</title>
</head>
<h1 align="left" >Flight Reservation Application</h1>
<p align="left" style="font-size:18px;" >User Registration</p>
<body>
	<form action="reg" method="post">
		<pre>
			First Name 	:: <input type="text" name="firstName" >
			Last Name 	:: <input type="text" name="lastName" >
			Email ID	:: <input type="text" name="email" >
			Password	:: <input type="password" name="password" >
			<!-- Confirm Password :: <input type="password" name="confirmpassword" > -->
				<input type="submit" value="Register"/>
		</pre>
	</form>
</body>
</html>