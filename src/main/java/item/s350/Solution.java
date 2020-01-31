package item.s350;

import java.util.*;

/**
 * created by zhangzhiyuan in 2020/1/28
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count >= 0) {
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int length = list.size();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
