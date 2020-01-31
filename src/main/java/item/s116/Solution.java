package item.s116;

import accessory.Node;

import java.util.LinkedList;

/**
 * created by zhangzhiyuan in 2020/1/13
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int length = nodeQueue.size();
            for (int i = 0; i < length -1; i++) {
                Node poll = nodeQueue.poll();
                Node peek = nodeQueue.peek();
                poll.next = peek;
                if (poll.left != null) nodeQueue.add(poll.left);
                if (poll.right != null) nodeQueue.add(poll.right);
            }
            Node poll = nodeQueue.poll();
            if (poll.left != null) nodeQueue.add(poll.left);
            if (poll.right != null) nodeQueue.add(poll.right);
        }
        return root;
    }
}
