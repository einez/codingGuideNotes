package ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static ArrayAndMatrix.CommonContract.swap;
import static org.junit.Assert.*;

public class OddIndexOddEvenIndexEvenTest {
    @Test
    public void oddIndexOddEvenIndexEven() throws Exception {
        Random random = new Random();
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            if (arr[i] % 2 != i % 2)
                arr[i]++;
        }
        for (int i = 0; i < arr.length * 2 / 3; i++) {
            int x = random.nextInt(arr.length);
            int y = random.nextInt(arr.length);
            swap(arr, x, y);
        }
        System.out.println(Arrays.toString(arr));
        OddIndexOddEvenIndexEven.oddIndexOddEvenIndexEven(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(true, arr[i] % 2 == i % 2);
        }
    }

}