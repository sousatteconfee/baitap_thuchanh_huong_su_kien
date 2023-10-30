package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GiaiPhuongTrinhBac2 extends JFrame implements ActionListener{
	
	private JTextField a, b, c, kq;
	private JButton btngiai, btnxoa, btnthoat;
	
	public GiaiPhuongTrinhBac2() {
		super("^_^");
		JPanel jpNorth = new JPanel();
		JLabel title;
		add(jpNorth = new JPanel(), BorderLayout.NORTH);
		jpNorth.setBackground(Color.CYAN);
		jpNorth.add(title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2"));
		title.setFont(new Font("null", Font.BOLD, 20));
		
		
		JPanel jpCenter = new JPanel();
		JLabel texta, textb, textc, textkq;
		jpCenter.setLayout(new BoxLayout(jpCenter, BoxLayout.Y_AXIS));
		add(jpCenter = new JPanel(), BorderLayout.CENTER);
		JPanel jpa = new JPanel();
		jpa.add(texta = new JLabel("Nhập a: "));
		jpa.add(a = new JTextField(30));
		jpCenter.add(jpa);
		JPanel jpb = new JPanel();
		jpb.add(textb = new JLabel("Nhập b: "));
		jpb.add(b = new JTextField(30));
		jpCenter.add(jpb);
		JPanel jpc = new JPanel();
		jpc.add(textc = new JLabel("Nhập c: "));
		jpc.add(c = new JTextField(30));
		jpCenter.add(jpc);
		JPanel jpkq = new JPanel();
		jpkq.add(textkq = new JLabel("Kết quả: "));
		jpkq.add(kq = new JTextField(30));
		kq.setEditable(false);
		jpCenter.add(jpkq);
		
		
		JPanel jpSouth = new JPanel();
		add(jpSouth = new JPanel(), BorderLayout.SOUTH);
		jpSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		jpSouth.add(btngiai = new JButton("Giải"));
		jpSouth.add(btnxoa = new JButton("Xóa Rỗng"));
		jpSouth.add(btnthoat = new JButton("Thoát"));
		
		btngiai.addActionListener(this);
		btnxoa.addActionListener(this);
		btnthoat.addActionListener(this);

		setVisible(true);
		setResizable(false); //chinh kich thuoc frame
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) 
	{
		new GiaiPhuongTrinhBac2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object source = e.getSource();
	    if (source == btngiai) {
	        double gtriA = Double.parseDouble(a.getText());
	        double gtriB = Double.parseDouble(b.getText());
	        double gtriC = Double.parseDouble(c.getText());
	        double delta = (gtriB * gtriB) - (4 * gtriA * gtriC);
	        if (delta < 0) {
	            kq.setText("Phương trình vô nghiệm");
	        } else if (delta == 0) {
	            double gtriX = (-gtriB) / (2 * gtriA);
	            kq.setText("Phương trình có nghiệm kép X = " + gtriX);
	        } else {
	            double gtriX1 = (-gtriB + Math.sqrt(delta)) / (2 * gtriA);
	            double gtriX2 = (-gtriB - Math.sqrt(delta)) / (2 * gtriA);
	            kq.setText("X1 = " + gtriX1 + ", X2 = " + gtriX2);
	        }
	    } else if (source == btnxoa) {
                a.setText("");
                b.setText("");
                c.setText("");
                kq.setText("");
            } else if (source == btnthoat) {
                System.exit(0);
            }
	}
}
