package be.vercruysse.advent2019.day9.opcode;

import be.vercruysse.advent2019.day9.reader.ParameterReader;

import java.util.List;

public class JumpIfTrueOpcode implements Opcode {
    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        Long check = parameterReaderList.get(0).readInput(index + 1, inputList);
        int indexToJumpTo = parameterReaderList.get(1).readInput(index + 2, inputList).intValue();
        if(check != 0) {
            System.out.println("Jump if true " + check + " is not zero so jumping to " + indexToJumpTo);
            return indexToJumpTo;
        }
        System.out.println("Jump if true " + check + " is zero so doing nothing");
        return index + 3;
    }
}
