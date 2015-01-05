package ru.ncedu.sa4ek.path_elements.active_elements;

import ru.ncedu.sa4ek.Network;
import ru.ncedu.sa4ek.path_elements.ActiveElement;

/**
 * Created by sa4ek on 25.12.14.
 */
public class Firewall extends ActiveElement {
    public Firewall(double timeDelay, double cost, String info, Integer id, String ip){
        super(timeDelay,cost,info, id, ip);
    }
}
