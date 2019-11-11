package item.s123;

/**
 * created by zhangzhiyuan in 2019/8/30
 * 只击败了5.6的用户已经是非常慢了，但是这里有优化的空间，本次领会到了切割点的概念，已经有所收获了
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int length = prices.length;

        if (length < 2) {
            return 0;
        }

        int ret = 0;

        //通过分割点分别去算
        for (int cut = 0; cut < length; cut++) {
            int cutMax = 0;

            //前一段
            int preMin = prices[0];
            int preMax = 0;
            for (int i = 1; i < cut; i++) {
                preMax = Math.max(preMax, prices[i] - preMin);
                preMin = Math.min(preMin, prices[i]);
            }
            cutMax += preMax;

            //后一段
            preMin = prices[cut];
            preMax = 0;
            for (int i = cut + 1; i < length; i++) {
                preMax = Math.max(preMax, prices[i] - preMin);
                preMin = Math.min(preMin, prices[i]);
            }
            cutMax += preMax;

            ret = Math.max(cutMax, ret);
        }

        return ret;
    }
}
