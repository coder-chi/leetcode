package item.s75;

/**
 * created by zhangzhiyuan in 2019/5/20
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class Solution {
    /**
     * 为什么交换2的时候不能步进，而交换0的时候却可以步进，这是一个可以思考的问题
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0,  right = nums.length - 1;
        for (int i = left; i <= right; i++) {
            if(nums[i] == 0) swap(nums, left++, i);
            if(nums[i] == 2) swap(nums, right--, i--);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 0, 0, 1, 2, 2, 1, 0, 0, 1, 2};
        new Solution().sortColors(a);
        System.out.println(1);
    }
}
