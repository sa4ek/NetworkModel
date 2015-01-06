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

    @Override
    public String getDescription() {
        return description;
    }
}
