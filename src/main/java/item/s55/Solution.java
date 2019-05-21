package item.s55;

/**
 * created by zhangzhiyuan in 2019/5/3
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class Solution {
    /**
     * 贪心策略，不用求路径
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] > max) {
                max = i + nums[i];
            }
            if (max >= nums.length - 1) {
                return true;
            }
            if (max <= i) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 4};
        boolean b = new Solution().canJump(a);
        System.out.println(b);
    }
}
