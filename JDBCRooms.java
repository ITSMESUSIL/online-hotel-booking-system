package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCRooms extends Database {
	
	public ArrayList room_view() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList a1=new ArrayList();
		String sql="SELECT * FROM room where roomstatus='Available'";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/luton","root","");
			
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				RoomLibs booking=new RoomLibs(rs.getInt("roomno"),
						rs.getString("roomtype"),
						rs.getInt("rate"),
						rs.getString("roomstatus")
						
						);
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}
	
	
	public boolean update (RoomLibs room) {
		Connection conn;
		PreparedStatement pstat;
		String sql="UPDATE room SET roomstatus=? WHERE roomno=?";
		boolean result=false;
		
		try {
			conn=connect();
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, room.getRoomstatus());
			pstat.setDouble(2, room.getRoomno());
			
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result=true;
		}
		catch (Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result;
		
	}
	
	
	public ArrayList room_viewall() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList a1=new ArrayList();
		String sql="SELECT * FROM room";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/luton","root","");
			
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				RoomLibs booking=new RoomLibs(rs.getInt("roomno"),
						rs.getString("roomtype"),
						rs.getInt("rate"),
						rs.getString("roomstatus")
						
						);
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}

}
