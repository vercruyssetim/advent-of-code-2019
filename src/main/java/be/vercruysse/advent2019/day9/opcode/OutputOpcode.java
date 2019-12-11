package be.vercruysse.advent2019.day9.opcode;

import be.vercruysse.advent2019.day9.reader.ParameterReader;

import java.util.List;

public class OutputOpcode implements Opcode {
    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        Long value = parameterReaderList.get(0).readInput(index + 1, inputList);

        System.out.println("Output " + value);
        return index + 2;
    }
}
