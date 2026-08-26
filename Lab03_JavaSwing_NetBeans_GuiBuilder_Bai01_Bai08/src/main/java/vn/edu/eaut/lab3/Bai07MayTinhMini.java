package vn.edu.eaut.lab3;
import javax.swing.*;
public class Bai07MayTinhMini extends JFrame {
    public Bai07MayTinhMini(){initComponents();setLocationRelativeTo(null);}
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);setTitle("Bài 7 - Máy tính mini");setLayout(null);
        JLabel a=new JLabel("Số 1:"),b=new JLabel("Số 2:"),h=new JLabel("Lịch sử:");
        a.setBounds(30,30,60,25);b.setBounds(30,65,60,25);txtA=new JTextField();txtB=new JTextField();txtA.setBounds(85,30,120,25);txtB.setBounds(85,65,120,25);
        btnAdd=new JButton("+");btnSub=new JButton("-");btnMul=new JButton("*");btnDiv=new JButton("/");btnClear=new JButton("Clear");
        btnAdd.setBounds(220,30,55,25);btnSub.setBounds(280,30,55,25);btnMul.setBounds(220,65,55,25);btnDiv.setBounds(280,65,55,25);btnClear.setBounds(340,30,65,60);
        lblResult=new JLabel("Kết quả:");lblResult.setBounds(30,105,370,30);txtHistory=new JTextArea();txtHistory.setEditable(false);JScrollPane sp=new JScrollPane(txtHistory);sp.setBounds(30,145,375,150);
        h.setBounds(30,125,70,20);add(a);add(b);add(txtA);add(txtB);add(btnAdd);add(btnSub);add(btnMul);add(btnDiv);add(btnClear);add(lblResult);add(h);add(sp);setSize(450,350);
        btnAdd.addActionListener(e->calc("+"));btnSub.addActionListener(e->calc("-"));btnMul.addActionListener(e->calc("*"));btnDiv.addActionListener(e->calc("/"));btnClear.addActionListener(e->{txtA.setText("");txtB.setText("");lblResult.setText("Kết quả:");txtHistory.setText("");});
    }
    private void calc(String op){try{double a=Double.parseDouble(txtA.getText().trim()),b=Double.parseDouble(txtB.getText().trim()),r=0;if(op.equals("+"))r=a+b;if(op.equals("-"))r=a-b;if(op.equals("*"))r=a*b;if(op.equals("/")){if(b==0){JOptionPane.showMessageDialog(this,"Không thể chia cho 0!");return;}r=a/b;}lblResult.setText("Kết quả: "+r);txtHistory.append(a+" "+op+" "+b+" = "+r+"\n");}catch(Exception e){JOptionPane.showMessageDialog(this,"Vui lòng nhập số hợp lệ!");}}
    private JTextField txtA,txtB;private JButton btnAdd,btnSub,btnMul,btnDiv,btnClear;private JLabel lblResult;private JTextArea txtHistory;
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai07MayTinhMini().setVisible(true));}
}
