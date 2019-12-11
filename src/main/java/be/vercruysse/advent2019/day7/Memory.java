package be.vercruysse.advent2019.day7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Memory {

    private static final Memory instance = new Memory();

    private Queue<Integer> phases = new LinkedList<>();
    private int output = 0;
    private int index = -1;

    public Memory() {
    }

    public static Memory getInstance() {
        return instance;
    }

    public int getNext() {
        index++;
        if (index % 2 == 0) {
            return phases.remove();
        }
        return output;
    }

    public void setPhases(List<Integer> phases) {
        this.phases.addAll(phases);
        output = 0;
        index = -1;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}
