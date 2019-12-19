package be.vercruysse.advent2019.day14;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ElementList {

    private List<Element> elementList = new ArrayList<>();

    public ElementList(Element element) {
        this.elementList.add(element);
    }

    public List<Element> getElementList() {
        return Lists.newArrayList(elementList);
    }

    public boolean isEmpty() {
        return elementList.stream()
                .filter(element -> !element.isEmpty())
                .count() == 1 &&
                elementList.stream()
                        .filter(element -> !element.isEmpty())
                        .map(Element::getName)
                        .findFirst().orElse("").equals("ORE");
    }

    public void addAll(List<Element> newElements) {
        for (Element newElement : newElements) {
            if (elementList.contains(newElement)) {
                elementList.stream()
                        .filter(t -> t.equals(newElement))
                        .findFirst()
                        .ifPresent(t -> t.add(newElement.getQuantity()));
            } else {
                elementList.add(newElement);
            }

        }


    }

    public void increaseFirstElement() {
        elementList.stream()
                .filter(element -> !element.isEmpty())
                .filter(element -> !element.getName().equals("ORE"))
                .findFirst().ifPresent(t -> t.increase());
    }

    public int getAmountOfOre() {
        return elementList.stream().filter(element -> element.getName().equals("ORE")).findFirst().map(e -> e.getQuantity()).orElse(0);
    }

    @Override
    public String toString() {
        return elementList.toString();
    }
}
