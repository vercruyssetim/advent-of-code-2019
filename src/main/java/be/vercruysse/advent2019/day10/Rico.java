package be.vercruysse.advent2019.day10;

public class Rico implements Comparable<Rico>{

    private int x;
    private int y;

    public Rico(int x, int y) {
        int gcd = gcd(Math.abs(x), Math.abs(y));
        if (gcd != 0) {
            this.x = x / gcd;
            this.y = y / gcd;
        } else {
            this.x = x;
            this.y = y;
        }
    }

    public float asNumber() {
        if(x == 0) {
            if(y < 0) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        return (float) y / (float) x;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Rico{" +
                "x=" + x +
                ", y=" + y +
                ", number=" + asNumber() +
                '}';
    }

    @Override
    public int compareTo(Rico otherRico) {
        int kwadrant = getKwadrant();
        int otherKwadrant = otherRico.getKwadrant();
        if(kwadrant == otherKwadrant) {
            return Float.compare(otherRico.asNumber(), asNumber());
        }
        return kwadrant - otherKwadrant;
    }

    private int getKwadrant() {
        if(x >= 0 && y > 0) {
            return 1;
        }
        if(x >= 0 && y <= 0) {
            return 2;
        }
        if(x < 0 && y <= 0) {
            return 3;
        }
        return 4;
    }
}
