package item.s65;

/**
 * created by zhangzhiyuan in 2019/5/10
 * 验证给定的字符串是否可以解释为十进制数字
 */
public class Solution {

    /**
     * 这破玩意还是之后搞一搞正则吧，有点脑壳痛
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        int num = 0, words = 0, dot = 0, i = 0;
        s = s.trim();
        int len = s.length();

        if (len == 0 || s.charAt(len - 1) == 'e' || s.charAt(len - 1) == '-' || s.charAt(len - 1) == '+') {
            return false;
        }
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            len--;
            i++;
        }
        for (; i < s.length(); i++) {
            //排除 +e、-e
            if ((len == 1 && s.charAt(i) == 'e') || (len == 1 && s.charAt(i) == '.')) {
                return false;
            //遍历到e，前面没有其他字母并且有数字，合格
            } else if ((s.charAt(i) == 'e' && words != 1) && num != 0) {
                words++;
            //遍历到. 前面没有. 也没有e 算合格
            } else if ((s.charAt(i) == '.' && dot != 1) && words != 1) {
                dot++;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num++;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (s.charAt(s.length() - 1) == '.' && words != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isNumber("005047e+6");
    }
}
