package item.s42;

/**
 * created by zhangzhiyuan in 2019/4/21
 */
public class Solution {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水
     * 核心思想：双指针，分阶段（之前的影响不会延迟到后期）
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int lh = height[left];
        int rh = height[right];
        while (left <= right) {
            if (lh < rh) {
                if (lh < height[left]) {
                    lh = height[left];
                } else {
                    sum += lh - height[left];
                }
                left++;
            } else {
                if (rh < height[right]) {
                    rh = height[right];
                } else {
                    sum += rh - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}
