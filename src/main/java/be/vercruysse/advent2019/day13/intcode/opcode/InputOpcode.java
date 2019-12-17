package be.vercruysse.advent2019.day13.intcode.opcode;

import be.vercruysse.advent2019.day13.intcode.io.InputProvider;
import be.vercruysse.advent2019.day13.intcode.reader.ParameterReader;

import java.util.List;

public class InputOpcode implements Opcode {

    private InputProvider inputProvider;

    public InputOpcode(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        int position = parameterReaderList.get(0).readForPosition(index + 1, inputList).intValue();
        Long value = inputProvider.getInput();

//        System.out.println("Placing " + value + " at position " + position);
        inputList.set(position, value);
        return index + 2;
    }
}
