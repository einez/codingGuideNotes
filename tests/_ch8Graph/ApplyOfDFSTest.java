package _ch8Graph;

import _ch8Graph.Graph.ALGraph;
import org.junit.Test;

public class ApplyOfDFSTest {
    @Test
    public void existPath() throws Exception {
        ALGraph alg = Graph.createUndirectedALGraph();
        System.out.println(alg);
        boolean hasPath = ApplyOfDFS.existPath(alg.vertex[0], alg.vertex[alg.n - 1]);
        System.out.println(hasPath);
    }

}