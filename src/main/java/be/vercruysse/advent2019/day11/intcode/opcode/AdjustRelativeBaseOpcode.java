package be.vercruysse.advent2019.day11.intcode.opcode;

import be.vercruysse.advent2019.day11.intcode.RelativeBase;
import be.vercruysse.advent2019.day11.intcode.reader.ParameterReader;

import java.util.List;

public class AdjustRelativeBaseOpcode implements Opcode {

    @Override
    public int run(int index, List<Long> inputList, List<ParameterReader> parameterReaderList) {
        Long value = parameterReaderList.get(0).readInput(index + 1, inputList);

        RelativeBase.getInstance().adjustBase(value);
        System.out.println("Adjusting relative mode to " + RelativeBase.getInstance().getBase());

        return index + 2;
    }
}
