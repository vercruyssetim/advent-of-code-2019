package be.vercruysse.advent2019.day13.intcode;

import be.vercruysse.advent2019.day13.intcode.opcode.Opcode;
import be.vercruysse.advent2019.day13.intcode.reader.ParameterReader;

import java.util.List;

public class Instruction {
    private Opcode opcode;
    private List<ParameterReader> parameterReaderList;

    public Instruction(Opcode opcode, List<ParameterReader> parameterReaderList) {
        this.opcode = opcode;
        this.parameterReaderList = parameterReaderList;
    }

    public int execute(int index, List<Long> inputList) {
        return opcode.run(index, inputList, parameterReaderList);
    }

}
