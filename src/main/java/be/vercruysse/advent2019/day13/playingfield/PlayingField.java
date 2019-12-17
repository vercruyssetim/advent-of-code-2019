package be.vercruysse.advent2019.day13.playingfield;

import be.vercruysse.advent2019.day13.intcode.io.InputProvider;
import be.vercruysse.advent2019.day13.intcode.io.OutputListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayingField implements InputProvider, OutputListener {

    private final Scanner scanner;
    private Map<Coordinate, Long> field = new HashMap<>();

    private int commandCounter = 0;

    private long totalScore = 0;

    private Long savedXCoordinate;
    private Long savedYCoordinate;

    public PlayingField() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Long getInput() {
        System.out.println(this);
        Coordinate balCoordinate = getCoordinate(4L);
        Coordinate tileCoordinate = getCoordinate(3L);
        return (long) Integer.compare(balCoordinate.getX(), tileCoordinate.getX());
    }

    private Coordinate getCoordinate(long type) {
        for(Map.Entry<Coordinate, Long> entry: field.entrySet()){
            if(entry.getValue() == type) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("Not found! " + type);
    }

    public Map<Coordinate, Long> getField() {
        return field;
    }

    public long getTotalScore() {
        return totalScore;
    }

    @Override
    public void receiveOutput(Long value) {
        if (commandCounter % 3 == 0) {
            savedXCoordinate = value;
        }
        if (commandCounter % 3 == 1) {
            savedYCoordinate = value;
        }
        if (commandCounter % 3 == 2) {
            if(savedXCoordinate == -1 && savedYCoordinate == 0) {
                totalScore = value;
            }
            field.put(new Coordinate(savedXCoordinate.intValue(), savedYCoordinate.intValue()), value);

        }
        commandCounter++;
    }

    @Override
    public String toString() {
        String result = "Total score: " + totalScore + "\n";
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 40; j++) {
                if (field.containsKey(new Coordinate(j, i))) {
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
