package item.s09;

/**
 *
 * created by zhangzhiyuan in 2019/5/6
 */
public class Solution {
    /**
     * 没用String，算是一个挑战吧，这里只要保证倒过来的数相等就可以了
     * 更快的方法猜测：只需要算到一半就可以了
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int sum = 0;
        int num1 = x;
        while (num1 != 0) {
            sum = sum * 10 + num1 % 10;
            num1 /= 10;
        }
        if (x == sum) {
            return true;
        }
        return false;
    }
}
