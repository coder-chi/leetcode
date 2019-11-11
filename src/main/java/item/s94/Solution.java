package item.s94;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/5/29
 */
public class Solution {
    /**
     * 中序，递归超级简单
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    public void dfs(List<Integer> list,TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(list, node.left);
        list.add(node.val);
        dfs(list, node.right);
    }

}
