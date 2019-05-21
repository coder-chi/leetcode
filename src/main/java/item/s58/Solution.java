package item.s58;

/**
 * created by zhangzhiyuan in 2019/5/6
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int l = 0;
        String trim = s.trim();
        int length = trim.length();
        for (int i = length - 1; i >= 0 && trim.charAt(i)!= ' '; i--) {
            l++;
        }
        return l;
    }

    public static void main(String[] args) {
        String s = "123   123   ";
        int i = new Solution().lengthOfLastWord(s);
        System.out.println(i);
    }

}
