package vn.edu.eaut.lab2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       LAB 2 - QUAN LY SINH VIEN");
        System.out.println("======================================");

        // Nhập mã sinh viên
        System.out.print("Nhap ma sinh vien: ");
        String studentId = scanner.nextLine();

        // Nhập họ tên
        System.out.print("Nhap ho ten sinh vien: ");
        String fullName = scanner.nextLine();

        // Nhập điểm
        double attendanceScore =
                inputScore(scanner, "diem chuyen can");

        double midtermScore =
                inputScore(scanner, "diem giua ky");

        double finalScore =
                inputScore(scanner, "diem cuoi ky");

        // Tạo đối tượng Student
        Student student = new Student(
                studentId,
                fullName,
                attendanceScore,
                midtermScore,
                finalScore
        );

        // Tính điểm tổng kết
        double totalScore =
                GradeCalculator.calculateFinalScore(student);

        // Xếp loại
        String grade =
                GradeCalculator.classify(totalScore);

        // Hiển thị kết quả
        System.out.println();
        System.out.println("========== KET QUA ==========");

        System.out.println("Ma sinh vien: "
                + student.getStudentId());

        System.out.println("Ho ten: "
                + student.getFullName());

        System.out.println("Diem chuyen can: "
                + student.getAttendanceScore());

        System.out.println("Diem giua ky: "
                + student.getMidtermScore());

        System.out.println("Diem cuoi ky: "
                + student.getFinalScore());

        System.out.printf("Diem tong ket: %.2f%n",
                totalScore);

        System.out.println("Xep loai: " + grade);

        scanner.close();
    }

    // Hàm nhập và kiểm tra điểm
    private static double inputScore(
            Scanner scanner,
            String label) {

        while (true) {

            try {

                System.out.print("Nhap " + label + ": ");

                double score =
                        Double.parseDouble(scanner.nextLine());

                GradeCalculator.validateScore(
                        score,
                        label
                );

                return score;

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Loi: " + e.getMessage()
                );
            }
        }
    }
}