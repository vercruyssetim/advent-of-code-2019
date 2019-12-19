package be.vercruysse.advent2019.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RuleSet {
    private List<Rule> rules;

    public RuleSet(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Element> getAllElementsSorted() {
        return rules.stream()
                .flatMap(r -> r.getAllElements().stream())
                .distinct()
                .sorted((e1, e2) -> compare(e1, e2))
                .collect(Collectors.toList());
    }

    private int compare(Element element1, Element element2) {
        return stepsToOre(element1) - stepsToOre(element2) ;
    }

    private int stepsToOre(Element element) {
        if(element.getName().equals("ORE")){
            return 0;
        }
        if(rules.stream().anyMatch(rule -> rule.isFor(element) && rule.contains(new Element(0, "ORE")))){
            return 1;
        }
        return rules.stream().filter(rule -> rule.isFor(element))
                .map(rule -> rule.getLeftElements())
                .flatMap(l -> l.stream())
                .mapToInt(e -> stepsToOre(e) + 1)
                .max()
                .orElseThrow(() -> new RuntimeException());
    }

    public List<Element> resolve(Element element) {
        return rules.stream()
                .filter(r -> r.matches(element))
                .findFirst()
                .map(t -> t.getResult(element))
                .orElse(new ArrayList<>());

    }
}
