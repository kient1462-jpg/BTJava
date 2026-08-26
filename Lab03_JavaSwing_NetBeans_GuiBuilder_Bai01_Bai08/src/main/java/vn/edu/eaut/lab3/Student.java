package vn.edu.eaut.lab3;
public class Student {
    private String maSinhVien,hoTen; private double diemTB;
    public Student(String ma,String ten,double diem){maSinhVien=ma;hoTen=ten;diemTB=diem;}
    public String getMaSinhVien(){return maSinhVien;} public String getHoTen(){return hoTen;} public double getDiemTB(){return diemTB;}
    public String xepLoai(){if(diemTB>=8.5)return"Giỏi";if(diemTB>=7)return"Khá";if(diemTB>=5)return"Trung bình";return"Yếu";}
}
