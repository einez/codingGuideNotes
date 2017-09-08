package _ch8Graph;

import _ch8Graph.Graph.MGraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//无向带权连通图
class MinimumGenTree {

    static class Edge {
        int len;
        int u;
        int v;

        Edge(int len, int u, int v) {
            this.len = len;
            this.u = u;
            this.v = v;
        }
    }

    static class Vertex {
        int p;
        int rank;

        Vertex(int index) {
            this.p = index;
            this.rank = 0;
        }
    }

    //时间复杂度为O(n^2)
    static String prim(MGraph mg, int v) {
        if (v < 0 || mg.n <= v)
            return "Invalid";
        if (mg.n == 1)
            return String.valueOf(v);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> candidate = new HashMap<>();
        for (int i = 0; i < mg.n; i++) {
            candidate.put(i, v);
        }
        candidate.remove(v);
        while (candidate.size() > 0) {
            int minEdge = Integer.MAX_VALUE;
            int theOne = -1;
            //这一个for循环可能可以通过维护一个堆结构优化？
            // Nope，如果维护一个堆结构，在下面一个for循环中每一次更新都要siftUp一次，O(1)->O(lgN)
            for (int cand : candidate.keySet()) {
                if (minEdge > mg.edges[candidate.get(cand)][cand]) {
                    minEdge = mg.edges[candidate.get(cand)][cand];
                    theOne = cand;
                }
            }
            if (theOne == -1) {
                return "Invalid";
            }
            sb.append("#[" + candidate.get(theOne) + "--" + theOne + "]");
            candidate.remove(theOne);
            Set<Integer> keySet = new HashSet<>(candidate.keySet());
            //每一次必须扫描所有剩余节点更新，此for循环不可优化
            for (int cand : keySet) {
                if (mg.edges[theOne][cand] < mg.edges[candidate.get(cand)][cand])
                    candidate.put(cand, theOne);
            }
        }
        return sb.toString();
    }

    //不考虑生成Edge数组的耗费，时间复杂度为O(e*lge)
    //如果采用邻接表，Edge数组的生成也就是O(e)
    //排序需要O(e*lge)，如果边长取值范围较小，可以用计数排序或桶排序优化达到O(n)
    //并查集的union和find平均为O(1)
    static String kruskal(MGraph mg) {
        Edge[] es = new Edge[mg.e];
        int c = 0;
        for (int i = 0; i < mg.n; i++) {
            for (int j = i + 1; j < mg.n; j++) {
                if (mg.edges[i][j] < Integer.MAX_VALUE)
                    es[c++] = new Edge(mg.edges[i][j], i, j);
            }
        }
        Arrays.sort(es, (e1, e2) -> (e1.len - e2.len));
//        用lambda表达式替换
//        Arrays.sort(es, new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                return o1.len - o2.len;
//            }
//        });
        Vertex[] vs = new Vertex[mg.n];
        for (int i = 0; i < mg.n; i++) {
            vs[i] = new Vertex(i);
        }
        StringBuilder sb = new StringBuilder();
        c = 0;
        for (int i = 0; i < mg.e && c < mg.n - 1; i++) {
            if (union(vs, es[i].u, es[i].v)) {
                sb.append("#[" + es[i].u + "--" + es[i].v + "]");
                c++;
            }
        }
        return sb.toString();
    }

    private static boolean union(Vertex[] vs, int u, int v) {
        int pu = ufind(vs, u);
        int pv = ufind(vs, v);
        if (pu == pv)
            return false;
        if (vs[pu].rank > vs[pv].rank)
            vs[pv].p = pu;
        else {
            if (vs[pu].rank == vs[pv].rank)
                vs[pv].rank++;
            vs[pu].p = pv;
        }
        return true;
    }

    private static int ufind(Vertex[] vs, int index) {
        if (vs[index].p == index)
            return index;
        while (vs[vs[index].p].p != vs[index].p) {//当该节点的父节点不是根节点时
            vs[index].p = vs[vs[index].p].p;//改变其父节点为其原来的组父节点
        }
        return vs[index].p;
    }
}
