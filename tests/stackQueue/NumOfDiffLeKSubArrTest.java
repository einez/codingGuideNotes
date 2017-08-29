package stackQueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by einez on 8/8/2017.
 */
public class NumOfDiffLeKSubArrTest {
    @Test
    public void getNumOfDiffLeKSubArr() throws Exception {
        Random random = new Random();
        int[] arr = new int[10];
        int K = random.nextInt(10);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        assertTrue(NumOfDiffLeKSubArr.getNumOfDiffLeKSubArr(arr, K) == NumOfDiffLeKSubArr.normalSolution(arr, K));
        assertTrue(NumOfDiffLeKSubArr.solutionInBook(arr, K) == NumOfDiffLeKSubArr.normalSolution(arr, K));
    }

}