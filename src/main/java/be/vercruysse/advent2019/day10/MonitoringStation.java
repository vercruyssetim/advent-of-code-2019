package be.vercruysse.advent2019.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class MonitoringStation {

    private Set<Coordinate> astroidList;

    public MonitoringStation(Set<Coordinate> astroidList) {
        this.astroidList = astroidList;
    }

    public static void main(String[] args) {
        MonitoringStation monitoringStation = new MonitoringStation(getAstroidList());
//        System.out.println(monitoringStation.findCoordinate());
        System.out.println(monitoringStation.findXthCollision(new Coordinate(20,18), 200));
    }

    private boolean findXthCollision(Coordinate coordinate, int i) {
        astroidList.stream()
                .filter(t -> Coordinate.canHit(coordinate, t, astroidList))
                .sorted(Comparator.comparing(t -> coordinate.specialMinus(t)))
                .limit(i)
                .forEach(t -> System.out.println("" + t + " " + coordinate.specialMinus(t)));
        return true;
    }


    private int findCoordinate() {
        return astroidList.stream()
                .mapToInt(this::getNumberOfCollisions)
                .max()
                .orElse(0);
    }

    private int getNumberOfCollisions(Coordinate astroid) {
        int count = (int) astroidList.stream()
                .filter(t -> Coordinate.canHit(astroid, t, astroidList))
                .count();
        System.out.println("Number of collisions " + count + " found for " + astroid);
        return count;
    }

    private static List<String> readFile(String fileName) {
        InputStream resource = MonitoringStation.class.getResourceAsStream(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static Set<Coordinate> getAstroidList() {
        Set<Coordinate> astroidList = new HashSet<>();
        List<String> input = readFile("input.txt");
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(y).length(); x++) {
                if (input.get(y).charAt(x) == '#') {
                    astroidList.add(new Coordinate(x, y));
                }
            }
        }
        return astroidList;
    }
}
