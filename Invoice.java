package gui;

import java.awt.BorderLayout;

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
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import libs.Global;

public class Invoice {
	JFrame frame;
	JPanel center;
	
	public Invoice() {
		frame = new JFrame("Invoice");
		frame.setSize(750, 470);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		
		
		
		center=new JPanel();
		center.setLayout(null);
		frame.add(center, BorderLayout.CENTER);
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu menu = new JMenu("Print");
		menubar.add(menu);

		JMenuItem print = new JMenuItem("Print");
		menu.add(print);
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("Print Data");

				job.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						pf.setOrientation(PageFormat.LANDSCAPE);
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.scale(0.85, 0.70);

						center.print(g2);

						return Printable.PAGE_EXISTS;

					}
				});
				boolean ok = job.printDialog();
				if (ok) {
					try {

						job.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}

			}

		});

		
		JLabel header=new JLabel("****************************************************************************************************************************************************");
		header.setBounds(10,5,750,10);
		center.add(header);
		
		JLabel title=new JLabel("LUTON HOTEL INVOICE");
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setBounds(250,20,250,30);
		center.add(title);
		
		JLabel title1=new JLabel("luton@gmail.com");
		title1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		title1.setBounds(300,50,200,20);
		center.add(title1);
		
		JLabel j1=new JLabel("**************************************");
		j1.setBounds(270,75,200,10);
		center.add(j1);
		
		
		JLabel invoiceno = new JLabel("Ref No:");
		invoiceno.setFont(new Font("Verdana", Font.PLAIN, 18));
		invoiceno.setBounds(20, 110, 230, 20);
		center.add(invoiceno);

		Random rand=new Random();
		int random=(int) (Math.random()*10569900+1);
		
		JLabel invoicenolbl = new JLabel();
		invoicenolbl.setText(String.valueOf(random));
		invoicenolbl.setFont(new Font("Verdana", Font.PLAIN, 18));
		invoicenolbl.setBounds(100, 110, 230, 20);
		center.add(invoicenolbl);
		
		
		JLabel custName = new JLabel("Name:");
		custName.setFont(new Font("Verdana", Font.PLAIN, 18));
		custName.setBounds(60, 160, 230, 20);
		center.add(custName);
		
		JLabel custNameLabel = new JLabel("Sushil");
		custNameLabel.setText(Global.currentBilling.getName());
		custNameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		custNameLabel.setBounds(180, 160, 230, 20);
		center.add(custNameLabel);
		
		JLabel BillingStatus = new JLabel("Status:");
		BillingStatus.setFont(new Font("Verdana", Font.PLAIN, 18));
		BillingStatus.setBounds(450, 160, 230, 20);
		center.add(BillingStatus);
		
		JLabel BillingLabel = new JLabel("Paid");
		BillingLabel.setText(Global.currentBilling.getBilling_Status());
		BillingLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		BillingLabel.setBounds(600, 160, 230, 20);
		center.add(BillingLabel);
		
		JLabel BookingID = new JLabel("Booking ID:");
		BookingID.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookingID.setBounds(60, 200, 230, 22);
		center.add(BookingID);
		
		JLabel BookingIDLabel = new JLabel("567");
		BookingIDLabel.setText(Integer.toString(Global.currentBilling.getBooking_ID()));
		BookingIDLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		BookingIDLabel.setBounds(180, 200, 230, 20);
		center.add(BookingIDLabel);
		
		JLabel RoomPrice = new JLabel("Room Charge:");
		RoomPrice.setFont(new Font("Verdana", Font.PLAIN, 18));
		RoomPrice.setBounds(450, 200, 230, 20);
		center.add(RoomPrice);
		
		JLabel RoomPriceLabel = new JLabel("3490");
		RoomPriceLabel.setText(Integer.toString(Global.currentBilling.getRoom_Price()));
		RoomPriceLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		RoomPriceLabel.setBounds(600, 200, 230, 20);
		center.add(RoomPriceLabel);
		
		JLabel Middle=new JLabel("****************************************************************************************************************************************************");
		Middle.setBounds(10,250,750,10);
		center.add(Middle);
		
		
		JLabel VAT = new JLabel("VAT:");
		VAT.setFont(new Font("Verdana", Font.PLAIN, 18));
		VAT.setBounds(450, 270, 230, 20);
		center.add(VAT);
		
		JLabel VATLabel = new JLabel("56");
		VATLabel.setText(Integer.toString(Global.currentBilling.getVAT()));
		VATLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		VATLabel.setBounds(600, 270, 230, 20);
		center.add(VATLabel);
		
		JLabel Service = new JLabel("Service Bill:");
		Service.setFont(new Font("Verdana", Font.PLAIN, 18));
		Service.setBounds(450, 310, 230, 22);
		center.add(Service);
		
		JLabel ServiceLabel = new JLabel("100");
		ServiceLabel.setText(Integer.toString(Global.currentBilling.getService_Charge()));
		ServiceLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		ServiceLabel.setBounds(600, 310, 230, 20);
		center.add(ServiceLabel);
		
		JLabel Total = new JLabel("Total Bill:");
		Total.setFont(new Font("Verdana", Font.PLAIN, 18));
		Total.setBounds(450, 360, 230, 22);
		center.add(Total);
		
		JLabel TotalLabel = new JLabel("89100");
		TotalLabel.setText(Double.toString(Global.currentBilling.getTotal_Bill()));
		TotalLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		TotalLabel.setBounds(600, 360, 230, 20);
		center.add(TotalLabel);
		
		
		
		
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Invoice();

	}

}
