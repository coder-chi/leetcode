package item.s106;

import accessory.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangzhiyuan in 2020/1/12
 */
public class Soution {
    int pre_inx = 0;
    int[] inorder;
    int[] postorder;

    Map<Integer, Integer> idx_Map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pre_inx = postorder.length - 1;

        this.inorder = inorder;
        this.postorder = postorder;

        int idx = 0;
        for (int val : inorder) {
            idx_Map.put(val, idx++);
        }

        return helper(0, inorder.length);
    }

    private TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right) {
            return null;
        }
        int root_val = postorder[pre_inx--];
        TreeNode root = new TreeNode(root_val);
        int in_index = idx_Map.get(root_val);
        root.right = helper(in_index + 1, in_right);
        root.left = helper(in_left, in_index);
        return root;
    }
}
