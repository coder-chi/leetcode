package item.s43;

/**
 * created by zhangzhiyuan in 2019/4/21
 */
public class Solution {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] b = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                //存储所有对位相乘的结果
                b[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = 0; i < num1.length() + num2.length(); i++) {
            if (b[i] > 9) {
                b[i + 1] += b[i] / 10;
                b[i] = b[i] % 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = num1.length() + num2.length() - 1; i >= 0; i--) {
            stringBuilder.append(b[i]);
        }

        while (stringBuilder.charAt(0) == '0' && stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("6913259244", "71103343"));
    }
}
