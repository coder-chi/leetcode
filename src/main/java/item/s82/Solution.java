package item.s82;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2019/5/21
 */
public class Solution {
    /**
     * 抄袭的，这个要反复练
     * https://blog.csdn.net/qq_38640439/article/details/81913805
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
            } else {
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;
            }
        }
        tmp.next = head;
        return newHead.next;
    }
}
