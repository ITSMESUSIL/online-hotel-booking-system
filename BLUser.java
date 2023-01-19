package BusinessLayer;

import Models.User;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DatabaseLayer.DLUser;
import FrontendLayer.Loginn;
import FrontendLayer.NewLogin;
import Helper.InputException;

public class BLUser {
	User user;
	
	
	public BLUser(){
		
		
		this.user= new User();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user ) throws InputException {
		try {
			if (this.validateUser(user)) {
				this.user= user;
			}
		}catch(InputException ex) {
			throw ex;
		}
	}
	
	
	
	public boolean validateUser(User user ) throws InputException{
		if (user.getName()==null||user.getName().equals("Customer Name") || user.getName().length()==0) {
			JOptionPane.showMessageDialog(null, "User name cannot be empty");
			
			throw new InputException("User name cannot be empty.");
		}
		if (user.getCountry()==null||user.getCountry().equals("Country")||user.getCountry()=="Country") {
			JOptionPane.showMessageDialog(null, "User Country cannot be empty");
			throw new InputException ("Country cannot be empty");
		}
		if (user.getAddress()==null||user.getAddress().equals("Address")||user.getAddress().length()==0) {
			JOptionPane.showMessageDialog(null, "User address cannot be empty");
			throw new InputException("User address cannot be empty");
		}
		if (user.getEmail()==null||user.getEmail().equals("Email")||user.getEmail()=="Email") {
			JOptionPane.showMessageDialog(null, "User Email cannot be empty");
			throw new InputException ("email cannot be empty");
		}
		
		if (user.getPassword()==null||user.getPassword().equals("password")) {
			JOptionPane.showMessageDialog(null, "User Password cannot be empty");
			throw new InputException ("password cannot be empty");
		}
		if (user.getCard()==null||user.getCard().equals("Creditcard Number")||user.getCard()=="Creditcard Number") {
			JOptionPane.showMessageDialog(null, "User address Credit card cannot be empty");
			throw new InputException ("credit card cannot be empty");
		}
		if (user.getPhone()==null||user.getPhone().equals("Phone")||user.getPhone()=="Phone") {
			JOptionPane.showMessageDialog(null, "User phone cannot be empty");
			throw new InputException ("phone cannot be empty");
		}
		if (user.getGender()==null) {
			JOptionPane.showMessageDialog(null, "show error");
			
			throw new InputException ("please select gender");
		}
		return true;
	}
	//save the user,update the user, delete the user, getUserList
	
	public User save1( ) throws Exception{
		// this function saves the user detail to database and returns the user object after saving 
		try {
			DLUser dlUser= new DLUser(this.user);
			return dlUser.save();
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	public User update( ) throws Exception{
		// this function update the user detail to database and returns the user object after saving 
		try {
			DLUser dlUser= new DLUser(this.user);
			return dlUser.update();
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	public User save( ) throws Exception{
		// this function update the user detail to database and returns the user object after saving 
		try {
			DLUser dlUser= new DLUser(this.user);
			return dlUser.save();
			
		}catch (Exception e) {
			throw e;
		}
	}
	public Boolean Login( ) throws Exception{
		// this function update the user detail to database and returns the user object after saving 
		try {
			DLUser dlUser= new DLUser(this.user);
			return dlUser.login();
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	
	public User delete( ) throws Exception{
		// this function delete the user detail to database and returns the user object after saving 
		try {
			DLUser dlUser= new DLUser();
			return dlUser.delete();
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<User> getAllUser() throws Exception{
		try {
			DLUser dlUser= new DLUser(this.user);
			return dlUser.getAllUser();
		}catch (Exception e) {
			throw e;
		}
	}
	
	public ArrayList<User> searchUser(String [] keys,String [] values ) throws Exception{
		try {
			DLUser dlUser= new DLUser(this.user);
			return dlUser.searchUser(keys, values);
			
		}catch (Exception e){
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
