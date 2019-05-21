package item.s57;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * created by zhangzhiyuan in 2019/5/5
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Solution {
    /**
     * 和上一题差不多，显然有效率高的解法，但是我懒得做了（下次再说吧）
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Map<Integer, Integer> interMap = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int a[] : intervals) {
            if (!interMap.containsKey(a[0])) {
                interMap.put(a[0], a[1]);
            } else if (interMap.get(a[0]) < a[1]) {
                interMap.put(a[0], a[1]);
            }
        }
        if (!interMap.containsKey(newInterval[0])) {
            interMap.put(newInterval[0], newInterval[1]);
        } else if (interMap.get(newInterval[0]) < newInterval[1]) {
            interMap.put(newInterval[0], newInterval[1]);
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
}
