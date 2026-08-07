package EJPracts; 
import javax.ejb.Stateless; 
@Stateless 
public class CCBean { 
 public CCBean() { 
 } 
 public double r2Dollar(double r) { 
 return r / 95.22; 
 } 
 public double d2Rupees(double d) { 
 return d * 95.22; 
 } 
} 
