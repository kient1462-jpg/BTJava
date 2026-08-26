package vn.edu.eaut.lab3;
import javax.swing.*;
public class Bai03PhuongTrinhBacNhat extends JFrame {
    public Bai03PhuongTrinhBacNhat(){initComponents();setLocationRelativeTo(null);}
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);setTitle("Bài 3 - Phương trình ax + b = 0");setLayout(null);
        JLabel l1=new JLabel("Hệ số a:");JLabel l2=new JLabel("Hệ số b:");
        l1.setBounds(40,45,90,25);l2.setBounds(40,85,90,25);txtA=new JTextField();txtB=new JTextField();
        txtA.setBounds(140,45,220,25);txtB.setBounds(140,85,220,25);btnSolve=new JButton("Giải");btnSolve.setBounds(140,125,120,30);
        lblResult=new JLabel("Nghiệm:");lblResult.setBounds(40,175,330,30);
        add(l1);add(l2);add(txtA);add(txtB);add(btnSolve);add(lblResult);setSize(420,250);
        btnSolve.addActionListener(e->giai());
    }
    private void giai(){try{double a=Double.parseDouble(txtA.getText().trim()),b=Double.parseDouble(txtB.getText().trim());if(Math.abs(a)<1e-9&&Math.abs(b)<1e-9)lblResult.setText("Nghiệm: vô số nghiệm");else if(Math.abs(a)<1e-9)lblResult.setText("Nghiệm: vô nghiệm");else lblResult.setText(String.format("Nghiệm: x = %.4f",-b/a));}catch(Exception e){JOptionPane.showMessageDialog(this,"Vui lòng nhập số hợp lệ!");}}
    private JTextField txtA,txtB;private JButton btnSolve;private JLabel lblResult;
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai03PhuongTrinhBacNhat().setVisible(true));}
}
