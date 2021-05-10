package be.hogent.landtlord.hogentstarter;

import be.hogent.landtlord.hogentstarter.domain.service.ProjectService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    private ProjectService projectService;

    public HelloServlet() {
        projectService = new ProjectService();
    }

    public void init() {
        message = "Hello World Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
