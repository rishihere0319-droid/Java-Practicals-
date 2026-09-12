import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String userName = null;

        if (session != null) {
            userName = (String) session.getAttribute("user");
        }

        out.println("<html><body>");
        if (userName != null) {
            out.println("<h2>Retrieved Session Value</h2>");
            out.println("<p>Welcome back, <b>" + userName + "</b>!</p>");
        } else {
            out.println("<h2>No session variable found with name 'user'.</h2>");
            out.println("<p>Please submit your name from the form first.</p>");
        }
        out.println("<a href='index.html'>Back to Form</a>");
        out.println("</body></html>");
    }
}