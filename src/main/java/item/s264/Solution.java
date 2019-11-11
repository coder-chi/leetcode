package item.s264;

/**
 * created by zhangzhiyuan in 2019/11/8
 */
public class Solution {

    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(Math.min(nums[index2] * 2, nums[index3] * 3), nums[index5] * 5);
            if (nums[i] == nums[index2] * 2) {
                index2++;
            }
            if (nums[i] == nums[index3] * 3) {
                index3++;
            }
            if (nums[i] == nums[index5] * 5) {
                index5++;
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        int i = new Solution().nthUglyNumber(10);
        System.out.println(i);
    }
}
