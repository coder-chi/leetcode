package item.s02;

/**
 * created by zhangzhiyuan in 2019/4/26
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            ListNode listNode = new ListNode(sum % 10);
            tmp.next = listNode;
            tmp = tmp.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            ListNode listNode = new ListNode(carry);
            tmp.next = listNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(9);
        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
