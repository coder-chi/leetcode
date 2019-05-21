package item.s41;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 缺失的第一个正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * created by zhangzhiyuan in 2019/4/20
 */
public class Solution {
    /**
     * 这道题的要求是On，并且使用的额外空间只有一个
     * 核心思路：1.桶排序 2.使用原来的数组空间进行交换，这样不需要申请额外空间
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length;) {
            if (nums[i] > length) {
                i++;
                continue;
            }
            if (nums[i] < 1) {
                i++;
                continue;
            }
            //重点：这一步既可以跳出循环，也可以避免死循环
            if (nums[i] == nums[nums[i] - 1]) {
                i++;
                continue;
            }
            int swap = nums[i] - 1;
            nums[i] = nums[swap];
            nums[swap] = swap + 1;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        System.out.println(new Solution().firstMissingPositive(array));
    }
}
