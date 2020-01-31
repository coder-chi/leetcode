package item.s110;

import accessory.TreeNode;

/**
 * created by zhangzhiyuan in 2020/1/30
 * 这个题倒是很简单，但是我没有想到怎么能通过递归传达"深度"和"是否是平衡二叉树"这两个信息
 * 实际上可以通过-1来判断是否是二叉树
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1) return -1;
        if (Math.abs(right - left) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
