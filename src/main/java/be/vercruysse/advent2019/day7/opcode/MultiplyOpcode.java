package be.vercruysse.advent2019.day7.opcode;

import be.vercruysse.advent2019.day7.reader.ParamerReader;

import java.util.List;

public class MultiplyOpcode implements Opcode {
    @Override
    public int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList) {
        int leftSide = paramerReaderList.get(0).readInput(index + 1, inputList);
        int rightSide = paramerReaderList.get(1).readInput(index + 2, inputList);
        int position = inputList.get(index + 3);

//        System.out.println("Multiplying " + leftSide +  " with " + rightSide + " and placing it at " + position);
        inputList.set(position, leftSide * rightSide);
        return index + 4;
    }
}
