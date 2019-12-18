package be.vercruysse.advent2019.day14;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RuleSet {
    private List<Rule> rules;

    public RuleSet(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Element> resolve(Element element) {
        return rules.stream()
                .filter(r -> r.matches(element))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element can not be reduced " + element))
                .getResult(element);

    }
}
