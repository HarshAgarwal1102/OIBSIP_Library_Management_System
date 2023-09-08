package com.owner.library.books;

import java.awt.Container;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.owner.library.utils.Coon;

public class ViewBook extends JFrame {

	DefaultTableModel model = new DefaultTableModel();
	Container co = getContentPane();
	JTable jtbl = new JTable(model);

	public ViewBook() {
		
		model.addColumn("Book ID");
		model.addColumn("Book Name");
		model.addColumn("Author");
		model.addColumn("Price");
		
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
}