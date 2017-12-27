package Arrays;

/**
 * Created by Shivangi on 8/7/2017.
 *
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average
 * value. And you need to output the maximum average value.
 *
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 */
public class MaximumAverageSubarray {


    public double findMaxAverageOne(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-k+1; i++){
            int sum = 0;
            for(int j=i; j<k+i; j++){
                sum += nums[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return ((double)maxSum)/ ((double)k);
    }

    public double findMaxAverageTwo(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<k; i++)
            sum += nums[i];

        int maxSum = sum;
        for(int i=0, j = k; j<nums.length; i++, j++){
            sum = sum - nums[i] + nums[j];
            maxSum = Math.max(sum, maxSum);
        }
        return (double)maxSum/ (double)k;
    }

    public static void main(String args[]){
        MaximumAverageSubarray mas = new MaximumAverageSubarray();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(mas.findMaxAverageOne(nums, k));
        System.out.println(mas.findMaxAverageTwo(nums, k));
    }
}
