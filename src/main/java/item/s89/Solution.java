package item.s89;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/5/28
 */
public class Solution {
    /**
     * 格雷编码，数学题
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = new Solution().grayCode(3);
        System.out.println(list);
    }
}
