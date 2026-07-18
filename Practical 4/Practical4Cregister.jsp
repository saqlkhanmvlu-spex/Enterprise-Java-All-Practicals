<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>

<%
try {

    out.println("db.jsp included<br>");

    if(con == null){
        out.println("Connection is NULL");
        return;
    }

    out.println("Connection OK<br>");

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    out.println("Username : " + username + "<br>");
    out.println("Password : " + password + "<br>");

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO users(username,password) VALUES(?,?)");

    ps.setString(1, username);
    ps.setString(2, password);

    int i = ps.executeUpdate();

    if(i > 0){
        out.println("<h2>Registration Successful</h2>");
    }else{
        out.println("<h2>Registration Failed</h2>");
    }

    ps.close();
    con.close();

}
catch(Exception e){
    e.printStackTrace(new java.io.PrintWriter(out));
}
%>
