package be.vercruysse.advent2019.day4;

import java.util.stream.IntStream;

public class PasswordGuesser {

    public static void main(String[] args) {
        PasswordGuesser passwordGuesser = new PasswordGuesser();
        System.out.println(passwordGuesser.guessPassword());
    }

    private long guessPassword() {
        return IntStream.range(356261, 846303)
                .mapToObj(String::valueOf)
                .filter(this::meetsCriteria)
                .count();
    }

    private boolean meetsCriteria(String number) {
        boolean check = increasingOrder(number) && hasDoubles(number);
        if (check) {
            System.out.println(number);
        }
        return check;
    }

    private boolean hasDoubles(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) == number.charAt(i + 1)) {
                if ((i == 0 || number.charAt(i - 1) != number.charAt(i)) && (i == number.length() - 2 || number.charAt(i + 1) != number.charAt(i + 2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean increasingOrder(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) > number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
