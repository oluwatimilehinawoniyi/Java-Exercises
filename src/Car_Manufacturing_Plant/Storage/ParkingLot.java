package Car_Manufacturing_Plant.Storage;

import Car_Manufacturing_Plant.Utils.*;

import java.util.Arrays;

public class ParkingLot {
    //    Car[][] Park;
    // FreeSlots freeSlots;
    Car[] Park;
    int size, capacity, front, rear;

    public ParkingLot(int capacity) {
        // this.freeSlots = new FreeSlots( 100 );
        this.capacity = capacity;
        this.Park = new Car[capacity];
        this.size = this.front = this.rear = 0;
    }

    public int getSize() {
        return this.size;
    }

//    synchronized public void parkCar(Car car) {
//        for ( int i = 0; i < Park.length; i++ ) {
//            for ( int j = 0; j < Park[i].length; j++ ) {
//                if ( Park[i][j] == null ) {
//                    Park[i][j] = car;
//                    System.out.println( car.toString() +
//                            " parked at slot [ "
//                            +
//                            Arrays.toString( Park[i] ) + " ] row - [ "
//                            + Park[i][j] + "] " +
//                            "column." );
//
//                    return;
//                }
//            }
//        }
//        System.out.println( "Parking lot is full!" );
//    }
//
//    synchronized public void retrieveCar(Coordinate slot) {
//        Car car = Park[slot.x][slot.y];
//        System.out.println(car.toString() +
//                " retrieved from slot [ "
//                +
//                slot.x + " ] row - [ " + slot.y + "] " +
//                "column.");
//        Park[slot.x][slot.y] = null;
//        // freeSlots.addSlot( slot.x, slot.y );
//    }

    synchronized public void parkCar(Car car) {
        while ( size == Park.length ) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() +
                        " waiting for an empty space in the " +
                        "Car Park. WHILE HOLDING ---> " + car.toString() );
            } catch ( InterruptedException e ) {
                System.out.println( "Park is full!" );
            }
        }
        Park[rear] = car;
        rear = (rear + 1) % capacity;
        System.out.println(Thread.currentThread().getName() + ": " + car.toString() + " successfully parked!");
        size++;
        notify();
    }

    synchronized public void retrieveCar() {
        while ( size == 0 ) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() +
                        " waiting for a car to be parked...");
            } catch ( InterruptedException e ) {
                System.out.println( "CarQueue is empty!" );
            }
        }
        Car car = Park[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(Thread.currentThread().getName() + ": " + car.toString() + " successfully retrieved!");
        notify();
    }
}