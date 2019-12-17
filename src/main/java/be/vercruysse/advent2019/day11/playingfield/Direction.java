package be.vercruysse.advent2019.day11.playingfield;

public enum Direction {
    UP, RIGHT, DOWN, LEFT;

    public Direction getNext(Clockwise clockwise) {
        switch (clockwise) {
            case COUNTER_CLOCKWISE:
                switch (this) {
                    case UP:
                        return LEFT;
                    case RIGHT:
                        return UP;
                    case DOWN:
                        return RIGHT;
                    case LEFT:
                        return DOWN;
                }
            case CLOCKWISE:
                switch (this) {
                    case UP:
                        return RIGHT;
                    case RIGHT:
                        return DOWN;
                    case DOWN:
                        return LEFT;
                    case LEFT:
                        return UP;
                }
            default:
                throw new RuntimeException("Unknown clockwise direction " + clockwise + " for direction " + this);
        }
    }


}
