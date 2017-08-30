package ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class FindMinK2Test {
    @Test
    public void findMinK2() throws Exception {
        Random random = new Random();
        for (int w = 0; w < 2000; w++) {
            int size = random.nextInt(30) + 1;
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(10);
            }
            int k = random.nextInt(size);
            int[] expected = FindMinK.sortToCompare(Arrays.copyOf(arr, arr.length), k);
            int[] actual = FindMinK2.findMinK2(Arrays.copyOf(arr, arr.length), k);
            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(expected));
            System.out.println(Arrays.toString(actual));
            assertArrayEquals(expected, actual);

        }
    }

}