package me.joebruckner;

import java.util.*;

public class DepthFirstSearch implements Iterator<Object> {
    Stack<Object> stack = new Stack<>();
    Set<Object> visited = new HashSet<>();
    Graph graph;

    public DepthFirstSearch(Graph graph, Object source) {
        this.graph = graph;
        stack.push(source);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Object next() {
        return advance();
    }

    protected Object advance() {
        Object next = stack.pop();
        if (visited.contains(next)) return advance();

        for (Object neighbor : graph.getNeighbors(next)) {
            if (visited.contains(neighbor)) continue;
            stack.push(next);
            stack.push(neighbor);
            return advance();
        }

        visited.add(next);
        return next;
    }
}
