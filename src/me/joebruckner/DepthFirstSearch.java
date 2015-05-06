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
        if (stack.empty()) return null;

        Object next = stack.peek();
        if (visited.contains(next)) {
            stack.pop();
            //System.err.println("Moving up to " + stack.peek().toString());
            return advance();
        }

        for (Object neighbor : graph.getNeighbors(next)) {
            if (visited.contains(neighbor)) continue;
            //System.err.println("Moving to " + neighbor.toString());
            stack.push(neighbor);
            return advance();
        }

        Object n = stack.pop();
        //System.err.println("Visiting " + n.toString());
        visited.add(n);
        return n;
    }
}
