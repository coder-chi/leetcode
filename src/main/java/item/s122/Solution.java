package item.s122;

/**
 * created by zhangzhiyuan in 2019/5/30
 */
public class Solution {
    /**
     * 又是头条挂这题，简直不敢相信
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            int count = diff > 0 ? diff : 0;
            sum += count;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int i = new Solution().maxProfit(a);
        System.out.println(i);
    }
}
