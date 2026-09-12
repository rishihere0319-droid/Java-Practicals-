import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        String userName = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    userName = cookie.getValue();
                    break;
                }
            }
        }

        out.println("<html><body>");
        if (userName != null) {
            out.println("<h2>Retrieved Cookie Value</h2>");
            out.println("<p>Welcome back, <b>" + userName + "</b>!</p>");
        } else {
            out.println("<h2>No cookie found with name 'user'.</h2>");
            out.println("<p>Please submit your name from the form first.</p>");
        }
        out.println("<a href='index.html'>Back to Form</a>");
        out.println("</body></html>");
    }
}