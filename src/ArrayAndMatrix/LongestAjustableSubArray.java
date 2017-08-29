package ArrayAndMatrix;


import java.util.HashMap;

public class LongestAjustableSubArray {
        public static int[] getSubArray(int[] arr) {
        int left = 0, right = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i], min = arr[i];
            HashMap<Integer,Integer> hashMap=new HashMap<>();
            for (int j = i; j < arr.length; j++) {
                if(hashMap.containsKey(arr[j]))
                    break;
                hashMap.put(arr[j],arr[j]);
                if (arr[j] > max)
                    max = arr[j];
                if (arr[j] < min)
                    min = arr[j];
                if (j - i > right - left && j - i == max - min) {
                    right = j;
                    left = i;
                }
            }
        }
        int[] ret = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            ret[i - left] = arr[i];
        }
        return ret;
    }
}
