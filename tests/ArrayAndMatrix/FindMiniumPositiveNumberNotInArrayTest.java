package ArrayAndMatrix;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class FindMiniumPositiveNumberNotInArrayTest {
    @Test
    public void findMiniumPositiveNumberNotInArray() throws Exception {
        Random random = new Random();
        int size = random.nextInt(20);
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length * 3 / 2) - random.nextInt(arr.length / 2);
        }
        int expected = FindMiniumPositiveNumberNotInArray.toCompare(arr);
        int actual = FindMiniumPositiveNumberNotInArray.findMiniumPositiveNumberNotInArray(arr);
        assertEquals(expected, actual);
    }

}