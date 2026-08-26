package vn.edu.eaut.lab3;
import javax.swing.*;
public class Bai01HelloSwing extends JFrame {
    public Bai01HelloSwing(){ initComponents(); setLocationRelativeTo(null); }
    private void initComponents(){
        lblTitle=new JLabel("BÀI 1 - CHÀO NGƯỜI DÙNG");
        lblName=new JLabel("Nhập tên:");
        txtName=new JTextField();
        btnHello=new JButton("Hiển thị lời chào");
        setDefaultCloseOperation(EXIT_ON_CLOSE); setTitle("Bài 1 - Chào người dùng");
        setLayout(null);
        lblTitle.setBounds(120,25,220,30); lblName.setBounds(40,80,80,25);
        txtName.setBounds(130,80,220,25); btnHello.setBounds(130,125,170,30);
        add(lblTitle); add(lblName); add(txtName); add(btnHello); setSize(420,210);
        btnHello.addActionListener(e -> {
            String name=txtName.getText().trim();
            if(name.isEmpty()) JOptionPane.showMessageDialog(this,"Vui lòng nhập tên!");
            else JOptionPane.showMessageDialog(this,"Xin chào, "+name+"!");
        });
    }
    private JLabel lblTitle,lblName; private JTextField txtName; private JButton btnHello;
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai01HelloSwing().setVisible(true));}
}
