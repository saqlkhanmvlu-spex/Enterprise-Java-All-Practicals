// Page 1 Servlet
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(urlPatterns = {"/SPage1"})
public class SPage1 extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException{
PrintWriter out = response.getWriter();
out.println("<html><head><title>Servlet Page1</title></head>");
HttpSession hs = request.getSession(true);
if(hs.isNew()){
out.println("<body bgcolor = #96D9FF>");
String name = request.getParameter("txtName");
hs.setAttribute("uname", name);
hs.setAttribute("visit", "1");
out.println("<h1>Welcome First Time</h1>");
}
else{
out.println("<h1> Welcome Again </h1>");
int visit = Integer.parseInt((String)hs.getAttribute("visit"))+1;
out.println("<h1>You Visited"+visit+"Times</h1>");
hs.setAttribute("visit"," " + visit);
}
out.println("<h1>Your Session ID"+hs.getId()+"<>/h1");
out.println("<h1>You Logged in at "+new java.util.Date(hs.getCreationTime())+"</h1>");
out.println("<h1><a href = SPage2>Click for Page 2 </a></h1>");
out.println("<h1><a href = LogoutServlet>Click to Terminate Session</a></h1>");
out.println("</body>");
out.println("</html>");
}}
