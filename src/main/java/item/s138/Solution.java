package item.s138;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangzhiyuan in 2020/1/15
 */
public class Solution {

    Map<Node, Node> dic = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (dic.containsKey(head)) {
            return dic.get(head);
        }

        Node node = new Node(head.val, null, null);
        node.val = head.val;
        this.dic.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
