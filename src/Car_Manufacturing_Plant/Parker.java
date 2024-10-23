package Car_Manufacturing_Plant;

import Car_Manufacturing_Plant.Storage.CarQueue;
import Car_Manufacturing_Plant.Storage.ParkingLot;
import Car_Manufacturing_Plant.Utils.Car;

public class Parker implements Runnable {
    Thread thread;
    CarQueue queue;
    ParkingLot park;

    Parker(CarQueue queue, ParkingLot park, String threadName) {
        this.park = park;
        this.queue = queue;
        thread = new Thread( this, threadName );
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                Car car = queue.getCar();
                park.parkCar( car );
            } catch ( Exception e ) {
                System.out.println( "Failed to park a car" );
            }
        }
    }
}
