package be.vercruysse.advent2019.day11.playingfield;

import static be.vercruysse.advent2019.day11.playingfield.Direction.UP;

public class Robot {

    private Coordinate currentCoordinate = new Coordinate(0,0);
    private Direction direction = UP;

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public void move(Clockwise clockwise) {
        direction = direction.getNext(clockwise);
        currentCoordinate = currentCoordinate.getNext(direction);
    }

    @Override
    public String toString() {
        return "Robot{" + currentCoordinate + ", " + direction + '}';
    }
}
