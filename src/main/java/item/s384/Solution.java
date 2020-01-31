package item.s384;

import java.util.Random;

/**
 * created by zhangzhiyuan in 2020/1/29
 */
public class Solution {

    private int[] array;

    private int[] original;

    private Random random = new Random();

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            swapAt(i, randRange(i, length));
        }
        return array;
    }
}
