package item.s78;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/5/20
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), result);
        result.add(new ArrayList<>());
        return result;
    }

    public void dfs(int index, int[] nums, List<Integer> list, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            dfs(i + 1, nums, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> subsets = new Solution().subsets(a);
        System.out.println(a);
    }
}
