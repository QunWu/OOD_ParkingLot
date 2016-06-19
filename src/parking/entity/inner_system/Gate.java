package parking.entity.inner_system;

import java.util.concurrent.TimeUnit;

import parking.entity.inner_system.interfaces.WaitingQueue;
import parking.util.BlockingQueue;
import parking.util.GateServices;
import parking.util.Utils;

public class Gate implements GateServices {
	private WaitingQueue enterQue = null;
	private WaitingQueue quitQue = null;
	
	public Gate(){
		this.enterQue = new BlockingQueue();
		this.quitQue = new BlockingQueue();
	}

	@Override
	public boolean enter(int carId)  {
		try {
			this.enterQue.add(carId);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Ticket getTicket(int carId) {
		Ticket ticket = null;
System.out.println("33:"+carId+" is getting ticket");
		try {
			this.enterQue.poll(carId);
			ticket = new Ticket(carId);
System.out.println("37:"+carId+" get the ticket "+ticket.getTicketId());
		} catch (Exception e) {
			e.printStackTrace();
			return ticket;
		}
		return ticket;
	}

	@Override
	public boolean quit(int carId) {
		try {
			this.quitQue.add(carId);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public double pay(Ticket ticket) {
		try {
			this.quitQue.poll(ticket.getCarId());
		} catch (InterruptedException e) {
			return -1;
		}
		
		ticket.recordEndTime();
		
		long duration = ticket.getEndTimeInLong()-ticket.getStartTimeInLong();
		long durationToHour = TimeUnit.MILLISECONDS.toMillis(duration);
		
		return durationToHour*Utils.PRICE_PER_HOUR;
	}
}
