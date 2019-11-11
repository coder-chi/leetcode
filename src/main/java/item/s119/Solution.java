package item.s119;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/8/16
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        res.add(1);
        if (rowIndex == 1) {
            return res;
        }
        for (int i = 2; i <= rowIndex; i++) {
            res.add(1);
            for (int j = i-1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> row = new Solution().getRow(3);
        System.out.println(row);

    }
}
