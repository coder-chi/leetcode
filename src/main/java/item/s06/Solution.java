package item.s06;

/**
 * created by zhangzhiyuan in 2019/5/3
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列
 */
public class Solution {
    /**
     * 这种一般是规律题，一开始有点被吓到了，实在是不应该
     * 我们可以很简单地看出除了第一行和最后一行的间隔为 next = n + 2*numsRow -2 其他行，中间间隔有两个，一个是固定的，另一个和i有关。
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length <= 2) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int skip = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < length; j+= skip) {
                stringBuilder.append(s.charAt(j));
                if (i > 0 && i < numRows - 1) {
                    int k = j + skip - 2 * i;
                    if (k < length) {
                        stringBuilder.append(s.charAt(k));
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new Solution().convert("PAYPALISHIRING", 3);
    }
}
