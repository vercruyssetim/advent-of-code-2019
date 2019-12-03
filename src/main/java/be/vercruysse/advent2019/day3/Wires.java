package be.vercruysse.advent2019.day3;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class Wires {

    public static void main(String[] args) {
        System.out.println(new Wires().findShortestDistance());
    }

    public int findShortestDistance() {
        List<String> result = readFile("input.txt");
        List<List<Track>> wires = result.stream()
                .map(t -> t.split(","))
                .map(this::toCoordinate)
                .collect(Collectors.toList());
        List<Coordinate> coordinateList1 = getCoordinateSet(wires.get(0));
        List<Coordinate> coordinateList2 = getCoordinateSet(wires.get(1));
        Sets.SetView<Coordinate> intersection = Sets.intersection(Sets.newHashSet(coordinateList1), Sets.newHashSet(coordinateList2));

        System.out.println(intersection);
        System.out.println(intersection.stream()
                .map(i -> coordinateList1.indexOf(i) + coordinateList2.indexOf(i))
                .sorted()
                .collect(Collectors.toList()));
        return 0;
//        return coordinateSet.stream().map(Coordinate::getDistance).sorted().findFirst().orElse(0);
    }

    private List<Coordinate> getCoordinateSet(List<Track> firstWire) {
        List<Coordinate> totalSet = new ArrayList<>();
        Coordinate startingCoordinate = new Coordinate(0, 0);
        for (Track track : firstWire) {
            List<Coordinate> line = getLine(startingCoordinate, track);
            startingCoordinate = line.get(line.size() - 1);
            System.out.println(line);
            totalSet.addAll(line);
        }
        return totalSet;
    }

    private List<Coordinate> getLine(Coordinate startingCoordinate, Track track) {
        switch (track.getDirection()) {
            case UP:
                return IntStream.rangeClosed(1, track.getDistance()).mapToObj(m -> new Coordinate(startingCoordinate.getX(), m + startingCoordinate.getY())).collect(Collectors.toList());
            case DOWN:
                return IntStream.rangeClosed(-track.getDistance(), -1).mapToObj(m -> new Coordinate(startingCoordinate.getX(), m + startingCoordinate.getY())).sorted(reverseOrder()).collect(Collectors.toList());
            case LEFT:
                return IntStream.rangeClosed(-track.getDistance(), -1).mapToObj(m -> new Coordinate(m + startingCoordinate.getX(), startingCoordinate.getY())).sorted(reverseOrder()).collect(Collectors.toList());
            case RIGHT:
                return IntStream.rangeClosed(1, track.getDistance()).mapToObj(m -> new Coordinate(m + startingCoordinate.getX(), startingCoordinate.getY())).collect(Collectors.toList());
            default:
                throw new RuntimeException();
        }
    }

    private List<Track> toCoordinate(String[] wire) {
        return Stream.of(wire).map(this::toCoordinate).collect(Collectors.toList());
    }

    private Track toCoordinate(String string) {
        return new Track(Direction.toDirection(string.charAt(0)), Integer.parseInt(string.substring(1)));
    }

    private List<String> readFile(String fileName) {
        InputStream resource = this.getClass().getResourceAsStream(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}
