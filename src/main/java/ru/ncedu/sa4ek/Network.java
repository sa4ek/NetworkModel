package ru.ncedu.sa4ek;

import ru.ncedu.sa4ek.path_elements.active_elements.Firewall;
import ru.ncedu.sa4ek.path_elements.active_elements.PC;
import ru.ncedu.sa4ek.path_elements.active_elements.Router;
import ru.ncedu.sa4ek.path_elements.active_elements.Switch;
import ru.ncedu.sa4ek.path_elements.passive_elements.Cable;
import ru.ncedu.sa4ek.path_elements.passive_elements.Hub;

import java.util.*;
import java.util.Map.*;


/**
 * Created by sa4ek on 25.12.14.
 */
public class Network {
    public static Map<Integer, PathElement> pathElements = new HashMap<Integer, PathElement>();

    public Network(){
        //create 1 router
        Router router = new Router(0,8,"router", 0, "192.168.0.0");

        //create 1 HUB
        Hub hub = new Hub(100,0.5,"hub", 1);

        //create 1 switch
        Switch switch1 = new Switch(200,5,"switch", 2, "192.168.0.1");

        //create 3 PC
        PC pc1 = new PC(100,0.5,"pc1", 3, "192.168.0.1");
        PC pc2 = new PC(100,0.5,"pc2", 4, "192.168.0.1");
        //pc2.setSecondIP("192.168.1.0");
        PC pc3 = new PC(100,0.5,"pc3", 5, "192.168.1.1");

        //create 1 firewall
        Firewall firewall = new Firewall(300,0.5,"firewall", 6, switch1.getIP());
        firewall.addElement(switch1);
        switch1.addElement(firewall);
        //create 10 cables
        Cable[] cables = new Cable[6];
        for(int i = 0; i < 6; i++){
            cables[i] = new Cable(50,0.1,"cable_" + (7 + i), 7 + i);
        }

        //connect Path Elements

        cables[0].connection(router, hub);
        cables[1].connection(hub, pc1);
        cables[2].connection(hub, pc2);
        cables[3].connection(hub, switch1);
        cables[4].connection(switch1, pc2);
        cables[5].connection(switch1, pc3);

      /*  Cable cable = new Cable(50,0.1,"cable_rout_pc2", 13);
        cable.connection(router, pc2);*/

        //add devices to network
        pathElements.put(router.getId(), router);
        pathElements.put(hub.getId(), hub);
        pathElements.put(switch1.getId(), switch1);
        pathElements.put(pc1.getId(), pc1);
        pathElements.put(pc2.getId(), pc2);
        pathElements.put(pc3.getId(), pc3);
        pathElements.put(firewall.getId(), firewall);
        for(int i = 8; i < 14; i++){
            pathElements.put(cables[i - 8].getId(), cables[i-8]);
        }

    }

    public HashMap<Integer, PathElement> getPathElements(){
        return (HashMap)pathElements;
    }

    public static void main(String[] args) {
        Network net = new Network();
        DejkstraPathElement.computePaths(net.getPathElements().get(0));
        System.out.println(DejkstraPathElement.getShortestPathTo(net.getPathElements().get(6)));

        for(Entry e: net.getPathElements().entrySet()){
            System.out.println("********************************************************************");
            System.out.println((PathElement)e.getValue());
            System.out.println(((PathElement)e.getValue()).getConnections());
            System.out.println();
            System.out.println();
        }

    }
}
