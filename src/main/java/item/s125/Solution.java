package item.s125;

/**
 * created by zhangzhiyuan in 2019/6/2
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char head, tail;
        if (j < 0) {
            return true;
        }
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                j--;
            }
            head = s.charAt(i);
            tail = s.charAt(j);
            if (Character.isLetterOrDigit(head) && Character.isLetterOrDigit(tail)) {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}
