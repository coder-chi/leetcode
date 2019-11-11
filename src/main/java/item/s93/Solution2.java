package item.s93;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/6/4
 */
public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(result, 4, s, "");
        return result;
    }

    private void dfs(List<String> result, int count, String s, String pattern) {
        int length = s.length();
        if (count == 1) {
            //保证没有以0开头的并且还不等于0的ip 比如010
            if (s.charAt(0) == '0' && length != 1) {
                return;
            }
            int i = Integer.parseInt(s);
            if (i >= 0 && i <= 255) {
                pattern += s;
                result.add(pattern);
                return;
            }
        }

        for (int i = 3; i > 0; i--) {
            if (length - i < count - 1 || length - i > (count - 1) * 3) {
                continue;
            }
            if (s.charAt(0) == '0' && i != 1) {
                continue;
            }
            if (i == 3) {
                int i1 = Integer.parseInt(s.substring(0, 3));
                if (i1 <= 255 && i1 > 0) {
                    String tmp = pattern + s.substring(0, 3) + ".";
                    dfs(result, count - 1, s.substring(3), tmp);
                }
            } else {
                String tmp = pattern + s.substring(0, i) + ".";
                dfs(result, count - 1, s.substring(i), tmp);
            }
        }
    }
}
