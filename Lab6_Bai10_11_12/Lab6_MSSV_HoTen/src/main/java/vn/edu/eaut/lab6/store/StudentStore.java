package vn.edu.eaut.lab6.store;

import java.util.ArrayList;
import java.util.List;
import vn.edu.eaut.lab6.model.Student;

public class StudentStore {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public Student findById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) return s;
        }
        return null;
    }
}
