package be.vercruysse.advent2019.day10;

public class Rico {

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
                '}';
    }

}
