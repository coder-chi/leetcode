package item.s136;

/**
 * created by zhangzhiyuan in 2019/6/2
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {2, 2,3,3, 1};
        int i = new Solution().singleNumber(a);
        System.out.println(i);
    }
}
