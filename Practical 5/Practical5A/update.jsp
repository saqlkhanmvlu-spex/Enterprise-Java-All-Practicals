<%@ page import="java.sql.*" %>

<%
String eno = request.getParameter("eno");
String name = request.getParameter("name");
String age = request.getParameter("age");
String designation = request.getParameter("designation");
String salary = request.getParameter("salary");

try
{
    Class.forName("com.mysql.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/company",
        "root",
        "root");

    PreparedStatement ps = con.prepareStatement(
            "UPDATE employee SET name=?, age=?, designation=?, salary=? WHERE eno=?");
    ps.setString(1, name);
    ps.setInt(2, Integer.parseInt(age));
    ps.setString(3, designation);
    ps.setDouble(4, Double.parseDouble(salary));
    ps.setInt(5, Integer.parseInt(eno));

    int i = ps.executeUpdate();

    if(i>0)
        out.println("<h2>Employee Updated Successfully!</h2>");
    else
        out.println("<h2>Employee Number Not Found!</h2>");

    con.close();
}
catch(Exception e)
{
    out.println(e);
}
%>
