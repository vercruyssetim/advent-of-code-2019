package be.vercruysse.advent2019.day5;

import java.util.List;

public class ImmediateMode implements ParamerReader {
    @Override
    public int readInput(int index, List<Integer> inputList) {
        return inputList.get(index);
    }
}
