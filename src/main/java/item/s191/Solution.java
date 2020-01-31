package item.s191;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        int count = 0;
        while (count < 32) {
            res += n & 1;
            n >>= 1;
            count++;
        }
        return res;
    }
}
