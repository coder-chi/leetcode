package item.s01;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangzhiyuan in 2019/4/25
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution {
    /**
     * 上次怎么做的已经忘了，既然没有空间限制，Map走起 结果:87.93%
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                return new int[]{i, indexMap.get(nums[i])};
            }
            indexMap.put(target - nums[i], i);
        }
        return null;
    }
}
