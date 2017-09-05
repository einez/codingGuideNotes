package _ch7Tree;

import java.util.HashMap;

public class UFSTree<T> {
    private class UNode<T> {
        T data;
        int rank;

        public UNode(T data) {
            this.data = data;
            this.rank = 0;
        }
    }

    private HashMap<T, UNode<T>> dataNodeMapping = new HashMap<>();
    private HashMap<UNode<T>, UNode<T>> childParentMapping = new HashMap<>();

    public boolean addSet(T data) {
        if (dataNodeMapping.containsKey(data))
            return false;
        UNode<T> node = new UNode<>(data);
        dataNodeMapping.put(data, node);
        childParentMapping.put(node, node);
        return true;
    }

    public T findSet(T data) {
        UNode<T> node = dataNodeMapping.get(data);
        if (childParentMapping.get(node) == node)
            return node.data;
        UNode<T> parent = childParentMapping.get(node);
        while (childParentMapping.get(parent) != parent) {
            parent = childParentMapping.get(parent);
            childParentMapping.put(node, parent);
        }
        return parent.data;
    }

    public void unionSet(T data1, T data2) {
        T p1 = findSet(data1);
        T p2 = findSet(data2);
        if (p1 == p2)
            return;
        UNode n1 = dataNodeMapping.get(p1);
        UNode n2 = dataNodeMapping.get(p2);
        if (n1.rank > n2.rank) {
            childParentMapping.put(n2, n1);
        } else {
            if (n1.rank == n2.rank)
                n2.rank++;
            childParentMapping.put(n1, n2);
        }
    }
}
