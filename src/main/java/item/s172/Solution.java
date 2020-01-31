package item.s172;

/**
 * created by zhangzhiyuan in 2020/1/23
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        new Solution().trailingZeroes(200);
    }
}
