package item.s66;


/**
 * created by zhangzhiyuan in 2019/5/7
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Solution {
    /**
     * 简单题，不解释
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int tmp = 1;
        for (int i = length - 1; i >= 0; i--) {
            int m = digits[i] + tmp;
            tmp = m / 10;
            digits[i] = m % 10;
            if (tmp == 0) {
                break;
            }
        }
        if (tmp == 1) {
            int[] result = new int[length + 1];
            result[0] = tmp;
            for (int i = 0; i < length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
    }
}
