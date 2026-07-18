import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/Calculator"})
public class Calculator extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String op = request.getParameter("Operator");
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if (op.equals("Addition")) {
            out.println("Addition is : " + (n1 + n2));
        }
        else if (op.equals("Subtraction")) {
            out.println("Subtraction is : " + (n1 - n2));
        }
        else if (op.equals("Multiplication")) {
            out.println("Multiplication is : " + (n1 * n2));
        }
        else if (op.equals("Division")) {
            out.println("Division is : " + (n1 / n2));
        }
        out.println("<br>Calculator");
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
