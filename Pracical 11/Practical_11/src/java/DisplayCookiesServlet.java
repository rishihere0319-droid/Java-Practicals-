import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayCookiesServlet")
public class DisplayCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html><head><title>Stored Cookies</title></head><body>");
        out.println("<h2>All Client Cookies</h2>");

        if (cookies != null && cookies.length > 0) {
            out.println("<table border='1' cellpadding='8' cellspacing='0'>");
            out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");

            for (Cookie cookie : cookies) {
                out.println("<tr>");
                out.println("<td>" + cookie.getName() + "</td>");
                out.println("<td>" + cookie.getValue() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } else {
            out.println("<p>No cookies found on the client for this site.</p>");
        }

        out.println("</body></html>");
    }
}