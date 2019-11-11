package item.s152;


/**
 * created by zhangzhiyuan in 2019/9/6
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-2};
        int i = new Solution().maxProduct(nums);
        System.out.println(i);
    }
}
