package item.s84;

import java.util.Stack;

/**
 * created by zhangzhiyuan in 2019/5/27
 */
public class Solution {
    /**
     * https://www.cnblogs.com/ganganloveu/p/4148303.html 非常棒的思路，学习学习
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int ret = 0;
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {
            if (stk.isEmpty() || stk.peek() <= heights[i]) {
                stk.push(heights[i]);
            } else {
                int count = 0;
                while (!stk.empty() && stk.peek() > heights[i]) {
                    count++;
                    ret = Math.max(ret, stk.pop() * count);
                }
                while (count != 0) {
                    count--;
                    stk.push(heights[i]);
                }
                stk.push(heights[i]);
            }
        }
        int count = 1;
        while (!stk.empty()) {
            ret = Math.max(ret, stk.pop() * count);
            count++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        new Solution().largestRectangleArea(a);
    }
}
