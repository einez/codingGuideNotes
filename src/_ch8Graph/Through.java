package _ch8Graph;

import _ch8Graph.Graph.ALGraph;
import _ch8Graph.Graph.ALGraph.GNode;
import _ch8Graph.Graph.MGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Through {
    public static String DFS(MGraph mg) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[mg.n];
        for (int i = 0; i < mg.n; i++) {
            DFS(i, visited, sb, mg.edges);
        }
        return sb.toString();
    }

    private static void DFS(int v, boolean[] visited, StringBuilder sb, int[][] edges) {
        if (visited[v])
            return;
        sb.append("#" + v);
        visited[v] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[v][i] != 0 && !visited[i])
                DFS(i, visited, sb, edges);
        }
    }

    public static String DFS(ALGraph alg) {
        StringBuilder sb = new StringBuilder();
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        for (GNode v : alg.vertex)
            DFS(v, sb, hashMap);
        return sb.toString();
    }

    public static String DFS(GNode v) {
        StringBuilder sb = new StringBuilder();
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        DFS(v, sb, hashMap);
        return sb.toString();
    }

    private static void DFS(GNode v, StringBuilder sb, HashMap<GNode, GNode> hashMap) {
        if (hashMap.containsKey(v))
            return;
        hashMap.put(v, v);
        sb.append("#" + v.data);
        for (GNode n : v.neibs)
            DFS(n, sb, hashMap);
    }

    public static String BFS(ALGraph alg) {
        StringBuilder sb = new StringBuilder();
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        for (GNode v : alg.vertex)
            BFS(v, sb, hashMap);
        return sb.toString();
    }

    public static String BFS(GNode v) {
        StringBuilder sb = new StringBuilder();
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        BFS(v, sb, hashMap);
        return sb.toString();
    }

    private static void BFS(GNode v, StringBuilder sb, HashMap<GNode, GNode> hashMap) {
        if (hashMap.containsKey(v))
            return;
        Queue<GNode> queue = new LinkedList<>();
        queue.offer(v);
        sb.append("#" + v.data);
        hashMap.put(v, v);
        while (!queue.isEmpty()) {
            GNode top = queue.poll();
            for (GNode n : top.neibs) {
                if (!hashMap.containsKey(n)) {
                    queue.offer(n);
                    sb.append("#" + n.data);
                    hashMap.put(n, n);
                }
            }
        }
    }
}
