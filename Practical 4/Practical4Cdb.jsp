<%@ page import="java.sql.*" %>

<%
Connection con = null;

try
{
    Class.forName("com.mysql.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/userdb",
        "root",
        "root");   // Change password if yours is different

    out.println("Database Connected<br>");

}
catch(Exception e)
{
    out.println("<h3>Database Error</h3>");
    e.printStackTrace(new java.io.PrintWriter(out));
}
%>
