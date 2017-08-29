package BinaryTrees;

import BinaryTrees.GenBinaryTrees.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintBoundTest {
    @Test
    public void standard1() throws Exception {
        TreeNode[] nodes = new TreeNode[17];
        for (int i = 1; i <= 16; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[1].lChild = nodes[2];
        nodes[1].rChild = nodes[3];
        nodes[2].rChild = nodes[4];
        nodes[3].lChild = nodes[5];
        nodes[3].rChild = nodes[6];
        nodes[4].lChild = nodes[7];
        nodes[4].rChild = nodes[8];
        nodes[5].lChild = nodes[9];
        nodes[5].rChild = nodes[10];
        nodes[8].rChild = nodes[11];
        nodes[9].lChild = nodes[12];
        nodes[11].lChild = nodes[13];
        nodes[11].rChild = nodes[14];
        nodes[12].lChild = nodes[15];
        nodes[12].rChild = nodes[16];
//        assertEquals("1 2 4 7 11 13 14 15 16 12 10 6 3 ", PrintBound.standard1(nodes[1]));
        assertEquals("1 2 4 7 13 14 15 16 10 6 3 ", PrintBound.standard2(nodes[1]));
    }

}