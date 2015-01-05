package ru.ncedu.sa4ek;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sa4ek on 25.12.14.
 */
public abstract class PathElement {
    private Integer id = 0;
    private double timeDelay;
    private double cost;
    private String info;
    protected Collection<PathElement> connections;


    public PathElement(double timeDelay, double cost, String info, Integer id){
        this.timeDelay = timeDelay;
        this.cost = cost;
        this.info = info;
        this.id = id;
    }


    public double getTimeDelay(){
        return timeDelay;
    }

    public double getCosts(){
        return cost;
    }

    public Collection<PathElement> getConnections(){
        return connections;
    }

    public String getInfo(){
        return info;
    }

    public Integer getId(){
        return id;
    }

    public void addElement(PathElement element) {
        if (connections == null) {
            connections = new ArrayList<PathElement>();
        }
        connections.add(element);
    }
}
