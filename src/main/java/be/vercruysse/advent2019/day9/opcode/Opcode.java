package be.vercruysse.advent2019.day9.opcode;

import be.vercruysse.advent2019.day9.reader.ParameterReader;

import java.util.List;

public interface Opcode {

    int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList);
}
