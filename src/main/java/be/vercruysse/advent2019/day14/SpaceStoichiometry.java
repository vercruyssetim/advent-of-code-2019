package be.vercruysse.advent2019.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SpaceStoichiometry {

    public static void main(String[] args) {
        RuleSet ruleSet = new RuleSet(getInput());

        long result = calculate(ruleSet);

        System.out.println(result);
    }
//975 068 428 860
    private static long calculate(RuleSet ruleSet) {
        List<Element> allElementsSorted = ruleSet.getAllElementsSorted();
        System.out.println(allElementsSorted);
        ElementList elementList = new ElementList(new Element(3281820, "FUEL"));
        while (!elementList.isEmpty()) {
            System.out.println(elementList);
            List<Element> iteration = elementList.getElementList();
            boolean change = false;
            for (Element element : iteration) {
                List<Element> resolve = ruleSet.resolve(element);
                if (!resolve.isEmpty()) {
                    change = true;
                }
                elementList.addAll(resolve);
                elementList.sort(allElementsSorted);
            }
            if (!change) {
                elementList.increaseFirstElement();
            }
        }
        return elementList.getAmountOfOre();
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
