package item.s179;


import java.util.Arrays;
import java.util.Comparator;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        if (strings[0].equals("0")) {
            return "0";
        }
        StringBuilder stb = new StringBuilder();
        for (String numAsStr : strings) {
            stb.append(numAsStr);
        }
        return stb.toString();
    }
}
