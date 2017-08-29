package ArrayAndMatrix;

import java.util.Arrays;

public class UnsortedArrayLongestSubArraySumLessThanSpecNum {
    public static int getLongestLen(int[] arr,int sum){
        int[] helper=new int[arr.length];
        helper[0]=0;
        int pSum=arr[0];
        for (int i = 1; i < arr.length; i++) {
            helper[i]=Math.max(helper[i-1],pSum);
            pSum+=arr[i];
        }
        int maxLen=0;
        pSum=0;
        for (int i = 0; i < arr.length; i++) {
            pSum+=arr[i];
            int e=Arrays.binarySearch(helper,pSum-sum);
            if(e<0){
                e=-e-1;
            }
            else while(e>0&&helper[e-1]==pSum-sum)
                e--;
            maxLen=Math.max(maxLen,i-e+1);
        }
        return maxLen;
    }
}
