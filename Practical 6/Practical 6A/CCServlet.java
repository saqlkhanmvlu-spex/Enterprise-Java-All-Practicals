import java.io.IOException; 
import java.io.PrintWriter; 
import javax.ejb.EJB; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import EJPracts.CCBean; 
@WebServlet(urlPatterns = {"/CCServlet"}) 
public class CCServlet extends HttpServlet { 
 @EJB 
 CCBean obj; 
 public void doGet(HttpServletRequest request, 
 HttpServletResponse response) 
 throws ServletException, IOException { 
 PrintWriter out = response.getWriter(); 
 double amt = Double.parseDouble( 
 request.getParameter("amt") 
 ); 
 if (request.getParameter("type").equals("r2d")) { 
 out.println( 
 "<h1>" + amt + " Rupees = "
 + obj.r2Dollar(amt) 
 + " Dollars</h1>" 
 ); 
 } 
 if (request.getParameter("type").equals("d2r")) { 
 out.println( 
 "<h1>" + amt + " Dollars = " 
 + obj.d2Rupees(amt) 
 + " Rupees</h1>" 
 ); 
 } 
 } 
} 
