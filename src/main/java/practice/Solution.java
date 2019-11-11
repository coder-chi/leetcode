package practice;

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import accessory.ListNode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode s = new ListNode(listNode.val);
        ListNode p = new ListNode(listNode.val);
        s.next = p;
        listNode = listNode.next;
        while (listNode != null) {
            ListNode temp = new ListNode(listNode.val);
            temp.next = s.next;
            s.next = temp;
            listNode = listNode.next;
        }
        s = s.next;
        while (s != null) {
            list.add(s.val);
            s = s.next;
        }
        return list;
    }
}
