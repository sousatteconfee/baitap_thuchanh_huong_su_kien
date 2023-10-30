package tuan5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.Selector;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class QuanLyNhanVienGUI extends JFrame implements ActionListener, MouseListener {

	private NhanVienList dao;
	private List<NhanVien> list;
	private final String fileParth = "src\\data\\danhSachNV.ser";
	private int flag = 0;

	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private JTextField txtTim = new JTextField(15);

	private JTextField txtmaNV;
	private JTextField txtTenNV;
	private JTextField txtHoNV;
	private JTextField txtTuoi;
	private JTextField txtLuong;
	private JRadioButton rdNam;
	private JRadioButton rdNu;

	private JPanel pnNorth;
	private JPanel pnSouth;
	private JPanel pnCenter;

	private JTable table;

	private DefaultTableModel model;

	public QuanLyNhanVienGUI(NhanVienList dao) {
		
		super("Quản lý nhân viên");
		this.dao = dao;
		list = dao.getList();
		
		// north
		pnNorth = new JPanel();

		JLabel h1 = new JLabel("THÔNG TIN NHÂN VIÊN");

		pnNorth.add(h1);
		h1.setForeground(Color.BLUE);
		h1.setFont(new Font("Arial", Font.BOLD, 35));
		add(pnNorth, BorderLayout.NORTH);

		// center

		pnCenter = new JPanel();
//		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();

		b1.add(new JLabel("Mã nhân viên"));
		txtmaNV = new JTextField();
		b1.setPreferredSize(new Dimension(720, 25));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(txtmaNV);

		b2.add(new JLabel("Họ"));
		txtHoNV = new JTextField();
		b2.setPreferredSize(new Dimension(200, 25));
		b2.add(Box.createHorizontalStrut(70));
		b2.add(txtHoNV);
		b2.add(Box.createHorizontalStrut(5));
		b2.add(new JLabel("Tên nhân viên"));
		txtTenNV = new JTextField();
		b2.add(Box.createHorizontalStrut(5));
		b2.add(txtTenNV);

		b3.add(new JLabel("Tuổi"));
		txtTuoi = new JTextField();
		b3.setPreferredSize(new Dimension(100, 25));
		b3.add(Box.createHorizontalStrut(60));
		b3.add(txtTuoi);
		b3.add(Box.createHorizontalStrut(15));
		b3.add(new JLabel("Phái"));
		b3.add(rdNam = new JRadioButton("Nam"));
		b3.add(rdNu = new JRadioButton("Nữ"));

		ButtonGroup group = new ButtonGroup();
		group.add(rdNam);
		group.add(rdNu);
		rdNam.setSelected(true);

		b4.add(new JLabel("Tiền lương"));
		txtLuong = new JTextField();
		b4.setPreferredSize(new Dimension(700, 25));
		b4.add(Box.createHorizontalStrut(23));
		b4.add(txtLuong);

		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		pnCenter.add(b);

		b.add(Box.createVerticalStrut(5));

		String[] cols = { "Mã nhân viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		Object[][] cells = { { "AB1111", "Nguyễn", "Hoàng", "Nam", new Integer(26), "4.500" },
				{ "AC2222", "Lê", "Thu", "Nữ", new Integer(28), "5.000" },
				{ "AD3333", "Hoàng", "Lê", "Nam", new Integer(30), "3.500" } };

		model = new DefaultTableModel(cells, cols);
		table = new JTable(model);
		b.add(new JScrollPane(table));

		// load file
		dao = (NhanVienList) StoreData.loadFile(fileParth);

		// nếu load file thất bại hoặc không có dữ liệu thì dữ liệu sẽ null
		if (dao == null)
			dao = new NhanVienList();
		loadDataTable(dao);
		table.addMouseListener(this);

		// gán combobox trong bảng thay đổi phái
		TableColumn phaiColumn = table.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");

		// thay đổi
		phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
		TableColumn column = new TableColumn();
		column.setPreferredWidth(100);
		add(pnCenter, BorderLayout.CENTER);
		pnSouth = new JPanel();
		add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setPreferredSize(new Dimension(0, 50));
		
		JPanel pnSouth_Left = new JPanel();
		pnSouth_Left.setBorder(BorderFactory.createTitledBorder(""));
		pnSouth_Left.add(new JLabel("Nhập số cần tìm"));
		pnSouth_Left.add(txtTim);
		pnSouth_Left.add(btnTim = new JButton("Tìm"));
		
		JPanel pnSouth_Right = new JPanel();
		pnSouth_Right.add(btnThem = new JButton("Thêm"));
		pnSouth_Right.add(btnXoa = new JButton("Xóa"));
		pnSouth_Right.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnSouth_Right.add(btnLuu = new JButton("Lưu"));

		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnSouth_Left, pnSouth_Right);
		pnSouth.add(sp);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		table.addMouseListener(this);
		
		setSize(750, 700);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (checkkytu()) {

			if (txtmaNV.getText().equals("") || txtHoNV.getText().equals("") || txtTenNV.getText().equals("")
					|| txtLuong.getText().equals("") || txtTuoi.getText().equals("") || txtLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");

			} else {
				try {
					themActions();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			txtmaNV.setText("");
			txtHoNV.setText("");
			txtTenNV.setText("");
			txtTuoi.setText("");
			txtLuong.setText("");

		} else if (o == btnXoaTrang) {
			xoaTrang();
		}

		else if (o == btnXoa) {
			// xoaActions();;
			xoaRowSelected();
			return;
		}

		else if (o == btnLuu) {
			if (StoreData.saveFile(dao, fileParth) == true) {
				JOptionPane.showMessageDialog(null, "Lưu thành công");
				return;
			} else
				JOptionPane.showMessageDialog(null, "Lỗi lưu file!");
		}

		else if (o == btnTim) {
			timNV();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtmaNV.setText(table.getValueAt(row, 0).toString());
		txtHoNV.setText(table.getValueAt(row, 1).toString());
		txtTenNV.setText(table.getValueAt(row, 2).toString());
		rdNu.setSelected(false);
		if (table.getValueAt(row, 3).toString().equalsIgnoreCase("true"))
			rdNu.setSelected(true);
		txtTuoi.setText(table.getValueAt(row, 4).toString());
		txtLuong.setText(table.getValueAt(row, 5).toString());

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

	/*
	 * Mô tả hàm: kiểm tra có phải số hay không Truyền vào string Trả về true nếu là
	 * số và ngược lại
	 */

	public boolean isNumber(String x) {
		try {
			Double.parseDouble(x);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/*
	 * Mô tả hàm: Đổi options Combobox về TRUE hay FALSE Truyền vào string Trả vè
	 * true nếu là nam, false là nữ
	 */
	public boolean optionsTrueOrFalse(String x) {
		return x.equals("Nam") ? true : false;
	}

	/*
	 * Mô tả hàm: Đổi true false về giới tính Truyền vào biến boolean Trả về chuỗi
	 * "Nam" nếu là true, "Nữ nếu là false"
	 */
	public String optionsGender(boolean x) {
		return x ? "Nam" : "Nữ";
	}

	/*
	 * Mô tả hàm: Hiện lỗi và focus textfield Truyền vào string, JTextField
	 */
	public void showError(String x, JTextField txt) {
		JOptionPane.showMessageDialog(null, x);
		txt.requestFocus();
	}

	/*
	 * Mô tả hàm: Load dữ liệu từ collection lên bảng Truyền vào NhanVienList Note:
	 * Load dữ liệu lên table, tái sử dụng khi tìm kiếm
	 */
	public void loadDataTable(NhanVienList x) {
		for (int i = 0; i < x.getSize(); i++) {
			model.addRow(x.getByIndex(i).getObjectNV());
		}
	}

	/*
	 * Mô tả hàm: xóa toàn bộ dữ liệu trên table
	 */
	public void clearDataOnTable() {
		while (model.getRowCount() > 0)
			model.removeRow(0);
	}

	/*
	 * Mô tả hàm: xóa trắng textfield
	 */
	public void xoaTrang() {
		txtmaNV.setText("");
		txtHoNV.setText("");
		txtTenNV.setText("");
		txtTuoi.setText("");
		txtLuong.setText("");
		rdNam.setSelected(true);
		txtmaNV.requestFocus();
	}

	/*
	 * Mô tả hàm: Sử dụng để tạo dữ liệu từ field Có chức năng lấy dữ liệu xuống và
	 * chuyển thành obj Nhân viên
	 */
	private NhanVien generateOBJ() {
		NhanVien temp;

		// isBlank: kiểm tra xem một chuỗi có rỗng hoặc chỉ chứa các ký tự trắng
		// (khoảng trắng, tab, dòng mới) hay không
		if (txtmaNV.getText().isBlank()) {
			showError("Hãy nhập mã nhân viên!", txtmaNV);
			return null;
		}

		String maNhanVien = txtmaNV.getText();

		if (txtHoNV.getText().isBlank()) {
			showError("Hãy nhập họ nhân viên!", txtHoNV);
			return null;
		}

		String hoNhanVien = txtHoNV.getText();

		if (txtTenNV.getText().isBlank()) {
			showError("Hãy nhập tên nhân viên!", txtTenNV);
			return null;
		}

		String tenNhanVien = txtTenNV.getText();

		if (!isNumber(txtTuoi.getText())) {
			showError("Hãy nhập tuổi hợp lệ!", txtTuoi);
			return null;
		}

		int tuoi = Integer.parseInt(txtTuoi.getText());

		if (!isNumber(txtLuong.getText())) {
			showError("Tiền lương phải là số hợp lệ!", txtLuong);
			return null;
		}

		double tien = Double.parseDouble(txtLuong.getText());

		boolean gioi = rdNam.isSelected() ? true : false;

		try {
			temp = new NhanVien(maNhanVien, hoNhanVien, tenNhanVien, tuoi, gioi, tien);

			return temp;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	/*
	 * Mô tả hàm: Thêm dữ liệu vào table Sử dụng trong sự kiện Add- Thêm dữ liệu vào
	 * collections hiện lên table
	 */
	private void themTable() {
		NhanVien temp = generateOBJ();
		// Khởi tạo đối tượng thất bại sẽ trả về null
		// Trong generateOBJ() có hiện thông báo lỗi nên chỉ cần tạm dừng thực thi hàm
		if (temp == null)
			return;
		try {
			if (!dao.themNhanVien(temp)) {
				JOptionPane.showMessageDialog(null, "Trùng mã! Vui lòng nhập lại mã");
				return;
			}
			model.addRow(temp.getObjectNV());
			xoaTrang();

			if (flag == 1) {
				clearDataOnTable();
				loadDataTable(dao);
				flag = 0;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void themActions() {
		try {
			String maNV = txtmaNV.getText();
			String ho = txtHoNV.getText();
			String ten = txtTenNV.getText();
			boolean phai = (rdNu.isSelected()) ? true : false;
			int tuoi = Integer.parseInt(txtTuoi.getText());
			double tienLuong = Double.parseDouble(txtLuong.getText());
			NhanVien nv = new NhanVien(maNV, ho, ten, phai, tuoi, tienLuong);
			if (dao.themNhanVien(nv)) {
				String[] row = { maNV, ho, ten, Boolean.toString(phai), Integer.toString(tuoi),
						Double.toString(tienLuong) };
				model.addRow(row);
				xoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Trùng mã nhân viên! ");
				txtmaNV.selectAll();
				txtmaNV.requestFocus();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi nhập liệu! ");
			return;
		}
	}

	/*
	 * Mô tả hàm: Sử dụng trong sự kiện DELETE Có chức năng xóa dữ liệu các dòng
	 * đang chọn, có thể xóa được nhiều dòng
	 */
	private void xoaRowSelected() {
		String listMaNV = "";
		String maNV = "";

		if (table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào để xóa!");
			return;
		}

		/* Lấy ra danh sách xóa để hiển thị trên GUI */
		int[] listIndex = table.getSelectedRows();
		/* Lấy giá trị đầu tiên */
		listMaNV += table.getValueAt(listIndex[0], 0);
		/* Nếu còn nhiều trong danh sách, hiện thêm cùng dấu phẩy cách các số */
		for (int i = 0; i < table.getSelectedRowCount(); i++)
			listMaNV += "," + table.getValueAt(listIndex[i], 0);
		if (table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào để xoá!");
			return;
		}
		/* Hiển thị thông tin xóa và xoá nhiều dòng */
		if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá nhân viên " + listMaNV + " ?", "Thông tin",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			try {
				for (int i = 0; i < table.getSelectedRowCount(); i++) {
					maNV = (String) table.getValueAt(listIndex[i], 0);
					if (!dao.xoaNhanVien(new NhanVien())) {
						JOptionPane.showMessageDialog(null,
								"Xoá thất bại. Lỗi bất thường khi xoá nhân viên mã " + maNV);
						// Nếu lỗi, xoá hết lựa chọn để tránh lặp lại nhiều lần
						table.clearSelection();
					}
				}
				clearDataOnTable();
				loadDataTable(dao);
			} catch (Exception e) {
				// Bắt lỗi nếu có sự cố bất thường trong quá trình xoá.
				clearDataOnTable();
				loadDataTable(dao);
				JOptionPane.showMessageDialog(null, "Xoá thất bại. Đã xảy ra lỗi trong quá trình thực hiện!");
				System.out.println(e);
			}
		}
	}

	/*
	 * Mô tả hàm: Sử dụng trong sự kiện SEARCH Tìm kiếm danh sách các ID gần đúng
	 */
	private void timNV() {
		NhanVienList nvList;
		this.flag = 1;
		String x = txtTim.getText();

		clearDataOnTable();
		if (x.isEmpty() || x.trim() == "") {
			loadDataTable(dao);
			return;
		}

		try {
			nvList = dao.timNhanVien(x);
			if (nvList == null)
				return;
			loadDataTable(nvList);
		} catch (Exception e) {
		}
	}

	/*
	 * Mô tả hàm: Sử dụng trong sự kiện SỬA Tự đồng sửa data trên field đang được
	 * chọn
	 */
	private void suaNV() {
		int pos = table.getSelectedRow();
		if (pos == -1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng nào để sửa!");
			return;
		}
		if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Chỉ sửa 1 dòng 1 lần!");
			return;
		}

		NhanVien x = generateOBJ();

		if (x == null)
			return;
		try {
			dao.replaceID(x);
			model.removeRow(pos);
			model.insertRow(pos, x.getObjectNV());
			JOptionPane.showMessageDialog(null, "Sửa thành công!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không thể chỉnh sửa ID, vui lòng kiểm tra lại!");
		}
	}

	public static void main(String[] args) {
		NhanVienList dao = new NhanVienList();
		new QuanLyNhanVienGUI(dao);
	}

	private boolean checkkytu() {
		String maNV = txtmaNV.getText().trim();
		String HoNV = txtHoNV.getText().trim();
		String TenNV = txtTenNV.getText().trim();
		String Tuoi = txtTuoi.getText().trim();
		String Luong = txtLuong.getText().trim();
		if (!(maNV.length() > 0 && maNV.matches("[A-Z]{2}.*"))) {
			JOptionPane.showMessageDialog(null, "Error: Mã nhân viên phải có 2 kí tự hoa ở đầu và 4 kí tự số");
			return false;
		}
		if (!(HoNV.length() > 0 && HoNV.matches("^[A-Z].*"))) {
			JOptionPane.showMessageDialog(null, "Error: Họ nhân viên phải viết hoa chữ cái đầu");
			return false;
		}
		if (!(TenNV.length() > 0 && TenNV.matches("^[A-Z].*"))) {
			JOptionPane.showMessageDialog(null, "Error: Tên nhân viên phải viết hoa chữ cái đầu");
			return false;
		}
		if (Tuoi.length() > 0) {
			try {
				int x = Integer.parseInt(Tuoi);
				int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
				if (!(x >= 20 && x < namHienTai - 1990)) {
					JOptionPane.showMessageDialog(null, "Tuổi không hợp lệ (tuổi lớn hơn hoặc bằng 20 và nhỏ hơn 33");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Tuổi phải là số");
				return false;
			}
		}
		if (Luong.length() > 0) {
			try {
				double y = Double.parseDouble(Luong);
				if(!(y > 0)) {
					JOptionPane.showMessageDialog(null, "Lương không được âm");
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lương phải là số");
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
