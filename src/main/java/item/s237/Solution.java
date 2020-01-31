package item.s237;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2020/1/25
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
