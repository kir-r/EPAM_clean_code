package com.epam.planes;

import java.util.Objects;

abstract public class Plane{
    final String MODEL;
    private final int MAX_SPEED;
    private final int MAX_FLIGHT_DISTANCE;
    private final int MAX_LOAD_CAPACITY;

    public Plane(String MODEL, int MAX_SPEED, int MAX_FLIGHT_DISTANCE, int MAX_LOAD_CAPACITY) {
        this.MODEL = MODEL;
        this.MAX_SPEED = MAX_SPEED;
        this.MAX_FLIGHT_DISTANCE = MAX_FLIGHT_DISTANCE;
        this.MAX_LOAD_CAPACITY = MAX_LOAD_CAPACITY;
    }

    public int getMAX_SPEED() {
        return MAX_SPEED;
    }

    public int getMAX_FLIGHT_DISTANCE() {
        return MAX_FLIGHT_DISTANCE;
    }

    public int getMAX_LOAD_CAPACITY() {
        return MAX_LOAD_CAPACITY;
    }

    @Override
    public String toString() {
        return "Plane model: " + MODEL +
                ", maxSpeed = " + MAX_SPEED +
                ", maxFlightDistance = " + MAX_FLIGHT_DISTANCE +
                ", maxLoadCapacity = " + MAX_LOAD_CAPACITY + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Plane)) return false;
        Plane plane = (Plane) object;
        return MAX_SPEED == plane.MAX_SPEED &&
                MAX_FLIGHT_DISTANCE == plane.MAX_FLIGHT_DISTANCE &&
                MAX_LOAD_CAPACITY == plane.MAX_LOAD_CAPACITY &&
                Objects.equals(MODEL, plane.MODEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MODEL, MAX_SPEED, MAX_FLIGHT_DISTANCE, MAX_LOAD_CAPACITY);
    }
}
