package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCLogin {
	
	final String Driver="com.mysql.cj.jdbc.Driver";		
	final String DBNAME="luton";
	final String HOST="localhost";
	final int PORT =3306;
	final String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;
	final String USER ="root";
	final String PASSWORD="";
	
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(Driver);   //loading driver
			conn=DriverManager.getConnection(URL,USER, PASSWORD);
		
		}
		
		catch (Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return conn;
		
	}
	
	public LoginLibs login(LoginLibs user) {
		String sql="SELECT * FROM customer WHERE Email=? AND Create_password=?";
		try {
			Connection conn=connect();
			if(conn!=null) {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1,user.getEmail());
			pstat.setString(2, user.getCreate_password());
			ResultSet rs=pstat.executeQuery();
			
			while(rs.next()) {
				
				user.setCustId(rs.getInt("CustID"));
				user.setEmail(rs.getString("Email"));
				user.setCustomer_Name(rs.getString("Customer_Name"));
				user.setCreate_password(rs.getString("Create_password"));
				user.setCustomerType(rs.getString("CustomerType"));
			}
			}
			
		}
		catch(Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return user;
	}

}