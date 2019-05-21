package item.s04;

/**
 * created by zhangzhiyuan in 2019/5/3
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Solution {
    /**
     * 这道题，非常的难，但是可以用思维转化为求第K个数
     * https://www.cnblogs.com/duanqiong/p/4415049.html
     * 这里偶数计算了两次，我觉得可能是有优化空间的
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLenght = m + n;
        if (totalLenght % 2 == 1) {
            return findKth(nums1, 0, m, nums2, 0, n, totalLenght / 2 + 1);
        } else {
            return (findKth(nums1, 0, m, nums2, 0, n, totalLenght / 2) + findKth(nums1, 0, m, nums2, 0, n, totalLenght / 2 + 1)) / 2;
        }
    }

    public double findKth(int a[], int begina, int m, int b[], int beginb, int n, int k) {
        if (m > n) {
            return findKth(b, beginb, n, a, begina, m, k);
        }
        if (m == 0) {
            return b[beginb + k - 1];
        }
        if (k == 1) {
            return Math.min(a[begina], b[beginb]);
        }
        int ma = Math.min(k / 2, m), mb = k - ma;
        if (a[begina + ma - 1] < b[beginb + mb - 1]) {
            return findKth(a, begina + ma, m-ma, b, beginb, n,k - ma);
        } else if (a[begina + ma - 1] > b[beginb + mb - 1]) {
            return findKth(a, begina, m, b, beginb + mb, n - mb, k - mb);
        } else {
            return a[begina + ma - 1];
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 3};
        int b[] = {2};
        new Solution().findMedianSortedArrays(a, b);
    }
}
