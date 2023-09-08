package com.owner.library.student;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.owner.library.login.Home;
import com.owner.library.utils.Coon;

public class AddStudent extends JFrame implements ActionListener {
	
	JLabel l11, l12, l13, l14, l15, l16, l17, label;
	JTextField t11, t12, t13, t14;
	JButton b1, b2, b3, b4, b5;
	JComboBox<Object> c1, c2, c3;
	Container con;

	public static void main(String args[]) {
		new AddStudent();
	}


	public AddStudent() {
		
		setTitle("Add Student");
		
		con = getContentPane();
		label = new JLabel(new ImageIcon(AddStudent.class.getResource("/assets/lib6.jpg")));
		label.setBounds(0, 0, 1000, 667);
		getContentPane().add(label);
		
		Font font = new Font("ARIAL", Font.BOLD , 15);
		
		l11 = new JLabel(" ADD STUDENTS ");
		label.add(l11);
		l11.setBounds(391, 21, 360, 60);
		l11.setFont(new Font("Rockwell Nova Light", Font.BOLD , 35));
		l11.setForeground(Color.WHITE);

		l12 = new JLabel("Student ID : ");
		label.add(l12);
		l12.setBounds(150, 100, 140, 30);
		l12.setFont(font);
		l12.setForeground(Color.WHITE);

		l13 = new JLabel("Student Name : ");
		label.add(l13);
		l13.setBounds(150, 170, 140, 30);
		l13.setFont(font);
		l13.setForeground(Color.WHITE);

		l14 = new JLabel("Branch & Year : ");
		label.add(l14);
		l14.setBounds(150, 240, 140, 30);
		l14.setFont(font);
		l14.setForeground(Color.WHITE);

		l15 = new JLabel("Department : ");
		label.add(l15);
		l15.setBounds(150, 310, 140, 30);
		l15.setFont(font);
		l15.setForeground(Color.WHITE);

		l16 = new JLabel("Mobile No : ");
		label.add(l16);
		l16.setBounds(150, 380, 140, 30);
		l16.setFont(font);
		l16.setForeground(Color.WHITE);
		
		l17 = new JLabel("Search by ID :");
		label.add(l17);
		l17.setBounds(650, 220, 140, 60);
		l17.setFont(font);
		l17.setForeground(Color.WHITE);

		t11 = new JTextField();
		label.add(t11);
		t11.setBounds(270, 100, 120, 30);
		t11.setFont(font);

		t12 = new JTextField();
		label.add(t12);
		t12.setBounds(270, 170, 220, 30);
		t12.setFont(font);
		
		t13 = new JTextField();
		t13.setBounds(270, 380, 220, 30);
		t13.setFont(new Font("Dialog", Font.BOLD, 15));
		label.add(t13);
		
		t14 = new JTextField();
		t14.setBounds(780, 235, 130, 30);
		t14.setFont(new Font("Dialog", Font.PLAIN, 15));
		label.add(t14);

		c1 = new JComboBox<Object>();
		label.add(c1);
		c1.setFont(font);
		c1.setBounds(270, 240, 110, 30);
		c1.setModel(new DefaultComboBoxModel<Object>(new String[] { "BE", "SE", "TE", "BTECH" }));

		c2 = new JComboBox<Object>();
		label.add(c2);
		c2.setFont(font);
		c2.setBounds(390, 240, 100, 30);
		c2.setModel(new DefaultComboBoxModel<Object>(new String[] { "1st", "2nd", "3rd", "4th" }));

		c3 = new JComboBox<Object>();
		label.add(c3);
		c3.setFont(font);
		c3.setBounds(270, 310, 120, 30);
		c3.setModel(new DefaultComboBoxModel<Object>(new String[] {"CS", "IT", "Civil", "Mechnical", "Electrical" }));

		b1 = new JButton("Save");
		label.add(b1);
		b1.setFont(font);
		b1.setBounds(150, 466, 120, 30);
		
		b2 = new JButton("View All Students");
		label.add(b2);
		b2.setFont(font);
		b2.setBounds(650, 350, 250, 30);

		b3 = new JButton("Cancel");
		label.add(b3);
		b3.setFont(font);
		b3.setBounds(380, 466, 120, 30);
		
		b4 = new JButton("Search");
		label.add(b4);
		b4.setFont(font);
		b4.setBounds(650, 290, 100, 30);

		b5 = new JButton("Delete");
		label.add(b5);
		b5.setFont(font);
		b5.setBounds(800, 290, 100, 30);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(1000, 600);
		setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent ae) {
		String sa = ae.getActionCommand();
		if (sa.equals("Save")) {
			try {
				Coon conn = new Coon();

				String sql = "insert into student values(?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.c.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(t11.getText()));
				ps.setString(2, t12.getText());
				ps.setString(3, (String) c1.getSelectedItem());
				ps.setString(4, (String) c2.getSelectedItem());
				ps.setString(5, (String) c3.getSelectedItem());
				ps.setString(6, t13.getText());

				int rs = ps.executeUpdate();
				if (rs > 0) {
					JOptionPane.showMessageDialog(null, "Student Successfully Added");					
				}
				else {
					JOptionPane.showMessageDialog(null, "Error");					
				}
				
				t11.setText("");
				t12.setText("");
				t13.setText("");
				
				ps.close();
				conn.c.close();
			} 
			catch (Exception e) {
				System.out.println(e);

				JOptionPane.showMessageDialog(null, "Error!!! All Fileds Required Or ID Is SAME");
			}
		}

		if (sa.equals("Search")) {
			try {
				Coon conn = new Coon();
				String s1;
				s1 = t14.getText();

				conn.c.createStatement();
				PreparedStatement ps = conn.c.prepareStatement("select * from Student where Student_Id=(?)");
				ps.setString(1, s1);

				ResultSet Rs = ps.executeQuery();
				if (Rs.next()) {
					JOptionPane.showMessageDialog(null,
							"Student Name : " + Rs.getString(2) +"\n"+ "Student ID : " + Rs.getString(1) +"\n"+ "Branch & Year : "
									+ Rs.getString(3) +" "+ Rs.getString(4) +"\n"+ "Department : " + Rs.getString(5));
				} 
				else {
					JOptionPane.showMessageDialog(null, "Error!!! ID Is Not Present");					
				}
				ps.close();
				conn.c.close();
			} 
			
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "BOOK IS NOT ISSUEED ON THIS ID.:");
			}
		}

		if (sa.equals("Delete")) {
			try {
				Coon conn = new Coon();

				String sql = "delete from Student where Student_Id = '" + t14.getText() + "'";
				PreparedStatement st = conn.c.prepareStatement(sql);

				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you Want to Delete?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (response == JOptionPane.YES_OPTION) {
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Student Removed Successfully...");
					t14.setText("");
				} 
				else if (response == JOptionPane.CLOSED_OPTION) {
					
				}
				st.close();
				conn.c.close();
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}

		if (sa.equals("Cancel")) {
			new Home();
			setVisible(false);
			dispose();
		}
		
		if (sa.equals("View All Students")) {
			new ViewStudent();
			setVisible(false);
			dispose();
		}
	}
}