package item.s127;

import javafx.util.Pair;

import java.util.*;

/**
 * created by zhangzhiyuan in 2020/1/15
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l = beginWord.length();

        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word ->{
                    for (int i = 0; i < l; i++) {
                        String newword = word.substring(0, i) + '*' + word.substring(i + 1, l);
                        List<String> transformations = allComboDict.getOrDefault(newword, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newword, transformations);
                    }
                }
        );

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));

        HashMap<String, Boolean> visited = new HashMap<>();

        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);

                for (String adjacendWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacendWord.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(adjacendWord)) {
                        visited.put(adjacendWord, true);
                        q.add(new Pair<>(adjacendWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
