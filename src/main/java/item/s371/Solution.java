package item.s371;

/**
 * created by zhangzhiyuan in 2020/1/28
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}