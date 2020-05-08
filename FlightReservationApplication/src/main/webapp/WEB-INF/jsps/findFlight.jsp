<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
</head>
<body>
<h1>Find Flights</h1>

	<form action="findFlights" method="post">
	From :: <input type="text" name="from"/>
	To :: <input type="text" name="to"/>
	Departure Date:: <input type="text" name="departureDate" placeholder="yyyy-MM-dd"/>
	<input type="submit" value="Find">	 
	</form>	

</body>
</html>