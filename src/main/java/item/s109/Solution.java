package item.s109;

import accessory.ListNode;
import accessory.TreeNode;

/**
 * created by zhangzhiyuan in 2020/1/30
 * 这个解法非常的棒，是沿用了中序遍历本身就是有序的思路，倒推构建搜索树的思路
 */
public class Solution {

    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        int length = getSize(head);
        this.head = head;
        return convertListToBST(0, length - 1);

    }

    private int getSize(ListNode head) {
        ListNode pre = head;
        int length = 0;
        while (pre != null) {
            pre = pre.next;
            length++;
        }
        return length;
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = convertListToBST(l, mid - 1);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        head = head.next;
        TreeNode right = convertListToBST(mid + 1, r);
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new Solution().sortedListToBST(node1);
    }

}
