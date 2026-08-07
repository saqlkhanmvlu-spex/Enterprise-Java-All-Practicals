package EJPracts; 
import java.util.ArrayList; 
import javax.ejb.Stateless; 
@Stateless 
public class ReservationBean { 
 public String welcome(String customer) { 
 return "Hello " + customer.toUpperCase() + " Welcome to Our Hotel";  } 
 public String roomType(String roomtype) { 
 return "You have Selected " + roomtype.toUpperCase() + " Room";  } 
 public String payment(String roomtype) { 
 if (roomtype.equalsIgnoreCase("SUITE")) { 
 return "You have to pay 8000 Rs"; 
 } 
 else if (roomtype.equalsIgnoreCase("DELUXE")) { 
 return "You have to pay 4000 Rs"; 
 } 
 else { 
 return "You have to pay 2000 Rs"; 
 } 
 } 
 public ArrayList<String> reserve( 
 String customer, 
 String add, 
 String ph, 
 String checkin, 
 String checkout, 
 String roomtype, 
 String paymode) { 
 ArrayList<String> a = new ArrayList<String>(); 
 a.add(customer); 
 a.add(add); 
 a.add(ph); 
 a.add(checkin); 
 a.add(checkout); 
 a.add(roomtype); 
 a.add(paymode); 
 return a; 
 } 
}
