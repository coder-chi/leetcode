package item.s99;

import accessory.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * created by zhangzhiyuan in 2020/1/30
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstNode == null && pre.val > p.val) {
                firstNode = pre;
            }
            if (firstNode != null && pre.val > p.val) {
                secondNode = p;
            }
            pre = p;
            p = p.right;
        }
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }
}
