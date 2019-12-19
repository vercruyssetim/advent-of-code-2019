package be.vercruysse.advent2019.day14;

import java.util.Objects;

public class Element {

    private int quantity;
    private final String name;

    public Element(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }


    public void multiply(int toMultiply) {
        quantity *= toMultiply;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void remove(int toRemove) {
        quantity -= toRemove;
    }

    public void add(int toAdd) {
        quantity += toAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return name.equals(element.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "" + quantity + " " + name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }

    public void increase() {
        quantity++;
    }
}
