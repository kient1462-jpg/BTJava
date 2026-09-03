package vn.edu.eaut.lab6.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebFilter("/*")
public class AccessLogFilter implements Filter {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();
        String method = req.getMethod();

        String user = "guest";
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            user = session.getAttribute("username").toString();
        }

        String time = LocalDateTime.now().format(FORMATTER);

        System.out.println(
                "[ACCESS] time=" + time
                + " | method=" + method
                + " | user=" + user
                + " | URI=" + uri
        );

        chain.doFilter(request, response);
    }
}
