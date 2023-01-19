package Models;

import javax.swing.ButtonModel;

import FrontendLayer.Loginn;

public class User {
	private int userId;
	private String name;
	private String country;
	private String address;
	private String email;
	private String password;
	private String phone;
	private String card;
	private String gender;
	private String custtype;
	public String getCusttype() {
		return custtype;
	}
	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}
	private String bookingdate;
	private String checkin;
	private String checkout;
	private String bookingstatus;

	

	

//	public User() {
//		this.userId=;
//		this.name="";
//		this.address="";
//	}
//	public User(String booking,String checkin,String checkout) {
//		this.bookingdate=booking;
//		
//		this.checkin=checkin;
//		this.checkout= checkout;
//	}
//	
//	public User(String name) {
//		
//		this.name= name;
////		this.address = Address;
////		this.country= Country;
////		this.email= Email;
////		this.password=password;
////		this.phone=Phone;
////		this.card= card;
////		this.gender= Gender;
//	}
    public int getUserId() {
//    	System.out.println("User" + this.userId);
    	return this.userId;
    }
    public void setUserId(int userId) {
    	this.userId=userId;
    	
    }


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}		

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
	public String toString() {
		return "User Id: " + this.userId+"Name: "+this.name+"Address: "+ this.address;  
	}
	

}
