package Car_Manufacturing_Plant;

import Car_Manufacturing_Plant.Storage.CarQueue;
import Car_Manufacturing_Plant.Storage.ParkingLot;

public class CarPlantDemo {
    public static void main(String[] args) {
        CarQueue carQueue = new CarQueue( 2 );
        ParkingLot parkingLot = new ParkingLot( 1 );

        Manufacturer M = new Manufacturer( carQueue, "Manufacturer One"
                , 10 );


        Parker P = new Parker( carQueue, parkingLot, "Parker One" );

        Retriever R = new Retriever( parkingLot );

        M.thread.start();
        P.thread.start();
        R.thread.start();

    }
}
