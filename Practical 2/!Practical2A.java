// Welcome Serlvet
import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {
@Override
public void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException , IOException{
response.setContentType("text/html");
PrintWriter out= response.getWriter();
String n=request.getParameter("txtId");
out.print("T013 Presents Welcome : "+n);
}
}
