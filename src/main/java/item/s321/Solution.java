package item.s321;

/**
 * created by zhangzhiyuan in 2019/12/17
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[k];

        for(int i=0; i<=k; i++){
            if((k - i) <= len2 && i <= len1){
                int[] tmp = new int[k];
                tmp = merge(singleNum(nums1, i), singleNum(nums2, k-i));
                if(compare(tmp, 0, res, 0))
                    res = tmp;
            }
        }

        return res;
    }

    public int[] singleNum(int[] nums, int k){
        int len = nums.length;
        int[] res = new int[k];
        int j = 0;

        for(int i=0; i<len; i++){

            while(len-i+j > k && j > 0 && res[j-1] < nums[i])
                j--;
            if(j < k)
                res[j++] = nums[i];
        }
        return res;

    }

    public int[] merge(int[] nums1, int[] nums2){
        int k = nums1.length + nums2.length;
        int[] res = new int[k];

        for(int i=0, j=0, idx = 0; idx < k; idx++){
            res[idx] = compare(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;

    }

    private boolean compare(int[] nums1, int idx1, int[] nums2, int idx2){
        while(idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]){
            idx1++;
            idx2++;
        }
        return idx2 == nums2.length || (idx1 < nums1.length && nums1[idx1] > nums2[idx2]);

    }


    public static void main(String[] args) {

    }
}
