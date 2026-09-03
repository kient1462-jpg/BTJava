package vn.edu.eaut.lab6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.edu.eaut.lab6.model.Student;
import vn.edu.eaut.lab6.store.StudentStore;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentStore store;

    @Override
    public void init() {
        store = (StudentStore) getServletContext().getAttribute("studentStore");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        request.setAttribute("students", store.getStudents());
        request.getRequestDispatcher("/student-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String className = request.getParameter("className");
        double score;

        try {
            score = Double.parseDouble(request.getParameter("score"));
        } catch (Exception e) {
            request.setAttribute("error", "Điểm phải là số.");
            request.getRequestDispatcher("/student-form.jsp").forward(request, response);
            return;
        }

        if (id == null || id.isBlank() || name == null || name.isBlank()
                || className == null || className.isBlank()) {
            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher("/student-form.jsp").forward(request, response);
            return;
        }

        if (store.findById(id) != null) {
            request.setAttribute("error", "Mã sinh viên đã tồn tại.");
            request.getRequestDispatcher("/student-form.jsp").forward(request, response);
            return;
        }

        store.add(new Student(id, name, className, score));
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
