package be.vercruysse.advent2019.day14;

public class RuleArgument {

    private final int quantity;
    private final String name;

    public RuleArgument(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public boolean matches(Element element) {
        return name.equals(element.getName()) && element.getQuantity() >= quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "" + quantity + " " + name;
    }


    public RuleArgument add(int quantity) {
        return new RuleArgument(this.quantity + quantity, name);
    }

    public Element toElement() {
        return new Element(quantity, name);
    }

    public boolean isFor(Element element) {
        return name.equals(element.getName());
    }
}
