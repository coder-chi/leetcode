package item.s341;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2020/1/28
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<Integer> deque = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        addDeque(nestedList);
    }

    private void addDeque(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                deque.addLast(nestedInteger.getInteger());
            } else {
                addDeque(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return deque.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return deque.size() > 0;
    }
}