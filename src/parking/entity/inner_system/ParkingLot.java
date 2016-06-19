package parking.entity.inner_system;

import parking.entity.inner_system.interfaces.UseCases;
import parking.util.GateServices;

public class ParkingLot implements UseCases {
	
	private GateServices gate = null;
	
	public ParkingLot(){
		this.gate = new Gate();
	}
	
	@Override
	public boolean enter(int carId) {
		return this.gate.enter(carId);
	}

	@Override
	public Ticket getTicket(int carId) {
		return this.gate.getTicket(carId);
	}

	@Override
	public boolean quit(int carId) {
		return this.gate.quit(carId);
	}

	@Override
	public double pay(Ticket ticket) {
		return this.gate.pay(ticket);
	}

}
