package item.s206;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2020/1/24
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;

        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }

        return pre;
    }
}
