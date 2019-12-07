package be.vercruysse.advent2019.day6;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Orbit {
    private String name;
    private Orbit parent;
    private List<Orbit> children = new ArrayList<>();

    public Orbit(String name) {
        this.name = name;
    }

    public void setParent(Orbit parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    public void addChild(Orbit child){
        children.add(child);
    }

    public Orbit getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public List<Orbit> getAllConnections() {
        List<Orbit> result = Lists.newArrayList(children);
        result.add(parent);
        return result;
    }
}
