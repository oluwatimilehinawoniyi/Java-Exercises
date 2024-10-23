package Car_Manufacturing_Plant.Storage;

import Car_Manufacturing_Plant.Utils.*;

/**
 * FreeSlots - a storage for parking slots
 * whose cars have been retrieved
 */

public class FreeSlots {
    private int front, rear, size, capacity;
    private Coordinate[] queue;

    FreeSlots(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException(
                "Capacity must be positive");
        this.capacity = capacity;
        queue = new Coordinate[capacity];
        front = rear = size = 0;
    }

    public void addSlot(int x, int y) {
        if (size == queue.length) throw new IllegalStateException(
                "Slots are full");
        queue[rear] = new Coordinate(x, y);
        rear = (rear + 1) % capacity;
        size++;
    }

    public Coordinate removeSlot () {
        if (size == 0) {
            throw new IllegalStateException("Slots are empty");
        }

        Coordinate points = queue[front];
        front = (front + 1) % capacity;
        size--;
        return points;
    }
}
