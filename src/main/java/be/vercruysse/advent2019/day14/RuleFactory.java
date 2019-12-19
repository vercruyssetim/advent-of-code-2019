package be.vercruysse.advent2019.day14;

import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public class RuleFactory {
    public static Rule createRule(String leftHandSide, String rightHandSide) {
        return new Rule(
                stream(leftHandSide.split(", "))
                .map(t -> t.split(" "))
                .map(t -> new RuleArgument(parseInt(t[0]), t[1]))
                .collect(Collectors.toList()),
                new RuleArgument(
                        parseInt(rightHandSide.split(" ")[0]),
                        rightHandSide.split(" ")[1])
        );
    }
}
