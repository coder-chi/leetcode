package item.s46;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * created by zhangzhiyuan in 2019/4/22
 */
public class Solution {
    /**
     * 思路一：将整组数中的所有的数分别与第一个数交换（包括自己，就是原顺序），这样就总是在处理后n-1个数的全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, 0);
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, int j) {
        if (j == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(nums, result, j+1);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}
