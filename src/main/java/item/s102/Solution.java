package item.s102;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * created by zhangzhiyuan in 2020/1/13
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                TreeNode poll = queue.poll();
                result.get(level).add(poll.val);

                if (poll.left!=null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            level++;
        }
        return result;
    }
}
