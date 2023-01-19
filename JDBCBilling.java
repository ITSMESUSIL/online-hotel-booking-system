package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JDBCBilling extends Database{
	
	SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
	Date date=new Date();
	String currentDate=dateformate.format(date);
	
	public ArrayList view_all1() {

		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BillingLibs2>Billing=new ArrayList();
		String sql="SELECT customer.Customer_Name, booking.bookingid, booking.checkindate, "
				+ "booking.checkoutdate, room.roomno, room.rate, room.roomstatus"
				+ " from customer inner join booking on customer.CustId ="
				+ " booking.CustId inner join room on room.roomno=booking."
				+ "roomno Where bookingstatus='Booked';";
		
		
		
		
		try {
			conn=connect();
			
			pstat=conn.prepareStatement(sql);
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BillingLibs2 billing=new BillingLibs2(
						rs.getString("Customer_Name"),
						rs.getInt("bookingid"),
						rs.getString("checkindate"),
						rs.getString("checkoutdate"),
						rs.getInt("roomno"),
						rs.getInt("rate"),
						rs.getString("roomstatus"));
						
				
				Billing.add(billing);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return Billing;
		
	}
	
	
	
	public boolean insert (BillingLibs3 billing) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO `billing`(`Billing_ID`, `bookingid`, `Name`, `VAT`, `Service_Charge`,`Room_Price`,  `Total_Bill`, `Biiling_Status`) VALUES (?,?,?,?,?,?,?,?)";
		try {
			
			conn=connect();
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, billing.getBilling_ID());
			pstat.setInt(2, billing.getBooking_ID());
			pstat.setString(3, billing.getName());
			pstat.setDouble(4, billing.getVAT());
			pstat.setInt(5, billing.getService_Charge());
			pstat.setDouble(6, billing.getRoom_Price());
			pstat.setDouble(7, billing.getTotal_Bill());
			pstat.setString(8, billing.getBilling_Status());
			
			pstat.executeUpdate();
			
			conn.close();
			pstat.close();
			result=true;
			
			
		}
		
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result;
	}
	


	
public boolean update(BookingLibs booking) {
	
	Connection conn;
	PreparedStatement pstat;
	boolean result5=false;
	String sql="UPDATE booking SET bookingstatus=? WHERE bookingid=?";
	try {
		
		conn=connect();
		
		pstat=conn.prepareStatement(sql);
		
		pstat.setString(1, booking.getBookingstatus());		
		pstat.setInt(2, booking.getBookingid());
		
		
		pstat.executeUpdate();
		conn.close();
		pstat.close();
		result5=true;
		
	}
	catch(Exception ex) {
		System.out.println("Error"+ex.getMessage());
	}
	return result5;
}

}
