package item.s344;

/**
 * created by zhangzhiyuan in 2020/1/28
 */
public class Solution {
    public void reverseString(char[] s) {
        int r = s.length - 1;
        if (r < 1) {
            return;
        }
        int l = 0;
        char temp;
        while (l < r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
