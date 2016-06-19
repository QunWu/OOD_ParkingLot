package parking.entity.actor;

import parking.entity.inner_system.ParkingLot;
import parking.entity.inner_system.Ticket;
import parking.entity.inner_system.interfaces.UseCases;
import parking.util.Utils;

public class Car extends Thread implements UseCases{

	private ParkingLot container = null;
	private Ticket ticket = null;
	private int carId = Utils.GENERATOR_INIT_VALUE-1;
	
	public Car(ParkingLot container) {
		this.container = container;
	}
	
	@Override
	public void run(){
		this.executeSequence();
	}
	
	public final void executeSequence(){
		this.setCarId();
		boolean reqSuccessfully = this.enter(carId);
		if(reqSuccessfully){
			this.ticket = this.getTicket(carId);
			if (ticket != null) {
				try {
					Thread.sleep(1500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				boolean quitSuccessfully = this.quit(carId);
				if (quitSuccessfully)
System.out.println("Car " + carId+ " quit the parking lot and cost $"+ this.pay(this.ticket));
				else
System.out.println("Car "+carId+" fails to entrer quit_waiting_queue");
			}else
System.out.println("Car "+carId+" fails to get a ticket after enter enter_waiting_queue");
		}else
System.out.println("Car "+carId+" fails to entrer enter_waiting_queue");
	}

	public boolean enter(int carId) {
		return this.container.enter(carId);
	}

	public Ticket getTicket(int carId) {
		return this.container.getTicket(carId);
	}

	public boolean quit(int carId) {
		return this.container.quit(carId);
	}

	public double pay(Ticket ticket) {
		return this.container.pay(ticket);
	}
	
	public void setCarId(){
		this.carId = Utils.getGeneratedCarId();
	}
}
