package item.s70;

/**
 * created by zhangzhiyuan in 2019/5/8
 * 爬楼梯
 */
public class Solution {
    /**
     * 斐波那契、动规，没什么好说
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        int i = new Solution().climbStairs(2);
        System.out.println(i);
    }
}
