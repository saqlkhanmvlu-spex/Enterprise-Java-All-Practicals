<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>

<%
String username=request.getParameter("username");
String password=request.getParameter("password");

if(con==null)
{
    out.println("Database Connection Failed");
    return;
}

try
{
    PreparedStatement ps=con.prepareStatement(
    "SELECT * FROM users WHERE username=? AND password=?");

    ps.setString(1,username);
    ps.setString(2,password);

    ResultSet rs=ps.executeQuery();

    if(rs.next())
    {
        out.println("<h2>Login Successful</h2>");
        out.println("Welcome : "+username);
    }
    else
    {
        out.println("<h2>Invalid Username or Password</h2>");
    }

    rs.close();
    ps.close();
    con.close();
}
catch(Exception e)
{
    out.println(e);
}
%>
