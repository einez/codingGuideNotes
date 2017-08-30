package ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

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
//        int[] arr = new int[]{9, 9, 13, 0, 6, 6, 8, 11, 19, 6, 17, 0, 16, 18, 9, 0, 11};
//        //0, 0, 0, 6, 6, 6, 8, 9, 9, 9, 11, 11, 13, 16, 17, 18, 19
//        int k = 15;
//        System.out.println(Arrays.toString(arr) + ", k=" + k);
            int[] expected = FindMinK.sortToCompare(Arrays.copyOf(arr, arr.length), k);
            int[] actual = FindMinK.getMinK(Arrays.copyOf(arr, arr.length), k);
            Arrays.sort(arr);
            System.out.println("#" + Arrays.toString(arr));
            System.out.println("#" + Arrays.toString(expected));
            System.out.println("#" + Arrays.toString(actual));
            assertArrayEquals(expected, actual);
        }
    }

}