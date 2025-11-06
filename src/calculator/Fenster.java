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

public class Fenster extends JFrame {

	private static final long serialVersionUID = 1L;

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
		setSize(new Dimension(320, 450));
		getContentPane().setBounds(new Rectangle(0, 0, 400, 700));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton.setBounds(20, 130, 60, 60);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_1.setBounds(85, 130, 60, 60);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_2.setBounds(150, 130, 60, 60);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3.setBounds(20, 195, 60, 60);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("5");
		btnNewButton_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1.setBounds(85, 195, 60, 60);
		getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_1 = new JButton("6");
		btnNewButton_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_1.setBounds(150, 195, 60, 60);
		getContentPane().add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_1_2 = new JButton("1");
		btnNewButton_3_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_2.setBounds(20, 260, 60, 60);
		getContentPane().add(btnNewButton_3_1_2);
		
		JButton btnNewButton_3_1_3 = new JButton("2");
		btnNewButton_3_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_3.setBounds(85, 260, 60, 60);
		getContentPane().add(btnNewButton_3_1_3);
		
		JButton btnNewButton_3_1_4 = new JButton("3");
		btnNewButton_3_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_4.setBounds(150, 260, 60, 60);
		getContentPane().add(btnNewButton_3_1_4);
		
		JButton btnNewButton_3_1_5 = new JButton("0");
		btnNewButton_3_1_5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_5.setBounds(20, 325, 125, 60);
		getContentPane().add(btnNewButton_3_1_5);
		
		JButton btnNewButton_3_1_6 = new JButton(",");
		btnNewButton_3_1_6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6.setBounds(150, 325, 60, 60);
		getContentPane().add(btnNewButton_3_1_6);
		
		JButton btnNewButton_3_1_6_1 = new JButton("=");
		btnNewButton_3_1_6_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1.setBounds(215, 325, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1);
		
		JButton btnNewButton_3_1_6_1_1 = new JButton("x");
		btnNewButton_3_1_6_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1_1.setBounds(215, 130, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1_1);
		
		JButton btnNewButton_3_1_6_1_2 = new JButton("-");
		btnNewButton_3_1_6_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1_2.setBounds(215, 195, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1_2);
		
		JButton btnNewButton_3_1_6_1_3 = new JButton("+");
		btnNewButton_3_1_6_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1_3.setBounds(215, 260, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1_3);
		
		JButton btnNewButton_3_1_6_1_4 = new JButton("/");
		btnNewButton_3_1_6_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1_4.setBounds(215, 65, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1_4);
		
		JButton btnNewButton_3_1_6_1_4_1 = new JButton("C");
		btnNewButton_3_1_6_1_4_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1_4_1.setBounds(150, 65, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1_4_1);
		
		JButton btnNewButton_3_1_6_1_4_2 = new JButton("CE");
		btnNewButton_3_1_6_1_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1_4_2.setBounds(85, 65, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1_4_2);
		
		JButton btnNewButton_3_1_6_1_4_3 = new JButton("<html><div style='text-align:left;'>DEL</div></html>");
		btnNewButton_3_1_6_1_4_3.setActionCommand("<html><div style='text-align:left; padding-left:-10px;'>DEL</div></html>");
		btnNewButton_3_1_6_1_4_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnNewButton_3_1_6_1_4_3.setBounds(20, 65, 60, 60);
		getContentPane().add(btnNewButton_3_1_6_1_4_3);

	}
}
