package be.vercruysse.advent2019.day5.opcode;

import be.vercruysse.advent2019.day5.ParamerReader;

import java.util.List;

public class OutputOpcode implements Opcode {
    @Override
    public int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList) {
        int value = paramerReaderList.get(0).readInput(index + 1, inputList);

        System.out.println("Output " + value);
        return index + 2;
    }
}
