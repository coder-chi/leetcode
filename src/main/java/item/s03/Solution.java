package item.s03;

/**
 * created by zhangzhiyuan in 2019/4/28
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution {
    /**
     * 这道题用了一个双指针，去滑动判断一个字符串窗口，速度还是飞快的
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[255];
        int len = 0;
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] != 0) {
                while (j != i) {
                    chars[s.charAt(j)]--;
                    len--;
                    j++;
                    if (s.charAt(j-1) == s.charAt(i)) {
                        break;
                    }
                }
            }
            chars[s.charAt(i)]++;
            len++;
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcdabc"));
    }
}
