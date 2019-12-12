package be.vercruysse.advent2019.day10;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.newHashSet;

public class MonitoringStation {

    private Set<Coordinate> astroidList;

    public MonitoringStation(Set<Coordinate> astroidList) {
        this.astroidList = astroidList;
    }

    public static void main(String[] args) {
        MonitoringStation monitoringStation = new MonitoringStation(getAstroidList());
        System.out.println(monitoringStation.findCoordinate());
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
                .sorted()
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
