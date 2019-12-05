package be.vercruysse.advent2019.day5.opcode;

import be.vercruysse.advent2019.day5.ParamerReader;

import java.util.List;

public interface Opcode {

    int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList);
}
