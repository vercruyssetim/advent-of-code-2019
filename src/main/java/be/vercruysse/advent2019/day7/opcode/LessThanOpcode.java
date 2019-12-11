package be.vercruysse.advent2019.day7.opcode;

import be.vercruysse.advent2019.day7.reader.ParamerReader;

import java.util.List;

public class LessThanOpcode implements Opcode {

    @Override
    public int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList) {
        int left = paramerReaderList.get(0).readInput(index + 1, inputList);
        int right = paramerReaderList.get(1).readInput(index + 2, inputList);
        int position = inputList.get(index + 3);
        if(left < right) {
//            System.out.println("" + left + " is less than " + right + " so setting 1 at " + position);
            inputList.set(position, 1);
        } else {
//            System.out.println("" + left + " is greater than or equals " + right + " so setting 0 at " + position);
            inputList.set(position, 0);
        }
        return index + 4;
    }
}