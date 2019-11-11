package item.s118;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/8/15
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> first = new ArrayList<>(1);
        first.add(1);
        res.add(first);
        if (numRows == 1) {
            return res;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>(i);
            int n = (i - 1) / 2;
            temp.add(1);
            for (int j = 1; j <= n; j++) {
                temp.add(res.get(i-2).get(j-1) + res.get(i-2).get(j));
            }
            for (int j = n + 1; j < i; j++) {
                temp.add(temp.get(i-1-j));
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().generate(10);
    }

}
