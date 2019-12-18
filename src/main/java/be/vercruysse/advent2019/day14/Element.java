package be.vercruysse.advent2019.day14;

public class Element {

    private final int quantity;
    private final String name;

    public Element(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    private String getName() {
        return name;
    }

    public boolean matches(Element element) {
        return name.equals(element.getName());
    }

    public Element multiply(int originalQuantity, int rightHandSideQuantity) {
        int newQuantity = (int) (quantity * Math.ceil((double) originalQuantity/rightHandSideQuantity));
        return new Element(newQuantity, name);
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "" + quantity + " " + name;
    }


    public Element add(int quantity) {
        return new Element(this.quantity + quantity, name);
    }
}
