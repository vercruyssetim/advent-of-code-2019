package be.vercruysse.advent2019.day5.reader;

import be.vercruysse.advent2019.day5.reader.ParamerReader;

import java.util.List;

public class ImmediateMode implements ParamerReader {
    @Override
    public int readInput(int index, List<Integer> inputList) {
        return inputList.get(index);
    }
}
