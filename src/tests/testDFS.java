import me.joebruckner.DepthFirstSearch;
import me.joebruckner.Graph;
import me.joebruckner.Type;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class testDFS {

    @Test
    public void simpleTest() {
        Graph graph = new Graph(0, Type.Undirected);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        Iterator dfs = new DepthFirstSearch(graph, 0);

        Assert.assertEquals(dfs.next(), 0);
        Assert.assertEquals(dfs.next(), 1);
        Assert.assertEquals(dfs.next(), 3);
        Assert.assertEquals(dfs.next(), 4);
        Assert.assertEquals(dfs.next(), 2);
        Assert.assertEquals(dfs.next(), 5);
        Assert.assertEquals(dfs.next(), 6);
    }
}
