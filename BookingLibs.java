package libs;

public class BookingLibs {
	
	int bookingid;
	String bookingdate;
	String checkindate;
	String checkoutdate;
	String BookingType;
	String bookingstatus;
	int Custid;
	int roomno;
	
	
	public BookingLibs() {
		
		this.bookingid = 0;
		this.bookingdate = "";
		this.checkindate = "";
		this.checkoutdate = "";
		this.BookingType = "";
		this.bookingstatus = "";
		this.Custid = 0;
		this.roomno = 0;
	}
	
	
	
	
	public BookingLibs(int bookingid, String bookingdate, String checkindate, String checkoutdate, String bookingType,
			String bookingstatus, int custid, int roomno) {
		
		this.bookingid = bookingid;
		this.bookingdate = bookingdate;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.BookingType = bookingType;
		this.bookingstatus = bookingstatus;
		this.Custid = custid;
		this.roomno = roomno;
	}




	public int getBookingid() {
		return bookingid;
	}




	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}




	public String getBookingdate() {
		return bookingdate;
	}




	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}




	public String getCheckindate() {
		return checkindate;
	}




	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}




	public String getCheckoutdate() {
		return checkoutdate;
	}




	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}




	public String getBookingType() {
		return BookingType;
	}




	public void setBookingType(String bookingType) {
		BookingType = bookingType;
	}




	public String getBookingstatus() {
		return bookingstatus;
	}




	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}




	public int getCustid() {
		return Custid;
	}




	public void setCustid(int custid) {
		Custid = custid;
	}




	public int getRoomno() {
		return roomno;
	}




	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}




	@Override
	public String toString() {
		return "BookingLibs [bookingid=" + bookingid + ", bookingdate=" + bookingdate + ", checkindate=" + checkindate
				+ ", checkoutdate=" + checkoutdate + ", BookingType=" + BookingType + ", bookingstatus=" + bookingstatus
				+ ", Custid=" + Custid + ", roomno=" + roomno + "]";
	}
	
	

}
