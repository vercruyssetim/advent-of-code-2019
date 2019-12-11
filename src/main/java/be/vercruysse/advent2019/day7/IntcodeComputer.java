package be.vercruysse.advent2019.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntcodeComputer {

    public static void main(String[] args) {
        IntcodeComputer intcodeComputer = new IntcodeComputer();
        intcodeComputer.calculate();
    }

    private void calculate() {
        PermutationGenerator permutationGenerator = new PermutationGenerator();
        System.out.println(permutationGenerator.getPermutations());
        System.out.println(permutationGenerator.getPermutations().size());
        Integer maximum = permutationGenerator
                .getPermutations()
                .stream()
                .map(t -> calculatePermutation(t))
                .max(Integer::compareTo)
                .orElse(0);

        System.out.println(maximum);
    }

    private int calculatePermutation(List<Integer> permutation) {
        System.out.println();
        System.out.println("******************");
        System.out.println("Trying for configuration " + permutation);
        System.out.println();
        List<Amplifier> amplifierList = new ArrayList<>();
        for (int amplifierIndex = 0; amplifierIndex < 5; amplifierIndex++) {
            amplifierList.add(new Amplifier("" + ((char) ('a' + amplifierIndex)), permutation.get(amplifierIndex), getInput()));
        }

        for(int amplifierIndex = 0; amplifierIndex < 5; amplifierIndex++) {
            amplifierList.get(amplifierIndex).setNextAmplififier(amplifierList.get((amplifierIndex + 1) % 5));
        }

        amplifierList.get(0).setInput(0);
        amplifierList.get(0).calculate();

        return amplifierList.get(0).getInput();
    }

    private List<Integer> getInput() {
        return Stream.of(readFile("input.txt").stream()
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
