package ru.ncedu.sa4ek.path_elements.active_elements;

import ru.ncedu.sa4ek.PathElement;
import ru.ncedu.sa4ek.path_elements.ActiveElement;

import java.util.ArrayList;

/**
 * Created by sa4ek on 25.12.14.
 */
public class Switch extends ActiveElement {
    static final byte CONNECTIONS = 6;

    public Switch(double timeDelay, double cost, String info, Integer id, String ip) {
        super(timeDelay, cost, info, id, ip);
    }

    public void addElement(PathElement p){
        if (connections == null) {
            connections = new ArrayList<PathElement>(CONNECTIONS);
            connections.add(p);
        } else {
            if (connections.size() == CONNECTIONS) {
                System.out.println("All ports busy. Switch with id = " + this.getId());
            } else {
                connections.add(p);
                System.out.println("Connection is successful");
            }
        }
    }
}
