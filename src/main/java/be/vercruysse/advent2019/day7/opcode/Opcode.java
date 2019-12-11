package be.vercruysse.advent2019.day7.opcode;

import be.vercruysse.advent2019.day7.reader.ParamerReader;

import java.util.List;

public interface Opcode {

    int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList);
}
