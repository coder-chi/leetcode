package item.s56;

import java.util.*;

/**
 * created by zhangzhiyuan in 2019/5/3
 * 给出一个区间的集合，请合并所有重叠的区间。
 */
public class Solution {
    /**
     * 用了原生的TreeMap排序，显然对数组还不熟，而且中间卡了很多边界
     * 25.24，太烂了，但是没时间搞细一点了
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Map<Integer, Integer> interMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int a[] : intervals) {
            if (!interMap.containsKey(a[0])) {
                interMap.put(a[0], a[1]);
            } else if (interMap.get(a[0]) < a[1]) {
                interMap.put(a[0], a[1]);
            }
        }
        int start = Integer.MIN_VALUE;
        int len = Integer.MIN_VALUE;
        Iterator<Map.Entry<Integer, Integer>> iterator = interMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getKey() > len) {
                start = next.getKey();
                len = next.getValue();
            } else {
                if (next.getValue() > interMap.get(start)) {
                    interMap.put(start, next.getValue());
                    len = next.getValue();
                }
                iterator.remove();
            }
        }


        int[][] result = new int[interMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : interMap.entrySet()) {
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{2, 3}, {5, 5}, {2, 2}, {3,4}, {3,4}};
        int[][] merge = new Solution().merge(a);
        System.out.println(merge);
    }
}
