package item.s60;

import java.util.LinkedList;

/**
 * created by zhangzhiyuan in 2019/5/6
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().getPermutation(3, 3);
    }

    /**
     * 全排列找规律，不用全部计算出来
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        k = k - 1;
        StringBuilder result = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] fac = fac(n);
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            index = k / fac[i];
            result.append(list.remove(index));
            k = k % fac[i];
        }
        return result.toString();
    }
    public int[] fac(int n) {
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = i * result[i - 1];
        }
        return result;
    }

}
