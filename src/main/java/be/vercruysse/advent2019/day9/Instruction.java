package be.vercruysse.advent2019.day9;

import be.vercruysse.advent2019.day9.opcode.*;
import be.vercruysse.advent2019.day9.reader.ImmediateMode;
import be.vercruysse.advent2019.day9.reader.ParameterReader;
import be.vercruysse.advent2019.day9.reader.PositionMode;
import be.vercruysse.advent2019.day9.reader.RelativeMode;

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

    public static Instruction instruction(char[] instruction) {
        return new Instruction(toOpcode(instruction), getParamerReaders(instruction));
    }

    private static List<ParameterReader> getParamerReaders(char[] instruction) {
        List<ParameterReader> result = new ArrayList<>();
        for (int i = 0; i < instruction.length - 2; i++) {
            result.add(getParamerReader(instruction[instruction.length - (i + 3)]));
        }
        return result;
    }

    private static ParameterReader getParamerReader(char character) {
        switch (character) {
            case '0':
                return new PositionMode();
            case '1':
                return new ImmediateMode();
            case '2':
                return new RelativeMode();
            default:
                throw new RuntimeException("Could not read mode " + character);
        }
    }

    private static Opcode toOpcode(char[] instruction) {
        String opcode = "" + instruction[4] + instruction[5];
        switch (opcode) {
            case "01":
                return new PlusOpcode();
            case "02":
                return new MultiplyOpcode();
            case "03":
                return new InputOpcode();
            case "04":
                return new OutputOpcode();
            case "05":
                return new JumpIfTrueOpcode();
            case "06":
                return new JumpIfFalseOpcode();
            case "07":
                return new LessThanOpcode();
            case "08":
                return new EqualsOpcode();
            case "09":
                return new AdjustRelativeBaseOpcode();
            default:
                throw new RuntimeException("Could not find opcode for " + new String(instruction));
        }
    }
}
