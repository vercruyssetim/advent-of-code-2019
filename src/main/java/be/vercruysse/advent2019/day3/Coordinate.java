package be.vercruysse.advent2019.day3;

import java.util.Objects;

public class Coordinate implements Comparable<Coordinate> {

    private int x;
    private int y;

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

    public int getDistance() {
        return Math.abs(x) + Math.abs(y);
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

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    @Override
    public int compareTo(Coordinate coordinate) {
        if(x == coordinate.getX()) {
            return y - coordinate.getY();
        }
        return x - coordinate.getX();
    }
}
