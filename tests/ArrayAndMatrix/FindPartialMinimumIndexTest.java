package ArrayAndMatrix;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class FindPartialMinimumIndexTest {
    @Test
    public void findPartialMinimumIndex() throws Exception {
        Random random = new Random();
        int[] arr = new int[random.nextInt(20)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        int index = FindPartialMinimumIndex.findPartialMinimumIndex(arr);
        assert ((index == arr.length - 1 || arr[index] < arr[index + 1]) && (index == 0 || arr[index] < arr[index - 1]));
    }

}