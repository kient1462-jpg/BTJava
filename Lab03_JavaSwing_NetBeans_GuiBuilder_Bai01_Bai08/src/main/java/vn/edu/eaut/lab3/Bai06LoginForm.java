package vn.edu.eaut.lab3;
import javax.swing.*;
public class Bai06LoginForm extends JFrame {
    public Bai06LoginForm(){initComponents();setLocationRelativeTo(null);}
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);setTitle("Bài 6 - Đăng nhập");setLayout(null);
        JLabel a=new JLabel("Tài khoản:"),b=new JLabel("Mật khẩu:"),c=new JLabel("Vai trò:");
        a.setBounds(40,35,90,25);b.setBounds(40,75,90,25);c.setBounds(40,115,90,25);
        txtUser=new JTextField();txtPass=new JPasswordField();cboRole=new JComboBox<>(new String[]{"Admin","User"});chkShow=new JCheckBox("Hiển thị mật khẩu");
        txtUser.setBounds(130,35,220,25);txtPass.setBounds(130,75,220,25);cboRole.setBounds(130,115,220,25);chkShow.setBounds(130,150,180,25);
        btnLogin=new JButton("Đăng nhập");btnLogin.setBounds(130,190,120,30);add(a);add(b);add(c);add(txtUser);add(txtPass);add(cboRole);add(chkShow);add(btnLogin);setSize(420,270);
        char echo=txtPass.getEchoChar();chkShow.addActionListener(e->txtPass.setEchoChar(chkShow.isSelected()?(char)0:echo));btnLogin.addActionListener(e->login());
    }
    private void login(){String u=txtUser.getText().trim(),p=new String(txtPass.getPassword()),r=(String)cboRole.getSelectedItem();boolean ok=(u.equals("admin")&&p.equals("123456")&&r.equals("Admin"))||(u.equals("user")&&p.equals("123456")&&r.equals("User"));JOptionPane.showMessageDialog(this,ok?"Đăng nhập thành công!":"Sai tài khoản, mật khẩu hoặc vai trò!");}
    private JTextField txtUser;private JPasswordField txtPass;private JComboBox<String> cboRole;private JCheckBox chkShow;private JButton btnLogin;
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai06LoginForm().setVisible(true));}
}
