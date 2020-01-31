package item.s334;

/**
 * created by zhangzhiyuan in 2020/1/28
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
