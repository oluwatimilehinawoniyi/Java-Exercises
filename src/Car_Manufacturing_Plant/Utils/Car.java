package Car_Manufacturing_Plant.Utils;

import Car_Manufacturing_Plant.Enums.Status;

/**
 * Car -
 */

public class Car {
    private int id;
    private String name;
    private Status status;

    public Car(String name, int id) {
        this.name = name;
        this.id = id;
        this.status = Status.NotProduced;
    }

    @Override
    public String toString() {
        return this.name + " " + this.id;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
