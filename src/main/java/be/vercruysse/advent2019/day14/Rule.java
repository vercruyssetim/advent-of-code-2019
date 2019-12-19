package be.vercruysse.advent2019.day14;

import java.util.List;
import java.util.stream.Collectors;

public class Rule {

    private final List<RuleArgument> leftHandSide;
    private final RuleArgument rightHandSide;

    public Rule(List<RuleArgument> leftHandSide, RuleArgument rightHandSide) {
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
    }

    @Override
    public String toString() {
        return leftHandSide.toString() + " => " + rightHandSide;
    }

    public boolean matches(Element element) {
        return rightHandSide.matches(element);
    }

    public List<RuleArgument> getLefthandSide() {
        return leftHandSide;
    }

    public List<Element> getResult(Element element) {
        int multiply = element.getQuantity() / rightHandSide.getQuantity();
        element.setQuantity(element.getQuantity() % rightHandSide.getQuantity());
        return leftHandSide.stream()
                .map(ruleArgument -> toElement(ruleArgument, multiply))
                .collect(Collectors.toList());
    }

    private Element toElement(RuleArgument ruleArgument, int multiply) {
        Element element = ruleArgument.toElement();
        element.multiply(multiply);
        return element;
    }
}
