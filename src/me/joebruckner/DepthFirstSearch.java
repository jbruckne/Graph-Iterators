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
        Object node = stack.pop();

        if (!visited.contains(node)) {
            visited.add(node);
            List<Object> neighbors = graph.getNeighbors(node);
            Collections.reverse(neighbors);
            neighbors.forEach(stack::push);
            return node;
        }

        return advance();
    }
}
