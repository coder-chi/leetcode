package item.s71;

import java.util.LinkedList;

/**
 * created by zhangzhiyuan in 2019/5/10
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 */
public class Solution {
    /**
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder("/");
        LinkedList<String> stack = new LinkedList<String>();
        for (String s:path.split("/")){
            if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.removeLast();
                }
            } else if(!s.equals("") && !s.equals(".")){
                stack.add(s);
            }
        }
        for (String s:stack){
            sb.append(s + "/");
        }
        if (!stack.isEmpty()){
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().simplifyPath("/ab/cd///../fe/./ee/../");
        System.out.println(s);
    }
}
