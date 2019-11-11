package item.s92;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2019/5/28
 */
public class Solution {

    /**
     * 91.8 有点爽的，这道题完全一个人手撸出来的，对于链表渣渣的我真的是一个挑战了
     * 关键在于抽象出链表的基本操作，插入、删除，不要把链表搞得太复杂
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode lPre = pre;
        for (int i = 0; i < m - 1; i++) {
            lPre = lPre.next;
        }
        ListNode rPre = lPre.next;
        for (int i = 0; i < n - m; i++) {
            ListNode r = rPre.next;
            rPre.next = r.next;
            r.next = lPre.next;
            lPre.next = r;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new Solution().reverseBetween(l1, 2, 4);
    }

}
