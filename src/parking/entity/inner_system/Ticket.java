package parking.entity.inner_system;

import java.util.Date;

import parking.util.Utils;

public class Ticket {
	private int carId;
	private int ticketId;
	
	private Date startTime;
	private Date endTime;
	
	public Ticket(int carId){
		this.carId = carId;
		this.ticketId = Utils.getGeneratedTicketId();
		this.startTime = new Date();
	}
	
	public void recordEndTime(){
		endTime = new Date();
	}

	public int getCarId() {
		return carId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}
	
	public long getStartTimeInLong(){
		return startTime.getTime();
	}
	
	public long getEndTimeInLong(){
		return endTime.getTime();
	}
}
