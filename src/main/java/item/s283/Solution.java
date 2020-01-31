package item.s283;

/**
 * created by zhangzhiyuan in 2020/1/25
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
