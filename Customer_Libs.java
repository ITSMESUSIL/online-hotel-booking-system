package libs;

public class Customer_Libs {
	
	int CustId;
	String Customer_Name;
	String Country;
	String Address;
	String Email;
	String Create_password;
	String phone;
	String Creaditcard_Number;
	String Gender;
	
	
	public Customer_Libs() {
		
		this.CustId = 0;
		this.Customer_Name = "";
		this.Country = "";
		this.Address = "";
		this.Email = "";
		this.Create_password = "";
		this.phone = "";
		this.Creaditcard_Number = "";
		this.Gender = "";
	}
	
	
	
	public Customer_Libs(int custId, String customer_Name, String country, String address, String email,
			String create_password, String phone, String creaditcard_Number, String gender) {
		
		this.CustId = custId;
		this.Customer_Name = customer_Name;
		this.Country = country;
		this.Address = address;
		this.Email = email;
		this.Create_password = create_password;
		this.phone = phone;
		this.Creaditcard_Number = creaditcard_Number;
		this.Gender = gender;
	}



	public int getCustId() {
		return CustId;
	}



	public void setCustId(int custId) {
		CustId = custId;
	}



	public String getCustomer_Name() {
		return Customer_Name;
	}



	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}



	public String getCountry() {
		return Country;
	}



	public void setCountry(String country) {
		Country = country;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getCreate_password() {
		return Create_password;
	}



	public void setCreate_password(String create_password) {
		Create_password = create_password;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getCreaditcard_Number() {
		return Creaditcard_Number;
	}



	public void setCreaditcard_Number(String creaditcard_Number) {
		Creaditcard_Number = creaditcard_Number;
	}



	public String getGender() {
		return Gender;
	}



	public void setGender(String gender) {
		Gender = gender;
	}



	@Override
	public String toString() {
		return "Customer_Libs [CustId=" + CustId + ", Customer_Name=" + Customer_Name + ", Country=" + Country
				+ ", Address=" + Address + ", Email=" + Email + ", Create_password=" + Create_password + ", phone="
				+ phone + ", Creaditcard_Number=" + Creaditcard_Number + ", Gender=" + Gender + "]";
	}
	
	
	
	
	
	
	
	
	

}
