package item.s80;

/**
 * created by zhangzhiyuan in 2019/5/21
 */
public class Solution {
    //抽象
    //index代表index前面的数组都是合乎要求的，count代表index上面的数字有几个值
    //length <= 2 return length
    //
    //index = 1
    //i = 0
    //count = 1
    //
    //if a[i] != a[index]
    //{
    //	index++
    //	a[index] = a[i]
    //	count=1
    //}
    //
    //if a[i] == a[index] && count == 1
    //{
    //	index++
    //	a[index] = a[i]
    //	count ++
    //}
    /**
     * 100%的题，so happy，然而很简单，手推一下就行了
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length;
        }
        int count = 1;
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
                count = 1;
            } else if (count == 1) {
                index++;
                nums[index] = nums[i];
                count++;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4};
        int i = new Solution().removeDuplicates(a);
        System.out.println(i);
    }
}
