package calculator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Fenster extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	
	/**
	 * Create the frame.
	 */
	public Fenster() {
		setMinimumSize(new Dimension(300, 400));
		
		setResizable(true);
		setSize(new Dimension(100, 220));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setText("");
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(80, 40));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 4, 5, 5));
		
		JButton delete = new JButton("DEL");
		delete.setMinimumSize(new Dimension(80, 40));
		delete.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(delete);
		
		JButton clearEntry = new JButton("CE");
		clearEntry.setMinimumSize(new Dimension(80, 40));
		clearEntry.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(clearEntry);
		
		JButton percent = new JButton("%");
		percent.setMinimumSize(new Dimension(80, 40));
		percent.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(percent);
		
		JButton divide = new JButton("/");
		divide.setMinimumSize(new Dimension(80, 40));
		divide.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(divide);
		
		JButton seven = new JButton("7");
		seven.setMinimumSize(new Dimension(80, 40));
		seven.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(seven);
		
		JButton eight = new JButton("8");
		eight.setMinimumSize(new Dimension(80, 40));
		eight.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(eight);
		
		JButton nine = new JButton("9");
		nine.setMinimumSize(new Dimension(80, 40));
		nine.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(nine);
		
		JButton times = new JButton("x");
		times.setMinimumSize(new Dimension(80, 40));
		times.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(times);
		
		JButton four = new JButton("4");
		four.setMinimumSize(new Dimension(80, 40));
		four.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(four);
		
		JButton five = new JButton("5");
		five.setMinimumSize(new Dimension(80, 40));
		five.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(five);
		
		JButton six = new JButton("6");
		six.setMinimumSize(new Dimension(80, 40));
		six.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(six);
		
		JButton minus = new JButton("-");
		minus.setMinimumSize(new Dimension(80, 40));
		minus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(minus);
		
		JButton one = new JButton("1");
		one.setMinimumSize(new Dimension(80, 40));
		one.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(one);
		
		JButton two = new JButton("2");
		two.setMinimumSize(new Dimension(80, 40));
		two.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(two);
		
		JButton three = new JButton("3");
		three.setMinimumSize(new Dimension(80, 40));
		three.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(three);
		
		JButton plus = new JButton("+");
		plus.setMinimumSize(new Dimension(80, 40));
		plus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(plus);
		
		JButton negate = new JButton("+/-");
		negate.setMinimumSize(new Dimension(80, 40));
		negate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(negate);
		
		JButton zero = new JButton("0");
		zero.setMinimumSize(new Dimension(80, 40));
		zero.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(zero);
		
		JButton comma = new JButton(",");
		comma.setMinimumSize(new Dimension(80, 40));
		comma.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(comma);
		
		JButton equals = new JButton("=");
		equals.setMinimumSize(new Dimension(80, 40));
		equals.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		panel.add(equals);

	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	public void addButtonListener(ActionListener listener) {
		for (Component c : getContentPane().getComponents()) {
			if (c instanceof JPanel) {
				for (Component btn : ((JPanel) c).getComponents()) {
					if (btn instanceof JButton) {
						((JButton) btn).addActionListener(listener);
					}
				}
			}
		}
	}
}
