import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetSessionServlet")
public class SetSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("username");

        if (userName != null && !userName.trim().isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userName);

            out.println("<html><body>");
            out.println("<h2>Session attribute set successfully!</h2>");
            out.println("<p>Username stored in session: <b>" + userName + "</b></p>");
            out.println("<a href='GetSessionServlet'>Go to GetSessionServlet to view stored session data</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Please enter a valid username.</h2>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}