package be.vercruysse.advent2019.day7;

import java.util.List;

import static be.vercruysse.advent2019.day7.Instruction.instruction;

public class Amplifier {
    private String name;
    private Integer phase = -1;
    private List<Integer> inputList;
    private Amplifier nextAmplififier;
    private int instructionIndex = 0;
    private int input = 0;
    private boolean stopped = false;

    public Amplifier(String name, Integer phase, List<Integer> inputList) {
        this.name = name;
        this.phase = phase;
        this.inputList = inputList;
    }

    public void setNextAmplififier(Amplifier nextAmplififier) {
        this.nextAmplififier = nextAmplififier;
    }

    public void calculate() {
        for (; instructionIndex < inputList.size() && !stopped; ) {
            Instruction instruction;
            try {
                instruction = readInstruction(inputList.get(instructionIndex));
            } catch (RuntimeException exception) {
                System.out.println("Stopping amplifier " + getName());
                stopped = true;
                break;
            }
            instructionIndex = instruction.execute(instructionIndex, inputList);
        }
    }

    private Instruction readInstruction(Integer input) {
        String stringInput = String.valueOf(input);
        return instruction(addLeadingZeros(stringInput), this);
    }

    private char[] addLeadingZeros(String stringInput) {
        char[] characters = "000000".toCharArray();
        for (int i = 0; i < stringInput.length(); i++) {
            characters[characters.length - (i + 1)] = stringInput.charAt(stringInput.length() - (i + 1));
        }
        return characters;
    }

    public int getInput() {
        if(phase != -1) {
            int result = phase;
            phase = -1;
            return result;
        }
        return input;
    }

    public void setInputNextAmplifier(int value) {
        nextAmplififier.setInput(value);
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void calculateNextAmplifier() {
        nextAmplififier.calculate();
    }

    public String getName() {
        return name;
    }

    public String getNameOfNextAmplifier() {
        return nextAmplififier.getName();
    }

    public void setInstructionIndex(int instructionIndex) {
        this.instructionIndex = instructionIndex;
    }
}
