package tuan05_QuanLySach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLySach extends JFrame implements ActionListener, MouseListener {
	private JPanel pntong;
	private JLabel lbma, lbtuasach, lbnamsx, lbsotrang, lbtacgia, lbnhaxuatban, lbdongia, lbISBN, lbtimtheomasach;
	private JTextField txtma, txttuasach, txtnamxb, txtsotrang, txttacgia, txtnhaxuatban, txtdongia, txtISBN;
	private JButton btnthem, btnxoarong, btnsua, btnxoa, btnluu;
	private DefaultComboBoxModel<String> dfBoxModel;
	private JComboBox combosach;
	private JTable table;
	private DefaultTableModel tableModel;

	public QuanLySach() {
		pntong = new JPanel();

		setContentPane(pntong);
		pntong.setLayout(null);

		JPanel pnnorth = new JPanel();
		pnnorth.setBounds(5, 5, 1000, 230);
		pnnorth.setLayout(null);
		Border bordernorth = BorderFactory.createLineBorder(Color.gray);
		TitledBorder titlenorth = new TitledBorder(bordernorth, "Records Editor");
		pnnorth.setBorder(titlenorth);
		lbma = new JLabel("Mã sách:");
		lbtuasach = new JLabel("Tựa sách:");
		lbnamsx = new JLabel("Năm xuất bản:");
		lbsotrang = new JLabel("Số trang:");
		lbISBN = new JLabel("Ineternational Standard Book Number(ISBN):");
		lbtacgia = new JLabel("Tác giả:");
		lbnhaxuatban = new JLabel("Nhà xuất bản:");
		lbdongia = new JLabel("Đơn giá:");
		txtma = new JTextField();
		txttuasach = new JTextField();
		txtnamxb = new JTextField();
		txtsotrang = new JTextField();
		txtISBN = new JTextField();
		txttacgia = new JTextField();
		txtnhaxuatban = new JTextField();
		txtdongia = new JTextField();

		lbma.setBounds(10, 30, 100, 20);
		txtma.setBounds(100, 30, 280, 20);
		lbtuasach.setBounds(10, 70, 100, 20);
		txttuasach.setBounds(100, 70, 350, 20);
		lbnamsx.setBounds(10, 110, 100, 20);
		txtnamxb.setBounds(100, 110, 350, 20);
		lbsotrang.setBounds(10, 150, 100, 20);
		txtsotrang.setBounds(100, 150, 350, 20);
		lbISBN.setBounds(10, 190, 280, 20);
		txtISBN.setBounds(270, 190, 180, 20);
		lbtacgia.setBounds(500, 70, 100, 20);
		txttacgia.setBounds(590, 70, 360, 20);
		lbnhaxuatban.setBounds(500, 110, 100, 20);
		txtnhaxuatban.setBounds(590, 110, 360, 20);
		lbdongia.setBounds(500, 150, 100, 20);
		txtdongia.setBounds(590, 150, 360, 20);

		pnnorth.add(lbma);
		pnnorth.add(txtma);
		pnnorth.add(lbtuasach);
		pnnorth.add(txttuasach);
		pnnorth.add(lbnamsx);
		pnnorth.add(txtnamxb);
		pnnorth.add(lbsotrang);
		pnnorth.add(txtsotrang);
		pnnorth.add(lbISBN);
		pnnorth.add(txtISBN);
		pnnorth.add(lbtacgia);
		pnnorth.add(txttacgia);
		pnnorth.add(lbnhaxuatban);
		pnnorth.add(txtnhaxuatban);
		pnnorth.add(lbdongia);
		pnnorth.add(txtdongia);

		// center
		JPanel pncenter = new JPanel();
		pncenter.setBounds(5, 240, 1000, 40);

		btnthem = new JButton("Thêm");
		btnxoarong = new JButton("Xoá Rỗng");
		btnsua = new JButton("Sửa");
		btnxoa = new JButton("Xoá");
		btnluu = new JButton("Lưu");
		pncenter.add(btnthem);
		pncenter.add(btnxoarong);
		pncenter.add(btnsua);
		pncenter.add(btnxoa);
		// pncenter.add(btnluu);
		pncenter.add(Box.createRigidArea(new Dimension(50, 0)));
		lbtimtheomasach = new JLabel("Tìm theo mã sách");
		dfBoxModel = new DefaultComboBoxModel<String>();
		JComboBox comboBox = new JComboBox(dfBoxModel);
		dfBoxModel.addElement("A001");
		dfBoxModel.addElement("J002");
		dfBoxModel.addElement("HD03");
		pncenter.add(lbtimtheomasach);
		pncenter.add(comboBox);
		// bảng
		JPanel pnsouth = new JPanel();
		pnsouth.setBounds(5, 290, 1000, 300);
		Border bordersouth = BorderFactory.createLineBorder(Color.gray);
		TitledBorder titlesouth = new TitledBorder(bordersouth, "Danh sách các cuốn sách");
		pnsouth.setBorder(titlesouth);
		pnsouth.setLayout(new BorderLayout());
		String[] header = { "Mã sách", "Tựa sách", "Tác Giả", "Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá",
				"ISBN" };
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);

		pnsouth.add(scrollPane, BorderLayout.CENTER);
		pntong.add(pnnorth);
		pntong.add(pncenter);
		pntong.add(pnsouth);

		btnthem.addActionListener(this);
		btnsua.addActionListener(this);
		btnxoa.addActionListener(this);
		btnxoarong.addActionListener(this);
		btnluu.addActionListener(this);
		table.addMouseListener(this);

		setSize(1030, 650);
		setTitle("Quản Lý Sách");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static void main(String[] args) {
		QuanLySach b1 = new QuanLySach();
		b1.setVisible(true);
		b1.show();
	}

	private boolean checkkytu() {
		String masach = txtma.getText().trim();
		String tuasach = txttuasach.getText().trim();
		String tacgia = txttacgia.getText().trim();
		String nam = txtnamxb.getText().trim();
		String gia = txtdongia.getText().trim();
		String isbn = txtISBN.getText().trim();
		String soTrang = txtsotrang.getText().trim();
		// Có ký tư đầu là ký tư đầu của tưa sách, theo sau là 3 ký số
		if (!(masach.length() > 0 && masach.matches("[A-Z]\\d{3}"))) {
//		   showMessage("Error: Mã sách theo mẫu: [A-Z]\\d{3}", txtma);
			JOptionPane.showMessageDialog(null, "Mã sách ko hợp lệ");
			return false;
		}
		// Tựa sách, và tác giả không được để trống,
		// có thể gồm nhiều từ ngăn cách bởi khoảng trắng.
		// Không chứa ký số hoặc các ký. tư đặc biệt khác, ngoại trừ ký tư
		if (!(tuasach.length() > 0 && tuasach.matches("[a-zA-Z' ]+"))) {
			// showMessage("Error: Tựa sách theo mẫu: [a-zA-Z' ]+", txttuasach);
			JOptionPane.showMessageDialog(null, "Tựa sách ko hợp lệ");
			return false;
		}
		if (!(tacgia.length() > 0 && tacgia.matches("[a-zA-Z' ]+"))) {
			// showMessage("Error: Tác già theo mẫu: [a-zA-Z' ]+", txtTacGia);
			JOptionPane.showMessageDialog(null, "Tác giả ko hợp lệ");
			return false;
		}
		if (nam.length() > 0) {
			try {
				int x = Integer.parseInt(nam);
				int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
				if (!(x >= 1900 && x < namHienTai)) {
//		             showMessage("Error: Năm xuất bàn >= 1900 && <= "
//		                       + namHienTai, txtnamxb);
					JOptionPane.showMessageDialog(null, "năm ko hợp lệ");
					return false;
				}
			} catch (NumberFormatException ex) {
				// showMessage("Error: Năm xuất bản phải nhập số.", txtNamXB);
				JOptionPane.showMessageDialog(null, "năm xb phải nhập số");
				return false;
			}
			if (soTrang.length() > 0) {
				try {
					int x = Integer.parseInt(soTrang);
					if (x <= 0) {
						// showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
						JOptionPane.showMessageDialog(null, "số phải nhạp nguyên duyongw");
						return false;
					}
				} catch (NumberFormatException ex) {
					// showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
					JOptionPane.showMessageDialog(null, "số phải nhạp nguyên duyongw");
					return false;
				}
			}
			if (gia.length() > 0) {
				try {
					double y = Double.parseDouble(gia);
					if (y < 0) {
						// showMessage("Error: Đơn giá phải > 0.", txtDonGia);
						JOptionPane.showMessageDialog(null, "dơn giá phải > 0");
						return false;
					}
				} catch (NumberFormatException ex) {
					// showMessage("Error: Đơn giá phải nhập số.", txtDonGia);
					JOptionPane.showMessageDialog(null, "đơn giá phải nhập số");
					return false;
				}
			}
			// ISBN có mẫu dang X-X-X-X Choặc X-X-X-X-X).
			// Trong đó, X gồm các ký, số, ít nhất là 1 ký số
			if (isbn.length() > 0)
				if (!isbn.matches("\\d+(-\\d+){3,4}")) {
					// showMessage("Error: ISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X).", txtISBN);
					JOptionPane.showMessageDialog(null, " ISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X)");
					return false;
				}
		}
		return true;

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnxoarong)) {
			txtma.setText("");
			txtdongia.setText("");
			txtISBN.setText("");
			txtnamxb.setText("");
			txtnhaxuatban.setText("");
			txtsotrang.setText("");
			txttacgia.setText("");
			txttuasach.setText("");
		} else if (o.equals(btnthem)) {
			if (checkkytu()) {

				if (txtma.getText().equals("") || txtdongia.getText().equals("") || txtISBN.getText().equals("")
						|| txtnamxb.getText().equals("") || txtnhaxuatban.getText().equals("")
						|| txtsotrang.getText().equals("") || txttacgia.getText().equals("")
						|| txttuasach.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");

				} else {
					try {
						themsach();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				txtma.setText("");
				txtdongia.setText("");
				txtISBN.setText("");
				txtnamxb.setText("");
				txtnhaxuatban.setText("");
				txtsotrang.setText("");
				txttacgia.setText("");
				txttuasach.setText("");
			}
		} else if (o.equals(btnxoa)) {
			try {
				xoadong();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	private void themsach() {
		// TODO Auto-generated method stub

		String masach = txtma.getText();
		boolean ktra = true;
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if (tableModel.getValueAt(i, 0).equals(masach)) {
				JOptionPane.showMessageDialog(this, "Mã bị trùng vui lòng nhập lại");
				ktra = false;
				return;
			}
		}
		if (ktra = true) {

			String tuasach = txttuasach.getText();
			String tacgia = txttacgia.getText();
			String namxb = txtnamxb.getText();
			String nhaxb = txtnhaxuatban.getText();
			String sotrang = txtsotrang.getText();
			String dongia = txtdongia.getText();
			String ISBN = txtISBN.getText();
			String[] row = { masach, tuasach, tacgia, namxb, nhaxb, sotrang, dongia, ISBN };
			tableModel.addRow(row);
			// dssach.themsach(new Sach(masach, tuasach, tacgia, Integer.parseInt(namxb),
			// nhaxb, Integer.parseInt(sotrang), Double.parseDouble(sotrang), ISBN));
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			// db.GhiFile(dssach);
		}
	}

	private void xoadong() {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		if (r == -1) {
			JOptionPane.showMessageDialog(null, "Phải chọn dòng cần xoá");
		} else {
			try {
				int tb = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá dòng này không", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (tb == JOptionPane.YES_OPTION) {
					tableModel.removeRow(r);
					// dssach.xoasach(r);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int r = table.getSelectedRow();
		int i = 0;
		txtma.setText(tableModel.getValueAt(r, i).toString());
		txttuasach.setText(tableModel.getValueAt(r, i + 1).toString());
		txttacgia.setText(tableModel.getValueAt(r, i + 2).toString());
		txtnamxb.setText(tableModel.getValueAt(r, i + 3).toString());
		txtnhaxuatban.setText(tableModel.getValueAt(r, i + 4).toString());
		txtsotrang.setText(tableModel.getValueAt(r, i + 5).toString());
		txtdongia.setText(tableModel.getValueAt(r, i + 6).toString());
		txtISBN.setText(tableModel.getValueAt(r, i + 7).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isCellEditable(int row, int column) {
		// all cells false
		return false;
	}

}
