package be.vercruysse.advent2019.day11.intcode;

import be.vercruysse.advent2019.day11.intcode.opcode.*;
import be.vercruysse.advent2019.day11.intcode.reader.ImmediateMode;
import be.vercruysse.advent2019.day11.intcode.reader.ParameterReader;
import be.vercruysse.advent2019.day11.intcode.reader.PositionMode;
import be.vercruysse.advent2019.day11.intcode.reader.RelativeMode;

import java.util.ArrayList;
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
