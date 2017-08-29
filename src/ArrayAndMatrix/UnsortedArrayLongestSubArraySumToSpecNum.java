package ArrayAndMatrix;

import java.util.HashMap;

public class UnsortedArrayLongestSubArraySumToSpecNum {
    public static int getLongestLen(int[] arr,int sum){
        int maxLen=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,-1);
        int pSum=0;
        for (int i = 0; i < arr.length; i++) {
            pSum+=arr[i];
            if(hashMap.containsKey(pSum-sum))
                maxLen=Math.max(maxLen,i-hashMap.get(pSum-sum));
            if(!hashMap.containsKey(pSum))
                hashMap.put(pSum,i);
        }
        return maxLen;
    }
    public static int posEqNeg(int[] arr){
        int maxLen=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,-1);
        int posNum=0;
        for (int i = 0; i < arr.length; i++) {
            posNum+=arr[i]>0?1:arr[i]==0?0:-1;
            if(hashMap.containsKey(posNum))
                maxLen=Math.max(maxLen,i-hashMap.get(posNum));
            else hashMap.put(posNum,i);
        }
        return maxLen;
    }
}
