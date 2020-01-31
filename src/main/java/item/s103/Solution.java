package item.s103;

import accessory.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2020/1/13
 */
public class Solution {

    /**
     * 这个双向链表真心折磨人，但只要理解了数据结构，整理好思路，就也没那么难了
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int level = 0;
        Deque<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int length = linkedList.size();
            result.add(new ArrayList<>());
            if (level % 2 == 0) {
                for (int i = 0; i < length; i++) {
                    TreeNode poll = linkedList.pollFirst();
                    result.get(level).add(poll.val);
                    if (poll.left != null) linkedList.offerLast(poll.left);
                    if (poll.right != null) linkedList.offerLast(poll.right);
                }
            } else {
                for (int i = 0; i < length; i++) {
                    TreeNode pop = linkedList.pollLast();
                    result.get(level).add(pop.val);
                    if (pop.right != null) linkedList.offerFirst(pop.right);
                    if (pop.left != null) linkedList.offerFirst(pop.left);
                }
            }
            level++;
        }
        return result;
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.push(3);
        System.out.println(1);
    }

}
