package ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class FindMinKTest {
    @Test
    public void getMinK() throws Exception {
        Random random = new Random();
        for (int t = 0; t < 10; t++) {
            for (int i = 0; i < 10; i++) {
                System.out.print("-*-");
            }
            System.out.println();
            int size = random.nextInt(30) + 1;
            int k = random.nextInt(size) + 1;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(20);
            }
            System.out.println(Arrays.toString(arr) + ", k=" + k);
            int[] expected = FindMinK.sortToCompare(arr, k);
            int[] actual = FindMinK.getMinK(arr, k);
            System.out.println("#" + Arrays.toString(expected));
            System.out.println("#" + Arrays.toString(actual));
//            assertArrayEquals(expected, actual);
        }
    }

}