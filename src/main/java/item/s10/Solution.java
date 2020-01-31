package item.s10;

/**
 * created by zhangzhiyuan in 2019/5/18
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        //第一个字符相同 或 p第一个字符为. 都匹配上了
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        //单个*没有意义，所以必须要大于2
        if (p.length() >= 2 && p.charAt(1) == '*') {

            //1.*这个匹配为空 2.*匹配了一个字符
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        } else {
            //非*的情况，正常向下匹配
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
