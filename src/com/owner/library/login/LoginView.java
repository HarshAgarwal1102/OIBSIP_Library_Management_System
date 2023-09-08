package com.owner.library.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class LoginView extends JFrame implements ActionListener {

	public static void main(String args[]) {
		LoginView r = new LoginView();
		r.setVisible(true);
		r.setSize(1000, 600);
		r.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	JLabel l1, l2, l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;

	public LoginView() {
		
		setTitle("Library Managment App");
		JLabel label = new JLabel(new ImageIcon(LoginView.class.getResource("/assets/lib8.jpg")));
		label.setBounds(0, 0, 1000, 667);
		getContentPane().add(label);
		
		l3 = new JLabel("L I B R A R Y");
		label.add(l3);
		l3.setFont(new Font("Rockwell Nova Light", Font.BOLD , 50));
		l3.setForeground(Color.WHITE);
		l3.setBounds(350, 80, 500, 44);
		
		Font font = new Font("Arial",Font.BOLD,17);
		
		l1 = new JLabel("Username:");
		label.add(l1);
		l1.setBounds(350, 230, 140, 30);
		l1.setFont(font);
		l1.setForeground(Color.WHITE);
		
		l2 = new JLabel("Password:");
		label.add(l2);
		l2.setBounds(350, 308, 140, 30);
		l2.setFont(font);
		l2.setForeground(Color.WHITE);
		
		b1 = new JButton("Login");
		label.add(b1);
		b1.setFont(font);
		b1.setBounds(310, 419, 130, 30);
		b1.addActionListener(this);

		b2 = new JButton("Exit");
		label.add(b2);
		b2.setFont(font);
		b2.setBounds(550, 419, 130, 30);
		b2.addActionListener(this);

		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		t1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.add(t1);
		t1.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 17));
		t1.setBounds(500, 230, 147, 30);

		t2 = new JPasswordField();
		t2.setHorizontalAlignment(SwingConstants.CENTER);
		t2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.add(t2);
		t2.setFont(font);
		t2.setBounds(500, 310, 147, 30);

		getContentPane().setLayout(null);
		setVisible(true);
		setSize(1000, 600);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent ae) {
		String tf1 = t1.getText();
		String tf2 = t2.getText();

		String s = ae.getActionCommand();
		if (s.equals("Login")) {
			if (tf1.equals("admin") && tf2.equals("admin")) {
				new Home();
				setVisible(false);
				dispose();
				
				
			} else {
				JOptionPane.showMessageDialog(null, "Wrong ID or Password");
			}
		}
		if (s.equals("Exit")) {
			System.exit(0);
		}
	}
}