package item.s11;

/**
 * created by zhangzhiyuan in 2019/5/18
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class Solution {
    /**
     * 数学题，双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int r = height.length - 1;
        int l = 0;
        if (r <= 0) {
            return 0;
        }
        int max = r * (Math.min(height[r], height[l]));
        while (l < r) {
            int area = (r - l) * Math.min(height[r], height[l]);
            if (area > max) {
                max = area;
            }
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
