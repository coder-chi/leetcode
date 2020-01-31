package item.s454;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangzhiyuan in 2020/1/30
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                abMap.put(sum, abMap.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = -c - d;
                count += abMap.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}
