package item.s120;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/8/27
 * 自底向上的动态规划
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int length = triangle.size();
        int[] a = new int[length];
        for (int i = 0; i < triangle.size(); i++) {
            a[i] = triangle.get(length - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                a[j] = Math.min(a[j] + list.get(j), a[j + 1] + list.get(j));
            }
        }
        return a[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = Lists.newArrayList(2);
        List<Integer> list2 = Lists.newArrayList(3,4);
        List<Integer> list3 = Lists.newArrayList(6, 5, 7);
        List<Integer> list4 = Lists.newArrayList(4, 1, 8, 3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        new Solution().minimumTotal(lists);
    }
}
