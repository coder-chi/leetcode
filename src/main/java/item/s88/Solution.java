package item.s88;

/**
 * created by zhangzhiyuan in 2019/5/27
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = nums1.length - 1;
        while (index1 != -1 || index2 != -1) {
            if (index1 == -1) {
                nums1[index] = nums2[index2];
                index2--;
                index--;
            } else if(index2 == -1){
                nums1[index] = nums1[index1];
                index1--;
                index--;
            } else if (nums1[index1] < nums2[index2]) {
                nums1[index] = nums2[index2];
                index2--;
                index--;
            }else {
                nums1[index] = nums1[index1];
                index1--;
                index--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        new Solution().merge(a, 3, b, 3);
        System.out.println(1);
    }
}
