package ru.ncedu.sa4ek;

import ru.ncedu.sa4ek.Dijkstra.Edge;
import ru.ncedu.sa4ek.Dijkstra.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sa4ek on 06.01.15.
 */
public class DejkstraPathElement {
    public static void computePaths(PathElement source) {
        source.minDistance = 0.;
        PriorityQueue<PathElement> vertexQueue = new PriorityQueue<PathElement>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            PathElement u = vertexQueue.poll();

            // Visit each edge exiting u
            for (PathElement e : u.getConnections()) {
                PathElement v = e;
                double weight = e.getTimeDelay();
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<PathElement> getShortestPathTo(PathElement target) {
        List<PathElement> path = new ArrayList<PathElement>();
        for (PathElement vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        try {
            if (path.size() <= 1) throw new RouteNotFoundException();
            return path;
        } catch (RouteNotFoundException e){
            System.out.println("Route not found!");
            return null;
        }
    }

}