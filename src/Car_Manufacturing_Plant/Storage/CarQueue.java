package Car_Manufacturing_Plant.Storage;

import Car_Manufacturing_Plant.Utils.Car;

/**
 * CarQueue - a storage for manufactured cars. Also,
 * the place cars are picked to be parked.
 */

public class CarQueue {
    private int front, rear, size, capacity;
    private Car[] queue;

    public CarQueue(int capacity) {
        if ( capacity <= 0 ) {
            throw new IllegalArgumentException(
                    "Capacity must be positive!"
            );
        }
        this.capacity = capacity;
        queue = new Car[capacity];
        front = rear = size = 0;
    }

    synchronized public void addCar(Car car) {
        while ( size == queue.length ) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() +
                        " waiting for car line queue to be free...");
            } catch ( InterruptedException e ) {
                System.out.println( "CarQueue is full!" );
            }
        }
        queue[rear] = car;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println(Thread.currentThread().getName() + ": " + car.toString() + " successfully produced!");
        notify();
    }

    synchronized public Car getCar() {
        while ( size == 0 ) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName() +
                        " waiting for car to be produced...");
            } catch ( InterruptedException e ) {
                System.out.println( "CarQueue is empty!" );
            }
        }
        Car car = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(Thread.currentThread().getName() + ": " + car.toString() + " successfully taken!");
        notify();
        return car;
    }
}
