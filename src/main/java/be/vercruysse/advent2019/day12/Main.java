package be.vercruysse.advent2019.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        List<Moon> moons = getInput()
                .stream()
                .map(t -> new Moon(t))
                .collect(Collectors.toList());

        NBody nBody = new NBody(moons);
        long i = 0;
        do {
            nBody.calculateNextStep();
            i++;
        } while (!nBody.allMoonsAreBackFor('z'));

        System.out.println(i);


    }

    private static List<Coordinate> getInput() {
        Pattern pattern = Pattern.compile("<x=(.*), y=(.*), z=(.*)>.*");
        return readFile("input.txt").stream()
                .map(pattern::matcher)
                .peek(Matcher::find)
                .map(t -> new Coordinate(parseInt(t.group(1)), parseInt(t.group(2)), parseInt(t.group(3))))
                .collect(Collectors.toList());
    }

    private static List<String> readFile(String fileName) {
        InputStream resource = Main.class.getResourceAsStream(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
