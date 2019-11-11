package item.s81;

/**
 * created by zhangzhiyuan in 2019/6/1
 */
public class Solution {

    /**
     * 主要是理解边界，之前有必须不相等的题
     * https://blog.csdn.net/u010771890/article/details/52837766
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int head = 0, tail = nums.length;
        while (head < tail) {
            int mid = (head + tail) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (target == nums[head]) {
                return true;
            }
            if (nums[mid] > nums[head]) {
                if (target < nums[mid] && target > nums[head]) {
                    tail = mid;
                } else {
                    head = mid + 1;
                }
            } else if (nums[mid] < nums[head]) {
                if (target > nums[mid] && target < nums[head]) {
                    head = mid + 1;
                } else {
                    tail = mid;
                }
            } else {
                head++;
            }
        }
        return false;
    }
}
