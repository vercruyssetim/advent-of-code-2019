package be.vercruysse.advent2019.day6;

import com.google.common.base.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrbitCalculator {

    public static void main(String[] args) {
        OrbitCalculator orbitCalculator = new OrbitCalculator();
        System.out.println(orbitCalculator.totalNumberOfOrbits());
    }

    private int totalNumberOfOrbits() {
        Map<String, Orbit> orbitMap = createOrbitMap();

        readFile("input.txt")
                .stream()
                .map(o -> o.split("\\)"))
                .forEach(t -> orbitMap.get(t[1]).setParent(orbitMap.get(t[0])));


        Orbit orbit = orbitMap.get("YOU");

        return stepsToSAN(orbit.getAllConnections(), new ArrayList<>());
    }

    private int stepsToSAN(List<Orbit> connections, List<Orbit> passedConnections) {
        boolean san = connections
                .stream()
                .map(t1 -> t1.getName())
                .anyMatch(t1 -> t1.equals("SAN"));
        if(san) {
            return 0;
        }

        passedConnections.addAll(connections);

        List<Orbit> nextOrbits = connections.stream()
                .flatMap(t -> t.getAllConnections().stream())
                .filter(Objects::nonNull)
                .filter(t -> !passedConnections.contains(t))
                .collect(Collectors.toList());

        return 1 + stepsToSAN(nextOrbits, passedConnections);
    }

    private int calculateTotalOrbits(Orbit orbit) {
        if(orbit.getParent() == null) {
            return 0;
        }
        return 1 + calculateTotalOrbits(orbit.getParent());
    }

    private Map<String, Orbit> createOrbitMap() {
        Map<String, Orbit> map = new HashMap<>();
        readFile("input.txt")
                .stream()
                .map(o -> o.split("\\)"))
                .flatMap(Stream::of)
                .distinct()
                .filter(t -> !Strings.isNullOrEmpty(t))
                .forEach(t -> map.put(t, new Orbit(t)));
        return map;
    }


    private List<String> readFile(String fileName) {
        InputStream resource = this.getClass().getResourceAsStream(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
