package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CongTruNhanChia extends JFrame implements ActionListener{

	private JTextField textA, textB, textKq;
	private JRadioButton rdCong, rdTru, rdNhan, rdChia;
	private JButton btnGiai, btnXoa, btnThoat, blue, red, yellow;

	public CongTruNhanChia() {
		super("Cộng-Trừ-Nhân-Chia");
		// North panel
		JPanel jpN = new JPanel();
		JLabel title = new JLabel();
		add(jpN, BorderLayout.NORTH);
		jpN.add(title = new JLabel("Cộng Trừ Nhân Chia"));
		title.setFont(new Font(null, Font.BOLD, 24));
		title.setForeground(Color.BLUE);

		// West panel
		JPanel jpW = new JPanel();
		add(jpW, BorderLayout.WEST);
		jpW.setLayout(null);
		jpW.setBackground(Color.LIGHT_GRAY);
		jpW.setPreferredSize(new Dimension(100, 0));
		jpW.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		btnGiai = new JButton("Giải");
		btnGiai.setBounds(15, 25, 70, 30);
		jpW.add(btnGiai);
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(15, 65, 70, 30);
		jpW.add(btnXoa);
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(15, 105, 70, 30);
		jpW.add(btnThoat);

		// Center panel
		JPanel jpC = new JPanel();
		JLabel nhapA, nhapB, Kq;
		add(jpC, BorderLayout.CENTER);
		jpC.setLayout(null);
		jpC.setBorder(BorderFactory.createTitledBorder("Tính Toán"));
		jpC.add(nhapA = new JLabel("Nhập a:"));
		nhapA.setBounds(60, 25, 250, 30);
		jpC.add(textA = new JTextField());
		textA.setBounds(130, 25, 250, 30);
		jpC.add(nhapB = new JLabel("Nhập b:"));
		nhapB.setBounds(60, 65, 250, 30);
		jpC.add(textB = new JTextField());
		textB.setBounds(130, 65, 250, 30);
		ButtonGroup groupMathBtn = new ButtonGroup();
		JPanel jpRadio = new JPanel();
		jpC.add(jpRadio = new JPanel());
		jpRadio.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		jpRadio.setBounds(130, 110, 250, 100);
		jpRadio.add(rdCong = new JRadioButton("Cộng"));
		jpRadio.add(rdTru = new JRadioButton("Trừ"));
		jpRadio.add(rdNhan = new JRadioButton("Nhân"));
		jpRadio.add(rdChia = new JRadioButton("Chia"));
		jpRadio.setLayout(new GridLayout(2, 2));
		groupMathBtn.add(rdCong);
		groupMathBtn.add(rdTru);
		groupMathBtn.add(rdNhan);
		groupMathBtn.add(rdChia);
		jpC.add(Kq = new JLabel("Kết quả:"));
		Kq.setBounds(60, 230, 250, 30);
		jpC.add(textKq = new JTextField());
		textKq.setBounds(130, 230, 250, 30);
		textKq.setEditable(false);

		// South
		JPanel jpS = new JPanel();
		add(jpS, BorderLayout.SOUTH);
		jpS.setBackground(Color.PINK);
		jpS.setPreferredSize(new Dimension(0, 50));
		blue = new JButton();
		blue.setPreferredSize(new Dimension(30, 30));
		blue.setBackground(Color.BLUE);
		jpS.add(blue);
		red = new JButton();
		red.setPreferredSize(new Dimension(30, 30));
		red.setBackground(Color.RED);
		jpS.add(red);
		yellow = new JButton();
		yellow.setPreferredSize(new Dimension(30, 30));
		yellow.setBackground(Color.YELLOW);
		jpS.add(yellow);
		
		//ActionLitener
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);

		setVisible(true);
		setSize(600, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CongTruNhanChia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		 try {
             int a = Integer.parseInt(textA.getText());
             int b = Integer.parseInt(textB.getText());
             int ketQua = 0;
             if (rdCong.isSelected()) {
                 ketQua = cong(a, b);
             } else if (rdTru.isSelected()) {
                 ketQua = tru(a, b);
             } else if (rdNhan.isSelected()) {
                 ketQua = nhan(a, b);
             } else if (rdChia.isSelected()) {
                 double ketQuaChia = chia(a, b);
                 textKq.setText(String.valueOf(ketQuaChia));
                 return;
             }
             textKq.setText(String.valueOf(ketQua));
         } catch (NumberFormatException ex) {
             textKq.setText("Nhập vào số nguyên hợp lệ");
         } catch (ArithmeticException ex) {
             textKq.setText(ex.getMessage());
         }
		 if(obj == btnXoa) {
			 textA.setText("");
			 textB.setText("");
		 }
		 else if (obj == btnThoat){
			 System.exit(0);
		 }
     }
	
	public int cong(int a, int b) {
        return a + b;
    }
	
	public int tru(int a, int b) {
        return a - b;
    }
	
	public int nhan(int a, int b) {
        return a * b;
    }
	
	public double chia(int a, int b) {
		if (b != 0) {
			return (double) a / b;
		} else {
			throw new ArithmeticException("Lỗi chia cho 0");
		}
	}
}
