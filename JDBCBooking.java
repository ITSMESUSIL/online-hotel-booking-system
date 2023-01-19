package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCBooking {
	
	
	public boolean insert (BookingLibs booking) {
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO `booking`(`bookingid`, `bookingdate`, `checkindate`, `checkoutdate`, `BookingType`, `bookingstatus`, `Custid`) VALUES (?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/luton","root","");
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, booking.getBookingid());
			pstat.setString(2, booking.getBookingdate());
			pstat.setString(3, booking.getCheckindate());
			pstat.setString(4, booking.getCheckoutdate());
			pstat.setString(5, booking.getBookingType());
			pstat.setString(6, booking.getBookingstatus());
			pstat.setInt(7, booking.getCustid());
			
			
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
	
	
	
	
	
	public ArrayList view_all() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList a1=new ArrayList();
		String sql="SELECT * FROM booking Where Custid=?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/luton","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, Global.currentUser.getCustId());
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BookingLibs booking=new BookingLibs(rs.getInt("bookingid"),
						rs.getString("bookingdate"),
						rs.getString("checkindate"),
						rs.getString("checkoutdate"),
						rs.getString("BookingType"),
						rs.getString("bookingstatus"),
						rs.getInt("Custid"),
						rs.getInt("roomno")
						);
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}
	
	
	public ArrayList reception_view() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList a1=new ArrayList();
		String sql="SELECT * FROM booking where bookingstatus='Pending'";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/luton","root","");
			
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BookingLibs booking=new BookingLibs(rs.getInt("bookingid"),
						rs.getString("bookingdate"),
						rs.getString("checkindate"),
						rs.getString("checkoutdate"),
						rs.getString("BookingType"),
						rs.getString("bookingstatus"),
						rs.getInt("Custid"),
						rs.getInt("roomno")
						);
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}
	
	
public boolean booking_update(BookingLibs booking) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE booking SET roomno=?, bookingstatus=? WHERE bookingid=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/luton", "root", "");
			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setInt(1, booking.getRoomno());
			pstat.setString(2, booking.getBookingstatus());
			pstat.setInt(3, booking.getBookingid());
			
			
			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result1=true;
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result1;
	}

}
