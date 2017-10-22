package Arrays;

import java.util.Random;

/**
 * Created by Shivangi on 10/22/2017.
 */
public class ShuffleAnArray {
    private int[] nums;
    private Random rand;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = nums.clone();
        for(int i=1; i<nums.length; i++){
            int j = rand.nextInt(i+1);
            swap(temp, j, i);
        }
        return temp;
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
