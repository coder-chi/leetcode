package item.s95;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/6/4
 */
public class Solution {
    /**
     * https://www.cnblogs.com/Dylan-Java-NYC/p/4824971.html
     * 认识递归、了解二叉树、什么是卡特兰数？
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftRes = dfs(left, i - 1);
            List<TreeNode> rightRes = dfs(i + 1, right);
            for (int m = 0; m < leftRes.size(); m++) {
                for (int n = 0; n < rightRes.size(); n++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRes.get(m);
                    root.right = rightRes.get(n);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
