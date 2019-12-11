package be.vercruysse.advent2019.day7.reader;

import java.util.List;

public class PositionMode implements ParamerReader {

    @Override
    public int readInput(int index, List<Integer> inputList) {
        return inputList.get(inputList.get(index));
    }
}
