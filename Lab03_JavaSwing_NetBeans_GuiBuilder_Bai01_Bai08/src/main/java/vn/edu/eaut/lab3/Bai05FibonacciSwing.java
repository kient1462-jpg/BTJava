package vn.edu.eaut.lab3;
import javax.swing.*;
public class Bai05FibonacciSwing extends JFrame {
    public Bai05FibonacciSwing(){initComponents();setLocationRelativeTo(null);}
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);setTitle("Bài 5 - Fibonacci");setLayout(null);
        JLabel l=new JLabel("Nhập n:");l.setBounds(35,35,70,25);txtN=new JTextField();txtN.setBounds(105,35,150,25);btnShow=new JButton("Hiển thị");btnShow.setBounds(265,35,100,25);
        txtArea=new JTextArea();txtArea.setEditable(false);JScrollPane sp=new JScrollPane(txtArea);sp.setBounds(35,75,330,150);
        add(l);add(txtN);add(btnShow);add(sp);setSize(420,270);btnShow.addActionListener(e->hienThi());
    }
    private void hienThi(){try{int n=Integer.parseInt(txtN.getText().trim());if(n<1||n>92){JOptionPane.showMessageDialog(this,"n từ 1 đến 92!");return;}long a=0,b=1;StringBuilder s=new StringBuilder();for(int i=0;i<n;i++){if(i>0)s.append(" ");s.append(a);long next=a+b;a=b;b=next;}txtArea.setText(s.toString());}catch(Exception e){JOptionPane.showMessageDialog(this,"n phải là số nguyên dương!");}}
    private JTextField txtN;private JButton btnShow;private JTextArea txtArea;
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai05FibonacciSwing().setVisible(true));}
}
