package item.s111;

import accessory.TreeNode;

/**
 * created by zhangzhiyuan in 2020/1/31
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countMinCount(root);
    }

    private int countMinCount(TreeNode root) {
        if (root.right == null && root.left == null) {
            return 1;
        }
        int left = root.left == null ? Integer.MAX_VALUE : countMinCount(root.left);
        int right = root.right == null ? Integer.MAX_VALUE : countMinCount(root.right);
        return Math.min(left, right) + 1;
    }

}
