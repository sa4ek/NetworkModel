package ru.ncedu.sa4ek.path_elements;

import ru.ncedu.sa4ek.PathElement;
import ru.ncedu.sa4ek.path_elements.active_elements.IPAddress;

import java.util.Collection;

/**
 * Created by sa4ek on 25.12.14.
 */
public class ActiveElement extends PathElement {
    private IPAddress ipAddress;

    public ActiveElement(double timeDelay, double cost, String info, Integer id, String ip) {
        super(timeDelay, cost, info, id);
        ipAddress = new IPAddress(ip);
    }

    public String getIP(){
        return ipAddress.toString();
    }

    public String toString(){
        return "id: " + this.getId() + "info: " + this.getInfo() + " time_delay: " + this.getTimeDelay() + " cost: " +
                this.getCosts() + " ip: " + this.getIP();
    }
}
