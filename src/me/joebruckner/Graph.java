package me.joebruckner;

import java.util.*;

public class Graph {
    Map<Object, List<Object>> edges = new HashMap<>();

    public void addEdge(Object from, Object to) {
        List<Object> neighbors = edges.get(from);
        if (neighbors == null)
            edges.put(from, neighbors = new ArrayList<>());
        neighbors.add(to);
    }

    public List<Object> getNeighbors(Object node) {
        List<Object> neighbors = edges.get(node);
        return neighbors == null ? Collections.emptyList() : neighbors;
    }

    public boolean hasEdge(Object from, Object to) {
        List<Object> neighbors = edges.get(from);
        return neighbors != null && neighbors.contains(to);
    }
}
