package be.vercruysse.advent2019.day10;

import java.lang.management.MemoryManagerMXBean;
import java.util.Objects;
import java.util.Set;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean canHit(Coordinate astroid, Coordinate otherAstroid, Set<Coordinate> astroidList) {
        if(astroid.equals(otherAstroid)) {
            return false;
        }
        Rico rico = astroid.minus(otherAstroid);
        Coordinate next = astroid;
        while(!next.plus(rico).equals(otherAstroid)) {
            next = next.plus(rico);
            if(astroidList.contains(next)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid() {
        return x >= 0 && x < 24 && y >= 0 && y < 24;
    }

    private Coordinate plus(Rico rico) {
        return new Coordinate(x + rico.getX(), y + rico.getY());
    }

    private Rico minus(Coordinate otherAstroid) {
        return new Rico(otherAstroid.x -x, otherAstroid.y - y);
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
}
