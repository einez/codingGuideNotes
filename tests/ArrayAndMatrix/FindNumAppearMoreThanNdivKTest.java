package ArrayAndMatrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class FindNumAppearMoreThanNdivKTest {
    @Test
    public void findMajorNumber() throws Exception {
        Random random = new Random();
        for (int w = 0; w < 100; w++) {
            int size = random.nextInt(50) + 1;
            int[] arr = new int[size];
            int cand = random.nextInt(30) + 1;
            for (int i = 0; i < size / 2 + 1; i++) {
                int tmp = random.nextInt(size);
                while (arr[tmp] != 0)
                    tmp = random.nextInt(size);
                arr[tmp] = cand;
            }
            for (int i = 0; i < size; i++) {
                if (arr[i] == 0)
                    arr[i] = random.nextInt(30);
            }
            int actual = FindNumAppearMoreThanNdivK.findMajorNumber(Arrays.copyOf(arr, arr.length));
            Arrays.sort(arr);
            int expected = arr[arr.length / 2];
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == expected)
                    count++;
            }
            if (count <= arr.length / 2)
                expected = -1;
            assertTrue(actual == expected);
        }
    }

    @Test
    public void findNKNum() throws Exception {
        Random random = new Random();
        for (int w = 0; w < 100; w++) {
            int size = random.nextInt(50) + 3;
            int[] arr = new int[size];
            int k = random.nextInt(size - 2) + 2;//k必须大于1，否则返回-1，而测试条件要求一定有解
            int cand = random.nextInt(30) + 1;//cand必须为正数否则与数组默认的初值0冲突导致无法分辨
            for (int i = 0; i < size / k + 1; i++) {//若k为1，这里会死循环，因为不可能产生合法解
                int tmp = random.nextInt(size);
                while (arr[tmp] != 0)
                    tmp = random.nextInt(size);
                arr[tmp] = cand;
            }
            for (int i = 0; i < size; i++) {
                if (arr[i] == 0)
                    arr[i] = random.nextInt(30);
            }
//            int actual = FindNumAppearMoreThanNdivK.toCompare(Arrays.copyOf(arr, arr.length), k);
            int actual = FindNumAppearMoreThanNdivK.findNumAppearMoreThanNdivK(Arrays.copyOf(arr, arr.length), k);
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == actual)
                    count++;
            }
            System.out.println("k=" + k + ", " + Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println("appear=" + (arr.length / k + 1) + ", " + Arrays.toString(arr));
            System.out.println("actual=" + actual + ", count=" + count + ", cand=" + cand);
            assertTrue(count > arr.length / k);
        }
    }

}