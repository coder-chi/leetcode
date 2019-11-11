package item.s198;

/**
 * created by zhangzhiyuan in 2019/11/7
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int max = Math.max(nums[0] + nums[2], nums[1]);
        nums[2] = nums[0] + nums[2];
        for (int i = 3; i < length; i++) {
            nums[i] = Math.max(nums[i - 2], nums[i - 3]) + nums[i];
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int rob = new Solution().rob(nums);
        System.out.println(rob);
    }
}
