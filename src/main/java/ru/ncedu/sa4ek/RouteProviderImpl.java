package ru.ncedu.sa4ek;


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

    public RouteProviderImpl(String description) {
        this.description = description;
    }
/*
    public static List<PathElement> getRoute(Integer firstId, Integer secondId, Network net) {
        List<PathElement> pathElements = new ArrayList<PathElement>();


    }
    */
    public  static List<PathElement> getList(PathElement p1, PathElement p2){
        try {
            List<PathElement> pathElements = new ArrayList<PathElement>();
            if (p1.getConnections().contains(p2)) {
                pathElements.add(p1);
                return pathElements;
            }
            for (PathElement p : p1.getConnections()) {
                getList(p, p2);
            }
            if(pathElements.isEmpty()) throw  new RouteNotFoundException();
        } catch (RouteNotFoundException e){
            return null;
        }

        return null;
    }

    private static ArrayList<PathElement> getElements(HashMap<Integer, PathElement> elementHashMap) {
        ArrayList<PathElement> pathElements = new ArrayList<PathElement>();
        for(Entry entry: elementHashMap.entrySet()){
            pathElements.add((PathElement) entry.getValue());
        }
        return pathElements;
    }

    public static void main(String[] args) throws RouteNotFoundException {

        //List<PathElement> list = getRoute(0, 1, new Network());
        Network net = new Network();
        PathElement p1 = net.getPathElements().get(1);
        PathElement p2 = net.getPathElements().get(6);
        for(PathElement e: getList(p1, p2)){
            System.out.println(e.toString());
        }
    }
/*
    // @Override
    public static List<PathElement> getRoute(String ip1, String ip2, Network net) throws RouteNotFoundException {
        ArrayList<PathElement> elements = new ArrayList<PathElement>();
        Network network = new Network();
        HashMap map = network.getPathElements();
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getValue());
        }
        IPAddress ipAddress_1 = new IPAddress(ip1);
        IPAddress ipAddress_2 = new IPAddress(ip2);


        return elements;
    }
*/
    @Override
    public String getDescription() {
        return description;
    }
}
