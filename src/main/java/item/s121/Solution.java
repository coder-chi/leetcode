package item.s121;

/**
 * created by zhangzhiyuan in 2019/5/30
 */
public class Solution {
    /**
     * 蛮简单一道题，面头条居然挂了，头疼
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1;i<length;i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 3, 2, 1};
        int i = new Solution().maxProfit(a);
        System.out.println(i);
    }
}
