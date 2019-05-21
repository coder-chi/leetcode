package item.s68;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created by zhangzhiyuan in 2019/5/10
 */
public class Solution {
    /**
     * 自己写的方法，垃圾的一批，不过这破题也不怎么样，就练练思路了
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int length = words.length;
        int index = 0;
        while (index < length) {
            LinkedList<String> line = new LinkedList<>();
            int width = words[index].length();
            line.push(words[index]);
            index++;
            for (; index < length;) {
                if (width + words[index].length() + 1 <= maxWidth) {
                    line.push(words[index]);
                    width += words[index].length() + 1;
                    index++;
                } else {
                    break;
                }
            }
            if (index == length) {
                result.add(convertStringLast(line, maxWidth));
            } else {
                result.add(convertString(line, maxWidth));
            }
        }
        return result;
    }

    public String convertString(LinkedList<String> line, int maxWidth) {
        int width = getWidthForLinkedList(line);
        StringBuilder stringBuilder = new StringBuilder();
        if (line.size() == 1) {
            return line.pollLast() + spacingOfN(maxWidth - width);
        }
        int span = line.size() - 1;
        int right = (maxWidth - width) / span;
        int lnum = (maxWidth - width) % span;
        stringBuilder.append(line.pollLast());
        String rspace = spacingOfN(right);
        String lspace = rspace + " ";

        for (int i = 0; i < lnum; i++) {
            stringBuilder.append(lspace);
            stringBuilder.append(line.pollLast());
        }
        while (!line.isEmpty()) {
            stringBuilder.append(rspace);
            stringBuilder.append(line.pollLast());
        }
        return stringBuilder.toString();
    }

    public String convertStringLast(LinkedList<String> line, int maxWidth) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(line.pollLast());
        while (!line.isEmpty()) {
            stringBuilder.append(" ");
            stringBuilder.append(line.pollLast());
        }
        if (stringBuilder.length() != maxWidth) {
            stringBuilder.append(spacingOfN(maxWidth - stringBuilder.length()));
        }
        return stringBuilder.toString();
    }

    public String spacingOfN(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " ";
        }
        return result;
    }

    public int getWidthForLinkedList(LinkedList<String> line) {
        int width = 0;
        for (String s : line) {
            width += s.length();
        }
        return width;
    }

    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        new Solution().fullJustify(words, 16);

    }
}
