package _ch8Graph;

import org.junit.Test;

public class MinimumGenTreeTest {
    @Test
    public void kurskal() throws Exception {
        Graph.MGraph mg = Graph.createUndirectedMGraph(true);
        System.out.println(mg);
        String res = MinimumGenTree.kruskal(mg);
        System.out.println(res);
    }

    @Test
    public void prim() throws Exception {
        Graph.MGraph mg = Graph.createUndirectedMGraph(true);
        System.out.println(mg);
        String res = MinimumGenTree.prim(mg, 0);
        System.out.println(res);
    }

}