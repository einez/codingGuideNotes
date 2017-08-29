package ArrayAndMatrix;


import static ArrayAndMatrix.CommonContract.swap;

public class OddIndexOddEvenIndexEven {
    public static void oddIndexOddEvenIndexEven(int[] arr) {
        int even = 0, odd = 1;
        while (odd < arr.length && arr[odd] % 2 == 1)
            odd += 2;
        while (odd < arr.length && even < arr.length) {
            if (arr[even] % 2 != 0) {
                swap(arr, even, odd);
                while (odd < arr.length && arr[odd] % 2 == 1)
                    odd += 2;
            } else even += 2;
        }
    }
}
