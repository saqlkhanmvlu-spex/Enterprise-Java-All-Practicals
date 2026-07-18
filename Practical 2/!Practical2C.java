// Page 2 Servlet
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(urlPatterns = {"/SPage2"})
public class SPage2 extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException{
PrintWriter out = response.getWriter();
out.println("<html><head><title>Servlet Page2</title></head>");
HttpSession hs = request.getSession(false);
out.println("<body bgcolor = #FECF6E>");
out.println("<h1> Welcome Again </h1>");
int visit = Integer.parseInt((String)hs.getAttribute("visit"))+1;
out.println("<h1>You Visited"+visit+"Times</h1>");
hs.setAttribute("visit"," " + visit);
out.println("<h1>Your Session ID"+hs.getId()+"<>/h1");
out.println("<h1>You Logged in at "+new java.util.Date(hs.getCreationTime())+"</h1>");
out.println("<h1><a href = SPage1>Click for Page 1 </a></h1>");
out.println("<h1><a href = LogoutServlet>Click to Terminate Session</a></h1>");
out.println("</body>");
out.println("</html>");
}
}
