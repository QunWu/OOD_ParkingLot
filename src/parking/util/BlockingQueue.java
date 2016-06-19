package parking.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import parking.entity.inner_system.interfaces.WaitingQueue;

public class BlockingQueue implements WaitingQueue{
	private int[] queue = null;
	private int nextIn = 0;
	private int nextOut = 0;
	private int count = 0;
	
	private Lock lockForCount = null;
	private Lock lockForNextOut = null;
	
	public BlockingQueue(){
		this.queue = new int[Utils.QUEUE_CAPACITY];
		lockForCount = new ReentrantLock();
		lockForNextOut = new ReentrantLock();
	}
	
	@Override
	public synchronized void add(int carId) throws InterruptedException {
		while(this.isFull())
			wait();
		
		queue[nextIn++]= carId;
		nextIn = nextIn % Utils.QUEUE_CAPACITY;
		
		lockForCount.lock();
		count++;
		lockForCount.unlock();
		
		notifyAll();
	}
	
	@Override
	public synchronized int poll(int carId) throws InterruptedException{
		while(this.isEmpty() || carId != this.peek()){
System.out.println("41: thead is waited: count in queue is "+count+" when car "+ carId+" is quering. peek() function return "+this.peek()+", queue[nextOut] is "+queue[nextOut]);
			wait();
		}
		lockForNextOut.lock();
		nextOut = (nextOut+1) % Utils.QUEUE_CAPACITY;
		
		lockForCount.lock();
		count--;
		lockForCount.unlock();
		
		lockForNextOut.unlock();
		notifyAll();
		return carId;
	}

	@Override
	public boolean isEmpty() {
		lockForCount.lock();
		if(count== 0){
			lockForCount.unlock();
			return true;
		}else{
			lockForCount.unlock();
			return false;
		}
	}
	@Override
	public boolean isFull() {
		lockForCount.lock();
		if(count== Utils.QUEUE_CAPACITY){
			lockForCount.unlock();
			return true;
		}else{
			lockForCount.unlock();
			return false;
		}
	}	
	@Override
	public int peek() {
		lockForNextOut.lock();
		if(!this.isEmpty()){
			lockForNextOut.unlock();
			return queue[nextOut];
		}
		else{
			lockForNextOut.unlock();
			return Utils.GENERATOR_INIT_VALUE-1;
		}
	}
}
