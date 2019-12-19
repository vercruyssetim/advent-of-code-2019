package be.vercruysse.advent2019.day14;

import java.util.ArrayList;
import java.util.List;

public class RuleSet {
    private List<Rule> rules;

    public RuleSet(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Element> resolve(Element element) {
        return rules.stream()
                .filter(r -> r.matches(element))
                .findFirst()
                .map(t -> t.getResult(element))
                .orElse(new ArrayList<>());

    }
}
