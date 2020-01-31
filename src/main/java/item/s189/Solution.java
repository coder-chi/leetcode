package item.s189;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[length - 1];
            for (int j = 0; j < length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
