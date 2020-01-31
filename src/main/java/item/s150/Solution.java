package item.s150;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * created by zhangzhiyuan in 2020/1/21
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack<Integer> numbers = new Stack<>();
        Set<String> operateSet = new HashSet<>();
        operateSet.add("*");
        operateSet.add("+");
        operateSet.add("/");
        operateSet.add("-");
        for (String s : tokens) {
            if (operateSet.contains(s)) {
                Integer number_2 = numbers.pop();
                Integer number_1 = numbers.pop();
                Integer result = operate(number_1, number_2, s);
                numbers.push(result);
            } else {
                numbers.push(Integer.valueOf(s));
            }
        }
        return numbers.pop();
    }

    private Integer operate(Integer a, Integer b, String s) {
        if (s.equals("+")) {
            return a + b;
        }
        if (s.equals("-")) {
            return a - b;
        }
        if (s.equals("*")) {
            return a * b;
        }
        return a / b;
    }

    public static void main(String[] args) {
        String[] strings = {"4", "13", "5", "/", "+"};
        new Solution().evalRPN(strings);
    }
}
