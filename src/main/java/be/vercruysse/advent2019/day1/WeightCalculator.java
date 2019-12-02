package be.vercruysse.advent2019.day1;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class WeightCalculator {

    public static void main(String[] args) {
        new WeightCalculator().calculateWeight();
    }

    public void calculateWeight() {
        int total = readFile("input.txt")
                .stream()
                .map(Integer::valueOf)
                .map(this::toFuel)
                .reduce(0, Integer::sum);

        System.out.println(total);
    }

    private int toFuel(int mass) {
        int tempResult = (mass / 3) - 2;
        if (tempResult <= 0) {
            return 0;
        }
        return tempResult + toFuel(tempResult);
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
