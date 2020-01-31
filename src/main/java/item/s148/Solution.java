package item.s148;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2020/1/19
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode preNode = pre;

        for (int len = 1; (preNode = sortSubList(preNode, len)) != null; len *= 2) {
            while (preNode != null) {
                preNode = sortSubList(preNode, len);
            }
            preNode = pre;
        }
        return pre.next;
    }

    ListNode sortSubList(ListNode pre, int num) {
        int fstnum = 0, lstnum = 0;

        ListNode fst = pre.next, lst = fst;

        for (int i = 0; i < num; i++) {
            if (lst == null) {
                return null;
            }
            lst = lst.next;
        }

        while (fstnum < num && lstnum < num && lst != null) {
            if (fst.val <= lst.val) {
                pre.next = fst;
                fst = fst.next;
                fstnum++;
            } else {
                pre.next = lst;
                lst = lst.next;
                lstnum++;
            }
            pre = pre.next;
        }

        if (fstnum < num) {
            pre.next = fst;
            for (; fstnum < num; fstnum++) {
                pre = pre.next;
            }
            pre.next = lst;
        }

        if (lstnum < num && lst != null) {
            pre.next = lst;
            for (; lstnum < num && pre != null; lstnum++) {
                pre = pre.next;
            }
        }

        return pre;
    }
}
