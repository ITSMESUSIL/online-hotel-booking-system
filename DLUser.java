package DatabaseLayer;
import  Models.User;
import Models.Global;
import Helper.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class DLUser {

	
	private DatabaseConnector db;
	private Connection connection;
	private User user;

	

	
	DLBooking dlbook = new DLBooking();
	
	public DLUser() throws Exception {
		
		try {
			this.db= DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
			
		}
	}
    public DLUser (User user) throws Exception{
    	 this.user = user;
    	try {
			this.db= DatabaseConnector.getInstance();
			this.connection = this.db.getConnection();
		}catch (Exception ex) {
			throw ex;
			
		}
    }
    public User getUser() {
    	return this.user;
    }
    public void setUser(User user) {
    	this.user=user;
    }
    public User save() throws Exception{
    	try {
    		String generatedColums[]= {};
    		String query ="INSERT INTO customer(Customer_Name,Country,Address,Email,Create_Password,Phone,Creaditcard_Number,Gender,CustomerType) Values(?,?,?,?,?,?,?,?,?)";
    		PreparedStatement statement= this.connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
    		
//    		statement.setInt(1,this.user.getUserId());
    		statement.setString(1,this.user.getName());
    		statement.setString(2,this.user.getCountry());
    		statement.setString(3,this.user.getAddress());
    		statement.setString(4,this.user.getEmail());
    		statement.setString(5,this.user.getPassword());
    		statement.setString(6,this.user.getPhone());
    		statement.setString(7,this.user.getCard());
    		statement.setString(8,this.user.getGender ());
    		statement.setString(9,this.user.getCusttype());
    		
    		int noOfUpdate= statement.executeUpdate();
    		if(noOfUpdate>0) {
//    			String idquery = "SELECT Custid from customer where Customer_Name=?";
//    			PreparedStatement idstatement= this.connection.prepareStatement(idquery);
//    			idstatement.setString(1, this.user.getName());
    			ResultSet rs= statement.getGeneratedKeys();
//    			System.out.println(custidUpdate);
//    			ResultSet rs = statement.getGeneratedKeys();
    			if(rs.next()) {
    				int id = rs.getInt(1);
    				
    				System.out.println(id);
    			    this.user.setUserId(id);
    			
//    		
    			}
    		}
    		return this.user;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
   
    
    public User update() throws Exception{
    	try {
    		
    		String query ="Update user SET name= ?, address=? WHERE id=?";
    		PreparedStatement statement= this.connection.prepareStatement(query);
    		statement.setString(1,this.user.getName());
    		statement.setString(2,this.user.getAddress());
    		statement.setInt(3,this.user.getUserId());
    	    statement.executeUpdate();
    	    return this.user;
    		
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public boolean login() throws Exception{
    	try {
    		
    		String query ="SELECT Email, Create_password FROM  WHERE Emaicustomer=? AND Create_password=?";
    		PreparedStatement statement= this.connection.prepareStatement(query);
    		statement.setString(1,this.user.getEmail());
    		statement.setString(2,this.user.getPassword());
    	    ResultSet rs = statement.executeQuery();
    	    while (rs.next()){
    			return true;
    		}
    	    return false;
    		
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    
    public User delete() throws Exception{
    	try {
    		
    		String query ="DELETE From user where id= ?";
    		PreparedStatement statement= this.connection.prepareStatement(query);
    		statement.setInt(1,this.user.getUserId());
    		statement.executeUpdate();
    		return this.user;
    		
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
//    public ArrayList<User> getAllUser() throws Exception{
//    	try {
//    		ArrayList<User> users= new ArrayList<User>();
//    		String query = "SELECT * FROM newone ORDER BY name";
//    		Statement statement = this.connection.createStatement();
//    		ResultSet rs = statement.executeQuery(query);
//    		while (rs.next()){
//    			User u= new User();
//    			u.setUserId(0);
//    			u.setName(rs.getString("name"));
//    			u.setAddress(rs.getString("address"));
//    			users.add(u);
//    			
//    		}
//    		return users;
//    	}catch(Exception ex) {
//    		throw ex;
//    	}
//    }
    	public ArrayList<User> getAllUser() throws Exception{
    		try {
    			ArrayList<User> users= new ArrayList<User>();
    			String query = "SELECT * FROM registration ";
    			
        		
        		
    			Statement st = this.connection.createStatement();
    			ResultSet rs = st.executeQuery(query);
    			while (rs.next()){
    				User u= new User();
//    				u.setUserId(0);
    				u.setName(rs.getString("Customer_Name"));
    				u.setAddress(rs.getString("Country"));
    				u.setAddress(rs.getString("Address"));
    				u.setAddress(rs.getString("Email"));
    				u.setAddress(rs.getString("Phone"));
    				users.add(u);
    				
    			}
    			return users;
    		}catch(Exception ex) {
    			throw ex;
    		}
    }
    
    public ArrayList<User> searchUser(String [] keys, String [] values) throws Exception{
    	ArrayList<User> users= new ArrayList<User>();
    	try {
    		int keyLength = keys.length;
    		String where= "";
    		for (int i=0; i<keyLength;++i) {
    			if (i==0) {
    				where = where+" WHERE"+ keys[i]+ " LIKE '%"+values[i]+"%' ";
    			}else {
    				where= where+" AND"+ keys[i]+ " LIKE '%"+values[i]+"%' ";
    			}
    		}
    		String query = "SELECT * FROM user" +where+ "ORDER BY name";
    		Statement statement = this.connection.createStatement();
    		ResultSet rs = statement.executeQuery(query);
    		while (rs.next()){
    			User u= new User();
//    			u.setUserId(rs.getInt("id"));
    			u.setName(rs.getString("name"));
    			u.setAddress(rs.getString("address"));
    			users.add(u);
    			
    		}
    		

    	}catch (SQLException e) {
    		throw new Exception(e.getMessage());
    	}
    	return users;
    }
    
    
    
}
