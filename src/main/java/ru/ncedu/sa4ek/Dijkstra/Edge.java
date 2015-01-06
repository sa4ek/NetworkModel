package ru.ncedu.sa4ek.Dijkstra;

/**
 * Created by sa4ek on 06.01.15.
 */
public class Edge {
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}
