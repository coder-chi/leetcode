package item.s69;

/**
 * created by zhangzhiyuan in 2019/5/8
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Solution {
    /**
     * 用了一个二分加了个速，结果还没有Math快
     * 执行最快的使用了位运算的骚操作，有空学下
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int min = 0;
        int max = 1;
        while (min != max) {
            //防止超出Int范围
            if (Integer.MAX_VALUE / max < max || max * max > x) {
                max = (min + max) / 2;
            } else if (max * max < x) {
                min = max;
                max = 2 * min;
            } else {
                return max;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int i = new Solution().mySqrt(2147395599);
        System.out.println(i);
    }

}
