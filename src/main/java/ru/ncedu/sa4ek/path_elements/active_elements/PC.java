package ru.ncedu.sa4ek.path_elements.active_elements;

import ru.ncedu.sa4ek.path_elements.ActiveElement;

/**
 * Created by sa4ek on 25.12.14.
 */
public class PC extends ActiveElement {
    private IPAddress secondIP;
    public PC(double timeDelay, double cost, String info, Integer id, String ip){
        super(timeDelay,cost,info, id, ip);
    }

    public void setSecondIP(String ip) {
        this.secondIP = new IPAddress(ip);
    }

    public String getSecondIP() {
        return secondIP.toString();
    }
}
