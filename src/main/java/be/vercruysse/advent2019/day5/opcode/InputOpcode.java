package be.vercruysse.advent2019.day5.opcode;

import be.vercruysse.advent2019.day5.ParamerReader;

import java.util.List;
import java.util.Scanner;

public class InputOpcode implements Opcode {

    private Scanner scanner;

    public InputOpcode() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList) {
        int position = inputList.get(index + 1);
        System.out.print(">");
        int value = Integer.parseInt(scanner.nextLine());

        System.out.println("Placing " + value + " at position " + position);
        inputList.set(position, value);
        return index + 2;
    }
}
