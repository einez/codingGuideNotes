package _ch7Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UFSTreeTest {
    @Test
    public void unionSet() throws Exception {
        UFSTree<Integer> ufsTree = new UFSTree<>();
        for (int i = 1; i <= 5; i++)
            ufsTree.addSet(i);
        for (int i = 1; i <= 5; i++)
            assert (i == ufsTree.findSet(i));
        ufsTree.unionSet(3, 4);
        assert (4 == ufsTree.findSet(3));
        ufsTree.unionSet(1, 5);
        assert (5 == ufsTree.findSet(1));
        ufsTree.unionSet(2, 3);
        assertEquals(ufsTree.findSet(2), ufsTree.findSet(4));
        ufsTree.unionSet(2, 1);
        assertEquals(ufsTree.findSet(5), ufsTree.findSet(4));
    }

}