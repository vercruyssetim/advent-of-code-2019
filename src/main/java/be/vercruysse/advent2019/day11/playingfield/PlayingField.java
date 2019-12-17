package be.vercruysse.advent2019.day11.playingfield;

import be.vercruysse.advent2019.day11.intcode.io.InputProvider;
import be.vercruysse.advent2019.day11.intcode.io.OutputListener;

import java.util.HashMap;
import java.util.Map;

import static be.vercruysse.advent2019.day11.playingfield.Clockwise.CLOCKWISE;
import static be.vercruysse.advent2019.day11.playingfield.Clockwise.COUNTER_CLOCKWISE;

public class PlayingField implements InputProvider, OutputListener {

    private Map<Coordinate, Character> field = new HashMap<>();
    private Robot robot = new Robot();

    private int commandCounter = 0;

    public PlayingField() {
        field.put(new Coordinate(0,0), '#');
    }

    @Override
    public Long getInput() {
        if (!field.containsKey(robot.getCurrentCoordinate())) {
            return 0L;
        }
        if (field.get(robot.getCurrentCoordinate()) == '.') {
            return 0L;
        }
        if (field.get(robot.getCurrentCoordinate()) == '#') {
            return 1L;
        }
        throw new RuntimeException("Unknown field character " + field.get(robot.getCurrentCoordinate()));
    }

    @Override
    public void receiveOutput(Long value) {
        if (commandCounter % 2 == 0) {
            field.put(robot.getCurrentCoordinate(), toCharacter(value));
            System.out.println("Painting " + value + " robot " + robot);
        } else {
            robot.move(toClockwise(value));
            System.out.println("Moving robot: " + robot);
        }
        commandCounter++;
    }

    private Clockwise toClockwise(Long value) {
        switch (value.intValue()) {
            case 0:
                return CLOCKWISE;
            case 1:
                return COUNTER_CLOCKWISE;
            default:
                throw new RuntimeException("Unknown clockwise direction " + value);
        }
    }

    private char toCharacter(Long value) {
        if (value.equals(1L)) {
            return '#';
        }
        if (value.equals(0L)) {
            return ' ';
        }
        throw new RuntimeException("Unknown input for field " + value);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = -5; i < 1; i++) {
            for(int j = -50; j < 30; j++) {
                if(field.containsKey(new Coordinate(j, i))) {
                    result += field.get(new Coordinate(j, i));
                } else {
                    result += ' ';
                }
            }
            result += "\n";
        }
        return result;
    }
}
