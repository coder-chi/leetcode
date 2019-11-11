package item.s160;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2019/6/2
 */
public class Solution {
    /**
     * 1.找到两个链表长度差n后较长的链表先走n步
     * 2,然后两个指针同时向前走，如果两个指针相等，则该点为交点的入口
     * 3.如果遍历完指针仍然不相等，则说明无焦点。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            headA = headA.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            headB = headB.next;
            p2 = p2.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
