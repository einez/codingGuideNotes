package stackQueue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class BuildMaxTreeOfArrayTest {
    @Test
    public void buildHeap() throws Exception {
        int[] arr = new int[]{5, 3, 7, 1, 3, 7, 4, 9, 2, 0, 3, 6};
        BuildMaxTreeOfArray.Node[] ret = BuildMaxTreeOfArray.buildHeap(arr);
        for (int i = 1; i < ret.length; i++) {
            if ((i & (i - 1)) == 0) System.out.println();
            System.out.print(ret[i].value + " ");
            assertTrue((ret[i].left == null || ret[i].value >= ret[i].left.value) && (ret[i].right == null || ret[i].value >= ret[i].right.value));
        }
    }

}