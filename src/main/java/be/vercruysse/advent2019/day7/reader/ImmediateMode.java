package be.vercruysse.advent2019.day7.reader;

import java.util.List;

public class ImmediateMode implements ParamerReader {
    @Override
    public int readInput(int index, List<Integer> inputList) {
        return inputList.get(index);
    }
}
