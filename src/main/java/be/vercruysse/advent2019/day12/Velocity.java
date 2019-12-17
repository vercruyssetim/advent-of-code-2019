package be.vercruysse.advent2019.day12;

public class Velocity {
    private int x;
    private int y;
    private int z;

    public Velocity(int x, int y, int z) {
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

    public Velocity add(Velocity otherVelocity) {
        return new Velocity(x + otherVelocity.getX(), y+ otherVelocity.getY(), z + otherVelocity.getZ());
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
