package item.s368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/11/18
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        int max = 1;
        int maxIndex = 0;
        int[] dp = new int[length];
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            list[i] = -1;
            dp[i] = 1;
        }
        Arrays.sort(nums);
        for (int i = 1; i < length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        list[i] = j;
                        if (max < dp[i]) {
                            max = dp[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }
        int index = maxIndex;
        result.add(nums[index]);
        while (list[index] != -1) {
            index = list[index];
            result.add(nums[index]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};


        List<Integer> list = new Solution().largestDivisibleSubset(nums);
        System.out.println(1);
    }
}
