package item.s207;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                ((LinkedList<Integer>) queue).addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer pre = ((LinkedList<Integer>) queue).removeLast();
            numCourses--;
            for (int[] req : prerequisites) {
                if (req[1] != pre) {
                    continue;
                }
                if (--indegrees[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }
        }
        return numCourses == 0;
    }
}
