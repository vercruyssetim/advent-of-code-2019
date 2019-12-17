package be.vercruysse.advent2019.day13.intcode.opcode;

import be.vercruysse.advent2019.day13.intcode.io.OutputListener;
import be.vercruysse.advent2019.day13.intcode.reader.ParameterReader;

import java.util.List;

public class OutputOpcode implements Opcode {

    private OutputListener outputListener;

    public OutputOpcode(OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        Long value = parameterReaderList.get(0).readInput(index + 1, inputList);

        outputListener.receiveOutput(value);
        return index + 2;
    }
}
