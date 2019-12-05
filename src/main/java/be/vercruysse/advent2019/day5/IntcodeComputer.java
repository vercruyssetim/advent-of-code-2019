package be.vercruysse.advent2019.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static be.vercruysse.advent2019.day5.Instruction.instruction;

public class IntcodeComputer {

    public static void main(String[] args) {
        IntcodeComputer intcodeComputer = new IntcodeComputer();
        intcodeComputer.calculate();
    }

    private void calculate() {
        List<Integer> inputList = getInput();
        for (int i = 0; i < inputList.size();) {
            Instruction instruction = readInstruction(inputList.get(i));
            i = instruction.execute(i, inputList);
        }
    }

    private Instruction readInstruction(Integer input) {
        String stringInput = String.valueOf(input);
        return instruction(addLeadingZeros(stringInput));
    }

    private char[] addLeadingZeros(String stringInput) {
        char[] characters = "000000".toCharArray();
        for(int i = 0; i < stringInput.length(); i++) {
            characters[characters.length - (i + 1)] = stringInput.charAt(stringInput.length() - (i + 1));
        }
        return characters;
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
