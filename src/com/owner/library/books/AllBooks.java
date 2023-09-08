package com.owner.library.books;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.owner.library.login.Home;
import com.owner.library.utils.Coon;

public class AllBooks extends JFrame implements ActionListener{

		DefaultTableModel model = new DefaultTableModel();
		JFrame frame = new JFrame("View All Books");
		JTable jtbl = new JTable(model);
		JLabel l1;
		JButton b1;

		public AllBooks() {
			
			model.addColumn("Book Name");
			model.addColumn("Book ID");
			model.addColumn("Author");
			model.addColumn("Price");

			l1 = new JLabel("Books Record");
			add(l1);
			l1.setBounds(400,30,400,30);
			l1.setFont(new Font("Rockwell Nova Light", Font.BOLD , 35));
			
			b1 = new JButton("Back");
			add(b1);
			b1.setBounds(450,520,120,30);
			b1.addActionListener(this);
			
			setLayout(null);
			setVisible(true);
			setSize(1000, 667);
			setLocationRelativeTo(null);
			
			try {
				Coon conn = new Coon();

				String sql = "select * from Book";
				PreparedStatement ps = conn.c.prepareStatement(sql);

				ResultSet Rs = ps.executeQuery();
				while (Rs.next()) {
					model.addRow(new Object[] { Rs.getString(1), Rs.getString(2), Rs.getString(3), Rs.getString(4) });
				}
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

			JScrollPane pg = new JScrollPane(jtbl);
			pg.setBounds(50,100,900,400);
			pg.setOpaque(false);
			pg.getViewport().setOpaque(false);
			add(pg);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String sa = e.getActionCommand();
			if (sa.equals("Back")) {
				new AddBook();
				setVisible(false);
				dispose();
			}
		}
	}