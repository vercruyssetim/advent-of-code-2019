package be.vercruysse.advent2019.day9.opcode;

import be.vercruysse.advent2019.day9.reader.ParameterReader;

import java.util.List;

public class LessThanOpcode implements Opcode {

    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        Long left = parameterReaderList.get(0).readInput(index + 1, inputList);
        Long right = parameterReaderList.get(1).readInput(index + 2, inputList);
        int position = parameterReaderList.get(2).readForPosition(index + 3, inputList).intValue();
        if(left < right) {
            System.out.println("" + left + " is less than " + right + " so setting 1 at " + position);
            inputList.set(position, 1L);
        } else {
            System.out.println("" + left + " is greater than or equals " + right + " so setting 0 at " + position);
            inputList.set(position, 0L);
        }
        return index + 4;
    }
}
