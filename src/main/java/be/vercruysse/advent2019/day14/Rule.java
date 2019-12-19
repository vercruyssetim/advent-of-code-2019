package be.vercruysse.advent2019.day14;

import java.util.ArrayList;
import java.util.Collections;
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

    public boolean isFor(Element element) {
        return rightHandSide.isFor(element);
    }

    public List<Element> getResult(Element element) {
        long multiply = element.getQuantity() / rightHandSide.getQuantity();
        element.setQuantity(element.getQuantity() % rightHandSide.getQuantity());
        List<Element> collect = leftHandSide.stream()
                .map(ruleArgument -> toElement(ruleArgument, multiply))
                .collect(Collectors.toList());
        Collections.shuffle(collect);
        return collect;
    }

    private Element toElement(RuleArgument ruleArgument, long multiply) {
        Element element = ruleArgument.toElement();
        element.multiply(multiply);
        return element;
    }

    public List<Element> getAllElements() {
        List<Element> elements = new ArrayList<>();
        elements.addAll(leftHandSide.stream().map(t -> t.toElement()).collect(Collectors.toList()));
        elements.add(rightHandSide.toElement());
        return elements;
    }

    public boolean contains(Element element) {
        return leftHandSide.stream().anyMatch(a -> a.toElement().equals(element));
    }

    public List<Element> getLeftElements() {
        return leftHandSide.stream().map(a -> a.toElement()).collect(Collectors.toList());
    }
}
