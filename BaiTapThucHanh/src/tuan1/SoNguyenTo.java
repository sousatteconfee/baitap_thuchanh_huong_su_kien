package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoNguyenTo extends JFrame implements ActionListener{
	
	private JTextField textNhap;
	private JButton generate;
	private JTextArea textShow;
	
	public SoNguyenTo() { 
		super("Primes");
		JPanel jp = new JPanel();
		add(jp = new JPanel(), BorderLayout.CENTER);
		jp.add(textNhap = new JTextField(30));
		jp.add(generate = new JButton("Generate"));
		jp.add(textShow = new JTextArea(10, 40));
		textShow.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		
		generate.addActionListener(this);
		
		setVisible(true);
		setResizable(true);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SoNguyenTo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == generate) {
			int x = Integer.parseInt(textNhap.getText());
			if(x < 2) {
				textShow.setText("Không có số nguyên tố hợp lệ!");
			}
			else {
				String showPrimes = timSoNguyenTo(x);
				textShow.setText(showPrimes);
			}
		}
	}
	
	public String timSoNguyenTo(int x) {
		StringBuilder primes = new StringBuilder();

        for (int i = 2; i <= x; i++) {
            if (isPrime(i)) {
                primes.append(i).append(System.lineSeparator());
            }
        }

        return primes.toString();
		
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
}
