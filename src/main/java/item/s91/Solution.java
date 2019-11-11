package item.s91;

/**
 * created by zhangzhiyuan in 2019/5/28
 */
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        if (s.charAt(0) > '0') {
            count[1] = 1;
        }
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) > '0') {
                count[i] = count[i - 1];
            }
            int sum = Integer.parseInt(s.substring(i - 2, i));
            if (sum <= 26 && s.charAt(i - 2) > '0') {
                count[i] += count[i - 2];
            }
        }
        return count[s.length()];
    }

    public static void main(String[] args) {
        int i = new Solution().numDecodings("12");
        System.out.println(i);
    }
}
