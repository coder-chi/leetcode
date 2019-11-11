package item.s86;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2019/6/1
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lNode = new ListNode(0);
        ListNode rNode = new ListNode(0);
        ListNode l = lNode;
        ListNode r = rNode;
        while (head != null) {
            ListNode tmp = head.next;
            if (head.val < x) {
                l.next = head;
                l = l.next;
                //这里要置空，否则会形成循环链表，或者不用原来链表的节点，复制一个节点
                l.next = null;
            } else {
                r.next = head;
                r = r.next;
                r.next = null;
            }
            head = tmp;
        }
        l.next = rNode.next;
        return lNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        new Solution().partition(listNode1, 3);
    }
}
