package be.vercruysse.advent2019.day13.intcode;

import be.vercruysse.advent2019.day13.intcode.io.InputProvider;
import be.vercruysse.advent2019.day13.intcode.io.OutputListener;
import be.vercruysse.advent2019.day13.intcode.opcode.*;
import be.vercruysse.advent2019.day13.intcode.reader.ImmediateMode;
import be.vercruysse.advent2019.day13.intcode.reader.ParameterReader;
import be.vercruysse.advent2019.day13.intcode.reader.PositionMode;
import be.vercruysse.advent2019.day13.intcode.reader.RelativeMode;

import java.util.ArrayList;
import java.util.List;

public class InstructionFactory {

    public InputProvider inputProvider;
    public OutputListener outputListener;

    public InstructionFactory(InputProvider inputProvider, OutputListener outputListener) {
        this.inputProvider = inputProvider;
        this.outputListener = outputListener;
    }

    public Instruction createInstruction(Long instruction) {
        char[] commandArray = addLeadingZeros(String.valueOf(instruction));
        return new Instruction(toOpcode(commandArray), getParamerReaders(commandArray));
    }

    private char[] addLeadingZeros(String stringInput) {
        char[] characters = "000000".toCharArray();
        for(int i = 0; i < stringInput.length(); i++) {
            characters[characters.length - (i + 1)] = stringInput.charAt(stringInput.length() - (i + 1));
        }
        return characters;
    }

    private List<ParameterReader> getParamerReaders(char[] instruction) {
        List<ParameterReader> result = new ArrayList<>();
        for (int i = 0; i < instruction.length - 2; i++) {
            result.add(getParamerReader(instruction[instruction.length - (i + 3)]));
        }
        return result;
    }

    private ParameterReader getParamerReader(char character) {
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

    private Opcode toOpcode(char[] instruction) {
        String opcode = "" + instruction[4] + instruction[5];
        switch (opcode) {
            case "01":
                return new PlusOpcode();
            case "02":
                return new MultiplyOpcode();
            case "03":
                return new InputOpcode(inputProvider);
            case "04":
                return new OutputOpcode(outputListener);
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
