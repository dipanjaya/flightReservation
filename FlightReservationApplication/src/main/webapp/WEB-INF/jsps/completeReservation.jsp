<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h1>Complete Reservation</h1>
Airline : ${flight.operatingAirlines}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Departure City : ${flight.departureCity}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Arrival City : ${flight.arrivalCity}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<form action="completeReservation" method="post">
<pre>
<h2>Passenger Details</h2>
First Name :: <input type="text" name="passengerFirstName" >
Last Name  :: <input type="text" name="passengerLastName" >
Email Id   :: <input type="text" name="passengerEmail" >
Phone 	   :: <input type="text" name="passengerPhone" >

<h3>Card Details</h3>
Name on Card :: <input type="text" name="cardName" >
Card No		 :: <input type="text" name="cardNo" >
Expiry Date	 :: <input type="text" name="cardExpiryDate" >
Three Digit Sec Code :: <input type="text" name="securityCode" >

<input type="hidden" value="${flight.id}" name="flightId">
<input type="submit" value="Confirm Book"> 
</pre>
</form>

</body>
</html>