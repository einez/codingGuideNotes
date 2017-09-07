package _ch8Graph;

import _ch8Graph.Graph.ALGraph.GNode;

import java.util.HashMap;

class ApplyOfDFS {
    static boolean existPath(GNode u, GNode v) {
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        return existPath(u, v, hashMap);
    }

    private static boolean existPath(GNode u, GNode v, HashMap<GNode, GNode> hashMap) {
        if (hashMap.containsKey(u))
            return false;
        if (u == v)
            return true;
        hashMap.put(u, u);
        for (GNode n : u.neibs) {
            if (existPath(n, v, hashMap))
                return true;
        }
        return false;
    }
}
