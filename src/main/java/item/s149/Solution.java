package item.s149;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangzhiyuan in 2020/1/20
 */
public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            int duplicate = 0;
            int x = points[i][0];
            int y = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int dis_x = points[j][0] - x;
                int dis_y = points[j][1] - y;
                if (dis_x == 0 && dis_y == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(dis_x, dis_y);
                dis_x = dis_x / gcd;
                dis_y = dis_y / gcd;
                String key = dis_x + "|" + dis_y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }


    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        new Solution().maxPoints(points);
    }
}
