package be.vercruysse.advent2019.day7.opcode;

import be.vercruysse.advent2019.day7.Amplifier;
import be.vercruysse.advent2019.day7.Memory;
import be.vercruysse.advent2019.day7.reader.ParamerReader;

import java.util.List;

public class OutputOpcode implements Opcode {
    private Amplifier amplifier;

    public OutputOpcode(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    @Override
    public int run(int index, List<Integer> inputList, List<ParamerReader> paramerReaderList) {
        int value = paramerReaderList.get(0).readInput(index + 1, inputList);

        System.out.println("Outputing value " + value + " from amplifier " + amplifier.getName() + " to amplifier " + amplifier.getNameOfNextAmplifier());
        amplifier.setInputNextAmplifier(value);
        amplifier.setInstructionIndex(index + 2);
        amplifier.calculateNextAmplifier();
        return index + 2;
    }
}
