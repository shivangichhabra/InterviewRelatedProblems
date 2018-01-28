package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfArray {

    /*
    Iterative
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());

        for(int i=0; i<nums.length; i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (int j = 0; j<=i; ++j){
                for (List<Integer> l : result){
                    List<Integer> sub = new ArrayList<Integer>(l);
                    sub.add(j,nums[i]);
                    temp.add(sub);
                }
            }
            result = temp;
        }
        return result;
    }

    /*
    Recursive
     */
    public List<List<Integer>> permuteR(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteR(nums, 0, result);
        return result;
    }

    public void permuteR(int[]nums, int start, List<List<Integer>> result){
        if(start >= nums.length){
            List<Integer> list = ArrayToList(nums);
            result.add(list);
        }

        for(int i=start; i<nums.length; i++){
            swap(nums, start, i);
            permuteR(nums, start+1, result);
            swap(nums, start, i);
        }

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> ArrayToList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        return list;
    }
}
