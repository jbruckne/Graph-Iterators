package me.joebruckner;

import java.util.*;

public class BreadthFirstSearch implements Iterator<Object> {
    Queue<Object> queue = new LinkedList<>();
    Set<Object> visited = new HashSet<>();
    Graph graph;

    public BreadthFirstSearch(Graph graph, Object source) {
        this.graph = graph;
        queue.add(source);
        visited.add(source);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Object next() {
        Object next = queue.remove();
        for (Object neighbor : graph.getNeighbors(next)) {
            if (visited.contains(neighbor)) continue;
            queue.add(neighbor);
            visited.add(neighbor);
        }
        return next;
    }
}
