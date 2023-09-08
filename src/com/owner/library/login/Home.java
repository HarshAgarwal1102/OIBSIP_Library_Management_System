package com.owner.library.login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.owner.library.books.AddBook;
import com.owner.library.books.AllBooks;
import com.owner.library.books.IssueBook;
import com.owner.library.books.ReturnBook;
import com.owner.library.student.AddStudent;

public class Home extends JFrame implements ActionListener {
	
	JLabel label, l1;
	JButton b1, b2, b3, b4, b5, b6, b9, b10;
	Container con;

	public static void main(String args[]) {
		new Home();
	}

	public Home() {
		
		setTitle("Main menu");
		
		con = getContentPane();
		JLabel label = new JLabel(new ImageIcon(Home.class.getResource("/assets/lib2.jpg")));
		label.setBounds(0, 0, 1000, 667);
		getContentPane().add(label);
		
		l1 = new JLabel("Main Menu");
		l1.setBounds(400, 100, 300, 60);
		label.add(l1);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Rockwell Nova Light", Font.BOLD ,45));
		
		Font font = new Font("ARIAL", Font.BOLD , 15);

		b1 = new JButton("Return Book");
		label.add(b1);
		b1.setFont(font);
		b1.setBounds(190, 200, 300, 35);
		b1.addActionListener(this);

		b2 = new JButton("Add Student / Search Student");
		label.add(b2);
		b2.setFont(font);
		b2.setBounds(550, 200, 300, 35);
		b2.addActionListener(this);

		b3 = new JButton("Issuee Book");
		label.add(b3);
		b3.setFont(font);
		b3.setBounds(190, 300, 300, 35);
		b3.addActionListener(this);

		b9 = new JButton("Logout");
		label.add(b9);
		b9.setFont(font);
		b9.setBounds(350, 400, 300, 35);
		b9.addActionListener(this);


		b10 = new JButton("Add Books / Search Book");
		label.add(b10);
		b10.setFont(font);
		b10.setBounds(550, 300, 300, 35);
		b10.addActionListener(this);
		
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(1000, 600);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();

		if (s.equals("Add Books / Search Book")) {
			new AddBook();
			setVisible(false);
			dispose();
		}

		if (s.equals("Add Student / Search Student")) {
			new AddStudent();
			setVisible(false);
			dispose();
		}

		if (s.equals("Issuee Book")) {
			new IssueBook();
			setVisible(false);
			dispose();
		}

		if (s.equals("Return Book")) {
			new ReturnBook();
			setVisible(false);
			dispose();
		}
		
		if (s.equals("Logout")) {
			System.exit(0);
		}
	}
}