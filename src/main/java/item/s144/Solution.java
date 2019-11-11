package item.s144;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/6/2
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    public void dfs(List<Integer> list, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        dfs(list, treeNode.left);
        dfs(list, treeNode.right);
    }
}
