package item.s268;

/**
 * created by zhangzhiyuan in 2020/1/25
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int sum = (n * (n + 1)) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
