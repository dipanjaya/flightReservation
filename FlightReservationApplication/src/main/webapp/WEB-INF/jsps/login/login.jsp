<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1 align="left" >Login Page</h1>
	<form action="login" method="post">
		<pre>
			User Name :: <input type="text" name="email" placeholder="EmailId or UserName/Number" > 
			Password  :: <input type="password" name="password" placeholder="Password" >
			<input type="submit" value="Login" >
			${msg}
		</pre>
	</form>

</body>
</html>