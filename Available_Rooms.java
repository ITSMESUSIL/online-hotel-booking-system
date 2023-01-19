package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import libs.JDBCRooms;
import libs.RoomLibs;

public class Available_Rooms {
	JFrame frame;
	Object[]columnsName;
	JTable table;
	DefaultTableModel model;
	
	public Available_Rooms() {
		
		frame = new JFrame();
		frame.setTitle("Available Rooms");
		frame.setSize(400, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(100, 60));
		north.setBackground(new Color(0, 0, 0));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		JLabel title = new JLabel("Available Rooms");
		title.setBounds(100, 15, 400, 30);
		title.setFont(new Font("Tahoma", Font.BOLD, 18));
		title.setForeground(Color.white);
		north.add(title);
		
		
		columnsName = new Object[4];
		columnsName[0] = "Room ID";
		columnsName[1] = "Room Type";
		columnsName[2] = "Rate";
		columnsName[3]="RoomStatus";
		
		

		table = new JTable();
		
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		
		table.setGridColor(Color.white);
		table.setRowHeight(25);
		JTableHeader h1 = table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		h1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        table.setSelectionBackground(Color.black);
        table.setSelectionForeground(Color.white);
       

		update();
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(400,20,500,400);
		frame.add(scroll, BorderLayout.CENTER);
		
		
		
		frame.setVisible(true);
	}
	
	
	private void update() {
		 JDBCRooms jdbc = new JDBCRooms();
			ArrayList select = jdbc.room_view();
			model.setRowCount(0);
			if (select.size() > 0) {
	            for (int i = 0; i < select.size(); i++) {
	                RoomLibs tmp_person = (RoomLibs) select.get(i);
	                
	                Vector tmpPerson = new Vector();
	                
	                tmpPerson.add(tmp_person.getRoomno());
	                tmpPerson.add(tmp_person.getRoomtype());
	                tmpPerson.add(tmp_person.getRate());
	                tmpPerson.add(tmp_person.getRoomstatus());
	                
	                
	               
	                
	                model.addRow(tmpPerson);
	            }
	        }
	    }

	public static void main(String[] args) {
		new Available_Rooms();

	}

}
