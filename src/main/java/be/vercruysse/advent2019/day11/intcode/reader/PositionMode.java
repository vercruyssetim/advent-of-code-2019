package be.vercruysse.advent2019.day11.intcode.reader;

import java.util.List;

public class PositionMode implements ParameterReader {

    @Override
    public Long readInput(int index, List<Long> inputList) {
        return inputList.get(inputList.get(index).intValue());
    }

    @Override
    public Long readForPosition(int index, List<Long> inputList) {
        return inputList.get(index);
    }
}
