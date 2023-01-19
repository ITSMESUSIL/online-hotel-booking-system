package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import libs.BookingLibs;
import libs.Global;
import libs.JDBCBooking;




public class Customer_Dashboard extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookRoomOnline;
	JTable table;
	DefaultTableModel dm;
	JLabel idLabel;
	JButton completebook;
	JDateChooser checkin, checkout, bookingdate;
	
	JComboBox roomtype;
	Object[]column;
	ArrayList a1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Dashboard frame = new Customer_Dashboard();
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
	public Customer_Dashboard() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 667);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.CYAN, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 2, true));
		panel.setBackground(Color.BLACK);
		panel.setBounds(63, 93, 897, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Booking Date");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(148, 34, 112, 15);
		panel.add(lblNewLabel_1);
		
		Date date= new Date();
		
		bookingdate = new JDateChooser();
		bookingdate.setMinSelectableDate(date);
		bookingdate.setDateFormatString("yyyy-MM-dd");
		bookingdate.setBorder(null);
		bookingdate.setBounds(270, 21, 127, 28);
		panel.add(bookingdate);
		
		JLabel lblNewLabel = new JLabel("Check-In");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(148, 114, 83, 28);
		panel.add(lblNewLabel);
		
		checkin = new JDateChooser();
		checkin.setMinSelectableDate(date);
		checkin.setDateFormatString("yyyy-MM-dd");
		checkin.setBorder(null);
		checkin.setBounds(270, 114, 127, 28);
		date.equals(checkin);
		panel.add(checkin);
		
		JLabel lblNewLabel_2 = new JLabel("Booking_Type");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(516, 37, 112, 18);
		panel.add(lblNewLabel_2);
		
		
		idLabel = new JLabel("sushil");
		idLabel.setVisible(false);
		idLabel.setText(Integer.toString(Global.currentUser.getCustId()));   
		idLabel.setForeground(Color.GRAY);
		idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		idLabel.setBounds(516, 55, 112, 18);
		panel.add(idLabel);
		
		
		JLabel welcome = new JLabel("Welcome:");
		welcome.setForeground(Color.white);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		welcome.setBounds(10, 10, 112, 18);
		contentPane.add(welcome);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText(Global.currentUser.getCustomer_Name());
		nameLabel.setForeground(Color.white);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameLabel.setBounds(90, 10, 200, 18);
		contentPane.add(nameLabel);
		
		String data[]= {"", "Single bed ", "Double bed"};
		roomtype = new JComboBox(data);		
		roomtype.setForeground(Color.GRAY);
		roomtype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		roomtype.setBorder(null);
		roomtype.setBounds(675, 27, 124, 28);
		panel.add(roomtype);
		
		JLabel lblNewLabel_4 = new JLabel("Check-Out\r\n");
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(516, 117, 78, 23);
		panel.add(lblNewLabel_4);
		
		checkout = new JDateChooser();
		checkout.setMinSelectableDate(date);
		checkout.setDateFormatString("yyyy-MM-dd");
		checkout.setBorder(null);
		checkout.setBounds(675, 114, 124, 28);
		panel.add(checkout);
		
		
		
		completebook = new JButton("Request Booking\r\n");
		completebook.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				
				if(ae.getSource()==completebook) {
					
//					Room room=new Room();
//					
//					String bookingtype=bookingtypetxt.getSelectedItem().toString();
//		                      
//		            room.setStatus(bookingtype);
//		            
//		            
//		            JDBCRoom jdbc1=new JDBCRoom();
//		            boolean result1=jdbc1.update1(room);
		            

					int cusid=Integer.parseInt(idLabel.getText());
					String str1 = ((JTextField)checkin.getDateEditor().getUiComponent()).getText();
		            String str2 = ((JTextField)checkout.getDateEditor().getUiComponent()).getText();
		            String str3=((JTextField)bookingdate.getDateEditor().getUiComponent()).getText();		     
		            String bookingtype=roomtype.getSelectedItem().toString();
		            
		            
		            
		            
		                   
		            BookingLibs booking=new BookingLibs();
		            
		            booking.setCustid(cusid);
		            booking.setCheckindate(str1);
		            booking.setCheckoutdate(str2);
		            booking.setBookingdate(str3);
		            booking.setBookingType(bookingtype);
		            booking.setBookingstatus("Pending");
		            
		            
		            JDBCBooking jdbc=new JDBCBooking();
		            boolean result=jdbc.insert(booking);
		            
		            if(result==true) {
		            	
		            	JOptionPane.showMessageDialog(null, "The booking is requested successfully!");
		            }

				
				}
			}
				
			
		
	
		});
		
		
		completebook.setForeground(Color.WHITE);
		completebook.setBorder(new LineBorder(Color.CYAN, 3));
		completebook.setBackground(Color.BLACK);
		completebook.setFont(new Font("Agency FB", Font.BOLD, 16));
		completebook.setBounds(63, 334, 173, 38);
		contentPane.add(completebook);
		
		JButton btnNewButton_1 = new JButton("Update your Booking");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(new LineBorder(Color.CYAN, 3));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnNewButton_1.setBounds(311, 334, 241, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Free Cancellation");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(new LineBorder(Color.CYAN, 3));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnNewButton_2.setBounds(609, 334, 207, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Booking Condition");
		btnNewButton_3.setBorder(new LineBorder(Color.CYAN, 3));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnNewButton_3.setBounds(854, 603, 201, 27);
		contentPane.add(btnNewButton_3);
		
		final JButton btnclose = new JButton("X");
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null, "do you want to close this app","confirmation",JOptionPane.YES_NO_OPTION)==0) {
						Customer_Dashboard.this.dispose();
					}
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnclose.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnclose.setForeground(Color.white);
			}
		});
		btnclose.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnclose.setForeground(Color.WHITE);
		btnclose.setBackground(Color.BLACK);
		btnclose.setBounds(966, 10, 77, 21);
		contentPane.add(btnclose);
		
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(60, 410, 897, 2);
		contentPane.add(separator_1);
		
		final JButton btnlogout = new JButton("LogOut");
		btnlogout.setForeground(Color.WHITE);
		btnlogout.setBackground(Color.BLACK);
		btnlogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnlogout.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnlogout.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "do you want logout!","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					Customer_Dashboard.this.dispose();
					Login_GUI nl= new Login_GUI();
					
				}
			}
		});
		btnlogout.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnlogout.setBounds(871, 12, 85, 21);
		contentPane.add(btnlogout);
		
		txtBookRoomOnline = new JTextField();
		txtBookRoomOnline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBookRoomOnline.setForeground(Color.WHITE);
		txtBookRoomOnline.setBorder(null);
		txtBookRoomOnline.setBackground(Color.BLACK);
		txtBookRoomOnline.setText("Book  Your Room Online");
		txtBookRoomOnline.setBounds(382, 49, 165, 19);
		contentPane.add(txtBookRoomOnline);
		txtBookRoomOnline.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("LUTON HOTEL");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("ROG Fonts", Font.BOLD, 25));
		lblNewLabel_3.setBounds(344, 0, 251, 39);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(354, 38, 217, 2);
		contentPane.add(separator_2);
		
		
		dm=new DefaultTableModel();
		
		
		
		
		
		dm.addColumn("ID");
		dm.addColumn("Booking Date");
		dm.addColumn("Check In");
		dm.addColumn("Check Out");
		dm.addColumn("Room No");
		dm.addColumn("Booking Status");
	
		
		table=new JTable(dm);
		JTableHeader h1=table.getTableHeader();
		h1.setBackground(Color.black);
		h1.setForeground(Color.white);
		loadtable();
		
		JButton refreshbtn = new JButton("Refresh");
		refreshbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				loadtable();
			}
		});
		refreshbtn.setForeground(Color.WHITE);
		refreshbtn.setFont(new Font("Agency FB", Font.BOLD, 16));
		refreshbtn.setBorder(new LineBorder(Color.CYAN, 3));
		refreshbtn.setBackground(Color.BLACK);
		refreshbtn.setBounds(820, 59, 140, 38);
		contentPane.add(refreshbtn);
		

		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(63, 439, 897, 124);
		contentPane.add(scroll);
		setLocationRelativeTo(null);
		loadtable();
		
		
		
		
	}
	public void loadtable() {
		
		JDBCBooking jdbc=new JDBCBooking();
		ArrayList a1=jdbc.view_all();
		if(a1.size()>0) {
			for(int i=0; i<a1.size(); i++) {
				BookingLibs booking=(BookingLibs) a1.get(i);
				Object [] tmp= {booking.getBookingid(),
						booking.getBookingdate(),
						booking.getCheckindate(),
						booking.getCheckoutdate(),
						booking.getRoomno(),
						booking.getBookingstatus()
						
						
						
						};
				
				dm.addRow(tmp);
				
				
				
			}
			
		}
		}
	
	
	
	
}
