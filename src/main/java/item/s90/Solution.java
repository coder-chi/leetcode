package item.s90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/5/28
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, int nums[], List<Integer> list, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfs(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
