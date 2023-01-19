package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBC_Customer {
	
	public ArrayList customer_view() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList a1=new ArrayList();
		String sql="SELECT * from customer";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/luton","root","");
			
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				Customer_Libs booking=new Customer_Libs(rs.getInt("CustId"),
						rs.getString("Customer_Name"),
						rs.getString("Country"),
						rs.getString("Address"),
						rs.getString("Email"),
						rs.getString("Create_password"),
						rs.getString("phone"),
						rs.getString("Creaditcard_Number"),
						rs.getString("Gender"));
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}

}
