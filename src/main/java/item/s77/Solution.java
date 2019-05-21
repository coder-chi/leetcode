package item.s77;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/5/20
 */
public class Solution {
    /**
     * 时间98.02% 内存99.23% 鬼能知道一个破递归有必要这么快么？可能我剪了个枝吧
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineN(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void combineN(int index, int n, int k, List<Integer> tmp, List<List<Integer>> result) {
        if (n - index + 1 < k) {
            return;
        }
        if (k == 0) {
            result.add(tmp);
            return;
        }
        for (int i = index; i + k - 1<= n ; i++) {
            List<Integer> list = new ArrayList<>(tmp);
            list.add(i);
            combineN(i + 1, n, k - 1, list, result);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(4, 2);
        System.out.println(combine);

    }
}
