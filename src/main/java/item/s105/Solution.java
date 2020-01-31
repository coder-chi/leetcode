package item.s105;

import accessory.TreeNode;

import java.util.HashMap;

/**
 * created by zhangzhiyuan in 2020/1/12
 */
public class Solution {
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;

    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        this.inorder = inorder;

        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right) {
            return null;
        }

        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx++;
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;
    }
}
