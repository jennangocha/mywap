import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(
        urlPatterns = "/support",
        initParams = {
                @WebInitParam(name = "supportEmail", value = "lbui@mum.edu")
        }
)

public class SupportServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
                out.println(
                String.format("Thank you! %s for contacting us. We should receive reply from us with in 24 hrs in " +
                                "your email address %s. Let us know in our support email %s if " +
                                "you don't receive reply within 24 hrs. Please be sure to attach your reference " +
                                "%s in your email.",
                        req.getParameter("name"),
                        req.getParameter("email"),
                        getServletConfig().getInitParameter("supportEmail"),
                        UUID.randomUUID().toString()
                ));
        out.print("</body></html>");

    }


}
