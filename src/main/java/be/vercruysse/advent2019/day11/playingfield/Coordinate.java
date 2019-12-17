package be.vercruysse.advent2019.day11.playingfield;

import java.util.Objects;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return '(' + x + ", " + y + ')';
    }

    public Coordinate getNext(Direction direction) {
        switch (direction) {
            case UP:
                return new Coordinate(x, y + 1);
            case RIGHT:
                return new Coordinate(x + 1, y);
            case DOWN:
                return  new Coordinate(x, y - 1);
            case LEFT:
                return new Coordinate(x - 1, y);
            default:
                throw new RuntimeException("Unknown direction " + direction);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
