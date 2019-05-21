package item.s49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * created by zhangzhiyuan in 2019/4/23
 */
public class Solution {

    /**
     * 解法很慢，虽然我不知道哪里慢，我用的hash直接可以帮我确定同类，之后重做吧
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortMap = new HashMap<>();

        for (String str : strs) {
            String sortKey = buildSortKey(str);
            if (!sortMap.containsKey(sortKey)) {
                sortMap.put(sortKey, new ArrayList<String>());
            }
            sortMap.get(sortKey).add(str);
        }
        return new ArrayList<>(sortMap.values());
    }


    public String buildSortKey(String str) {
        int[] count = new int[26];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            int index = (int)(ch - 'a');
            count[index]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            stringBuilder.append(i).append(count[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(strings);
        System.out.println(lists);

    }
}
