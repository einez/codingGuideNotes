package _ch8Graph;

import _ch8Graph.Graph.ALGraph;
import org.junit.Test;

public class ApplyOfBFSTest {
    @Test
    public void findFurthestNodeInUndirectedGraph() throws Exception {
        ALGraph alg = Graph.createUndirectedALGraph();
        System.out.println(alg);
        ALGraph.GNode furthest = ApplyOfBFS.findFurthestNodeInUndirectedGraph(alg.vertex[0]);
        System.out.println(furthest.data);
    }

    @Test
    public void findShortestPath() throws Exception {
        ALGraph alg = Graph.createUndirectedALGraph();
        System.out.println(alg);
        String shortestPath = ApplyOfBFS.findShortestPathInUndirectedGraph(alg.vertex[0], alg.vertex[alg.n - 1]);
        System.out.println(shortestPath);
    }

}