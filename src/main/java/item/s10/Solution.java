package item.s10;

/**
 * created by zhangzhiyuan in 2019/5/18
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        //如果都为空则匹配成功
        if (p.isEmpty()) return s.isEmpty();

        //第一个是否匹配上
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            //看有没有可能,剩下的pattern匹配上全部的text
            //看有没有可能,剩下的text匹配整个pattern
            //isMatch(text, pattern.substring(2)) 指当p第二个为*时，前面的字符不影响匹配所以可以忽略，所以将*以及*之前的一个字符删除后匹配之后的字符，这就是为什么用pattern.substring(2)
            //如果第一个已经匹配成功，并且第二个字符为*时，这是我们就要判断之后的需要匹配的字符串是否是多个前面的元素（*的功能），这就是first_match && isMatch(text.substring(1), pattern))的意义
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            //没有星星的情况:第一个字符相等,而且剩下的text,匹配上剩下的pattern，没有星星且第一个匹配成功，那么s和p同时向右移动一位看是否仍然能匹配成功
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
