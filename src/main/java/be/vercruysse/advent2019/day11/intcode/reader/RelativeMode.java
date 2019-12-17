package be.vercruysse.advent2019.day11.intcode.reader;

import be.vercruysse.advent2019.day11.intcode.RelativeBase;

import java.util.List;

public class RelativeMode implements ParameterReader {

    @Override
    public Long readInput(int index, List<Long> inputList) {
        return inputList.get(inputList.get(index).intValue() + RelativeBase.getInstance().getBase().intValue());
    }

    @Override
    public Long readForPosition(int index, List<Long> inputList) {
        return inputList.get(index) + RelativeBase.getInstance().getBase().intValue();
    }
}
