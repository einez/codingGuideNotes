package _ch8Graph;

import _ch8Graph.Graph.ALGraph;
import _ch8Graph.Graph.MGraph;
import org.junit.Test;

public class GraphTest {
    @Test
    public void createUndirectedMGraph() throws Exception {
        MGraph mg = Graph.createUndirectedMGraph();
        System.out.println(mg);
    }

    @Test
    public void createDirectedMGraph() throws Exception {
        MGraph mg = Graph.createDirectedMGraph();
        System.out.println(mg);
    }

    @Test
    public void createUndirectedALGraph() throws Exception {
        ALGraph alg = Graph.createUndirectedALGraph();
        System.out.println(alg);
    }

    @Test
    public void createDirectedALGraph() throws Exception {
        ALGraph alg = Graph.createDirectedALGraph();
        System.out.println(alg);
    }

}