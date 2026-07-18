package mypack;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class QuizServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body bgcolor='lightblue'>");
        out.println("<center>");
        out.println("<h1>Java Quiz</h1>");
        out.println("</center>");

        out.println("<form action='ShowResult' method='get'>");

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qadb",
                    "root",
                    "root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM quiz");

            int i = 1;

            while (rs.next()) {

                out.println("<hr>");
                out.println("<h3>Q" + i + ". " + rs.getString("question") + "</h3>");

                out.println("<input type='radio' name='" + i + "' value='" + rs.getString("op1") + "'>" + rs.getString("op1") + "<br>");

                out.println("<input type='radio' name='" + i + "' value='" + rs.getString("op2") + "'>" + rs.getString("op2") + "<br>");

                out.println("<input type='radio' name='" + i + "' value='" + rs.getString("op3") + "'>" + rs.getString("op3") + "<br>");

                out.println("<input type='radio' name='" + i + "' value='" + rs.getString("op4") + "'>" + rs.getString("op4") + "<br>");

                i++;
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        out.println("<br><br>");
        out.println("<input type='submit' value='Submit Quiz'>");
        out.println("<input type='reset' value='Reset'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}

