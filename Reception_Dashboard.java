package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import libs.Global;

public class Reception_Dashboard {

	protected static final Color COLOR = null;
	JFrame frame;
	JLabel BookingLabel, CustomerLabel;

	public Reception_Dashboard() {
		frame = new JFrame();
		frame.setTitle("Reception Dashboard");
		frame.setSize(1100, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(100, 100));
		north.setBackground(new Color(0, 0, 0));
		north.setLayout(null);
		frame.add(north, BorderLayout.NORTH);

		JLabel title = new JLabel("RECEPTION DASHBOARD");
		title.setBounds(130, 40, 400, 30);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setForeground(Color.white);
		north.add(title);
		
		JLabel headingImage = new JLabel();
		headingImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("hotel.png")));
		headingImage.setBounds(40, 20, 64, 64);
		headingImage.setFont(new Font("Tahoma", Font.BOLD, 18));
		headingImage.setForeground(Color.white);
		north.add(headingImage);
		
		JLabel welcome = new JLabel("Welcome:");
		welcome.setBounds(830, 40, 400, 20);
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		welcome.setForeground(Color.white);
		north.add(welcome);
		
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText(Global.currentUser.getCustomer_Name());
		welcomeLabel.setBounds(910, 40, 400, 20);
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		welcomeLabel.setForeground(Color.white);
		north.add(welcomeLabel);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		frame.add(centerPanel, BorderLayout.CENTER);

		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(null);
		bookingPanel.setBounds(50, 20, 220, 200);
		bookingPanel.setBackground(Color.black);
		centerPanel.add(bookingPanel);

		JLabel img = new JLabel();
		img.setIcon(new javax.swing.ImageIcon(getClass().getResource("booking.png")));
		img.setBounds(40, 20, 128, 128);
		img.setFont(new Font("Tahoma", Font.BOLD, 18));
		img.setForeground(Color.white);
		bookingPanel.add(img);

		// *******************Label for manage Customers***************
		BookingLabel = new JLabel("Booking");
		BookingLabel.setBounds(60, 150, 200, 30);
		BookingLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		BookingLabel.setForeground(Color.white);
		bookingPanel.add(BookingLabel);
		BookingLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Booking();
			}

		});

		// ----------------------Customer Panel--------------------------
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(null);
		customerPanel.setBounds(300, 20, 220, 200);
		customerPanel.setBackground(Color.black);
		centerPanel.add(customerPanel);

		JLabel img1 = new JLabel();
		img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("people.png")));
		img1.setBounds(40, 20, 128, 128);
		img1.setFont(new Font("Tahoma", Font.BOLD, 18));
		img1.setForeground(Color.white);
		customerPanel.add(img1);

		CustomerLabel = new JLabel("Search Customers");
		CustomerLabel.setBounds(20, 150, 200, 30);
		CustomerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		CustomerLabel.setForeground(Color.white);
		customerPanel.add(CustomerLabel);
		CustomerLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Search_Customers();
			}

		});

		// ----------------Room Panel------------------------
		JPanel roomPanel = new JPanel();
		roomPanel.setLayout(null);
		roomPanel.setBounds(550, 20, 220, 200);
		roomPanel.setBackground(Color.black);
		centerPanel.add(roomPanel);

		JLabel img3 = new JLabel();
		img3.setIcon(new javax.swing.ImageIcon(getClass().getResource("interior-design.png")));
		img3.setBounds(40, 20, 128, 128);
		img3.setFont(new Font("Tahoma", Font.BOLD, 18));
		img3.setForeground(Color.white);
		roomPanel.add(img3);

		CustomerLabel = new JLabel("Search Rooms");
		CustomerLabel.setBounds(45, 150, 200, 30);
		CustomerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		CustomerLabel.setForeground(Color.white);
		roomPanel.add(CustomerLabel);
		CustomerLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Search_Rooms();
			}

		});

		// ----------------Billing Panel------------------------
		JPanel billingPanel = new JPanel();
		billingPanel.setLayout(null);
		billingPanel.setBounds(800, 20, 220, 200);
		billingPanel.setBackground(Color.black);
		centerPanel.add(billingPanel);

		JLabel img2 = new JLabel();
		img2.setIcon(new javax.swing.ImageIcon(getClass().getResource("bill.png")));
		img2.setBounds(40, 20, 128, 128);
		img2.setFont(new Font("Tahoma", Font.BOLD, 18));
		img2.setForeground(Color.white);
		billingPanel.add(img2);

		CustomerLabel = new JLabel("Billing");
		CustomerLabel.setBounds(80, 150, 200, 30);
		CustomerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		CustomerLabel.setForeground(Color.white);
		billingPanel.add(CustomerLabel);
		CustomerLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Billing();
			}

		});
		
		
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(100, 50));
		south.setBackground(new Color(0, 0, 0));
		south.setLayout(null);
		frame.add(south, BorderLayout.SOUTH);
		
		JButton logout=new JButton("Logout");
		logout.setBounds(10,10,100,30);
		logout.setFocusable(false);
		logout.setBackground(Color.white);
		logout.setForeground(Color.black);
		south.add(logout);
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login_GUI();
				frame.dispose();
				
			}
			
			
			
		});
		
		JLabel version=new JLabel("Version 1.0");
		version.setBounds(950,10,200,20);
		version.setForeground(Color.white);
		version.setFont(new Font("Tahoma", Font.PLAIN,17));
		south.add(version);

		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new Reception_Dashboard();

	}

}
