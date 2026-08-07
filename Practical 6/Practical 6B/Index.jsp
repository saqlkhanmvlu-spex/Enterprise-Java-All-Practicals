<html> 
<head> 
 <title>Room Reservation</title> 
</head> 
<body> 
<p><b>Enter Details For Room Reservation.</b></p> <form method="post" action="ReservationServlet"> 
 Customers Name: 
 <input type="text" name="cname" value="" size="20">  <br><br> 
 Address: 
 <input type="text" name="cadd" value="" size="20">  <br><br> 
 Phone Number: 
 <input type="text" name="cph" value="" size="12">  <br><br> 
 Room Type: 
 <select name="roomtype"> 
 <option value="General">General</option>  <option value="Deluxe">Deluxe</option>  <option value="Suite">Suite</option> 
 </select> 
 <br><br> 
 Check In Date (DD/MM/YYYY): 
 <input type="text" name="checkindate"> 
 <br><br> 
 Check Out Date (DD/MM/YYYY): 
 <input type="text" name="checkoutdate">  <br><br> 
 Payment Mode: 
 <select name="paymode"> 
 <option value="CASH">CASH</option> 
 <option value="CREDIT CARD">CREDIT CARD</option>  </select>
 <br><br> 
 <input type="submit" value="Submit"> 
</form> 
</body> 
</html> 
