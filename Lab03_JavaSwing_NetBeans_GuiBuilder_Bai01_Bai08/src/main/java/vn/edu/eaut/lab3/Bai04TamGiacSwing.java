package vn.edu.eaut.lab3;
import javax.swing.*;import java.util.Arrays;
public class Bai04TamGiacSwing extends JFrame {
    public Bai04TamGiacSwing(){initComponents();setLocationRelativeTo(null);}
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);setTitle("Bài 4 - Kiểm tra tam giác");setLayout(null);
        JLabel l1=new JLabel("Cạnh a:"),l2=new JLabel("Cạnh b:"),l3=new JLabel("Cạnh c:");
        l1.setBounds(40,35,80,25);l2.setBounds(40,75,80,25);l3.setBounds(40,115,80,25);
        txtA=new JTextField();txtB=new JTextField();txtC=new JTextField();
        txtA.setBounds(130,35,220,25);txtB.setBounds(130,75,220,25);txtC.setBounds(130,115,220,25);
        btnCheck=new JButton("Kiểm tra");btnCheck.setBounds(130,155,120,30);lblResult=new JLabel("Kết quả:");
        lblResult.setBounds(40,200,330,30);add(l1);add(l2);add(l3);add(txtA);add(txtB);add(txtC);add(btnCheck);add(lblResult);setSize(420,280);
        btnCheck.addActionListener(e->kiemTra());
    }
    private void kiemTra(){try{double a=Double.parseDouble(txtA.getText().trim()),b=Double.parseDouble(txtB.getText().trim()),c=Double.parseDouble(txtC.getText().trim());lblResult.setText("Kết quả: "+loai(a,b,c));}catch(Exception e){JOptionPane.showMessageDialog(this,"Ba cạnh phải là số!");}}
    private String loai(double a,double b,double c){if(a<=0||b<=0||c<=0||a+b<=c||a+c<=b||b+c<=a)return"Không phải tam giác";double[]d={a,b,c};Arrays.sort(d);boolean deu=a==b&&b==c,can=a==b||a==c||b==c,vuong=Math.abs(d[0]*d[0]+d[1]*d[1]-d[2]*d[2])<1e-9;if(deu)return"Tam giác đều";if(vuong&&can)return"Tam giác vuông cân";if(vuong)return"Tam giác vuông";if(can)return"Tam giác cân";return"Tam giác thường";}
    private JTextField txtA,txtB,txtC;private JButton btnCheck;private JLabel lblResult;
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai04TamGiacSwing().setVisible(true));}
}
