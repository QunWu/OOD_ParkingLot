package parking.entity.inner_system.interfaces;

import parking.entity.inner_system.Ticket;


public interface UseCases {
	public boolean enter(int carId);
	public Ticket getTicket(int carId);
	public boolean quit(int carId);
	public double pay(Ticket ticket); 
}
