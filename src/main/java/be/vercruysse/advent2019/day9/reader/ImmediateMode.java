package be.vercruysse.advent2019.day9.reader;

import java.util.List;

public class ImmediateMode implements ParameterReader {
    @Override
    public Long readInput(int index, List<Long> inputList) {
        return inputList.get(index);
    }

    @Override
    public Long readForPosition(int index, List<Long> inputList) {
        return inputList.get(index);
    }
}
