package be.vercruysse.advent2019.day7.opcode;

import be.vercruysse.advent2019.day7.Amplifier;
import be.vercruysse.advent2019.day7.Memory;
import be.vercruysse.advent2019.day7.reader.ParamerReader;

import java.util.List;
import java.util.Scanner;

public class InputOpcode implements Opcode {

    private Amplifier amplifier;

    public InputOpcode(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    @Override
    public int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList) {
        int position = inputList.get(index + 1);
        int value = amplifier.getInput();

        System.out.println("Amplifier " + amplifier.getName() + " is reading input " + value);
//        System.out.println("Placing " + value + " at position " + position);
        inputList.set(position, value);
        return index + 2;
    }
}
