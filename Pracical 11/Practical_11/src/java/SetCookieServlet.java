import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("username");

        if (userName != null && !userName.trim().isEmpty()) {
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(24 * 60 * 60); 
            response.addCookie(userCookie);

            out.println("<html><body>");
            out.println("<h2>Cookie has been set successfully!</h2>");
            out.println("<p>Username stored: <b>" + userName + "</b></p>");
            out.println("<a href='GetCookieServlet'>Go to GetCookieServlet to view stored cookie</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Please enter a valid username via HTML Form.</h2>");
            out.println("<a href='index.html'>Go to Form</a>");
            out.println("</body></html>");
        }
    }
}