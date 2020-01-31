package item.s204;

import java.util.BitSet;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        BitSet bit = new BitSet(n);
        for (int i = 2; i * i < n; i++) {
            if (!bit.get(i)) {
                for (int j = i * i; j < n; j += i) {
                    bit.set(j);
                }
            }
        }
        return n - 2 - bit.cardinality();
    }
}
