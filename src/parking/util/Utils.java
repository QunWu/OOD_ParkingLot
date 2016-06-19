package parking.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
	public static final int GENERATOR_INIT_VALUE = 0;
	public static final int QUEUE_CAPACITY = 10;
	public static final double PRICE_PER_HOUR = 1.0;
	
	private static AtomicInteger CAR_ID_GENERATER = null;
	private static AtomicInteger TICKET_ID_GENERATER = null;
	
	public static void initUtils(){
		if(CAR_ID_GENERATER == null)
			CAR_ID_GENERATER = new AtomicInteger(GENERATOR_INIT_VALUE);
		if(TICKET_ID_GENERATER == null)
			TICKET_ID_GENERATER= new AtomicInteger(GENERATOR_INIT_VALUE);
	}
	
	public static int getGeneratedCarId(){
		return CAR_ID_GENERATER.incrementAndGet();
	}
	
	public static int getGeneratedTicketId(){
		return TICKET_ID_GENERATER.incrementAndGet();
	}
}
