package be.vercruysse.advent2019.day5.opcode;

import be.vercruysse.advent2019.day5.reader.ParamerReader;

import java.util.List;

public interface Opcode {

    int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList);
}
