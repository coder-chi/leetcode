package item.s217;

import java.util.HashSet;
import java.util.Set;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
