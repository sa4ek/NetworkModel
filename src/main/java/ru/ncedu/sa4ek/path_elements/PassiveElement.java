package ru.ncedu.sa4ek.path_elements;

import ru.ncedu.sa4ek.PathElement;

import java.util.Collection;

/**
 * Created by sa4ek on 25.12.14.
 */
public class PassiveElement extends PathElement {
    public PassiveElement(double timeDelay, double cost, String info, Integer id){
        super(timeDelay, cost, info, id);
    }

    public String toString(){
        return "id: " + this.getId() + "info: " + this.getInfo() + " time_delay: " + this.getTimeDelay() + " cost: " +
                this.getCosts();
    }
}
