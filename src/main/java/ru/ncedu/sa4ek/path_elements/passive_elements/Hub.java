package ru.ncedu.sa4ek.path_elements.passive_elements;

import ru.ncedu.sa4ek.PathElement;
import ru.ncedu.sa4ek.path_elements.PassiveElement;

import java.util.ArrayList;

/**
 * Created by sa4ek on 25.12.14.
 */
public class Hub extends PassiveElement {
    static final byte CONNECTIONS = 6;

    public Hub(double timeDelay, double cost, String info, Integer id){
        super(timeDelay,cost,info, id);
    }

    public void addElement(PathElement p){
        if (connections == null) {
            connections = new ArrayList<PathElement>(CONNECTIONS);
            connections.add(p);
            p.addElement(this);
        } else {
            if (connections.size() == CONNECTIONS) {
                System.out.println("All ports busy. Hub with id = " + getId());
            } else {
                connections.add(p);
                if(!(p instanceof Cable ))
                    p.addElement(this);
                System.out.println("Connection is successful");
            }
        }
    }

}
