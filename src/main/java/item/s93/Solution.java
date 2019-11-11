package item.s93;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/5/29
 */
public class Solution {
    /**
     * 需要判断一些特殊情况
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(result, 4, s, "");
        return result;
    }

    public void dfs(List<String> result, int nums, String s, String pattern) {
        int length = s.length();
        if (nums == 1) {
            //保证没有以0开头并且还不等于0的ip 比如 010
            if (length != 1 && s.charAt(0) == '0') {
                return;
            }
            int i = Integer.parseInt(s);
            if (i >= 0 && i <= 255) {
                pattern += s;
                result.add(pattern);
                return;
            }
        }
        for (int i = 3; i>0; i--) {
            if (length - i < nums - 1 || length - i > (nums - 1) * 3) {
                continue;
            }
            if (i != 1 && s.charAt(0) == '0') {
                continue;
            }
            if (i == 3) {
                int i1 = Integer.parseInt(s.substring(0, 3));
                if (i1 <= 255 && i1 > 0) {
                    String tmp = pattern + s.substring(0, 3) + ".";
                    dfs(result, nums-1, s.substring(3), tmp);
                }
            } else {
                String tmp = pattern + s.substring(0, i) + ".";
                dfs(result, nums-1, s.substring(i), tmp);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().restoreIpAddresses("010010");
    }
}
