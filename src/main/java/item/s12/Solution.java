package item.s12;

/**
 * created by zhangzhiyuan in 2019/6/4
 */
public class Solution {

    /**
     * 感觉这道题实在没有什么好讲，其实很简单
     * 乍一看很复杂，实际上却很简单
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (true) {
            int count = num / nums[i];
            if (count != 0) {
                result.append(buildString(count, chars[i]));
            }
            num %= nums[i];
            if (num == 0) {
                break;
            }
            i++;
        }
        return result.toString();
    }

    private String buildString(int count, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().intToRoman(1994);
        System.out.println(s);
    }
}
