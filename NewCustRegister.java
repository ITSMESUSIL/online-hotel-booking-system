package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import BusinessLayer.BLUser;
import FrontendLayer.NewLogin;
import Models.User;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewCustRegister extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JButton btnclose;
	private JTextField txtCustomerName;
	private JTextField txtCountry;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JPasswordField psdpassword;
	private JTextField txtPhone;
	private JTextField txtCard;
	private JComboBox custtype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustRegister frame = new NewCustRegister();
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
	public NewCustRegister() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 624);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(Color.CYAN, 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final ButtonGroup group= new ButtonGroup();
		
		btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				try {
					final String rdo = group.getSelection().getActionCommand();
					
					User us= new User();
					us.setName(txtCustomerName.getText());
					us.setCountry(txtCountry.getText());
					us.setAddress(txtAddress.getText());
					us.setEmail(txtEmail.getText());
					us.setPassword(psdpassword.getText());
					us.setPhone(txtPhone.getText());
					us.setCard(txtCard.getText());
					
//					us.setUserId(1);
					us.setGender(rdo);
					String custtype1= custtype.getSelectedItem().toString();
					if(custtype1.equals("Customer Type")) {
						JOptionPane.showMessageDialog(null, "customer type is empty");
					}else {
						us.setCusttype(custtype1);
					}
					BLUser bl = new BLUser();
					bl.setUser(us);
					bl.save();
					System.out.println(us.getUserId());
					if(us.getUserId()>0) {
						
                        JOptionPane.showMessageDialog(null, "successfull register");
						
						 new Login_GUI();
						 
					
						dispose();
//						//dashboard
					}
					else {
//						JOptionPane.showMessageDialog(null, "successfull register");
//						
//						Dashboard d = new Dashboard();
//						d.setVisible(true);
//						dispose();
					}
				} catch (Exception e1) {
                    JLabel jLabel = new JLabel();
					//					// TODO Auto-generated catch block
					jLabel.setText("fill field properly");
					e1.printStackTrace();
				}
//					
//				
				
			}

			}
		);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new LineBorder(Color.CYAN, 3));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(343, 504, 101, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("<<login");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBorder(new LineBorder(Color.CYAN, 3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_GUI nl= new Login_GUI();
				
				dispose();
			}
			
			});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(60, 566, 122, 37);
		contentPane.add(btnNewButton_1);
		
		separator = new JSeparator();
		separator.setBounds(60, 546, 729, 13);
		contentPane.add(separator);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(218, 451, 376, 21);
		contentPane.add(lblNewLabel_1);
		
		btnclose = new JButton("X");
		btnclose.setForeground(Color.WHITE);
		btnclose.setBackground(new Color(0, 0, 0));
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "do you want to close this app","confirmation",JOptionPane.YES_NO_OPTION)==0) {
					NewCustRegister.this.dispose();
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
		btnclose.setHorizontalAlignment(SwingConstants.LEFT);
		btnclose.setBounds(749, 10, 45, 21);
		contentPane.add(btnclose);
		
		JPanel panel = new JPanel();
		panel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		panel.setBackground(Color.BLACK);
		panel.setBounds(60, 62, 729, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCustomerName = new JTextField();
		txtCustomerName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCustomerName.getText().equals("Customer Name")) {
					txtCustomerName.setText("");
				}
				
					
					
				}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCustomerName.getText().equals("")) {
					txtCustomerName.setText("Customer Name");
				}
			}
			});
		
		
	
		
		txtCustomerName.setText("Customer Name");
		txtCustomerName.setForeground(Color.GRAY);
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCustomerName.setColumns(10);
		txtCustomerName.setBorder(null);
		txtCustomerName.setBounds(64, 71, 256, 37);
		panel.add(txtCustomerName);
		
		txtCountry = new JTextField();
		txtCountry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCountry.getText().equals("Country")) {
					txtCountry.setText("");
				}
				
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCountry.getText().equals("")) {
					txtCountry.setText("Country");
				}
			}
		});
		txtCountry.setText("Country");
		txtCountry.setForeground(Color.GRAY);
		txtCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCountry.setColumns(10);
		txtCountry.setBorder(null);
		txtCountry.setBounds(388, 71, 270, 37);
		panel.add(txtCountry);
		
		txtAddress = new JTextField();
		txtAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAddress.getText().equals("Address")) {
					txtAddress.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAddress.getText().equals("")) {
					txtAddress.setText("Address");
				}
			}
		});
		txtAddress.setText("Address");
		txtAddress.setForeground(Color.GRAY);
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAddress.setColumns(10);
		txtAddress.setBorder(null);
		txtAddress.setBounds(64, 137, 256, 37);
		panel.add(txtAddress);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmail.getText().equals("Email")) {
					txtEmail.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().equals("")) {
					txtEmail.setText("Email");
				}
			}
		});
		txtEmail.setText("Email");
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(64, 203, 256, 37);
		panel.add(txtEmail);
		
		psdpassword = new JPasswordField();
		psdpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (psdpassword.getText().equals("Create Password")) {
					psdpassword.setText("");
					psdpassword.setEchoChar('●');
					
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (psdpassword.getText().equals("")) {
					psdpassword.setText("Create Password");
					psdpassword.setEchoChar((char)0);
					
				}
			}
		});
		psdpassword.setText("Create Password");
		psdpassword.setForeground(Color.GRAY);
		psdpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		psdpassword.setEchoChar((char)0);
		psdpassword.setBorder(null);
		psdpassword.setBounds(388, 140, 270, 32);
		panel.add(psdpassword);
		
		txtPhone = new JTextField();
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhone.getText().equals("Phone")) {
					txtPhone.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPhone.getText().equals("")) {
					txtPhone.setText("Phone");
				}
			}
		});
		txtPhone.setText("Phone");
		txtPhone.setForeground(Color.GRAY);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBounds(64, 268, 256, 37);
		panel.add(txtPhone);
		
		txtCard = new JTextField();
		txtCard.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCard.getText().equals("Creditcard Number")) {
					txtCard.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCard.getText().equals("")) {
					txtCard.setText("Creditcard Number");
				}
			}
		});
		txtCard.setText("Creditcard Number");
		txtCard.setForeground(Color.GRAY);
		txtCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCard.setColumns(10);
		txtCard.setBorder(null);
		txtCard.setBounds(388, 203, 270, 37);
		panel.add(txtCard);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBounds(64, 332, 594, 66);
		panel.add(panel_1);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setActionCommand("Male");
		rdbtnMale.setForeground(Color.GRAY);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setActionCommand("Male");
		rdbtnMale.setBounds(6, 20, 55, 21);
		panel_1.add(rdbtnMale);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Female");
		rdbtnNewRadioButton.setActionCommand("Female");
		rdbtnNewRadioButton.setForeground(Color.GRAY);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setActionCommand("Female");
		rdbtnNewRadioButton.setBounds(123, 20, 72, 21);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Other");
		rdbtnNewRadioButton_1.setActionCommand("Other");
		rdbtnNewRadioButton_1.setForeground(Color.GRAY);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setActionCommand("Other");
		rdbtnNewRadioButton_1.setBounds(243, 20, 80, 21);
		panel_1.add(rdbtnNewRadioButton_1);
		group.add(rdbtnMale);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
		
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 1, 80, 13);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(6, 20, 58, 21);
		panel_1.add(panel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(115, 20, 80, 21);
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(232, 4, -1, 10);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(232, 20, 93, 21);
		panel_1.add(panel_4);
		
		JLabel error = new JLabel("");
		error.setFont(new Font("Tahoma", Font.PLAIN, 13));
		error.setForeground(Color.RED);
		error.setBounds(64, 574, 270, 13);
		panel.add(error);
		
		custtype = new JComboBox();
		custtype.setForeground(Color.GRAY);
		custtype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		custtype.setModel(new DefaultComboBoxModel(new String[] {"Customer Type", "Customer", "Receptionist"}));
		custtype.setBounds(388, 270, 270, 37);
		panel.add(custtype);
		setLocationRelativeTo(null);
	}
}
