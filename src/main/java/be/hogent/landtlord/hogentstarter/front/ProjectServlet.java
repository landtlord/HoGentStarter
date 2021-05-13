package be.hogent.landtlord.hogentstarter.front;

import be.hogent.landtlord.hogentstarter.domain.service.ProjectService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class ProjectServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy() {
    }
}
