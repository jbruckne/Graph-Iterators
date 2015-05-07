package me.joebruckner;

import java.util.*;

public class Graph {
    Map<Object, List<Object>> edges = new HashMap<>();
    Object source;
    Type type;

    public Graph(Type type) {
        this(null, type);
    }

    public Graph(Object source, Type type) {
        this.source = source;
        this.type = type;
    }

    public void addEdge(Object from, Object to) {
        addEdgeToGraph(from, to);
        if (type == Type.Undirected) addEdgeToGraph(to, from);
    }

    private void addEdgeToGraph(Object from, Object to) {
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
