package item.s145;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/6/2
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    public void dfs(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        dfs(list, treeNode.left);
        dfs(list, treeNode.right);
        list.add(treeNode.val);
    }
}
