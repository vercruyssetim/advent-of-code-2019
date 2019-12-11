package be.vercruysse.advent2019.day7;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;

public class PermutationGenerator {

    private Set<List<Integer>> permutations = new HashSet<>();

    public PermutationGenerator() {
        List<Integer> input = newArrayList(5, 6, 7, 8, 9);
        initAllRecursive(input);
    }

    public void initAllRecursive(List<Integer> elements) {
        for(int i = 0; i < 120; i ++) {
            List<Integer> next = newArrayList(elements);
            Collections.shuffle(next);
            permutations.add(next);
        }
    }

    public Set<List<Integer>> getPermutations() {
        return permutations;
    }
}
