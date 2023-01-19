package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import libs.BookingLibs;
import libs.JDBCBooking;
import libs.JDBCRooms;
import libs.RoomLibs;

public class Booking implements MouseListener {
	JFrame frame;
	Object[]columnsName;
	JTable table;
	DefaultTableModel model;
	JTextField bookingtxt, roomidtxt;
	JDateChooser checkin, checkout1;
	JComboBox bookingtypetext;
	JButton booking, roombtn;

	public Booking() {
		frame = new JFrame();
		frame.setTitle("Booking Management System");
		frame.setSize(1200, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(100, 100));
		north.setBackground(new Color(0, 0, 0));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		JLabel title = new JLabel("RECEPTION DASHBOARD");
		title.setBounds(370, 30, 400, 30);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setForeground(Color.white);
		north.add(title);

		
		//++++++++++++++++++=West Panel+++++++++++++++++
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBackground(new Color(0, 0, 0));
		westPanel.setPreferredSize(new Dimension(400, 100));
		frame.add(westPanel, BorderLayout.WEST);
		
		JSeparator s1=new JSeparator();
		s1.setBounds(0,0,400,1);
		westPanel.add(s1);
		
		
		JLabel bookinglbl = new JLabel("Booking ID:");
		bookinglbl.setBounds(20, 50, 200, 20);
		bookinglbl.setFont(new Font("Verdana", Font.PLAIN, 16));
		bookinglbl.setForeground(Color.white);
		westPanel.add(bookinglbl);

		bookingtxt = new JTextField();
		bookingtxt.setBounds(160, 50, 220, 25);
		bookingtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingtxt.setFont(new Font("Verdana", Font.PLAIN, 16));
		westPanel.add(bookingtxt);

		JLabel CheckInlbl = new JLabel("Check-In:");
		CheckInlbl.setBounds(20, 100, 200, 20);
		CheckInlbl.setFont(new Font("Verdana", Font.PLAIN, 16));
		CheckInlbl.setForeground(Color.white);
		westPanel.add(CheckInlbl);

		checkin = new JDateChooser();
		checkin.setDateFormatString("yyyy-MM-dd");
		checkin.setBounds(160, 100, 220, 25);
		checkin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		checkin.setFont(new Font("Verdana", Font.PLAIN, 16));
		westPanel.add(checkin);

		JLabel CheckOutlbl = new JLabel("Check-Out:");
		CheckOutlbl.setBounds(20, 150, 200, 35);
		CheckOutlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		CheckOutlbl.setForeground(Color.white);
		westPanel.add(CheckOutlbl);

		checkout1 = new JDateChooser();
		checkout1.setDateFormatString("yyyy-MM-dd");
		checkout1.setBounds(160, 150, 220, 25);
		checkout1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		checkout1.setFont(new Font("Verdana", Font.PLAIN, 16));
		westPanel.add(checkout1);

		JLabel roomidlbl = new JLabel("Room No:");
		roomidlbl.setBounds(20, 200, 200, 35);
		roomidlbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		roomidlbl.setForeground(Color.white);
		westPanel.add(roomidlbl);

		roomidtxt = new JTextField();
		roomidtxt.setBounds(160, 200, 220, 25);
		roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roomidtxt.setFont(new Font("Verdana", Font.PLAIN, 16));
		westPanel.add(roomidtxt);

		JLabel statuslbl = new JLabel("Status:");
		statuslbl.setBounds(20, 250, 200, 35);
		statuslbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		statuslbl.setForeground(Color.white);
		westPanel.add(statuslbl);

		Object[] h5 = { "Booked", "Not Available" };
		bookingtypetext = new JComboBox(h5);
		bookingtypetext.setBounds(160, 250, 220, 25);
		bookingtypetext.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingtypetext.setFont(new Font("Verdana", Font.PLAIN, 16));
		westPanel.add(bookingtypetext);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 310, 470, 21);
		westPanel.add(separator);
		
		JButton booking=new JButton("Confirm Booking");
		booking.setFocusable(false);
		booking.setBounds(20,350,150,30);
		booking.setBackground(new Color(255,255,255));
		booking.setForeground(Color.black);
		westPanel.add(booking);
		booking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// *********Update Room Status***************
				RoomLibs room = new RoomLibs();

				int room_id1 = Integer.parseInt(roomidtxt.getText());

				room.setRoomno(room_id1);
				room.setRoomstatus("Booked");
				JDBCRooms jdbc1 = new JDBCRooms();
				boolean result1 = jdbc1.update(room);

				// **************Update Customer Booking***********************
				int cusid = Integer.parseInt(bookingtxt.getText());
				
				String bookingtype1 = bookingtypetext.getSelectedItem().toString();
				int room_id = Integer.parseInt(roomidtxt.getText());

				BookingLibs booking = new BookingLibs();

				booking.setBookingid(cusid);
				booking.setRoomno(room_id);
				booking.setBookingstatus(bookingtype1);

				JDBCBooking jdbc = new JDBCBooking();
				boolean result = jdbc.booking_update(booking);

				if (result == true) {
					update();
					JOptionPane.showMessageDialog(null, "The booking is confirmed successfully!");
				}

			}

		});
		
		JButton roombtn=new JButton("Check Rooms");
		roombtn.setFocusable(false);
		roombtn.setBounds(200,350,150,30);
		roombtn.setBackground(new Color(255,255,255));
		roombtn.setForeground(Color.black);
		westPanel.add(roombtn);
		roombtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Available_Rooms();
				
			}
			
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		// ********************Center Booking Table*********************
		columnsName = new Object[7];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Check-In";
		columnsName[2] = "CheckOut";
		columnsName[3] = "Booking Type";
		columnsName[4] = "Room No";
		columnsName[5] = "Customer ID";
		columnsName[6] = "Status";
		

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
        table.addMouseListener(this);

		update();
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(400,20,500,400);
		frame.add(scroll, BorderLayout.CENTER);

		frame.setVisible(true);
	}
	
	
	private void update() {
		 JDBCBooking jdbc = new JDBCBooking();
			ArrayList select = jdbc.reception_view();
			model.setRowCount(0);
			if (select.size() > 0) {
	            for (int i = 0; i < select.size(); i++) {
	                BookingLibs tmp_person = (BookingLibs) select.get(i);
	                
	                Vector tmpPerson = new Vector();
	                
	                tmpPerson.add(tmp_person.getBookingid());
	                tmpPerson.add(tmp_person.getCheckindate());
	                tmpPerson.add(tmp_person.getCheckoutdate());
	                tmpPerson.add(tmp_person.getBookingType());
	                tmpPerson.add(tmp_person.getRoomno());
	                tmpPerson.add(tmp_person.getCustid());
	                tmpPerson.add(tmp_person.getBookingstatus());
	                
	               
	                
	                model.addRow(tmpPerson);
	            }
	        }
	    }
	
	
	
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == table) {

			try {
				int h2 = table.getSelectedRow();

				TableModel model = table.getModel();

				String name = model.getValueAt(h2, 0).toString();
				bookingtxt.setText(name);

				Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h2, 1));
				checkin.setDate(date);

				Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h2, 2));
				checkout1.setDate(date2);

			} catch (Exception ex) {
				System.out.println("Erro" + ex.getMessage());
			}

		}

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Booking();

	}


	

}
