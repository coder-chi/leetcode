package item.s324;

import java.util.Arrays;

/**
 * created by zhangzhiyuan in 2020/1/28
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] a = Arrays.copyOf(nums, length);
        int mid = (length - 1) / 2;
        for (int i = mid; i >= 0; i--) {
            nums[(mid - i) * 2] = a[i];
        }
        for (int j = length-1; j >= mid+1; j--) {
            nums[(length - j - 1) * 2 + 1] = a[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 6, 4, 4, 2, 1};
        new Solution().wiggleSort(nums);
        System.out.println(1);
    }

}
