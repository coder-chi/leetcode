package item.s87;

/**
 * created by zhangzhiyuan in 2019/8/28
 * 该题说是用动态规划的方法，我觉得更像分治
 * 感觉还可以用快速失败的方式再优化下
 */
public class Solution {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alpha[s1.charAt(i) - 'a']++;
            alpha[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean scramble = new Solution().isScramble("great", "treag");
        System.out.println(scramble);
    }
}
