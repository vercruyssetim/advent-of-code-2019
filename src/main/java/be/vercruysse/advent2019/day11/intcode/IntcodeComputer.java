package be.vercruysse.advent2019.day11.intcode;

import java.util.List;

public class IntcodeComputer {

    private List<Long> input;
    private InstructionFactory instructionFactory;

    public IntcodeComputer(List<Long> input, InstructionFactory instructionFactory) {
        this.input = input;
        this.instructionFactory = instructionFactory;
    }

    public void calculate() {
        for (int index = 0; index < input.size();) {
            System.out.println(input.get(index));
            Instruction instruction = instructionFactory.createInstruction(input.get(index));
            index = instruction.execute(index, input);
        }
    }

}
