package kiemTraTK2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener {
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnadd, btndelete, btnupdate, btnsave, btnfilter;
	private XuLyXML dom = new XuLyXML();

	public GUI() {
		setSize(900, 500);
		setTitle("Kiểm Tra 45P");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setBounds(10, 10, 870, 400);
		String[] header = { "idSv", "hoten", "lop", "noisinh", "monhoc" };
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel1.add(scrollPane, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 420, 870, 60);
		btnadd = new JButton("Thêm");
		btndelete = new JButton("Xoá");
		btnsave = new JButton("Cập Nhật");
		btnupdate = new JButton("Update");
		btnfilter = new JButton("Tìm Kiếm");
		panel2.add(btnadd);
		panel2.add(btndelete);
		panel2.add(btnsave);
		panel2.add(btnupdate);
		panel2.add(btnfilter);
		this.add(panel1);
		this.add(panel2);
		loadata();
		btnadd.addActionListener(this);
		btndelete.addActionListener(this);
		btnsave.addActionListener(this);
		btnfilter.addActionListener(this);
		btnupdate.addActionListener(this);

	}

	private void loadata() {
		// TODO Auto-generated method stub
		while (table.getRowCount() != 0) {
			tableModel.removeRow(0);
		}
		for (SinhVien p : dom.getAllProducts()) {
			String[] row = { p.getId(), p.getHoten(), p.getLop(), p.getNoisinh(), p.getMonhoc() };
			tableModel.addRow(row);

		}
	}

	public static void main(String[] args) {
		new GUI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object.equals(btnadd)) {
			add();
		}
		if (object.equals(btndelete)) {
			delete();
		}
		if (object.equals(btnsave)) {
			save();
		}
		if (object.equals(btnupdate)) {
			update();
		}
		if (object.equals(btnfilter)) {
			findSinhVien();
		}
	}

	private void update() {
		// TODO Auto-generated method stub
		String idold = JOptionPane.showInputDialog("Nhập id cần tìm");
		String lopnew = JOptionPane.showInputDialog("Nhập lớp mới cần cập nhật");
		dom.update(idold, lopnew);
		loadata();
	}

	private void save() {
		// TODO Auto-generated method stub
		dom.writeXML();
		JOptionPane.showMessageDialog(this, "Lưu file XML thành công");
	}

	private void delete() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Chưa chọn sinh viên");
			return;
		}
		if (row != 1) {
			String idString = (String) table.getValueAt(row, 0);
			dom.delete(idString);
			JOptionPane.showMessageDialog(this, "Xoá Thành Công");
			loadata();
		} else {
			JOptionPane.showMessageDialog(this, "Chưa chọn dòng cần xoá");
		}

	}

	private void add() {
		// TODO Auto-generated method stub
		String id = JOptionPane.showInputDialog("Nhập id");
		String hoten = JOptionPane.showInputDialog("Nhập họ tên");
		String lop = JOptionPane.showInputDialog("Nhập Lớp ");
		String noisinh = JOptionPane.showInputDialog("Nhập nơi sinh");
		String monhoc = JOptionPane.showInputDialog("Nhập môn học");
		if (id.isEmpty() || hoten.isEmpty() || lop.isEmpty() || noisinh.isEmpty() || monhoc.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
			return;
		}
		else {
			for (int i = 0; i < table.getRowCount(); i++) {
				if (table.getValueAt(i, 0).equals(id)) {
					JOptionPane.showMessageDialog(null, "ID đã tồn tại vui long nhập lại");
					break;
				} 
				else {
					SinhVien sVien = new SinhVien(id, hoten, lop, noisinh, monhoc);
					dom.add(sVien);
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					loadata();
					break;
				}
			}		
		}		
	}
	public void findSinhVien() {
	    String tenLop = JOptionPane.showInputDialog("Nhập Lớp");
	    ArrayList<SinhVien> dsTimKiem = dom.searchSinhVien(tenLop);
	    if (dsTimKiem != null) {
	      tableModel.setRowCount(0);
	      for (SinhVien sv : dsTimKiem) {
	        String[] row = { sv.getId(), sv.getHoten(), sv.getLop(), sv.getNoisinh(), sv.getMonhoc() };
	        tableModel.addRow(row);
	      }
	    } else {
	      tableModel.setRowCount(0);
	      JOptionPane.showMessageDialog(null, "Không tìm thấy tên lớp");
	    }
	  }
}
