package item.s104;

import accessory.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * created by zhangzhiyuan in 2020/1/13
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int level = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int length = treeNodes.size();
            for (int i = 0; i < length; i++) {
                TreeNode poll = treeNodes.poll();
                if (poll.left!=null) treeNodes.add(poll.left);
                if (poll.right!=null) treeNodes.add(poll.right);
            }
            level++;
        }
        return level;
    }
}
