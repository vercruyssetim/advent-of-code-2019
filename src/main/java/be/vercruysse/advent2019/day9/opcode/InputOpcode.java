package be.vercruysse.advent2019.day9.opcode;

import be.vercruysse.advent2019.day9.reader.ParameterReader;

import java.util.List;
import java.util.Scanner;

public class InputOpcode implements Opcode {

    private Scanner scanner;

    public InputOpcode() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        int position = parameterReaderList.get(0).readForPosition(index + 1, inputList).intValue();
        System.out.print(">");
        Long value = Long.parseLong(scanner.nextLine());

        System.out.println("Placing " + value + " at position " + position);
        inputList.set(position, value);
        return index + 2;
    }
}
