package item.s213;

/**
 * created by zhangzhiyuan in 2019/11/7
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len ==  1){
            return nums[0];
        }
        if(len ==  2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        return Math.max(help(nums,0,len-2),help(nums,1,len-1));

    }
    private int help(int[] nums,int start,int end){
        int[] dp = new int[end-start+1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start+1],nums[start]);

        for(int i = start+2;i<=end;i++ ){
            dp[i-start] = Math.max(dp[i-start-1],dp[i-start-2]+nums[i]);
        }
        return dp[end-start];

    }
}
