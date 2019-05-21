package item.s61;

/**
 * created by zhangzhiyuan in 2019/5/7
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class Solution {
    /**
     * 100% 但是真的有点太简单了，没啥说的，只要搞成循环就行了
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        tmp.next = head;
        int index = length - k % length;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        ListNode result = tmp.next;
        tmp.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode = new Solution().rotateRight(listNode1, 2);
        System.out.println(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
