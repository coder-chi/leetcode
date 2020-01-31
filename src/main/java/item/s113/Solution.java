package item.s113;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * created by zhangzhiyuan in 2020/1/31
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        depth(root, sum, res, new ArrayList<>());
        return res;
    }

    private void depth(TreeNode root,int sum, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        sum -= root.val;
        if (root.right == null && root.left == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(tmp));
            }
        }
        depth(root.left, sum, res, tmp);
        depth(root.right, sum, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
