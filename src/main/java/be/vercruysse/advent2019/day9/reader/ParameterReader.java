package be.vercruysse.advent2019.day9.reader;

import java.util.List;

public interface ParameterReader {
    Long readInput(int index, List<Long> inputList);

    Long readForPosition(int index, List<Long> inputList);
}
