package ru.ncedu.sa4ek;


import ru.ncedu.sa4ek.path_elements.ActiveElement;
import ru.ncedu.sa4ek.path_elements.active_elements.IPAddress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map.*;


/**
 * Created by sa4ek on 25.12.14.
 */
public class RouteProviderImpl implements RouteProvider {
    String description;

    @Override
    public List<PathElement> getRoute(Integer firstId, Integer secondId, Network net) throws RouteNotFoundException {
        HashMap<Integer, PathElement> elements = net.getPathElements();
        DejkstraPathElement.computePaths(elements.get(firstId));
        return DejkstraPathElement.getShortestPathTo(elements.get(secondId));
    }
/*
    @Override
    public List<PathElement> getRoute(String ip1, String ip2, Network net) throws RouteNotFoundException {
        PathElement p1 = null, p2 = null;
        for (Entry entry : net.getPathElements().entrySet()) {
            if (entry instanceof ActiveElement) {
                if (((ActiveElement) entry).getIP().equals(ip1)) {
                    p1 = (PathElement) entry;
                }
                if (((ActiveElement) entry).getIP().equals(ip2)) {
                    p2 = (PathElement) entry;
                }
            }
        }
        if((p1.equals(null)) || (p2.equals(null)))
        {
            System.out.println("Devices with this ip not found!");
            return null;
        }
            DejkstraPathElement.computePaths(p1);
            return DejkstraPathElement.getShortestPathTo(p2);
    }
*/
    @Override
    public String getDescription() {
        return description;
    }
}
