package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import libs.Customer_Libs;
import libs.JDBC_Customer;




public class Search_Customers {
	
	JFrame frame;
	JLabel customer;
	 JTable table;
	 JButton btn;
	 JScrollPane scrollPane;
	 DefaultTableModel modeltable;
	 JTextField searchField;
	 TableRowSorter sorter;
	 
	public Search_Customers() {
		frame=new JFrame("CUSTOMER DETAILS");
		frame.setSize(1250,600);

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel north=new JPanel();
		north.setBackground(new Color(0,0,0));
		north.setPreferredSize(new Dimension(100,80));
		north.setLayout(null);
		frame.getContentPane().add(north, BorderLayout.NORTH);
		
		customer=new JLabel("SEARCH CUSTOMER DETAILS", SwingConstants.CENTER);
		customer.setBounds(700,20,500,35);
		customer.setForeground(Color.white);
		customer.setFont(new Font("Verdana", Font.BOLD, 25));
		north.add(customer);
		
		JLabel searchlbl=new JLabel("Search Customers: ");
		searchlbl.setBounds(10,20,210,35);
		searchlbl.setForeground(Color.white);
		searchlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(searchlbl);
		
		searchField=new JTextField();
		searchField.setBorder(BorderFactory.createLineBorder(Color.white,1));
		searchField.setFont(new Font("Times New Roman",Font.PLAIN,18));
		searchField.setBounds(210,20,200,30);
		north.add(searchField);
		
		
		
		
		modeltable = new DefaultTableModel();
		
		
		table = new JTable(modeltable);
		JTableHeader h1=table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		h1.setFont(new Font("Verdana", Font.BOLD,15));
		table.setFont(new Font("Verdana", Font.PLAIN,16));
		table.setRowHeight(20);
		table.setSelectionBackground(Color.BLACK);
		table.setSelectionForeground(Color.white);
		
		modeltable.addColumn("ID");
		modeltable.addColumn("Name");
		modeltable.addColumn("Country");
		modeltable.addColumn("Address");
		modeltable.addColumn("Email");
		modeltable.addColumn("Password");
		modeltable.addColumn("Phone");
		modeltable.addColumn("Creadit Number");
		modeltable.addColumn("Gender");
		
		
		sorter = new TableRowSorter<>(modeltable);
		table.setRowSorter(sorter);
		
		JDBC_Customer jdbc2 = new JDBC_Customer();
		ArrayList select = jdbc2.customer_view();
		if(select.size()>0) {
			for(int i=0; i<select.size(); i++) {
				Customer_Libs p = (Customer_Libs) select.get(i);
				Object []tmp= {p.getCustId(), 
								p.getCustomer_Name(), 
								p.getCountry(),
								p.getAddress(),	
								p.getEmail(),
								p.getCreate_password(),							
								p.getPhone(),
								p.getCreaditcard_Number(),
								p.getGender()
								
								
															
								

				};
				modeltable.addRow(tmp);
			}
		}
		scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);
		
		searchField.getDocument().addDocumentListener(new DocumentListener() {
	         @Override
	         public void insertUpdate(DocumentEvent e) {
	            search(searchField.getText());
	         }
	         @Override
	         public void removeUpdate(DocumentEvent e) {
	            search(searchField.getText());
	         }
	         @Override
	         public void changedUpdate(DocumentEvent e) {
	            search(searchField.getText());
	         }
	         
	         
	         public void search(String str) {
	            if (str.length() == 0) {
	               sorter.setRowFilter(null);
	            } else {
	               sorter.setRowFilter(RowFilter.regexFilter(str));
	            }
	         }
	      });
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Search_Customers();
		

	}
}