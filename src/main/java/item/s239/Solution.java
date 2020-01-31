package item.s239;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * created by zhangzhiyuan in 2020/1/25
 */
public class Solution {

    private int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int max_idx = 0;
        this.nums = nums;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            clean_deque(deque, i, k);
            deque.addLast(i);
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }
        int[] output = new int[length - k + 1];
        output[0] = nums[max_idx];
        for (int i = k; i < length; i++) {
            clean_deque(deque, i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }

    private void clean_deque(Deque<Integer> deque, int i, int k) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }
}
