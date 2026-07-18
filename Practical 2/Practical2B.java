// Page 1 Servlet 
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(urlPatterns = {"/Page1"})
public class Page1 extends HttpServlet {
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
PrintWriter out=response.getWriter();
out.println("<html><head><title>Page1</title></head>");
out.println("<body bgcolor=pink>");
String uname=request.getParameter("txtName");
out.println("<h1>~Welcome"+uname+"</h1>");
Cookie ck1=new Cookie("Username",uname);
Cookie ck2=new Cookie("visit","1");
response.addCookie(ck1);
response.addCookie(ck2);
out.println("<h1><a href=Page2>Click to visit Page 2</a></h1>");
out.println("</body>");
out.println("</html>");
}
}
