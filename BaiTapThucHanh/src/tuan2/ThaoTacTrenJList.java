package tuan2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ThaoTacTrenJList extends JFrame implements ActionListener{
	
	private JButton btnExit, btnToChan, btnToLe, btnToSNT, 
			btnXoaTo, btnXoa, btnTong, btnNhap;
	private JTextField textNhap;
	private JCheckBox CboxNhap;
	private DefaultListModel<Integer> ltmodel;
	private JList<Integer> list;
	
	public ThaoTacTrenJList() {
		//Set frame
		super("Thao tác trên JList");
		setVisible(true);
		setSize(600, 420);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//North panel
		JPanel jpN = new JPanel();
		JLabel title = new JLabel();
		add(jpN, BorderLayout.NORTH);
		jpN.add(title = new JLabel("Thao tác trên JList - Checkbox"));
		title.setFont(new Font(null, Font.BOLD, 30));
		title.setForeground(Color.BLUE);
		
		//West panel
		JPanel jpW = new JPanel();
		add(jpW, BorderLayout.WEST);
		jpW.setPreferredSize(new Dimension(200, 0));
		jpW.setLayout(new BoxLayout(jpW, BoxLayout.Y_AXIS));
		jpW.setBorder(new TitledBorder(new LineBorder(Color.RED), "Chọn tác vụ"));
		btnToChan = new JButton("Tô đen số chẵn");
		jpW.add(Box.createVerticalStrut(10));
		jpW.add(btnToChan);
		btnToLe = new JButton("Tô đen số lẻ");
		jpW.add(Box.createVerticalStrut(5));
		jpW.add(btnToLe);
		btnToSNT = new JButton("Tô đen số nguyên tố");
		jpW.add(Box.createVerticalStrut(5));
		jpW.add(btnToSNT);
		btnXoaTo = new JButton("Bỏ tô đen");
		jpW.add(Box.createVerticalStrut(5));
		jpW.add(btnXoaTo);
		btnXoa = new JButton("Xóa các giá trị đang tô đen");
		jpW.add(Box.createVerticalStrut(5));
		jpW.add(btnXoa);
		btnTong = new JButton("Tổng giá trị trong JList");
		jpW.add(Box.createVerticalStrut(5));
		jpW.add(btnTong);
		
		// Center panel
		JPanel jpC = new JPanel();
		add(jpC, BorderLayout.CENTER);
		jpC.setBorder(new TitledBorder(new LineBorder(Color.RED), "Nhập thông tin"));
		Box b1 = Box.createHorizontalBox();
		b1.add(btnNhap = new JButton("Nhập"));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(textNhap = new JTextField(10));
		b1.add(CboxNhap = new JCheckBox());
		JLabel NhapSoAm = new JLabel("Cho nhập số âm");
		b1.add(NhapSoAm);
		jpC.add(b1);
		// JList
		Box b2 = Box.createVerticalBox();
		b2.setPreferredSize(new Dimension(365, 225));
		ltmodel = new DefaultListModel<Integer>();
		list = new JList<Integer>(ltmodel);
		list.setBorder(BorderFactory.createTitledBorder(""));
		list.setVisibleRowCount(14);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		b2.add(Box.createVerticalStrut(10));
		b2.add(list);
		JScrollPane sp = new JScrollPane(list);
		b2.add(sp);
		jpC.add(b2);
		
		//South panel
		JPanel jpS = new JPanel();
		add(jpS, BorderLayout.SOUTH);
		jpS.setPreferredSize(new Dimension(50, 50));
		jpS.setBorder(BorderFactory.createLineBorder(Color.RED));
		jpS.add(btnExit = new JButton("Đóng chương trình"));
		jpS.setBackground(Color.LIGHT_GRAY);
		
		//ActionListener
		btnNhap.addActionListener(this);
		btnToChan.addActionListener(this);
		btnToLe.addActionListener(this);
		btnToSNT.addActionListener(this);
		btnXoaTo.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTong.addActionListener(this);
		btnExit.addActionListener(this);

}
		
	public static void main(String[] args) {
		new ThaoTacTrenJList();
	}

	public boolean isPrime(int x) {
		if(x < 2) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nhap;
		Object obj = e.getSource();
		nhap = textNhap.getText();
		if (obj.equals(btnNhap))
			if (nhap.equals(""))
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập liệu");
			else {
				try {
					ltmodel.addElement(Integer.parseInt(textNhap.getText()));
					textNhap.setText("");
					textNhap.requestFocus();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Nhập sai định dạng");
					textNhap.selectAll();
					textNhap.requestFocus();
				}
			}
		if (obj.equals(btnToChan)) {
			list.clearSelection();
			for (int i = 0; i < ltmodel.getSize(); i++)
				if (ltmodel.getElementAt(i) % 2 == 0)
					list.addSelectionInterval(i, i);

		}
		else
			if(obj.equals(btnToLe)) {
				list.clearSelection();
				for(int i = 0; i < ltmodel.getSize(); i++) {
					if(ltmodel.getElementAt(i) %2 != 0)
						list.addSelectionInterval(i, i);
				}
			}
			else
				if(obj.equals(btnToSNT)) {
					list.clearSelection();
					for(int i = 0; i < ltmodel.getSize(); i++) {
						if(isPrime(ltmodel.getElementAt(i)) == true)
							list.addSelectionInterval(i, i);
					}
				}
				else
					if(obj.equals(btnXoa)) {
						Object[] items = list.getSelectedValues();
						for (Object value  : items)
							ltmodel.removeElement(value);
					}
					else
						if(obj.equals(btnTong)) {
							int sum = 0;
							for(int i = 0; i < ltmodel.getSize(); i++)
								sum = sum + ltmodel.getElementAt(i);
							JOptionPane.showMessageDialog(this, "Tổng JList là: " + sum);
						}
						else
							if(obj.equals(btnXoaTo)) {
								list.clearSelection();
							}
							else
								if(obj == btnExit) {
									System.exit(0);
								}
	}
	
}
