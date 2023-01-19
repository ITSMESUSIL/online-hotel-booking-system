package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

import libs.JDBCRooms;
import libs.RoomLibs;




public class Search_Rooms {
	
	JFrame frame;
	JLabel customer;
	 JTable table;
	 JButton btn;
	 JScrollPane scrollPane;
	 DefaultTableModel modeltable;
	 JTextField searchField;
	 TableRowSorter sorter;
	 
	public Search_Rooms() {
		frame=new JFrame("CUSTOMER ROOMS");
		frame.setSize(1250,600);

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel north=new JPanel();
		north.setBackground(new Color(0,0,0));
		north.setPreferredSize(new Dimension(100,80));
		north.setLayout(null);
		frame.getContentPane().add(north, BorderLayout.NORTH);
		
		customer=new JLabel("SEARCH ROOM DETAILS", SwingConstants.CENTER);
		customer.setBounds(700,20,500,35);
		customer.setForeground(Color.white);
		customer.setFont(new Font("Verdana", Font.BOLD, 25));
		north.add(customer);
		
		JLabel searchlbl=new JLabel("Search Rooms: ");
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
		
		modeltable.addColumn("Room No");
		modeltable.addColumn("Room Type");
		modeltable.addColumn("Room Rate");
		modeltable.addColumn("Room Status");
		
		
		
		sorter = new TableRowSorter<>(modeltable);
		table.setRowSorter(sorter);
		
		JDBCRooms jdbc2 = new JDBCRooms();
		ArrayList select = jdbc2.room_viewall();
		if(select.size()>0) {
			for(int i=0; i<select.size(); i++) {
				RoomLibs p = (RoomLibs) select.get(i);
				Object []tmp= {p.getRoomno(), 
								p.getRoomtype(), 
								p.getRate(),
								p.getRoomstatus(),	
								
								
								
															
								

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
		new Search_Rooms();
		

	}
}