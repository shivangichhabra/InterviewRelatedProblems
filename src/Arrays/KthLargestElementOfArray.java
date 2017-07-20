package Arrays;

import java.util.PriorityQueue;

/**
 * Created by Shivangi on 7/19/2017.
 */
public class KthLargestElementOfArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++)
        {
            q.offer(nums[i]);
            if(q.size() > k)
                q.poll();
        }

        return q.peek();
    }
    public static void main(String args[]){
        int[] nums = {2,1,3};
        int k = 2;
        KthLargestElementOfArray element = new KthLargestElementOfArray();
        System.out.println(element.findKthLargest(nums, k));
    }
}
