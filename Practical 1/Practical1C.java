import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(urlPatterns = {"/ServReg"})
public class ServReg extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
String connectionURL = "jdbc:mysql://localhost:3306/reg";
Connection connection = null;
ResultSet rs;
response.setContentType("text/html;charset=UTF-8");
String uid = request.getParameter("uid");
String fname = request.getParameter("fname");
String sname = request.getParameter("sname");
String pwd = request.getParameter("pwd");
String pwd1 = request.getParameter("pwd1");
String town = request.getParameter("town");
String country = request.getParameter("country");
String zip = request.getParameter("zip");
try{
Class.forName("org.gjt.mm.mysql.Driver");
connection = DriverManager.getConnection(connectionURL,"root","root"); String
sql = "insert into Register values(?,?,?,?,?,?,?,?)"; PreparedStatement pst =
connection.prepareStatement(sql); pst.setString(1,uid);
pst.setString(2,fname);
pst.setString(3,sname);
pst.setString(4,pwd);
pst.setString(5,pwd1);
pst.setString(6,town);
pst.setString(7,country);
pst.setString(8,zip);
int numRowsChanged = pst.executeUpdate();
out.println("Welcome : ");
out.println("'"+fname+"'");
pst.close();
}
catch(ClassNotFoundException e){
out.println("Couldnt Load database driver : "+e.getMessage()); }
catch(SQLException e){
out.println("SQL Exception caught : "+e.getMessage()); }
catch(Exception e){
out.println(e);

}
finally{
try{
if(connection != null)
connection.close();
}
catch(SQLException ignored){
out.println(ignored);
}
}
}
}
}
