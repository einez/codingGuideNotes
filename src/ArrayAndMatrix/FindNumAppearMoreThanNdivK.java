package ArrayAndMatrix;

import java.util.*;

public class FindNumAppearMoreThanNdivK {
    public static int toCompare(int[] arr, int k) {
        if (arr.length < 1 || k < 2)//就算此处不限制下面也可以应对k=1的情况
            return -1;
        if (k >= arr.length)
            return arr[0];
        int freq = arr.length / k + 1;
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length - freq + 1) {
            if (arr[i] == arr[i + freq - 1]) {//[i,i+freq-1]有freq个
                return arr[i];
            } else i++;
        }
        return -1;
    }

    public static int findNumAppearMoreThanNdivK(int[] arr, int k) {
        if (arr.length < 1 || k < 2)//就算此处不限制下面也可以应对k=1的情况
            return -1;
        if (k >= arr.length)
            return arr[0];
        class Helper {
            private HashMap<Integer, Integer> hashMap;
            private int k;

            public Helper(int k) {
                this.k = k;
                this.hashMap = new HashMap<>();
            }

            public void addItem(int data) {
                if (hashMap.containsKey(data))
                    hashMap.put(data, hashMap.get(data) + 1);
                else {
                    hashMap.put(data, 1);
                    if (hashMap.size() == k) {
                        Set<Integer> keySet = new HashSet(hashMap.keySet());//拷贝此时的状态后再遍历删除
                        for (Integer key : keySet) {
                            if (hashMap.get(key) == 1) {
                                hashMap.remove(key);
                            } else hashMap.put(key, hashMap.get(key) - 1);
                        }
                    }
                }
            }

            public int getMaxKey() {
                int maxKey = Integer.MIN_VALUE, freq = -1;
                for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                    if (entry.getValue() > freq) {
                        maxKey = entry.getKey();
                        freq = entry.getValue();
                    }
                }
                return maxKey;
            }

            public boolean removeKey(int key) {
                if (!hashMap.containsKey(key))
                    return false;
                hashMap.remove(key);
                return true;
            }
        }
        Helper helper = new Helper(k);
        for (int i = 0; i < arr.length; i++) {
            helper.addItem(arr[i]);
        }
        int cand = helper.getMaxKey(), count;
        while (helper.removeKey(cand)) {//所有余留的key都是候选者
            count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == cand)
                    count++;
            }
            if (count > arr.length / k)
                return cand;
            cand = helper.getMaxKey();
        }
        return -1;
    }

    public static int findMajorNumber(int[] arr) {
        if (arr.length < 1)
            return -1;
        int cand = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == cand)
                count++;
            else {
                if (count > 1)
                    count--;
                else {
                    i++;
                    if (i < arr.length)
                        cand = arr[i];
                }
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand)
                count++;
        }
        return count > arr.length / 2 ? cand : -1;
    }
}
