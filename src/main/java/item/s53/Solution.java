package item.s53;

/**
 * created by zhangzhiyuan in 2020/1/6
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] > 0 ? nums[i - 1] + nums[i] : nums[i];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
