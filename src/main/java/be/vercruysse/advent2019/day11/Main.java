package be.vercruysse.advent2019.day11;

import be.vercruysse.advent2019.day11.intcode.InstructionFactory;
import be.vercruysse.advent2019.day11.intcode.IntcodeComputer;
import be.vercruysse.advent2019.day11.intcode.io.SystemOutput;
import be.vercruysse.advent2019.day11.intcode.io.UserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        IntcodeComputer intcodeComputer = new IntcodeComputer(getInput(), new InstructionFactory(new UserInput(), new SystemOutput()));
        intcodeComputer.calculate();
    }

    private static List<Long> getInput() {
        List<Long> result = Stream.of(readFile("input.txt").stream()
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        for(int i = 0; i < 4000; i++) {
            result.add(0L);
        }
        return result;
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
