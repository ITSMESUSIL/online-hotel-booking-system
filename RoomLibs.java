package libs;

public class RoomLibs {
	
	int roomno;
	String roomtype;
	int rate;
	String roomstatus;
	
	
	public RoomLibs() {
		
		this.roomno = 0;
		this.roomtype = "";
		this.rate = 0;
		this.roomstatus = "";
	}
	
	
public RoomLibs(int roomno, String roomtype, int rate, String roomstatus) {
		
		this.roomno = roomno;
		this.roomtype = roomtype;
		this.rate = rate;
		this.roomstatus = roomstatus;
	}


public int getRoomno() {
	return roomno;
}


public void setRoomno(int roomno) {
	this.roomno = roomno;
}


public String getRoomtype() {
	return roomtype;
}


public void setRoomtype(String roomtype) {
	this.roomtype = roomtype;
}


public int getRate() {
	return rate;
}


public void setRate(int rate) {
	this.rate = rate;
}


public String getRoomstatus() {
	return roomstatus;
}


public void setRoomstatus(String roomstatus) {
	this.roomstatus = roomstatus;
}


@Override
public String toString() {
	return "RoomLibs [roomno=" + roomno + ", roomtype=" + roomtype + ", rate=" + rate + ", roomstatus=" + roomstatus
			+ "]";
}


	
	
	

}
