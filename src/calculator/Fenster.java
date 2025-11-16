package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;

public class Fenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenster frame = new Fenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenster() {
		setResizable(false);
		setSize(new Dimension(310, 485));
		getContentPane().setBounds(new Rectangle(0, 0, 400, 700));
		getContentPane().setLayout(null);
		
		JButton seven = new JButton("7");
		seven.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		seven.setBounds(20, 180, 60, 60);
		getContentPane().add(seven);
		
		JButton eight = new JButton("8");
		eight.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		eight.setBounds(85, 180, 60, 60);
		getContentPane().add(eight);
		
		JButton nine = new JButton("9");
		nine.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		nine.setBounds(150, 180, 60, 60);
		getContentPane().add(nine);
		
		JButton four = new JButton("4");
		four.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		four.setBounds(20, 245, 60, 60);
		getContentPane().add(four);
		
		JButton fiive = new JButton("5");
		fiive.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		fiive.setBounds(85, 245, 60, 60);
		getContentPane().add(fiive);
		
		JButton six = new JButton("6");
		six.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		six.setBounds(150, 245, 60, 60);
		getContentPane().add(six);
		
		JButton one = new JButton("1");
		one.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		one.setBounds(20, 310, 60, 60);
		getContentPane().add(one);
		
		JButton two = new JButton("2");
		two.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		two.setBounds(85, 310, 60, 60);
		getContentPane().add(two);
		
		JButton three = new JButton("3");
		three.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		three.setBounds(150, 310, 60, 60);
		getContentPane().add(three);
		
		JButton zero = new JButton("0");
		zero.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		zero.setBounds(20, 375, 125, 60);
		getContentPane().add(zero);
		
		JButton comma = new JButton(",");
		comma.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comma.setBounds(150, 375, 60, 60);
		getContentPane().add(comma);
		
		JButton equals = new JButton("=");
		equals.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		equals.setBounds(215, 375, 60, 60);
		getContentPane().add(equals);
		
		JButton times = new JButton("x");
		times.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		times.setBounds(215, 180, 60, 60);
		getContentPane().add(times);
		
		JButton minus = new JButton("-");
		minus.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		minus.setBounds(215, 245, 60, 60);
		getContentPane().add(minus);
		
		JButton plus = new JButton("+");
		plus.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		plus.setBounds(215, 310, 60, 60);
		getContentPane().add(plus);
		
		JButton divide = new JButton("/");
		divide.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		divide.setBounds(215, 115, 60, 60);
		getContentPane().add(divide);
		
		JButton clear = new JButton("C");
		clear.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		clear.setBounds(150, 115, 60, 60);
		getContentPane().add(clear);
		
		JButton clearEntry = new JButton("CE");
		clearEntry.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		clearEntry.setBounds(85, 115, 60, 60);
		getContentPane().add(clearEntry);
		
		JButton delete = new JButton("<html><div style='text-align:left;'>DEL</div></html>");
		delete.setActionCommand("<html><div style='text-align:left; padding-left:-10px;'>DEL</div></html>");
		delete.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		delete.setBounds(20, 115, 60, 60);
		getContentPane().add(delete);
		
		textField = new JTextField();
		textField.setBounds(20, 11, 256, 92);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
}
