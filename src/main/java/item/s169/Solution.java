package item.s169;

import java.util.Arrays;

/**
 * created by zhangzhiyuan in 2020/1/23
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
