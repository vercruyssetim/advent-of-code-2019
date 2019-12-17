package be.vercruysse.advent2019.day12;

import static java.lang.Integer.compare;

public class Coordinate {

    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Velocity getDifference(Coordinate otherCoordinate) {
        return new Velocity(compare(otherCoordinate.getX(), x), compare(otherCoordinate.getY(), y), compare(otherCoordinate.getZ(), z));
    }

    public Coordinate change(Velocity velocity) {
        return new Coordinate(x + velocity.getX(), y + velocity.getY(), z + velocity.getZ());
    }

    @Override
    public String toString() {
        return "<x=" + x + ", y=" + y + ", z=" + z + '>';
    }

    public int getEnergy() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    public int get(char dimension) {
        switch (dimension) {
            case 'x':
                return x;
            case 'y':
                return y;
            case 'z':
                return z;
            default:
                throw new RuntimeException("Unknown dimension " + dimension);
        }
    }
}
