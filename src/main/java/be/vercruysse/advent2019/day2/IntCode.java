package be.vercruysse.advent2019.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntCode {

    public static void main(String[] args) {
        System.out.println(new IntCode().findNounAndVerb());
    }

    public Integer findNounAndVerb() {
        List<Integer> integerList = getInput();

        for (int i = 0; i < integerList.size(); i++) {
            for (int j = 0; j < integerList.size(); j++) {
                Integer result = runIntcodeComputer(new ArrayList<>(integerList), i, j);
                if(result == 19690720) {
                    return (i * 100) + j;
                }
            }
        }
        return 0;
    }

    private Integer runIntcodeComputer(List<Integer> integerList, int noun, int verb) {
        integerList.set(1, noun);
        integerList.set(2, verb);
        for (int i = 0; i < integerList.size(); i += 4) {
            int result;
            switch (integerList.get(i)) {
                case 1:
                    result = integerList.get(integerList.get(i + 1)) + integerList.get(integerList.get(i + 2));
                    break;
                case 2:
                    result = integerList.get(integerList.get(i + 1)) * integerList.get(integerList.get(i + 2));
                    break;
                case 99:
                    System.out.println(integerList);
                    return integerList.get(0);
                default:
                    throw new RuntimeException("");
            }
            integerList.set(integerList.get(i + 3), result);
        }
        throw new RuntimeException("");
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
