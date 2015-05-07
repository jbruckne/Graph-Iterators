import me.joebruckner.Graph;
import me.joebruckner.Type;
import org.junit.Assert;
import org.junit.Test;

public class testGraph {

    @Test
    public void addUndirectedEdgeTest() {
        Graph graph = new Graph(Type.Undirected);

        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(0, 3);

        Assert.assertTrue(graph.hasEdge(1, 0));
        Assert.assertTrue(graph.hasEdge(0, 2));
        Assert.assertTrue(graph.hasEdge(3, 0));
    }

    @Test
    public void addDirectedEdgeTest() {
        Graph graph = new Graph(Type.Directed);

        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(0, 3);

        Assert.assertFalse(graph.hasEdge(1, 0));
        Assert.assertFalse(graph.hasEdge(0, 2));
        Assert.assertFalse(graph.hasEdge(3, 0));
    }
}

