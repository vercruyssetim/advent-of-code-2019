package be.vercruysse.advent2019.day11.intcode.io;

import java.util.Scanner;

public class UserInput implements InputProvider {

    private final Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }
    @Override
    public Long getInput() {
        System.out.println(">");
        return Long.parseLong(scanner.nextLine());
    }
}
