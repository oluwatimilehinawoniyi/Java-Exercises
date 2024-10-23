package Car_Manufacturing_Plant;

import Car_Manufacturing_Plant.Storage.CarQueue;
import Car_Manufacturing_Plant.Utils.Car;

public class Manufacturer implements Runnable {
    Thread thread;
    CarQueue queue;
    int car_id;

    Manufacturer(CarQueue queue, String threadName, int car_id) {
        this.queue = queue;
        thread = new Thread( this, threadName );
        this.car_id = car_id;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                var car = new Car( "Honda", car_id++ );
                queue.addCar( car );
                Thread.sleep( 2000 );
            } catch ( Exception e ) {
                System.out.println( "Failed to add a car" );
            }
        }
    }
}
