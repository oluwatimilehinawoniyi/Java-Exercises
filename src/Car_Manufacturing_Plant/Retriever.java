package Car_Manufacturing_Plant;

import Car_Manufacturing_Plant.Storage.ParkingLot;

import java.util.Random;

public class Retriever implements Runnable {
    Thread thread;
    ParkingLot park;

    Retriever(ParkingLot park) {
        this.park = park;
        thread = new Thread( this, "Retriever" );
    }

    @Override
    public void run() {
        Random random = new Random();

        while ( true ) {
//            int x = random.nextInt( 6 );
//            int y = random.nextInt( 6 );
//            var coords = new Coordinate( x, y );
            try {
                park.retrieveCar();
                Thread.sleep( 4000 );
            } catch ( Exception e ) {
                System.out.println( "Failed to retrieve a car from Park" );
            }
        }
    }
}
