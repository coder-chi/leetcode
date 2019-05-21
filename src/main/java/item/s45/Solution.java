package item.s45;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
 * created by zhangzhiyuan in 2019/4/22
 */
public class Solution {
    /**
     * 核心：一维，用贪心算就可以了，不用动规
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int step = 0;
        int index = 0;
        int p = 0;
        int len = nums.length;
        while (p < len - 1) {
            if (nums[p] + p >= len - 1) {
                return step + 1;
            }
            int max = 0;
            for (int i = p + 1; i <= p + nums[p]; i++) {
                if (max < i + nums[i]) {
                    max = i + nums[i];
                    index = i;
                }
            }
            step++;
            p = index;
        }
        return step;
    }

    public static void main(String[] args) {

    }
}
