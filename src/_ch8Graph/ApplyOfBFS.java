package _ch8Graph;

import _ch8Graph.Graph.ALGraph.GNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class ApplyOfBFS {
    //如果有多条，不保证结果的唯一性
    static String findShortestPathInUndirectedGraph(GNode u, GNode v) {
        StringBuilder sb = new StringBuilder();
        Queue<GNode> qu = new LinkedList<>();
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        qu.offer(u);
        hashMap.put(u, u);
        label:
        while (!qu.isEmpty()) {
            u = qu.poll();
            for (GNode n : u.neibs) {
                if (!hashMap.containsKey(n)) {
                    hashMap.put(n, u);
                    qu.offer(n);
                }
                if (n == v)
                    break label;
            }
        }
        if (!hashMap.containsKey(v))
            return "No path";
        while (hashMap.get(v) != v) {
            sb.insert(0, "#" + v.data);
            v = hashMap.get(v);
        }
        sb.insert(0, "#" + v.data);
        return sb.toString();
    }

    //如果有多条，不保证结果的唯一性
    static GNode findFurthestNodeInUndirectedGraph(GNode v) {
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Queue<GNode> qu = new LinkedList<>();
        qu.offer(v);
        hashMap.put(v, v);
        while (!qu.isEmpty()) {
            v = qu.poll();
            for (GNode n : v.neibs) {
                if (!hashMap.containsKey(n)) {
                    qu.offer(n);
                    hashMap.put(n, v);
                }
            }
        }
        GNode res = v;
        while (hashMap.get(v) != v) {
            sb.insert(0, "#" + v.data);
            v = hashMap.get(v);
        }
        sb.insert(0, "#" + v.data);
        System.out.println(sb);
        return res;
    }
}
