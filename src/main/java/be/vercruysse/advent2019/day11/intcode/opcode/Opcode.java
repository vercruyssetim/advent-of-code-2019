package be.vercruysse.advent2019.day11.intcode.opcode;

import be.vercruysse.advent2019.day11.intcode.reader.ParameterReader;

import java.util.List;

public interface Opcode {

    int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList);
}
