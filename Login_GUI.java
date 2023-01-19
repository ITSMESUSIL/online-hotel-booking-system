package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import FrontendLayer.NewCustRegister12;
import FrontendLayer.ReceptionistForm;
import libs.Global;
import libs.JDBCLogin;
import libs.LoginLibs;

public class Login_GUI {
	JFrame frame;
	JTextField emailField;
	JPasswordField  passwordField;
	JButton loginBtn;
	
	public Login_GUI() {
		
		frame=new JFrame();
		frame.setTitle("Login System");
		frame.setSize(750,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		
		//++++++++++++++++Center Panel+++++++++++++++++
		JPanel center=new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100,60));
		center.setBackground(new Color(0,0,0));
		frame.add(center, BorderLayout.CENTER);
		
		JLabel title=new JLabel("LOGIN SYSTEM");
		title.setFont(new Font("ROG", Font.BOLD, 19));
		title.setForeground(new Color(255,255,255));
		title.setBounds(10,10,200,30);
		center.add(title);
		
		JLabel emailLabel=new JLabel("Email:");
		emailLabel.setFont(new Font("ROG", Font.BOLD, 19));
		emailLabel.setForeground(new Color(255,255,255));
		emailLabel.setBounds(230,100,200,30);
		center.add(emailLabel);
		
//		emailField=new JTextField();
//		emailField.setBounds(350,100,200,30);
//		emailField.setForeground(Color.BLACK);
//		emailField.setFont(new Font("Tahoma", Font.BOLD,20));
//		center.add(emailField);
		emailField = new JTextField();
		emailField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailField.requestFocus();
			}
		});
		emailField.setForeground(new Color(169, 169, 169));
		
		emailField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(emailField.getText().equals("Email")) {
					emailField.setText("");
				}
				
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(emailField.getText().equals("")) {
					emailField.setText("Email");
					
				}
			}
			
		});
		emailField.setBorder(null);
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailField.setText("Email");
		emailField.setBounds(350,100,200,30);
		center.add(emailField);
		emailField.setColumns(10);
		
		JLabel passwordLabel=new JLabel("Password:");
		passwordLabel.setFont(new Font("ROG", Font.BOLD, 19));
		passwordLabel.setForeground(new Color(255,255,255));
		passwordLabel.setBounds(230,150,200,30);
		center.add(passwordLabel);
		

		
		passwordField = new JPasswordField();

		passwordField.setForeground(new Color(169, 169, 169));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordField.getText().equals("Password")) {
					passwordField.setEchoChar('●');
					passwordField.setText("");
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().equals("")) {
					passwordField.setText("Password");
					passwordField.setEchoChar((char)0);
				}
			}
		});
		passwordField.setBorder(null);
		passwordField.setEchoChar((char)0);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setText("Password");
		passwordField.setBounds(350,150,200,30);
		center.add(passwordField);
		
		
		
		
		loginBtn=new JButton("Login");
		loginBtn.setBorder(new LineBorder(new Color(0, 255, 255), 3, true));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginBtn.setBounds(306, 305, 157, 39);
		loginBtn.setFocusable(false);
		loginBtn.setForeground(Color.black);
		loginBtn.setBackground(Color.white);
		center.add(loginBtn);
		
		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				if (emailField.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter username and password");
				}

				else if (ae.getSource() == loginBtn) {

					LoginLibs user = new LoginLibs();
					user.setEmail(emailField.getText());
					user.setCreate_password(passwordField.getText());
					
					user = new JDBCLogin().login(user);
					Global.currentUser=user;
					if (user.getCustId() > 0) {
//						
						JOptionPane.showMessageDialog(null, "Welcome to Luton Hotel");
						
						if (user.getCustomerType().equals("Customer")) {
							new Customer_Dashboard().setVisible(true);;
							frame.dispose();
							
						} else if (user.getCustomerType().equals("Receptionist")) {
							new Reception_Dashboard();
							JOptionPane.showMessageDialog(null, "Welcome manager");
							frame.dispose();
						} 
					} else {

						JOptionPane.showMessageDialog(null, "Incorrect Username and password");
					}

				}
			}
		});

		JButton btnNewButton_1 = new JButton("Create New Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCustRegister ncr= new NewCustRegister();
				ncr.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 255, 255), 3, true));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(269, 417, 240, 29);
		center.add(btnNewButton_1);
		
		
		
		
		
		
		
		
		
		
		
		
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new Login_GUI();

	}

}
