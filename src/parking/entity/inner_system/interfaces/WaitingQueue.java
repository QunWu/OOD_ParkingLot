package parking.entity.inner_system.interfaces;

public interface WaitingQueue {
	public void add(int carId)throws InterruptedException;
	public int poll(int carId)throws InterruptedException;
	public boolean isEmpty();
	public boolean isFull();
	public int peek();
}
