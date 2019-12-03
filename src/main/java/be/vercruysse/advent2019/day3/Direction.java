package be.vercruysse.advent2019.day3;

public enum Direction {
    UP, LEFT, DOWN, RIGHT;

    public static Direction toDirection(char direction) {
        switch (direction) {
            case 'U':
                return UP;
            case 'L':
                return LEFT;
            case 'D':
                return DOWN;
            case 'R':
                return RIGHT;
            default:
                throw new RuntimeException(""+ direction);
        }
    }
}
