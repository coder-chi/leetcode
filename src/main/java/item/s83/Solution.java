package item.s83;

import accessory.ListNode;

/**
 * created by zhangzhiyuan in 2019/5/27
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        if (cur == null ){
            return head;
        }
        while (cur.next != null){
            if (cur.val == cur.next.val){
                //当前值与下一个值相等， 则删除
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        new Solution().deleteDuplicates(listNode0);

    }
}
