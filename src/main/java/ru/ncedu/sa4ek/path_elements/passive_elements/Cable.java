package ru.ncedu.sa4ek.path_elements.passive_elements;

import ru.ncedu.sa4ek.PathElement;
import ru.ncedu.sa4ek.path_elements.PassiveElement;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sa4ek on 25.12.14.
 */
public class Cable extends PassiveElement {
    static final byte CONNECTIONS = 2;

    public Cable(double timeDelay, double cost, String info, Integer id) {
        super(timeDelay, cost, info, id);
    }

    public Collection<PathElement> connection(PathElement p1, PathElement p2){
        connections = new ArrayList<PathElement>(CONNECTIONS);
        connections.add(p1);
        connections.add(p2);
        p1.addElement(this);
        p2.addElement(this);
        return connections;
    }
}
