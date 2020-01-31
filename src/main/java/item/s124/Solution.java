package item.s124;

import accessory.TreeNode;

/**
 * created by zhangzhiyuan in 2020/1/13
 */
public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        int helper = helper(root);
        return Math.max(helper, max);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        int price_newpath = val + left + right;
        max = Math.max(max, price_newpath);
        return val + Math.max(left, right);
    }

    public static void main(String[] args) {
        new Solution().maxPathSum(new TreeNode(-3));
    }
}
