package be.vercruysse.advent2019.day11.intcode.opcode;

import be.vercruysse.advent2019.day11.intcode.reader.ParameterReader;

import java.util.List;

public class PlusOpcode implements Opcode {

    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        Long leftSide = parameterReaderList.get(0).readInput(index + 1, inputList);
        Long rightSide = parameterReaderList.get(1).readInput(index + 2, inputList);
        int position = parameterReaderList.get(2).readForPosition(index + 3, inputList).intValue();

//        System.out.println("Adding " + leftSide +  " with " + rightSide + " and placing it at " + position);
        inputList.set(position, leftSide + rightSide);
        return index + 4;
    }
}
