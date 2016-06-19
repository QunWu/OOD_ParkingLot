package parking.boot;

import parking.entity.actor.Car;
import parking.entity.inner_system.ParkingLot;
import parking.util.Utils;

public class MainEntry {
	public static void main(String[] agrs){
		Utils.initUtils();
		ParkingLot container = new ParkingLot();
		
		Thread car_1 = new Car(container);
		Thread car_2 = new Car(container);
		Thread car_3 = new Car(container);
		Thread car_4 = new Car(container);
		
		car_1.start();
		car_2.start();
		car_3.start();
		car_4.start();
	}
}
