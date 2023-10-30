package tuan3;

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

	public QuanLyNhanVienGUI() {
		super("Quản lý nhân viên");
		// north
		pnNorth = new JPanel();
		JLabel h1 = new JLabel("THÔNG TIN NHÂN VIÊN");
		pnNorth.add(h1);
		h1.setForeground(Color.BLUE);
		h1.setFont(new Font("Arial", Font.BOLD, 35));
		add(pnNorth, BorderLayout.NORTH);
		// center

		pnCenter = new JPanel();
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
		Object[][] cells = { { "1111", "Nguyễn", "Hoàng", "Nam", new Integer(26), "4.500" },
				{ "2222", "Lê", "Thu", "Nữ", new Integer(28), "5.000" },
				{ "3333", "Hoàng", "Lê", "Nam", new Integer(30), "3.500" } };

		model = new DefaultTableModel(cells, cols);
		table = new JTable(model);
		b.add(new JScrollPane(table));

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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
