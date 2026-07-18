// Logout Servlet
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException{
PrintWriter out = response.getWriter();
out.println("<html><head><title>Servlet LogoutServlet</title></head>");
out.println("<body bgcolor = #F6B0FF >");
javax.servlet.http.HttpSession hs = request.getSession();
if(hs != null){ hs.invalidate(); }
out.println("<h1>You are Logged out now........</h1>");
out.println("</body>");
out.println("</html>");
}
}
