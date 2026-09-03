package vn.edu.eaut.lab6.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import vn.edu.eaut.lab6.model.Student;
import vn.edu.eaut.lab6.store.StudentStore;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        StudentStore store = new StudentStore();

        store.add(new Student("SV001", "Nguyễn Văn An", "K48-CNTT1", 8.2));
        store.add(new Student("SV002", "Trần Thị Bình", "K48-CNTT1", 7.5));
        store.add(new Student("SV003", "Lê Văn Cường", "K48-CNTT2", 9.0));
        store.add(new Student("SV004", "Phạm Thị Dung", "K48-CNTT2", 6.8));
        store.add(new Student("SV005", "Hoàng Văn Em", "K49-CNTT1", 8.7));

        ServletContext context = event.getServletContext();
        context.setAttribute("studentStore", store);

        System.out.println("=== AppContextListener ===");
        System.out.println("Đã khởi tạo " + store.getStudents().size() + " sinh viên vào ServletContext.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        StudentStore store = (StudentStore) event.getServletContext().getAttribute("studentStore");
        int count = store == null ? 0 : store.getStudents().size();
        System.out.println("Ứng dụng dừng. Số sinh viên hiện có: " + count);
    }
}
