package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;	

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
			this.roomNumber = roomNumber;
			this.checkIn = checkin;
			this.checkOut = checkout;
		

	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Atualizações só pódem ser realizadas para datas futuras";
		}
		if( !checkOut.after(checkIn)) {
			return "data de Check-Out é anteriaor a data de Check-in";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Room: "+roomNumber
				+", Check IN: "+sdf.format(checkIn)
				+", Check Out: "+sdf.format(checkOut)
				+", Duração: "+duration());
		return sb.toString();
	}
	
	
}
