package item.s230;

import accessory.TreeNode;

/**
 * created by zhangzhiyuan in 2020/1/25
 */
public class Solution {
    private int i = 0;

    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root,int k) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, k);
        }
        i++;
        if (i == k) {
            result = root.val;
        }
        dfs(root.right, k);
    }
}
