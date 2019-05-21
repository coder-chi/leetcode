package item.s47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列2，这道题必需重做
 * created by zhangzhiyuan in 2019/4/22
 */
public class Solution {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteAux(nums,0, new ArrayList<>(), used, res);
        return res;
    }

    private void permuteAux(int[] nums,int index, List<Integer> st, boolean[] used,List<List<Integer>> res) {
        if(index == nums.length){

            List<Integer> t = new ArrayList<>(st);
            res.add(t);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            //这个地方是精髓，要仔细理解
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;

            st.add(nums[i]);
            used[i] = true;
            permuteAux(nums,index+1,st, used, res);
            used[i] = false;
            st.remove(st.size()-1);

        }

        return;
    }
}
