package be.vercruysse.advent2019.day14;

import java.util.List;
import java.util.stream.Collectors;

public class Rule {

    private final List<Element> leftHandSide;
    private final Element rightHandSide;

    public Rule(List<Element> leftHandSide, Element rightHandSide) {
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

    public List<Element> getLefthandSide() {
        return leftHandSide;
    }

    public List<Element> getResult(Element element) {
        return leftHandSide.stream()
                .map(element1 -> element1.multiply(element.getQuantity(), rightHandSide.getQuantity()))
                .collect(Collectors.toList());
    }
}
