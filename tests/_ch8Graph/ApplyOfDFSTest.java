package _ch8Graph;

import _ch8Graph.Graph.ALGraph;
import org.junit.Test;

import java.util.List;

public class ApplyOfDFSTest {
    @Test
    public void dispAllSimpleLoopViaNodeK() throws Exception {
        ALGraph alg = Graph.createUndirectedALGraph();
        System.out.println(alg);
        List<String> loops = ApplyOfDFS.dispAllSimpleLoopViaNodeK(alg.vertex[0]);
        for (String loop : loops)
            System.out.println(loop);
    }

    @Test
    public void dispSpecLenPath() throws Exception {
        ALGraph alg = Graph.createUndirectedALGraph();
        System.out.println(alg);
        for (int len = 0; len < alg.n; len++) {
            System.out.println("长度为" + len + "的路径有：");
            List<String> pathes = ApplyOfDFS.dispSpecLenPath(alg.vertex[0], alg.vertex[alg.n - 1], len);
            for (String path : pathes)
                System.out.println(path);
        }
    }

    @Test
    public void existPath() throws Exception {
        ALGraph alg = Graph.createUndirectedALGraph();
        System.out.println(alg);
        String path = ApplyOfDFS.existPath(alg.vertex[0], alg.vertex[alg.n - 1]);
        System.out.println(path);
    }

}