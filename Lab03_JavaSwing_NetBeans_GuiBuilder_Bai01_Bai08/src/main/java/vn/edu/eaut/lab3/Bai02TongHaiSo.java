package vn.edu.eaut.lab3;
import javax.swing.*;
public class Bai02TongHaiSo extends JFrame {
    public Bai02TongHaiSo(){initComponents();setLocationRelativeTo(null);}
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);setTitle("Bài 2 - Tính tổng hai số");setLayout(null);
        JLabel l1=new JLabel("Số thứ nhất:"); JLabel l2=new JLabel("Số thứ hai:");
        l1.setBounds(40,40,100,25);l2.setBounds(40,80,100,25);
        txtA=new JTextField();txtB=new JTextField();txtA.setBounds(150,40,210,25);txtB.setBounds(150,80,210,25);
        btnSum=new JButton("Tính tổng");btnClear=new JButton("Làm mới");btnSum.setBounds(80,125,120,30);btnClear.setBounds(220,125,120,30);
        lblResult=new JLabel("Kết quả:");lblResult.setBounds(40,170,320,25);
        add(l1);add(l2);add(txtA);add(txtB);add(btnSum);add(btnClear);add(lblResult);setSize(420,240);
        btnSum.addActionListener(e->tinhTong());btnClear.addActionListener(e->{txtA.setText("");txtB.setText("");lblResult.setText("Kết quả:");txtA.requestFocus();});
    }
    private void tinhTong(){try{double a=Double.parseDouble(txtA.getText().trim()),b=Double.parseDouble(txtB.getText().trim());lblResult.setText("Kết quả: "+(a+b));}catch(Exception e){JOptionPane.showMessageDialog(this,"Dữ liệu phải là số hợp lệ!");}}
    private JTextField txtA,txtB;private JButton btnSum,btnClear;private JLabel lblResult;
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai02TongHaiSo().setVisible(true));}
}
