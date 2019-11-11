package item.s94;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by zhangzhiyuan in 2019/6/4
 */
public class Solution2 {
    /**
     * 中序遍历、不用递归版本
     * 用手去模拟一遍就可以了
     * 当前节点不为空就可以入栈，留待之后再输出，然后遍历其左节点。
     * 当前节点为null，则出栈，输出；开始遍历右节点。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !stack.empty()) {
            if (tmp == null) {
                tmp = stack.pop();
                result.add(tmp.val);
                tmp = tmp.right;
            } else {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return result;
    }
}
