package item.s202;

import java.util.HashSet;
import java.util.Set;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int result = 0;
            while (n != 0) {
                int yu = n % 10;
                result += yu * yu;
                n /= 10;
            }
            if (result == 1) {
                return true;
            }
            n = result;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().isHappy(19);
    }
}
