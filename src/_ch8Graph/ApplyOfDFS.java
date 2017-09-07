package _ch8Graph;

import _ch8Graph.Graph.ALGraph.GNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ApplyOfDFS {
    static String existPath(GNode u, GNode v) {
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (existPath(u, v, hashMap, sb))
            return sb.toString();
        return "No Path";
    }

    private static boolean existPath(GNode u, GNode v, HashMap<GNode, GNode> hashMap, StringBuilder sb) {
        if (hashMap.containsKey(u))
            return false;
        int start = sb.length();
        sb.append("#" + u.data);
        if (u == v) {
            return true;
        }
        hashMap.put(u, u);
        for (GNode n : u.neibs) {
            if (existPath(n, v, hashMap, sb))
                return true;
        }
        sb.delete(start, sb.length());
        return false;
    }

    static List<String> dispSpecLenPath(GNode u, GNode v, int len) {
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        List<String> pathes = new ArrayList<>();
        dispSpecLenPath(u, v, 0, len, hashMap, sb, pathes);
        return pathes;
    }

    private static void dispSpecLenPath(GNode u, GNode v, int pLen, int targetLen, HashMap<GNode, GNode> hashMap, StringBuilder sb, List<String> pathes) {
        if (hashMap.containsKey(u) || pLen > targetLen)
            return;
        int start = sb.length();
        sb.append("#" + u.data);
        hashMap.put(u, u);
        if (u == v && pLen == targetLen) {
            pathes.add(sb.toString());
            sb.delete(start, sb.length());
            hashMap.remove(u);
            return;
        }
        for (GNode n : u.neibs) {
            dispSpecLenPath(n, v, pLen + 1, targetLen, hashMap, sb, pathes);
        }
        sb.delete(start, sb.length());
        hashMap.remove(u);
    }

    static List<String> dispAllSimpleLoopViaNodeK(GNode k) {
        HashMap<GNode, GNode> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("#" + k.data);
        List<String> pathes = new ArrayList<>();
        for (GNode n : k.neibs)
            dispAllPath(n, k, hashMap, sb, pathes);
        return pathes;
    }

    private static void dispAllPath(GNode v, GNode k, HashMap<GNode, GNode> hashMap, StringBuilder sb, List<String> pathes) {
        if (hashMap.containsKey(v))
            return;
        int start = sb.length();
        hashMap.put(v, v);
        sb.append("#" + v.data);
        if (v == k) {
            pathes.add(sb.toString());
            sb.delete(start, sb.length());
            hashMap.remove(v);
        }
        for (GNode n : v.neibs) {
            dispAllPath(n, k, hashMap, sb, pathes);
        }
        sb.delete(start, sb.length());
        hashMap.remove(v);
    }
}
