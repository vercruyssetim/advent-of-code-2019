package be.vercruysse.advent2019.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class SpaceStoichiometry {

    public static void main(String[] args) {
        RuleSet ruleSet = new RuleSet(getInput());

        long number = 0;
        List<Element> elements = newArrayList(new Element(1, "FUEL"));
        while (!elements.isEmpty()) {
            List<Element> iteration = newArrayList(elements);
            for (Element element : iteration) {
                elements.remove(element);
                try {
                    System.out.println(element + " => " + ruleSet.resolve(element));
                    elements.addAll(ruleSet.resolve(element));
                } catch(RuntimeException runtimeException) {
                    number += element.getQuantity();
                }
            }
            System.out.println("new iteration!");
            elements = elements.stream()
                    .collect(ArrayList::new, SpaceStoichiometry::collector, ArrayList::addAll);

        }
        System.out.println(number);
    }

    private static void collector(List<Element> list, Element element) {
        List<Element> elementsToRemove = new ArrayList<>();
        Element newElement = list.stream()
                .filter(listElement -> listElement.matches(element))
                .peek(elementsToRemove::add)
                .findFirst()
                .map(listElement -> listElement.add(element.getQuantity()))
                .orElse(element);
        list.add(newElement);
        list.removeAll(elementsToRemove);
    }

    private static List<Rule> getInput() {
        Pattern pattern = Pattern.compile("(.*) => (.*)");
        return readFile("input.txt").stream()
                .map(pattern::matcher)
                .filter(Matcher::find)
                .map(t -> RuleFactory.createRule(t.group(1), t.group(2)))
                .collect(Collectors.toList());
    }

    private static List<String> readFile(String fileName) {
        InputStream resource = SpaceStoichiometry.class.getResourceAsStream(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
