package vn.edu.eaut.lab6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import vn.edu.eaut.lab6.model.Student;
import vn.edu.eaut.lab6.store.StudentStore;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        StudentStore store = (StudentStore) getServletContext().getAttribute("studentStore");
        int total = store.getStudents().size();

        Map<String, Integer> byClass = new LinkedHashMap<>();
        for (Student s : store.getStudents()) {
            byClass.put(s.getClassName(),
                    byClass.getOrDefault(s.getClassName(), 0) + 1);
        }

        request.setAttribute("totalStudents", total);
        request.setAttribute("studentsByClass", byClass);
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
}
