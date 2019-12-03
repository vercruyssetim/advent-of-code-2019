package be.vercruysse.advent2019.day3;

import java.util.Objects;

public class Track {

    private Direction direction;
    private int distance;

    public Track(Direction direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "horizontal=" + direction +
                ", vertical=" + distance +
                '}';
    }
}
