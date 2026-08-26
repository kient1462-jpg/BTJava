package vn.edu.eaut.lab3;
import javax.swing.*;import javax.swing.table.DefaultTableModel;
public class Bai08QuanLySinhVien extends JFrame {
    private JTextField txtMa,txtTen,txtDiem;private JButton btnThem,btnSua,btnXoa,btnMoi;private JTable table;private DefaultTableModel model;
    public Bai08QuanLySinhVien(){initComponents();setLocationRelativeTo(null);}
    private void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);setTitle("Bài 8 - Quản lý sinh viên");setLayout(null);
        JLabel a=new JLabel("Mã SV:"),b=new JLabel("Họ tên:"),c=new JLabel("Điểm TB:");a.setBounds(25,20,70,25);b.setBounds(25,55,70,25);c.setBounds(25,90,70,25);
        txtMa=new JTextField();txtTen=new JTextField();txtDiem=new JTextField();txtMa.setBounds(95,20,180,25);txtTen.setBounds(95,55,180,25);txtDiem.setBounds(95,90,180,25);
        btnThem=new JButton("Thêm");btnSua=new JButton("Sửa");btnXoa=new JButton("Xóa");btnMoi=new JButton("Làm mới");
        btnThem.setBounds(290,20,90,30);btnSua.setBounds(290,55,90,30);btnXoa.setBounds(290,90,90,30);btnMoi.setBounds(290,125,90,30);
        model=new DefaultTableModel(new String[]{"Mã SV","Họ tên","Điểm TB","Xếp loại"},0);table=new JTable(model);JScrollPane sp=new JScrollPane(table);sp.setBounds(25,170,385,180);
        add(a);add(b);add(c);add(txtMa);add(txtTen);add(txtDiem);add(btnThem);add(btnSua);add(btnXoa);add(btnMoi);add(sp);setSize(450,400);
        btnThem.addActionListener(e->them());btnSua.addActionListener(e->sua());btnXoa.addActionListener(e->xoa());btnMoi.addActionListener(e->moi());table.getSelectionModel().addListSelectionListener(e->{int r=table.getSelectedRow();if(r>=0){txtMa.setText(model.getValueAt(r,0).toString());txtTen.setText(model.getValueAt(r,1).toString());txtDiem.setText(model.getValueAt(r,2).toString());}});
    }
    private Student read(){String m=txtMa.getText().trim(),t=txtTen.getText().trim();if(m.isEmpty()||t.isEmpty())throw new IllegalArgumentException("Không được để trống!");double d=Double.parseDouble(txtDiem.getText().trim());if(d<0||d>10)throw new IllegalArgumentException("Điểm từ 0 đến 10!");return new Student(m,t,d);}
    private void them(){try{Student s=read();model.addRow(new Object[]{s.getMaSinhVien(),s.getHoTen(),s.getDiemTB(),s.xepLoai()});moi();}catch(Exception e){JOptionPane.showMessageDialog(this,e.getMessage());}}
    private void sua(){int r=table.getSelectedRow();if(r<0){JOptionPane.showMessageDialog(this,"Chọn sinh viên cần sửa!");return;}try{Student s=read();model.setValueAt(s.getMaSinhVien(),r,0);model.setValueAt(s.getHoTen(),r,1);model.setValueAt(s.getDiemTB(),r,2);model.setValueAt(s.xepLoai(),r,3);moi();}catch(Exception e){JOptionPane.showMessageDialog(this,e.getMessage());}}
    private void xoa(){int r=table.getSelectedRow();if(r<0){JOptionPane.showMessageDialog(this,"Chọn sinh viên cần xóa!");return;}model.removeRow(r);moi();}
    private void moi(){txtMa.setText("");txtTen.setText("");txtDiem.setText("");table.clearSelection();txtMa.requestFocus();}
    public static void main(String[] args){SwingUtilities.invokeLater(()->new Bai08QuanLySinhVien().setVisible(true));}
}
