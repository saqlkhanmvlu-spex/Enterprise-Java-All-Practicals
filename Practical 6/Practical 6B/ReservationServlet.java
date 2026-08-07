package servlet; 
import EJPracts.ReservationBean; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.ArrayList; 
import javax.ejb.EJB; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
@WebServlet(name = "ReservationServlet", 
 urlPatterns = {"/ReservationServlet"}) 
public class ReservationServlet extends HttpServlet { 
 @EJB 
 ReservationBean rb; 
 protected void processRequest(HttpServletRequest request, 
 HttpServletResponse response) 
 throws ServletException, IOException { 
 response.setContentType("text/html;charset=UTF-8"); 
 String cname = request.getParameter("cname"); 
 String add = request.getParameter("cadd"); 
 String ph = request.getParameter("cph"); 
 String roomtype = request.getParameter("roomtype"); 
 String chkin = request.getParameter("checkindate"); 
 String chkout = request.getParameter("checkoutdate"); 
 String paymode = request.getParameter("paymode"); 
 PrintWriter out = response.getWriter(); 
 ArrayList<String> list1 = 
 rb.reserve(cname, add, ph, chkin, chkout, 
 roomtype, paymode); 
 try { 
 out.println("<html>"); 
 out.println("<head>"); 
 out.println("<title>Reservation EJB</title>"); 
 out.println("</head>"); 
 out.println("<body>"); 
 out.println("<h2>" + rb.welcome(cname) + "</h2>"); 
 out.println("<br/>");
 out.println(rb.roomType(roomtype));  out.println("<br/><br/>"); 
 out.println(rb.payment(roomtype));  out.println("<br/><br/>"); 
 out.println("<hr>"); 
 out.println("Your Details :"); 
 out.println("<br/><br/>"); 
 out.println("<table border='1'>"); 
 out.println("<tr>"); 
 out.println("<th>Name</th>"); 
 out.println("<th>Address</th>");  out.println("<th>Phone</th>"); 
 out.println("<th>Check In Date</th>");  out.println("<th>Check Out Date</th>");  out.println("<th>Room</th>"); 
 out.println("<th>Payment Mode</th>");  out.println("</tr>"); 
 out.println("<tr>"); 
 for (int i = 0; i < list1.size(); i++) { 
 out.println("<td>"); 
 out.println(list1.get(i)); 
 out.println("</td>"); 
 } 
 out.println("</tr>"); 
 out.println("</table>"); 
 out.println("<br/>"); 
 out.println("Click "); 
 out.println("<a href='index.jsp'>here</a>");  out.println(" to go back"); 
 out.println("</body>"); 
 out.println("</html>"); 
 } 
 finally { 
 out.close(); 
 } 
 } 
 @Override 
 protected void doGet(HttpServletRequest request,  HttpServletResponse response)
 throws ServletException, IOException { 
 processRequest(request, response);  } 
 @Override 
 protected void doPost(HttpServletRequest request,  HttpServletResponse response) 
 throws ServletException, IOException { 
 processRequest(request, response);  } 
}
