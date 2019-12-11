package be.vercruysse.advent2019.day7.opcode;

import be.vercruysse.advent2019.day7.reader.ParamerReader;

import java.util.List;

public class JumpIfFalseOpcode implements Opcode {
    @Override
    public int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList) {
        int check = paramerReaderList.get(0).readInput(index + 1, inputList);
        int indexToJumpTo = paramerReaderList.get(1).readInput(index + 2, inputList);
        if(check == 0) {
//            System.out.println("Jump if false " + check + " is zero so jumping to " + indexToJumpTo);
            return indexToJumpTo;
        }
//        System.out.println("Jump if false " + check + " is not zero so doing nothing");
        return index + 3;
    }
}
