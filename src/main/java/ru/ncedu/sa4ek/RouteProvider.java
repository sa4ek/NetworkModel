package ru.ncedu.sa4ek;

import ru.ncedu.sa4ek.path_elements.active_elements.IPAddress;

import java.util.List;

/**
 * Created by sa4ek on 25.12.14.
 */
public interface RouteProvider {

    public List<PathElement> getRoute(Integer firstId, Integer secondId, Network net) throws RouteNotFoundException;

    // public List<PathElement> getRoute(String ip1, String ip2, Network net) throws RouteNotFoundException;

    public String getDescription();
}
